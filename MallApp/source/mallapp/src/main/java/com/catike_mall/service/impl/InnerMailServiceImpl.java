package com.catike_mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catike_mall.dao.normal.InnerMailMapper;
import com.catike_mall.domain.entity.normal.InnerMail;
import com.catike_mall.service.InnerMailService;

/**
 * @disc Message Service Impl
 * 
 * @author Ma Xuefeng
 * @date 2017Äê8ÔÂ26ÈÕ
 * @version v1.0.0
 */
@Service("innerMailService")
public class InnerMailServiceImpl implements InnerMailService {

	private InnerMailMapper innerMailMapper;

	@Autowired
	public InnerMailServiceImpl(InnerMailMapper innerMailMapper) {
		this.innerMailMapper = innerMailMapper;
	}

	/* (non-Javadoc)
	 * @see com.catike_mall.service.InnerMailService#addInnerMail(com.catike_mall.domain.entity.normal.InnerMail)
	 */
	public InnerMail addInnerMail(InnerMail innerMail) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.catike_mall.service.InnerMailService#getInnerMailListByCurrentUser()
	 */
	public List<InnerMail> getInnerMailListByCurrentUser() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.catike_mall.service.InnerMailService#getInnerMailByPkId(int)
	 */
	public InnerMail getInnerMailByPkId(int pkId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
