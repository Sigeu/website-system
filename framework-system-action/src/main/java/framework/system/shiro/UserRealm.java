package framework.system.shiro;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import framework.system.dao.UserMapper;
import framework.system.model.User;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserMapper userMapper;

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();

		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

		Set<String> roles = userMapper.queryUserRolesByUserName(username);
		authorizationInfo.setRoles(roles);

		Set<String> permissions = userMapper.queryUserPermissionsByUserName(username);
		authorizationInfo.setStringPermissions(permissions);

		return authorizationInfo;
	}

	// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) {

		// UsernamePasswordToken login_token = (UsernamePasswordToken) token;
		//
		// //校验码判断逻辑
		// //取得用户输入的校验码
		// String userInputValidCode = login_token.getValidCode();
		//
		// //取得真实的正确校验码
		// String realRightValidCode = (String)
		// SecurityUtils.getSubject().getSession().getAttribute("rand");
		//
		// if (null == userInputValidCode ||
		// !userInputValidCode.equalsIgnoreCase(realRightValidCode)) {
		// throw new ValidCodeException("验证码输入不正确");
		// }

		// 以上校验码验证通过以后,查数据库
		String username = (String) token.getPrincipal();
		User user = userMapper.queryUserByUserName(username);

		if (user == null) {
			throw new UnknownAccountException();// 没找到帐号
		}

		/*if (Boolean.FALSE.equals(user.getEnable())) {
			throw new LockedAccountException(); // 帐号锁定
		}*/

		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				user.getLogin_name(), // 用户名
				user.getPassword(), // 密码
				getName() // realm name
		);
		return authenticationInfo;
	}

	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}

}
