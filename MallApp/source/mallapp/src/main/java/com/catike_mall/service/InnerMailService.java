package com.catike_mall.service;

import java.util.List;

import com.catike_mall.domain.entity.normal.InnerMail;

/**
 * @disc Message Service
 * 
 * @author Ma Xuefeng
 * @date 2017Äê8ÔÂ26ÈÕ
 * @version v1.0.0
 */

public interface InnerMailService {
	
	/**
	 * Add Inner Mail
	 * 
	 * @param innerMail
	 */
	InnerMail addInnerMail(InnerMail innerMail);
	
	/**
	 * Get Inner Mail List
	 * 
	 * @return
	 */
	List<InnerMail> getInnerMailListByCurrentUser();
	
	/**
	 * Get Inner Mail by PkId
	 * 
	 * @return
	 */
	InnerMail getInnerMailByPkId(int pkId);
	
}
