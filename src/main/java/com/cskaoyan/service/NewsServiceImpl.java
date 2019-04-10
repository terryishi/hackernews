package com.cskaoyan.service;

import com.cskaoyan.bean.News;
import com.cskaoyan.bean.User;
import com.cskaoyan.mapper.NewsMapper;
import com.cskaoyan.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsMapper newsMapper;

    @Override
    public List<News> findAllNews() {

        List<News> allNews = newsMapper.findAllNews();
        return allNews;
    }


}
