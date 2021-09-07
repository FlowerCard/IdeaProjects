package com.qf.test0907.jsontest;

import com.alibaba.fastjson.JSON;
import com.qf.test0907.pojo.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/7.
 */
public class FastJsonTest {

    /**
     * 对象转Json
     */
    @Test
    public void testObjectToJson(){
        User user = new User(
                1L,"jack@163.com","jack","123","杰克","1111111",new Date(),new Date(),1,0
        );

        String jsonString = JSON.toJSONString(user);
        System.out.println("jsonString = " + jsonString);

    }

    /**
     * 集合转Json
     */
    @Test
    public void testArrayToJson(){
        List<User> userList = new ArrayList<>();

        User user1 = new User(
                1L,"jack@163.com","jack","123","杰克","1111111",new Date(),new Date(),1,0
        );

        User user2 = new User(
                2L,"tom@163.com","tom","123","汤姆","1111111",new Date(),new Date(),1,0
        );
        
        userList.add(user1);
        userList.add(user2);

        String jsonString = JSON.toJSONString(userList);
        System.out.println("jsonString = " + jsonString);

    }

    /**
     * Json字符串转对象
     */
    @Test
    public void testJsonToObject() {
        String jsonStr1 = "{\"createTime\":\"2021-09-07\",\"id\":1,\"idcode\":\"1111111\",\"isdelete\":0,\"modifiedTime\":\"2021-09-07\",\"realname\":\"杰克\",\"status\":1,\"useraccount\":\"jack@163.com\",\"username\":\"jack\"}\n";
        User user = JSON.parseObject(jsonStr1, User.class);
        System.out.println(user);
    }

    /**
     * Json字符串 转 集合
     */
    @Test
    public void testJsonToArray() {
        String jsonStr = "[{\"createTime\":\"2021-09-07\",\"id\":1,\"idcode\":\"1111111\",\"isdelete\":0,\"modifiedTime\":\"2021-09-07\",\"realname\":\"杰克\",\"status\":1,\"useraccount\":\"jack@163.com\",\"username\":\"jack\"},{\"createTime\":\"2021-09-07\",\"id\":2,\"idcode\":\"1111111\",\"isdelete\":0,\"modifiedTime\":\"2021-09-07\",\"realname\":\"汤姆\",\"status\":1,\"useraccount\":\"tom@163.com\",\"username\":\"tom\"}]\n";
        List<User> userList = JSON.parseArray(jsonStr, User.class);
        userList.forEach(System.out::println);
    }

}
