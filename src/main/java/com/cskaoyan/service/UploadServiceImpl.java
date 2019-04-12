package com.cskaoyan.service;

import com.cskaoyan.mapper.UploadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    UploadMapper uploadMapper;

    @Override
    public String uploadFile(MultipartFile file) {

        String filename = file.getOriginalFilename();
        String substringName = filename.substring(filename.lastIndexOf("."));
        filename = UUID.randomUUID() + substringName;
        String filePath = "/Users/smallstone/IdeaProjects/hackernews/target/classes/static/images/img/";
        File finalFile = new File(filePath + filename);
        if (!finalFile.getParentFile().exists()){
            finalFile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(finalFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String path = "img/" + filename;
        return path;
    }


    @Override
    public int insertUrl(int id, String url) {

        int i = uploadMapper.insertUrl(id, url);

        return i;
    }
}
