package com.bjsxt.test;

import com.bjsxt.pojo.Role;
import com.bjsxt.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import javax.crypto.spec.SecretKeySpec;
import javax.jws.soap.SOAPBinding;
import java.security.Key;
import java.util.Iterator;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		/*Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager sm = factory.getInstance();
		SecurityUtils.setSecurityManager(sm);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("张三", "1111");
		System.out.println(token.getPassword());
		try {
			subject.login(token);
*//*			PrincipalCollection principalCollection = subject.getPrincipals();
			Set<String> strings = principalCollection.getRealmNames();
			Iterator<String> stringIterator = strings.iterator();
			if(stringIterator.hasNext()){
				String a =stringIterator.next();
				System.out.println(a);
			}*//*
			Object o=subject.getPrincipals().getPrimaryPrincipal();
			//System.out.println(o.toString());
			System.out.println("登录成功");
			System.out.println(subject.hasRole("超级管理员"));
			System.out.println(subject.isPermitted("删除"));
		} catch (UnknownAccountException e) {
			System.out.println("账户不存在");
		} catch (IncorrectCredentialsException e) {
			System.out.println("密码错误");
		}*/
//		String abc = "aaa";
//		System.out.println(abc.getBytes().toString());
//		Key key =new javax.crypto.spec.SecretKeySpec(abc.getBytes(),"DES");
//		System.out.println(key.getEncoded().toString());
		String abc = null;
		for(int i=0;i<1;i++){
			abc = "aaadsafdasfdasfsadfs";
		}
		System.out.println(abc);
		System.out.println("hha");
		System.out.println("hahahaha");
		System.out.println("test");
		System.out.println("msms");
	}
}
