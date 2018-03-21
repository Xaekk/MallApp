package com.catike_mall.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.catike_mall.util.UpdateExposureList;

/**
 * @disc Create & Operate Exposure Task
 * 
 * @author Ma Xuefeng
 * @date 2017年8月19日
 * @version v1.0.0
 */

public class ExposureTask implements ServletContextListener {
	
	//Every [2 Hours] Update 'Exposure'
	private static final int delayTime = 1000 * 60 * 60 * 2;
	
	public void contextInitialized(ServletContextEvent event) {
		final UpdateExposureList updateExposureList = (UpdateExposureList) WebApplicationContextUtils
				.getWebApplicationContext(event.getServletContext()).getBean("updateExposureList");

		updateExposureList.updateExposureInList(delayTime);
	}

	public void contextDestroyed(ServletContextEvent event) {
	}
}
