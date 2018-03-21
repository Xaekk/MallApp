package com.catike_mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.catike_mall.domain.entity.normal.ShoppingCart;
import com.catike_mall.domain.enums.AjaxResultStatus;
import com.catike_mall.service.CurrentUserService;
import com.catike_mall.service.ShoppingCartService;

/**
 * @disc Shopping Cart Controller
 * 
 * @author Ma Xuefeng
 * @date 2017Äê8ÔÂ26ÈÕ
 * @version v1.0.0
 */
@Controller
@RequestMapping("/cart")
public class ShoppingCartController {

	private ShoppingCartService shoppingCartService;
	private CurrentUserService currentUserService;

	@Autowired
	public ShoppingCartController(ShoppingCartService shoppingCartService, CurrentUserService currentUserService) {
		this.shoppingCartService = shoppingCartService;
		this.currentUserService = currentUserService;
	}

	@RequestMapping(value = "/putin", method = RequestMethod.POST)
	public @ResponseBody int putInCart(@RequestParam("goodsPkid") int goodsPkid, @RequestParam("quantity") int quantity) {

		if(currentUserService.getCurrentUser() != null){
			ShoppingCart shoppingCart = getNewShoppingCart(goodsPkid, quantity);
			shoppingCartService.addShoppingCart(shoppingCart);
			
			return AjaxResultStatus.SUCCESS.getValue();
		}else{
			return AjaxResultStatus.NOTLOGIN.getValue();
		}
	}
	
	@RequestMapping(value = "/getCurrentCart", method = RequestMethod.GET)
	public String getCurrentCart(Model model){
		
		List<ShoppingCart> shoppingCartList = shoppingCartService.getShoppingCartListByCurrentUser();
		model.addAttribute("shoppingCartList", shoppingCartList);
		
		return "";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteCart(@RequestParam("cartPkid") int cartPkid, @RequestParam("ver") int ver, Model model){
		
		
		
		shoppingCartService.deleteShoppingCartByPkid(cartPkid, ver);
		
		return "Redirect://";
	}

	/**
	 * Init New Shopping Cart
	 * 
	 * @param goodsPkid
	 * @param quantity
	 * @return
	 */
	private ShoppingCart getNewShoppingCart(int goodsPkid, int quantity){
		ShoppingCart shoppingCart = new ShoppingCart();
		
		shoppingCart.setBuyyerPkid(currentUserService.getCurrentUser().getPkId());
		shoppingCart.setGoodsPkid(goodsPkid);
		shoppingCart.setQuantity(quantity);
		
		return shoppingCart;
	}

}
