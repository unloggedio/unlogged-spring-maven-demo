import io.unlogged.runner.UnloggedTestRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;

@RunWith(UnloggedTestRunner.class)
@ComponentScan("org.unlogged.demo")                  // update the package name here
@EnableAutoConfiguration
//@PropertySource(
//        value = {"config/application.yml", "config/application-dev.yml"},       // update the config files you want to use
//        factory = UnloggedRunnerTest.YamlPropertySourceFactory.class)           // this is for supporting yml files
//@EnableConfigurationProperties({ApplicationProperties.class})
// specify your test application properties
@TestConfiguration
public class UnloggedRunnerTest {

    public static class YamlPropertySourceFactory implements PropertySourceFactory {
        public YamlPropertySourceFactory() {
        }

        @Override
        public PropertiesPropertySource createPropertySource(String name, EncodedResource encodedResource) throws IOException {
            YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
            factory.setResources(encodedResource.getResource());
            return new PropertiesPropertySource(encodedResource.getResource().getFilename(), factory.getObject());
        }
    }
}