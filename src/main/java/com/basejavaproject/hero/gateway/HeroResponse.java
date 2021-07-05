package com.basejavaproject.hero.gateway;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
class HeroResponse {
    private int code;
    private String status;
    private String copyright;
    private String attributionText;
    private String attributionHTML;
    private String etag;
    private Data data;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    static class Data {
        private int offset;
        private int limit;
        private int total;
        private int count;
        private List<Result> results;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    static class Result {
        private int id;
        private String name;
        private String description;
        private Date modified;
        private Thumbnail thumbnail;
        private String resourceURI;
        private Comics comics;
        private Series series;
        private Stories stories;
        private Events events;
        private List<Url> urls;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    static class Url {
        private String type;
        private String url;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    static class Events {
        private int available;
        private String collectionURI;
        private List<Item> items;
        private int returned;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    static class Stories {
        private int available;
        private String collectionURI;
        private List<Item> items;
        private int returned;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    static class Series {
        private int available;
        private String collectionURI;
        private List<Item> items;
        private int returned;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    static class Comics {
        private int available;
        private String collectionURI;
        private List<Item> items;
        private int returned;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    static class Item {
        private String resourceURI;
        private String name;
        private String type;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    static class Thumbnail {
        private String path;
        private String extension;
    }

}
