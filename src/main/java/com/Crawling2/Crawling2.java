package com.Crawling2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Crawling2 extends HttpServlet {
private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Posts2> posts = crawlPosts();
    request.setAttribute("posts", posts);
    RequestDispatcher dispatcher = request.getRequestDispatcher("result2.jsp");
    dispatcher.forward(request, response);
}

private List<Posts2> crawlPosts() {
    List<Posts2> posts = new ArrayList<>();
    final String url = "https://www.daangn.com/kr/jobs/";

    try {
        Connection conn = Jsoup.connect(url);
        Document document = conn.get();
        Elements titleElements = document.select("a > article.w7pzr90.w7pzr92 > div.w7pzr97.w7pzr99 > div.w7pzr93");
        Elements priceElements = document.select("a > article.w7pzr90.w7pzr92 > div.w7pzr97.w7pzr99 > div.w7pzr95");
        Elements regionElements = document.select("a > article.w7pzr90.w7pzr92 > div.w7pzr97.w7pzr99 > div.w7pzr94");
        Elements imageElements = document.select("a > article.w7pzr90.w7pzr92 > div.w7pzr96 > span > img"); // 이미지 URL을 가져올 새로운 Elements

        for (int i = 0; i < titleElements.size(); i++) {
            String title = titleElements.get(i).text();
            String price = priceElements.get(i).text();
            String region = regionElements.get(i).text();
            String imageUrl = imageElements.get(i).attr("src");

            posts.add(new Posts2(title, price, region, imageUrl));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return posts;
    }
}
