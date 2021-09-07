package com.qf.test0907.jsontest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qf.test0907.pojo.User;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/7.
 */
public class JacksonTest {

    /**
     * 对象转Json
     */
    @Test
    public void testObjectToJson() {
        User user = new User(
                1L,"jack@163.com","jack","123","杰克","1111111",new Date(),new Date(),1,0
        );
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String valueAsString = objectMapper.writeValueAsString(user);
            System.out.println("valueAsString = " + valueAsString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 集合转Json
     */
    @Test
    public void testListToJson() {
        List<User> userList = new ArrayList<>();

        User user1 = new User(
                1L,"jack@163.com","jack","123","杰克","1111111",new Date(),new Date(),1,0
        );

        User user2 = new User(
                2L,"tom@163.com","tom","123","汤姆","1111111",new Date(),new Date(),1,0
        );

        userList.add(user1);
        userList.add(user2);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String valueAsString = objectMapper.writeValueAsString(userList);
            System.out.println("valueAsString = " + valueAsString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * Json转对象
     */
    @Test
    public void testJsonToObject() {
        String jsonStr = "{\"id\":1,\"useraccount\":\"jack@163.com\",\"username\":\"jack\",\"password\":\"123\",\"realname\":\"杰克\",\"idcode\":\"1111111\",\"createTime\":1631010960498,\"modifiedTime\":1631010960498,\"status\":1,\"isdelete\":0}\n";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            User user = objectMapper.readValue(jsonStr, User.class);
            System.out.println("user = " + user);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Json转集合
     */
    @Test
    public void testJsonToList() {
        String jsonStr = "[{\"id\":1,\"useraccount\":\"jack@163.com\",\"username\":\"jack\",\"realname\":\"杰克\",\"idcode\":\"1111111\",\"createTime\":\"2021-09-07\",\"modifiedTime\":\"2021-09-07\",\"status\":1,\"isdelete\":0},{\"id\":2,\"useraccount\":\"tom@163.com\",\"username\":\"tom\",\"realname\":\"汤姆\",\"idcode\":\"1111111\",\"createTime\":\"2021-09-07\",\"modifiedTime\":\"2021-09-07\",\"status\":1,\"isdelete\":0}]\n";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<User> userList = objectMapper.readValue(jsonStr, new TypeReference<ArrayList<User>>() {});
            userList.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
