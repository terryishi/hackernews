package com.cskaoyan.controller;

import com.cskaoyan.bean.News;
import com.cskaoyan.bean.User;
import com.cskaoyan.service.NewsService;
import com.cskaoyan.service.UploadService;
import com.cskaoyan.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;


@Controller
public class UploadController {

    @Autowired
    UploadService uploadService;

    @Autowired
    NewsService newsService;



    @RequestMapping("/uploadImage/")
    @ResponseBody
    public HashMap<String, Object> uploadImage(@RequestParam(value = "file")MultipartFile file, HttpSession session){

        User user = (User) session.getAttribute("user");
        HashMap<String,Object> result = new HashMap<>();
        if (file.isEmpty()){
            result.put("code",1);
        }else {
            String url = uploadService.uploadFile(file);
            result.put("code", 0);
            result.put("msg",url);
        }
        return result;
    }

    @RequestMapping("/user/addNews/")
    @ResponseBody
    public HashMap addNews(String image, String title, String link, HttpSession session){

        User user = (User) session.getAttribute("user");
        HashMap<String, Object> result = new HashMap<>();
        int i = newsService.insertNews(image, title, link, user.getId());
        if ( i != 0){
            result.put("code", 0);
        }else {
            result.put("code", 1);
        }
        return result;
    }
}
