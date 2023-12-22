package com.Crawling;

public class Posts {
    private String title;
    private String price;
    private String region;
    private String counts;
    private String imageUrl; // 이미지 URL 추가

    // 생성자
    public Posts(String title, String price, String region, String counts, String imageUrl) {
        this.title = title;
        this.price = price;
        this.region = region;
        this.counts = counts;
        this.imageUrl = imageUrl;
    }

    // getter, setter 생략

    // toString 메서드 재정의
    @Override
    public String toString() {
        return "게시물 제목: " + title +
                ", 가격: " + price +
                ", 위치: " + region +
                ", 조회수: " + counts +
                ", 이미지 URL: " + imageUrl;
    }

    // 게시물 제목 getter
    public String getTitle() {
        return title;
    }

    // 가격 getter
    public String getPrice() {
        return price;
    }

    // 위치 getter
    public String getRegion() {
        return region;
    }

    // 조회수 getter
    public String getCounts() {
        return counts;
    }

    // 이미지 URL getter
    public String getImageUrl() {
        return imageUrl;
    }

    // 이미지 URL setter
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
