package com.catike_mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.catike_mall.dao.normal.AdvertiseMapper;
import com.catike_mall.domain.entity.normal.Advertise;
import com.catike_mall.domain.entity.normal.AdvertiseExample;
import com.catike_mall.domain.enums.AdvertisePosition;
import com.catike_mall.service.AdvertiseService;

/**
 * @disc Advertisement Function
 * 
 * @author Ma Xuefeng
 * @date 2017Äê8ÔÂ20ÈÕ
 * @version v1.0.0
 */
@Service("advertiseService")
public class AdvertiseServiceImpl implements AdvertiseService {

	private AdvertiseMapper advertiseMapper;

	@Autowired
	public AdvertiseServiceImpl(AdvertiseMapper advertiseMapper) {
		this.advertiseMapper = advertiseMapper;
	}
	
	public void addAllAdvertiseService(Model model) {

		withGoodsList(model);
		topOfHomepage(model);
		
	}

	public void withGoodsList(Model model) {
		
		AdvertiseExample advertiseExample = new AdvertiseExample();
		AdvertiseExample.Criteria advertiseExampleCriteria = advertiseExample.createCriteria();
		
		advertiseExampleCriteria.andEnableEqualTo(true)
								.andPositionEqualTo(AdvertisePosition.WithGoodsList.getValue());
		
		advertiseExample.setOrderByClause("PRICE desc");
		
		List<Advertise> advertiseList = advertiseMapper.selectByExample(advertiseExample);
		
		model.addAttribute("adWithGoodsList", advertiseList);
		model.addAttribute("advertiseList", advertiseList);
	}

	public void topOfHomepage(Model model) {

		AdvertiseExample advertiseExample = new AdvertiseExample();
		AdvertiseExample.Criteria advertiseExampleCriteria = advertiseExample.createCriteria();
		
		advertiseExampleCriteria.andEnableEqualTo(true)
								.andPositionEqualTo(AdvertisePosition.TopOfHomepage.getValue());
		
		advertiseExample.setOrderByClause("PRICE desc");
		
		List<Advertise> advertiseList = advertiseMapper.selectByExample(advertiseExample);
		
		model.addAttribute("adTopOfHomepage", advertiseList);
		model.addAttribute("advertiseList", advertiseList);
	}
	
	
}
