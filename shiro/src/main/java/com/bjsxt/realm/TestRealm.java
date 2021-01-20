package com.bjsxt.realm;

import com.bjsxt.pojo.User;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class TestRealm extends AuthorizingRealm {
    @Override
    public String getName() {
        return "UserRealm";
    }
    //用于认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
//从 token 中获取身份信息
        String username = (String)token.getPrincipal();
        System.out.println(username);
//根据用户名到数据库中取出用户信息 如果查询不到 返回 null
        String password = "96e79218965eb72c92a549dd5a330112";//假如从数据库中获取密码为 1111
        System.out.println(password);
        System.out.println("执行认证");
//返回认证信息
        SimpleAuthenticationInfo simpleAuthenticationInfo = new
                SimpleAuthenticationInfo(username, password, ByteSource.Util.bytes("11"), this.getName());
        return simpleAuthenticationInfo;
    }
    //用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        System.out.println("执行doGetAuthorizationInfo");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		info.addRole(role);

        Object result = principals.getPrimaryPrincipal();
        System.out.println(result);
            info.addRole("超级管理员");
            info.addStringPermission("删除");
        return info;
    }
}
