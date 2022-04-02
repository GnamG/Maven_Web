package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();
    Student findById(@Param("id")Integer id);
    List<Student> findByKeyword(@Param("name")String name , @Param("info") String info);
    List<Student> findByStudent(Student student);
    List<Student> findByStudentOnTrim(Student student);


    int update(Student student);

    // 不定长参数/可变长参数  可以传递0个或者多个
    // 只能用于形参最后一个参数
    int deleteMore(Integer... ids);
}
