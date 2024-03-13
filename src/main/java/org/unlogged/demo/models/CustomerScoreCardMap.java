package org.unlogged.demo.models;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CustomerScoreCardMap {
    private int mapId;
    private Map<Long, CustomerScoreCard> scoreMap;
    private List<CustomerScoreCard> listOfCards;

    public CustomerScoreCardMap(List<CustomerScoreCard> scoreCards) {
        this.mapId = new Date().toString().hashCode();
        this.listOfCards = scoreCards;
        scoreMap = new TreeMap<>();
        for (CustomerScoreCard scoreCard : scoreCards) {
            scoreMap.put(scoreCard.getCustomerProfile().getCustomerid(), scoreCard);
        }
    }

    public Map<Long, CustomerScoreCard> getScoreMap() {
        return scoreMap;
    }

    public int getMapId() {
        return mapId;
    }

    @Override
    public String toString() {
        return "CustomerScoreCardMap{" +
                "mapId=" + mapId +
                ", scoreMap=" + scoreMap +
                ", listOfCards=" + listOfCards +
                '}';
    }
}
