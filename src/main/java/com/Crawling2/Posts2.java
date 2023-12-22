package com.Crawling2;

public class Posts2 {
	private String title;
	private String price;
	private String region;
	private String imageUrl;
	
	public Posts2(String title, String price, String region, String imageUrl) {
	    this.title = title;
	    this.price = price;
	    this.region = region;
	    this.imageUrl = imageUrl; 
	}
	

	@Override
	public String toString() {
	    return "게시물 제목: " + title +
	            ", 가격: " + price +
	            ", 위치: " + region +
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
	
	// 이미지 URL getter
	public String getImageUrl() {
	    return imageUrl;
}
}
