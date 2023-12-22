package com.Crawling;

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


public class Crawling extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Posts> posts = crawlPosts();
        request.setAttribute("posts", posts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request, response);
    }

    private List<Posts> crawlPosts() {
        List<Posts> posts = new ArrayList<>();
        final String url = "https://www.daangn.com/hot_articles";

        try {
            Connection conn = Jsoup.connect(url);
            Document document = conn.get();
            Elements titleElements = document.select("a > div.card-desc > h2 ");
            Elements priceElements = document.select("a > div.card-desc > div.card-price ");
            Elements regionElements = document.select("a > div.card-desc > div.card-region-name");
            Elements countsElements = document.select("a > div.card-desc > div.card-counts");
            Elements imageElements = document.select("a > div.card-photo > img");

            for (int i = 0; i < titleElements.size(); i++) {
                String title = titleElements.get(i).text();
                String price = priceElements.get(i).text();
                String region = regionElements.get(i).text();
                String counts = countsElements.get(i).text();
                String imageUrl = imageElements.get(i).attr("src");

                posts.add(new Posts(title, price, region, counts, imageUrl));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return posts;
    }
}
