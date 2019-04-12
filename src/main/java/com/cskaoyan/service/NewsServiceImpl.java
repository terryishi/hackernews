package com.cskaoyan.service;

import com.cskaoyan.bean.News;
import com.cskaoyan.bean.User;
import com.cskaoyan.mapper.NewsMapper;
import com.cskaoyan.service.NewsService;
import com.cskaoyan.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsMapper newsMapper;


    @Autowired
    DateUtil dateUtil;

    @Override
    public List<News> findAllNews() {

        List<News> allNews = newsMapper.findAllNews();
        return allNews;
    }

    @Override
    public int insertNews(String image, String title, String link, int id) {

        News news = new News();
        news.setImage(image);
        news.setTitle(title);
        news.setLink(link);
        news.setLikeCount(0);
        news.setCommentCount(0);
        news.setCreatedDate(dateUtil.getDate());
        news.setUserId(id);
        int i = newsMapper.insertNews(news);
        return i;
    }
}
