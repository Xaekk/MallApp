package com.catike_mall.service;

/**
 * @disc Entity Data Version Security
 * 
 * @author Ma Xuefeng
 * @date 2017Äê8ÔÂ5ÈÕ
 * @version v1.0.0
 */

public interface VerService {
	
	/**
	 * Entity be Created
	 * 
	 * @param obj
	 */
	public void entityCreate(Object obj);
	
	/**
	 * Entity be Updated
	 * 
	 * @param obj
	 * @return true: version the same
	 * 		   false: version wrong 
	 */
	public boolean entityUpdate(Object obj);
	
	/**
	 * Entity be Deleted
	 * 
	 * @param obj
	 * @return true: version the same
	 * 		   false: version wrong
	 */
	public boolean entityDelete(Object obj);
}
