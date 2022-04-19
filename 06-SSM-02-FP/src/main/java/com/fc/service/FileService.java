package com.fc.service;

import com.fc.vo.ResultVo;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String upload(MultipartFile file);

    ResultVo fileUpload(MultipartFile file, String type);
}
