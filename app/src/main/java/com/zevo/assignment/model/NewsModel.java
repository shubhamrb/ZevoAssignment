package com.zevo.assignment.model;

import java.io.Serializable;

public class NewsModel implements Serializable {
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;
    private SourceModel source;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SourceModel getSource() {
        return source;
    }

    public void setSource(SourceModel source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", content='" + content + '\'' +
                ", source=" + source +
                '}';
    }

    public static class SourceModel implements Serializable {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
