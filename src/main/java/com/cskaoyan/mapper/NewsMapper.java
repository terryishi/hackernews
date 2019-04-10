package com.cskaoyan.mapper;

import com.cskaoyan.bean.News;
import com.cskaoyan.bean.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface NewsMapper {

    List<News> findAllNews();

}
