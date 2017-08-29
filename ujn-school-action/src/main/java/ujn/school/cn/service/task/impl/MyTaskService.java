/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package ujn.school.cn.service.task.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import ujn.school.cn.service.task.IMyTaskService;
import framework.system.dao.LogMapper;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年8月29日 上午11:51:25 
 * @version V1.0   
 */
@Service
@Lazy(false)
public class MyTaskService implements IMyTaskService {
 
	@Resource
	private LogMapper logMapper;
    
    //（3、6、9、12） 月份的每月15日凌晨3点30分执行任务
    @Scheduled(cron="0 30 3 15 3,6,9,12 ?") 
    public void deleteLogTask() {
        //删除前3个月的日志
        logMapper.deleteLogForTask();
    }
 
    /**
     * 心跳更新。启动时执行一次，之后每隔2秒执行一次
     */
    //@Scheduled(fixedRate = 1000*2)
    //public void print(){
   //     System.out.println("心跳执行次数："+y++);
    //}
}
