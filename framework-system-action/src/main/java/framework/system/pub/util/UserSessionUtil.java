package framework.system.pub.util;

import javax.servlet.http.HttpServletRequest;

import framework.system.model.Department;
import framework.system.model.User;

/**
 * 用户session管理
 * 
 * @author lizhaotao lzh_me@126.com
 * @date 2017年3月10日 上午11:35:01
 */
public class UserSessionUtil {
	private static String systemUserKey = "systemUser";
	private static String userIDKey = "userID";
	private static String memberIDKey = "memberID";
	private static String memberUserKey = "memberUser";
	private static String memberNameKey = "memberName";
	private static String glbmIDKey = "deptID";
	private static String glbmNameKey = "deptName";
	private static String adminFlagKey = "adminFlag";
	private static String roleIDsKey = "roleIDs";
	private static String themeNameKey = "themeName";
	private static String deptKey = "sessionDept";

	/**
	 * 向session中放入对象
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param key
	 *            String
	 * @param obj
	 *            Object
	 */
	public static void put(HttpServletRequest request, String key, Object obj) {
		request.getSession().setAttribute(key, obj);
	}

	/**
	 * 根据key获取session中的对象
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param key
	 *            String
	 * @return Object
	 */
	public static Object get(HttpServletRequest request, String key) {
		return request.getSession().getAttribute(key);
	}

	/**
	 * 放入用户session
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param user
	 *            Object
	 */
	public static void putUser(HttpServletRequest request, Object user) {
		request.getSession().setAttribute(systemUserKey, user);
	}

	/**
	 * 获取用户session
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return Object
	 */
	public static User getUser(HttpServletRequest request) {
		return null == request.getSession().getAttribute(systemUserKey) ? null
				: (User) request.getSession().getAttribute(systemUserKey);
	}

	/**
	 * 放入用户session
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param user
	 *            Object
	 */
	public static void putDept(HttpServletRequest request, Department department) {
		request.getSession().setAttribute(deptKey, department);
	}

	/**
	 * 获取用户session
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return Object
	 */
	public static Department getDept(HttpServletRequest request) {
		return request.getSession().getAttribute(deptKey) == null ? null
				: (Department) request.getSession().getAttribute(deptKey);
	}

	/**
	 * 放入成员IDsession
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param memberID
	 *            成员ID
	 */
	public static void putMemberID(HttpServletRequest request, long memberID) {
		request.getSession().setAttribute(memberIDKey, memberID);
	}

	/**
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return long
	 */
	public static long getMemberID(HttpServletRequest request) {
		return (Long) request.getSession().getAttribute(memberIDKey);
	}

	/**
	 * 放入成员session
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param member
	 *            Object
	 */
	public static void putMember(HttpServletRequest request, Object member) {
		request.getSession().setAttribute(memberUserKey, member);
	}

	/**
	 * 获取成员session
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return Object
	 */
	public static Object getMember(HttpServletRequest request) {
		return request.getSession().getAttribute(memberUserKey);
	}

	/**
	 * 放入用户角色ID数组session
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param roleIDs
	 *            用户角色ID
	 */
	public static void putRoleIDs(HttpServletRequest request, long[] roleIDs) {
		request.getSession().setAttribute(roleIDsKey, roleIDs);
	}

	/**
	 * 获取用户角色ID数组session
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return 用户角色ID
	 */
	public static long[] getRoleIDs(HttpServletRequest request) {
		return (long[]) request.getSession().getAttribute(roleIDsKey);
	}

	/**
	 * 放入管理员标识session
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param adminFlag
	 *            String
	 */
	public static void setAdminFlag(HttpServletRequest request, String adminFlag) {
		request.getSession().setAttribute(adminFlagKey, adminFlag);
	}

	/**
	 * 获取管理员标识session
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return String
	 */
	public static String getAdminFlag(HttpServletRequest request) {
		return (String) request.getSession().getAttribute(adminFlagKey);
	}

	/**
	 * 放入皮肤样式session
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param themeName
	 *            样式名字
	 */
	public static void setThemeName(HttpServletRequest request, String themeName) {
		request.getSession().setAttribute(themeNameKey, themeName);
	}

	/**
	 * 获取皮肤样式session
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return 样式名字
	 */
	public static String getThemeName(HttpServletRequest request) {
		return (String) request.getSession().getAttribute(themeNameKey);
	}

	/**
	 * 放入用户session
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param user
	 *            Object
	 */
	public static void putUserId(HttpServletRequest request, Long userId) {
		request.getSession().setAttribute(userIDKey, userId);
	}

	/**
	 * 获取用户ID
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return 用户ID
	 */
	public static long getUserID(HttpServletRequest request) {
		return (Long) request.getSession().getAttribute(userIDKey);
	}

	/**
	 * 获取成员姓名session
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param memberName
	 *            成员名字
	 */
	public static void putMemberName(HttpServletRequest request,
			String memberName) {
		request.getSession().setAttribute(memberNameKey, memberName);
	}

	/**
	 * 获取成员姓名session
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return 成员名字
	 */
	public static String getMemberName(HttpServletRequest request) {
		return (String) request.getSession().getAttribute(memberNameKey);
	}

	/**
	 * 放入管理部门IDsession
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param deptID
	 *            部门ID
	 */
	public static void putGlbmID(HttpServletRequest request, Long deptID) {
		request.getSession().setAttribute(glbmIDKey, deptID);
	}

	/**
	 * 获取管理部门IDsession
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return 部门ID
	 */
	public static long getGlbmID(HttpServletRequest request) {
		return (Long) request.getSession().getAttribute(glbmIDKey);
	}

	/**
	 * 放入管理部门名称session
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param deptName
	 *            部门名称
	 */
	public static void putGlbmName(HttpServletRequest request, String deptName) {
		request.getSession().setAttribute(glbmNameKey, deptName);
	}

	/**
	 * 获取管理部门名称IDsession
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return 部门名称
	 */
	public static String getGlbmName(HttpServletRequest request) {
		return (String) request.getSession().getAttribute(glbmNameKey);
	}
}
