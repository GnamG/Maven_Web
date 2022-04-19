package com.fc.controller;

import com.fc.service.FileService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping
public class FileController {
    @Autowired
     private FileService fileService;
    @PostMapping("upload")
    public String upload(MultipartFile file) {

        return fileService.upload(file);
    }
}
