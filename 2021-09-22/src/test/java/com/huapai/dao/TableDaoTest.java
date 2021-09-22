package com.huapai.dao;

import com.huapai.pojo.Table;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/22.
 */
public class TableDaoTest {
    
    @Test
    public void queryByIdTest(){

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
            //获取接口
            TableDao tableDao = sqlSession.getMapper(TableDao.class);

            Table table = tableDao.queryById(1);
            System.out.println(table);
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    @Test
    public void queryAll(){

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
            
            TableDao tableDao = sqlSession.getMapper(TableDao.class);

            List<Table> tableList = tableDao.queryAll();
            
            tableList.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    @Test
    public void insertTableTest(){
        
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

            TableDao tableDao = sqlSession.getMapper(TableDao.class);
            
            Table table = new Table();
            table.setTableName("白虎");
            table.setTableStatus(1);
            table.setScheduledTime(new Date());

            Integer row = tableDao.insertTable(table);
            sqlSession.commit();
            
            System.out.println(row);

            System.out.println(table);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @Test
    public void updateTableById(){
        
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

            TableDao tableDao = sqlSession.getMapper(TableDao.class);
            
            Table table = new Table();
            table.setTableName("白虎王");
            table.setTableStatus(2);
            table.setScheduledTime(new Date());

            Integer row = tableDao.updateTableById(7, table.getTableName(), table.getTableStatus(), table.getScheduledTime());
            sqlSession.commit();
            System.out.println(row);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
