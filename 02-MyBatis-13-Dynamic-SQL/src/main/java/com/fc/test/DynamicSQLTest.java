package com.fc.test;


import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtils;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class DynamicSQLTest {
    @Test
    public void testFindAll(){
        StudentDao studentDao = MyBatisUtils.getMapper(StudentDao.class);
        List<Student> students = studentDao.findAll();

        for (Student student : students) {
            System.out.println(student);
        }
        MyBatisUtils.commit();
    }

    @Test
    public void testFindById(){
        StudentDao studentDao = MyBatisUtils.getMapper(StudentDao.class);

        Student student = studentDao.findById(2);
        System.out.println(student);
        MyBatisUtils.commit();
    }


    @Test
    public void testIfSql(){
        StudentDao studentDao = MyBatisUtils.getMapper(StudentDao.class);

        List<Student> students = studentDao.findByKeyword(null, "%111%");

        for (Student student : students) {
            System.out.println(student);
        }

        MyBatisUtils.commit();

    }

    @Test
    public void testFindByStudent(){
        StudentDao studentDao = MyBatisUtils.getMapper(StudentDao.class);

        Student student  = new Student();
        student.setId(1);
        List<Student> students = studentDao.findByStudent(student);

        for (Student temp : students) {
            System.out.println(temp);
        }
    }
    @Test
    public void testUpdate(){
        StudentDao studentDao = MyBatisUtils.getMapper(StudentDao.class);

        Student student =new Student();
        student.setId(3);
        student.setName("Krystal");
        student.setBirthday(new Date());
        student.setAge((byte) 40);
        student.setInfo("话务员");
        int affectedRows = studentDao.update(student);

        System.out.println("受影响的行数"+affectedRows);
        MyBatisUtils.commit();
    }

    @Test
    public void testDelete(){
        StudentDao studentDao = MyBatisUtils.getMapper(StudentDao.class);

        int affe = studentDao.deleteMore(5);

        System.out.println(affe);
        MyBatisUtils.commit();
    }
}