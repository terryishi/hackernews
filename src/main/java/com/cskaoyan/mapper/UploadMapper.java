package com.cskaoyan.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UploadMapper {

    int insertUrl(@Param("id") int id, @Param("url") String url);

}
