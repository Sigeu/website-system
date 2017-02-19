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

import framework.system.model.Log;
import framework.system.pub.base.MyBaseController;
import framework.system.pub.util.DateUtil;
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
public class LoginController extends MyBaseController {
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
				Log log = new Log();
				log.setUser(userName);
				log.setIp(this.getIpAddr(request));
				log.setCreate_date(DateUtil.getDateTime());
				log.setOperation("登录");
				log.setType("");
				logService.saveLog(log);
	        } 
	        return "main/index"; 
		} catch (IncorrectCredentialsException e) {  
	        msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	        return "redirect:/";
	    } catch (ExcessiveAttemptsException e) {  
	        msg = "登录失败次数过多";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
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
	        return "redirect:/";
	    } catch (UnauthorizedException e) {  
	        msg = "您没有得到相应的授权！" + e.getMessage();  
	        model.addAttribute("message", msg);  
	        System.out.println(msg); 
	        return "redirect:/";
	    }
		
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
