package org.unlogged.demo.controller;

import com.rometools.rome.feed.atom.Feed;
import com.rometools.rome.feed.atom.Link;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.feed.AbstractAtomFeedView;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class AtomViewImpl extends AbstractAtomFeedView {

    private SiteUrl siteUrl;

    public AtomViewImpl() {
        siteUrl = new SiteUrl();
    }

    @Override
    protected List<com.rometools.rome.feed.atom.Entry> buildFeedEntries(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.buildFeedEntries(model, newFeed(), request, response);
        return null;
    }

    @Override
    protected void buildFeedMetadata(Map<String, Object> model, Feed feed, HttpServletRequest request) {
        String feedPath = (String) model.get("feed-path");
        feed.setTitle((String) model.get("feed-title"));
        feed.setId(String.format("http://spring.io%s", feedPath));
        setFeedUrl(feedPath, feed);
        setBlogUrl((String) model.get("blog-path"), feed);
        setUpdatedDate(model, feed);

        super.buildFeedMetadata(model, newFeed(), request);
    }

    private void setUpdatedDate(Map<String, Object> model, Feed feed) {
        @SuppressWarnings("unchecked")
        List<Object> posts = (List<Object>) model.get("posts");
        if (posts.size() > 0) {
            feed.setUpdated(new Date());
        }
    }

    private void setFeedUrl(String feedPath, Feed feed) {
        String feedUrl = siteUrl.getAbsoluteUrl(feedPath);
        Link feedLink = new Link();
        feedLink.setHref(feedUrl);
        feedLink.setRel("self");
        feed.setOtherLinks(Arrays.asList(feedLink));
    }

    private void setBlogUrl(String blogPath, Feed feed) {
        String blogUrl = siteUrl.getAbsoluteUrl(blogPath);
        Link blogLink = new Link();
        blogLink.setHref(blogUrl);
        feed.setAlternateLinks(Arrays.asList(blogLink));
    }
}
