package com.smartAI.search.model;

import org.apache.commons.lang3.StringUtils;

public class VectorData {
    private String contentId;
    private String title;
    private String synopsis;

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return "TestContentIdXXXXX\t\"Indian 3\"\t\"this third film in the blockbuster Indian action series.Ex-INA agent tuned vigilant named Senapathy , a freedom fighter during british Raj in the 1890s, he mission is to clean his country from corrupt officials.\"\tP6C6E";
    }
}
