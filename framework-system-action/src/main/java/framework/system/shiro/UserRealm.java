package framework.system.shiro;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import framework.system.dao.UserMapper;
import framework.system.model.RoleFuncright;
import framework.system.model.User;
import framework.system.service.IFuncrightService;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserMapper userMapper;

	@Resource
	private IFuncrightService funcrightService;

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = null;
		if (null != username) {
			// 查询用户授权信息
			List<RoleFuncright> roleFuncrightList = funcrightService
					.queryUserFuncright(username);
			if (null != roleFuncrightList && !roleFuncrightList.isEmpty()) {
				info = new SimpleAuthorizationInfo();
				for (RoleFuncright roleFuncright : roleFuncrightList) {
					info.addStringPermission(roleFuncright.getFuncright_code());
				}
			}
		}

		return info;
	}

	// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) {

		// UsernamePasswordToken login_token = (UsernamePasswordToken) token;
		// String username = login_token.getUsername();

		String username = (String) token.getPrincipal();
		User user = userMapper.queryUserByUserName(username);
		AuthenticationInfo authenticationInfo = null;
		if (null != user) {
			authenticationInfo = new SimpleAuthenticationInfo(
					user.getLogin_name(), user.getPassword(), getName());
			this.setSession("session_user", user);
		}

		return authenticationInfo;
	}

	private void setSession(Object key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				session.setAttribute(key, value);
			}
		}
	}

}
