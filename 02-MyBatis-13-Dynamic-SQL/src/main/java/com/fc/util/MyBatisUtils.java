package com.fc.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * MyBatis工具类
 *
 * 封装了获取连接，关闭连接，获取接口实现类对象的方法
 */
public class MyBatisUtils {
    // 准备SqlSession工厂对象
    private static SqlSessionFactory factory;

    // 创建ThreadLocal绑定当前线程中的SqlSession对象
    private static final ThreadLocal<SqlSession> SESSION = new ThreadLocal<>();

    // 通过静态代码块加载SqlSession工厂对象
    static {
        try {
            // 读取配置文件
            InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");

            // 获取工厂对象
            factory = new SqlSessionFactoryBuilder().build(resource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获得连接（从ThreadLocal中获得当前线程SqlSession）
    private static SqlSession openSession() {
        // 从ThreadLocal中获取连接
        SqlSession session = SESSION.get();

        // 如果连接为null
        if (session == null) {

            // 从工厂对象中获取连接
            session = factory.openSession();

            // 将连接存入ThreadLocal
            SESSION.set(session);
        }

        return session;
    }

    // 释放连接（释放当前线程中的SqlSession）
    private static void closeSession() {
        // 从ThreadLocal中获取连接
        SqlSession sqlSession = SESSION.get();

        // 关闭连接
        sqlSession.close();

        // 从ThreadLocal中移除连接
        SESSION.remove();
    }

    // 提交事务（提交当前线程中的SqlSession所管理的事务）
    public static void commit() {
        // 获取连接
        SqlSession session = openSession();

        // 提交事务
        session.commit();

        // 关闭资源
        closeSession();
    }

    // 回滚事务（回滚当前线程中的SqlSession所管理的事务）
    public static void rollback() {
        // 获取连接
        SqlSession session = openSession();

        // 回滚事务
        session.rollback();

        // 关闭资源
        closeSession();
    }

    /**
     *
     * @param clazz 类型
     * @param <T> 泛型
     * @return
     */
    // 获取接口实现类对象
    public static <T> T getMapper(Class<T> clazz) {
        // 获取连接
        SqlSession session = openSession();

        // 获取接口代理对象
        return session.getMapper(clazz);
    }
}
