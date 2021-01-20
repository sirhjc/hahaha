package com.bjsxt.realm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.bjsxt.pojo.Permission;
import com.bjsxt.pojo.Role;
import com.bjsxt.pojo.User;

public class MyRealm extends AuthorizingRealm{

	//执行授权方法
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("执行doGetAuthorizationInfo");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		info.addRole(role);

		Object result = principals.getPrimaryPrincipal();
		System.out.println(result);
		User user = (User)result;

		for (Role role : user.getRoles()) {
			info.addRole(role.getName());
		}
		for(Permission per :user.getPermission()){
			info.addStringPermission(per.getName());
		}
		return info;
	}
	//执行认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ego","root","hong56dd");
			PreparedStatement ps = conn.prepareStatement("select * from user where username=?");
			ps.setString(1, token.getPrincipal().toString());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setPassword(rs.getString("password"));
				user.setPhoto(rs.getString("photo"));
				user.setUsername(rs.getString("username"));

				List<Role> listRole = new ArrayList<>();
				//获取用户的角色和权限
				/* 开始 */
				try {
					PreparedStatement ps1 = conn.prepareStatement("select * from role where id in (select rid from role_user where uid=?)");
					ps1.setObject(1, user.getId());
					ResultSet rs1 = ps1.executeQuery();
					while(rs1.next()){
						listRole.add(new Role(rs1.getLong(1),rs1.getString(2)));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				//把所有的角色都放入到用户中
				user.setRoles(listRole);

				List<Permission> listPermission = new ArrayList<>();

				try {
					PreparedStatement ps2 = conn.prepareStatement("select * from permission where id in (select pid from role_permission where rid in (select rid from role_user where uid=?))");
					ps2.setObject(1, user.getId());
					ResultSet rs2 = ps2.executeQuery();
					while(rs2.next()){
						listPermission.add(new Permission(rs2.getLong(1), rs2.getString(2)));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				user.setPermission(listPermission);
				/* 结束 */



				SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,rs.getObject("password"),
					 ByteSource.Util.bytes(rs.getObject("id").toString())	,"key:"+rs.getObject("id"));
				return info;
			}else{
				return null;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
