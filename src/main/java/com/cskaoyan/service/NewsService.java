package com.cskaoyan.service;

import com.cskaoyan.bean.News;
import com.cskaoyan.bean.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;


public interface NewsService {

    List<News> findAllNews();


    int insertNews(String image, String title, String link, int id);
}
