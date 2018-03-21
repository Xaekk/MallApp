package com.catike_mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catike_mall.util.ViewDir;

/**
 * @disc The Path Controller
 * 
 * @author Ma Xuefeng
 * @date 2017Äê8ÔÂ20ÈÕ
 * @version v1.0.0
 */
@Controller
@RequestMapping("/path")
public class PathController {

	public PathController() {

	}

	@RequestMapping(value = "/HowToOpenAnOnlineStore", method = RequestMethod.GET)
	public String HowToOpenAnOnlineStore() {
		return ViewDir.getDir("else.howToOpenAnOnlineStore");
	}

}
