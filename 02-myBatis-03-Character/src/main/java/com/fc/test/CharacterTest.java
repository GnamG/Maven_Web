package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CharacterTest {
  /*  @Test
    public void test(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            List<Student> students = studentDao.findLessThanAge(30);
            for (Student student : students) {
                System.out.println(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

//    @Test
//    public void test(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//
//            SqlSession session = factory.openSession();
//
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//
//            List<Student> students = studentDao.findLessThanAge(20);
//
//            for (Student student : students) {
//                System.out.println(student);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void test(){
        try {
            // 获取配置
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            // 获取工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            // 获取连接
            SqlSession session = factory.openSession();
            // 通过接口实现类对象
            StudentDao studentDao = session.getMapper(StudentDao.class);
            // 调用方法
            List<Student> students = studentDao.findLessThanAge(19);

            // 遍历
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 /*   @Test
    public void testfindGreaterThanAge(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            List<Student> students = studentDao.findGreaterThanAge(20);

            for (Student student : students) {
                System.out.println(student);
            }
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

//    @Test
//    public void testFindGreaterThanAge(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//
//            SqlSession session = factory.openSession();
//
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//
//            List<Student> students = studentDao.findGreaterThanAge(20);
//
//            for (Student student : students) {
//                System.out.println(student);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void testFindGreaterThanAge(){
        try {
            // 获取配置
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            // 获取工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            // 获取连接
            SqlSession session = factory.openSession();
            // 通过接口实现类对象
            StudentDao studentDao = session.getMapper(StudentDao.class);
            // 调用方法
            List<Student> students = studentDao.findGreaterThanAge(19);

            for (Student student : students) {
                System.out.println(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
