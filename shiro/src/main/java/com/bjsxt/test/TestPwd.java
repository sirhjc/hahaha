package com.bjsxt.test;

import org.apache.shiro.crypto.hash.Md5Hash;

public class TestPwd {
	public static void main(String[] args) {
		Md5Hash md5 = new Md5Hash("zs");
		System.out.println(md5);
		
		//加盐-在原有内容基础上,在添加内容
		//把第一个参数和第二个参数拼接称字符串.在进行加密
		//第二个参数 写行数据的id
		Md5Hash md51 = new Md5Hash("zs", "123");
		System.out.println(md51);

		//迭代,对加密后的内容再次加密
		Md5Hash md52 = new Md5Hash("zs", "1",2);
		System.out.println(md52);
		System.out.println("lalalal");
	}
}
