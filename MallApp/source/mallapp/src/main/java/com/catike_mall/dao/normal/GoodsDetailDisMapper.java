package com.catike_mall.dao.normal;

import com.catike_mall.domain.entity.normal.GoodsDetailDis;
import com.catike_mall.domain.entity.normal.GoodsDetailDisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsDetailDisMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_detail_dis
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	long countByExample(GoodsDetailDisExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_detail_dis
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	int deleteByExample(GoodsDetailDisExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_detail_dis
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	int deleteByPrimaryKey(Integer pkId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_detail_dis
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	int insert(GoodsDetailDis record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_detail_dis
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	int insertSelective(GoodsDetailDis record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_detail_dis
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	List<GoodsDetailDis> selectByExample(GoodsDetailDisExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_detail_dis
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	GoodsDetailDis selectByPrimaryKey(Integer pkId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_detail_dis
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	int updateByExampleSelective(@Param("record") GoodsDetailDis record,
			@Param("example") GoodsDetailDisExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_detail_dis
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	int updateByExample(@Param("record") GoodsDetailDis record, @Param("example") GoodsDetailDisExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_detail_dis
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	int updateByPrimaryKeySelective(GoodsDetailDis record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_detail_dis
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	int updateByPrimaryKey(GoodsDetailDis record);
}