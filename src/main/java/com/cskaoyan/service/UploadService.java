package com.cskaoyan.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    String uploadFile(MultipartFile file);

    int insertUrl(int id, String url);
}
