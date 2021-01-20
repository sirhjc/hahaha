package com.bjsxt.test;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class Test1 {
    public static void main(String[] args) {
        //MD5 加密
        String password = new Md5Hash("1111").toString();
        System.out.println("加密后："+password);
//加盐 salt 默认一次散列
        String password_salt=new Md5Hash("1111",
                "11").toString();
        System.out.println("加盐后："+password_salt);
//散列 2 次
        String test = new Md5Hash(password_salt).toString();
        System.out.println(test);
        String password_salt_2 = new Md5Hash("1111", "siggy",
                2).toString();
        System.out.println("散列 2 次："+password_salt_2);
//使用 SimpleHash
        SimpleHash hash = new SimpleHash("MD5", "1111", "siggy", 1);
        System.out.println("simpleHash:"+hash.toString());
    }
}
