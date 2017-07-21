package framework.system.pub.util;

import javax.servlet.http.HttpServletRequest;

import framework.system.context.FrameworkeContext;
import framework.system.model.Log;
import framework.system.model.User;
import framework.system.service.ILogService;

/**
 * 操作日志对外服务工具类
 * @author Administrator
 *
 */
public class LogUtil {

	/**
	 * 保存操作日志
	 * @param log Log
	 * @return boolean
	 */
	public static int saveLog(Log log){
		ILogService logService = (ILogService) FrameworkeContext.getInstance().getBean("logService");
		return logService.addLog(log);
	}

	/**
	 * 
	 * @Description: 保存日志
	 * @param request
	 * @param operation 操作说明
	 * @return
	 */
	public static int saveLog(HttpServletRequest request,String operation) {
		User sessionUser = UserSessionUtil.getUser(request);
		Log log = new Log();
		if(null != sessionUser){
			log.setUser(sessionUser.getLogin_name());
		}
		log.setIp(getIpAddr(request));
		log.setCreate_date(DateUtil.getDateTime());
		log.setOperation(operation);
		log.setType("");
		return saveLog(log);
		
	}
	
	/**
	 * 获取IP
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
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
