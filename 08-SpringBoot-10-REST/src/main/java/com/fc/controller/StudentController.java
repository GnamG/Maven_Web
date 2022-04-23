package com.fc.controller;

import com.fc.entity.Student;
import com.fc.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public PageInfo<Student> findAll(@RequestParam(defaultValue = "1") Integer pageNum,
                                     @RequestParam(defaultValue = "3") Integer pageSize){
        return studentService.findAll(pageNum,pageSize);
    }

    @PostMapping("{name}/{age}/{gender}/{info}")
    public Map<String,Object> add(Student student){
        int rows = studentService.add(student);
        Map<String, Object> result = new HashMap<>();
        if (rows>0){
            result.put("code",200);
            result.put("massage","成功");
            result.put("access",true);

        }else {
            result.put("code",404);
            result.put("massage","失败");
            result.put("access",false);
        }
        result.put("data",null);
        return result;
    }

    @PutMapping("{id}/{info}")
    public Map<String,Object> update(Student student){
        int rows = studentService.update(student);
        Map<String, Object> result = new HashMap<>();
        if (rows>0){
            result.put("code",200);
            result.put("massage","成功");
            result.put("access",true);

        }else {
            result.put("code",404);
            result.put("massage","失败");
            result.put("access",false);
        }
        result.put("data",null);
        return result;
    }
    @DeleteMapping("{id}")
    public Map<String,Object> delete(@PathVariable("id") Integer id){
        int rows = studentService.delete(id);
        Map<String, Object> result = new HashMap<>();
        if (rows>0){
            result.put("code",200);
            result.put("massage","成功");
            result.put("access",true);

        }else {
            result.put("code",404);
            result.put("massage","失败");
            result.put("access",false);
        }
        result.put("data",null);
        return result;
    }
}
