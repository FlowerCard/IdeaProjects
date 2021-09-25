package com.qf.java2105.huangzihao.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/24.
 */


public class MybatisUtil {

    /**
     * SQL会话工程
     */
    private static SqlSessionFactory sqlSessionFactory;

    /**
     * 线程绑定
     */
    private static final ThreadLocal<SqlSession> THREADLOCAL = new ThreadLocal<>();

    static {
        try {
            //配置文件路径
            String resource = "mybatis-config.xml";
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 开启会话
     *
     * @return SqlSession
     */
    private static SqlSession openSession() {
        SqlSession sqlSession = THREADLOCAL.get();
        if (null == sqlSession) {
            sqlSession = sqlSessionFactory.openSession();
            THREADLOCAL.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 关闭会话
     */
    private static void closeSession() {
        SqlSession sqlSession = openSession();
        if (null == sqlSession) {
            return;
        }
        sqlSession.close();
        THREADLOCAL.remove();
    }

    /**
     * 提交事务，关闭会话
     */
    public static void commit() {
        SqlSession sqlSession = THREADLOCAL.get();
        sqlSession.commit();
        closeSession();
    }

    /**
     * 回滚事务，关闭会话
     */
    public static void rollback() {
        SqlSession sqlSession = THREADLOCAL.get();
        sqlSession.rollback();
        closeSession();
    }

    /**
     * 获取对象
     *
     * @param clazz 类对象
     * @param <T>   泛型
     * @return 返回类对象
     */
    public static <T extends Object> T getMapper(Class<T> clazz) {
        return openSession().getMapper(clazz);
    }

}
