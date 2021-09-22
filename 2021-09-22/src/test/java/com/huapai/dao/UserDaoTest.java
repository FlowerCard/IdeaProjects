package com.huapai.dao;

import com.huapai.pojo.User;
import jdk.nashorn.internal.scripts.JD;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/22.
 */
public class UserDaoTest {
    
    @Test
    public void selectByIdTest(){
        try {

            //配置文件路径
            String resource = "mybatis-config.xml";
            /*
                获取配置文件流对象
                import org.apache.ibatis.io.Resources
             */
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //工厂构建SQL会话
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //开启会话
            SqlSession sqlSession = sqlSessionFactory.openSession();

            UserDao userDao = sqlSession.getMapper(UserDao.class);

            User user = userDao.selectById(1);
            System.out.println(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void selectAll(){
        try {

            //配置文件路径
            String resource = "mybatis-config.xml";
            /*
                获取配置文件流对象
                import org.apache.ibatis.io.Resources
             */
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //工厂构建SQL会话
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //开启会话
            SqlSession sqlSession = sqlSessionFactory.openSession();

            UserDao userDao = sqlSession.getMapper(UserDao.class);

            List<User> userList = userDao.selectAll();
            
            userList.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void insertUser(){
        try {

            //配置文件路径
            String resource = "mybatis-config.xml";
            /*
                获取配置文件流对象
                import org.apache.ibatis.io.Resources
             */
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //工厂构建SQL会话
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //开启会话
            SqlSession sqlSession = sqlSessionFactory.openSession();

            UserDao userDao = sqlSession.getMapper(UserDao.class);
            
            User user = new User();
            user.setUsername("lisi");
            user.setPassword("123");

            Integer row = userDao.insertUser(user);
            sqlSession.commit();
            System.out.println(row);

            System.out.println(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
