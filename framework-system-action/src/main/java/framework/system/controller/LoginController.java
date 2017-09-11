/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import framework.system.model.User;
import framework.system.pub.base.SystemBaseController;
import framework.system.pub.util.LogUtil;
import framework.system.pub.util.UserSessionUtil;
import framework.system.service.ILogService;
import framework.system.service.IUserService;

/**
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月18日 下午5:02:47
 * @version V1.0
 */
@Controller
@RequestMapping("/system/controller/loginController")
public class LoginController extends SystemBaseController {
	@Resource
	private IUserService userService;

	@Resource
	private ILogService logService;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request,  Model model) {
		String msg = "";
		UsernamePasswordToken token = null;
		try {
		    String userName = request.getParameter("login_name");  
		    String password = request.getParameter("password");  
		    token = new UsernamePasswordToken(userName, password);  
		    token.setRememberMe(true);  
		    Subject subject = SecurityUtils.getSubject();  
	        subject.login(token);  
	        //验证通过
	        if (subject.isAuthenticated()) { 
	        	User userParam = new User();
	        	userParam.setLogin_name(userName);
	        	userParam.setPassword(password);
	        	User systemUser = userService.queryUserByLogin(userParam);
	        	//用户信息放在session中
	        	UserSessionUtil.putUser(request, systemUser);
				//记录日志
				LogUtil.saveLog(request, "登录成功");
	        } 
	        return "main/index"; 
		} catch (IncorrectCredentialsException e) {  
	        msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";  
	        model.addAttribute("message", msg);  
	        //记录日志
			LogUtil.saveLog(request, "登录密码错误");
	        return "redirect:/";
	    } catch (ExcessiveAttemptsException e) {  
	        msg = "登录失败次数过多";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	        //记录日志
			LogUtil.saveLog(request, "登录失败次数过多");
	        return "redirect:/";
	    } catch (LockedAccountException e) {  
	        msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	        return "redirect:/";
	    } catch (DisabledAccountException e) {  
	        msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	        return "redirect:/";
	    } catch (ExpiredCredentialsException e) {  
	        msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	        return "redirect:/";
	    } catch (UnknownAccountException e) {  
	        msg = "帐号不存在. There is no user with username of " + token.getPrincipal();  
	        model.addAttribute("message", msg);  
	        System.out.println(msg); 
	      //记录日志
			LogUtil.saveLog(request, "帐号不存在");
	        return "redirect:/";
	    } catch (UnauthorizedException e) {  
	        msg = "您没有得到相应的授权！" + e.getMessage();  
	        model.addAttribute("message", msg);  
	        System.out.println(msg); 
	        return "redirect:/";
	    }
		
	}
	
	/**
	 * 
	 * @Description: 后台管理：管理员退出 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,  Model model) {
		Subject currentUser = SecurityUtils.getSubject();  
        currentUser.logout();  
        return "redirect:/login.jsp"; 
		
	}
	
	@RequestMapping("/admin")
	public String admin(HttpServletRequest request,  Model model) {
		
		//return "main/index";
		return "/login";
	}
	
	/**
	 * 获取IP
	 * @param request
	 * @return
	 */
	String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
