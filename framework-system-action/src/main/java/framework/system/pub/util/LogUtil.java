package framework.system.pub.util;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import framework.system.context.FrameworkeContext;
import framework.system.model.Log;
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
	 * 保存操作日志.
	 * @param req
	 * @param czlx 操作类型
	 * @param cznr 操作内容
	 * @return
	 */
	/*public static int saveLog(HttpServletRequest req,
			String czlx, String cznr, String bz) {
		long glbm = UserSessionUtil.getGlbmID(req);
		long yhid = UserSessionUtil.getUserID(req);
		String yhxm = UserSessionUtil.getMemberName(req);
		String bmmc = UserSessionUtil.getGlbmName(req);
		Log log = new Log();
		log.setYhid(yhid);
		log.setYhxm(yhxm);
		log.setGlbm(glbm);
		log.setBmmc(bmmc);
		log.setCzsj(new Date());
		log.setCzlx(czlx);
		if(StringUtils.isNotEmpty(req.getParameter("menuID"))){
			log.setCzcd(Long.parseLong(req.getParameter("menuID")));
		}else{
			log.setCzcd(-1L);
		}
		log.setCznr(cznr);
		log.setIp(req.getRemoteAddr());
		log.setBz(bz);
		return saveLog(log);
	}*/
}
