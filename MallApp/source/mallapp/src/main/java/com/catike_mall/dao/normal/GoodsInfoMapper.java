package com.catike_mall.dao.normal;

import com.catike_mall.domain.entity.normal.GoodsInfo;
import com.catike_mall.domain.entity.normal.GoodsInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsInfoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_info
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	long countByExample(GoodsInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_info
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	int deleteByExample(GoodsInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_info
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	int deleteByPrimaryKey(Integer pkId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_info
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	int insert(GoodsInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_info
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	int insertSelective(GoodsInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_info
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	List<GoodsInfo> selectByExample(GoodsInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_info
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	GoodsInfo selectByPrimaryKey(Integer pkId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_info
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	int updateByExampleSelective(@Param("record") GoodsInfo record, @Param("example") GoodsInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_info
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	int updateByExample(@Param("record") GoodsInfo record, @Param("example") GoodsInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_info
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	int updateByPrimaryKeySelective(GoodsInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_info
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	int updateByPrimaryKey(GoodsInfo record);
}