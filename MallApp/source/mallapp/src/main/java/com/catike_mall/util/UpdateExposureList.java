package com.catike_mall.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.catike_mall.dao.normal.GoodsInfoMapper;
import com.catike_mall.domain.entity.normal.GoodsInfo;

/**
 * @disc Update GoodsInfo Exposure List
 * 
 * @author Ma Xuefeng
 * @date 2017Äê8ÔÂ19ÈÕ
 * @version v1.0.0
 */

@Component("updateExposureList")
public class UpdateExposureList {
	
	private Lock lock = new ReentrantLock();
	
	private static List<Integer> exposureList = new ArrayList<Integer>();
	
	GoodsInfoMapper goodsInfoMapper;
	
	@Autowired
	public UpdateExposureList(GoodsInfoMapper goodsInfoMapper){
		this.goodsInfoMapper = goodsInfoMapper;
	}

	/**
	 * Used in ServiceImpl , to add GoodsInfo Exposure Into List
	 * 
	 * @param goodsInfoList
	 */
	public void addExposureInList(List<GoodsInfo> goodsInfoList) {
		
		lock.lock();
		try {
			for (GoodsInfo goodsInfo : goodsInfoList) {
				exposureList.add(goodsInfo.getPkId());
			}
		} finally {
			lock.unlock();
		}
	}
	
	/**
	 * Used in ContextListener , to add ExposureList Into DB 
	 * 
	 * @param delayTime : Delay Time
	 */
	public void updateExposureInList(final Integer delayTime){
		
		new Thread(new Runnable() {

			public void run() {
				while (true) {

					lock.lock();
					
					try {
						
						for (Integer pkId : exposureList) {
							GoodsInfo goodsInfo = goodsInfoMapper.selectByPrimaryKey(pkId);
							
							goodsInfo.setExposure(goodsInfo.getExposure() + 1);
							
							goodsInfoMapper.updateByPrimaryKeySelective(goodsInfo);
						}
						exposureList.clear();
					} finally {
						lock.unlock();
					}

					try {
						Thread.sleep(delayTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}).start();
	}
}
