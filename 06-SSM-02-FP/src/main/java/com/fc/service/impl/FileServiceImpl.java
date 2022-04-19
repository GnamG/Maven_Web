package com.fc.service.impl;

import com.fc.service.FileService;
import com.fc.vo.ResultVo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String upload(MultipartFile file) {

            // 准备路径
            String path = "http://localhost:8081/upload/";

            // 获取文件名
            String filename = file.getOriginalFilename();

            // 获取后缀名
            String suffix = filename.substring(filename.lastIndexOf('.'));

            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");

            String format = formatter.format(new Date());

            // 拼接成一个新的文件名
            filename = format + suffix;

            Client client = Client.create();

            // 连接服务器
            WebResource resource = client.resource(path + filename);

            try {
                // 推送文件到服务器上
                resource.put(file.getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }
            filename = path + filename;
            return filename;
        }

    @Override
    public ResultVo fileUpload(MultipartFile file, String type) {
        // 上传的路径
        String path = "D:/apache-server/apache-tomcat-8.5.37/webapps/upload/PovertyAlleviation/"+type;

        File pathFile = new File(path);
        // 如果路径不存在不存在
        if(!pathFile.exists()){
            // 创建一个
            pathFile.mkdirs();
        }

        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 日期格式化
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSS");
        // 获取格式化之后的日期时间字符串
        String formatDate = formatter.format(new Date());

        // 获取文件后缀名
        String suffix = fileName.substring(fileName.lastIndexOf("."));

        // 获取新的文件名
        fileName = formatDate + suffix;
        ResultVo vo = new ResultVo();
        HashMap<String, Object> map = new HashMap<>();
        try {
            // 文件上传操作
            file.transferTo(new File(pathFile,fileName));
            vo.setMessage("Ok");
            vo.setCode(200);
            vo.setSuccess(true);
            map.put("imgurl","http://localhost:8081/upload/PovertyAlleviation/" + type +"/"+ fileName);
            vo.setData(map);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vo;
    }
}
