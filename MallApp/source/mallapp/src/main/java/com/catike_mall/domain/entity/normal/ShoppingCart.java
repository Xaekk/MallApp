package com.catike_mall.domain.entity.normal;

import java.util.Date;

public class ShoppingCart {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shopping_cart.PK_ID
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    private Integer pkId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shopping_cart.GOODS_PKID
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    private Integer goodsPkid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shopping_cart.BUYYER_PKID
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    private Integer buyyerPkid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shopping_cart.QUANTITY
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    private Integer quantity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shopping_cart.MAKE_EMP
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    private Integer makeEmp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shopping_cart.MAKE_TIME
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    private Date makeTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shopping_cart.MODIFY_EMP
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    private Integer modifyEmp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shopping_cart.MODIFY_TIME
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    private Date modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shopping_cart.VER
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    private Integer ver;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shopping_cart.PK_ID
     *
     * @return the value of shopping_cart.PK_ID
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    public Integer getPkId() {
        return pkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shopping_cart.PK_ID
     *
     * @param pkId the value for shopping_cart.PK_ID
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shopping_cart.GOODS_PKID
     *
     * @return the value of shopping_cart.GOODS_PKID
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    public Integer getGoodsPkid() {
        return goodsPkid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shopping_cart.GOODS_PKID
     *
     * @param goodsPkid the value for shopping_cart.GOODS_PKID
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    public void setGoodsPkid(Integer goodsPkid) {
        this.goodsPkid = goodsPkid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shopping_cart.BUYYER_PKID
     *
     * @return the value of shopping_cart.BUYYER_PKID
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    public Integer getBuyyerPkid() {
        return buyyerPkid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shopping_cart.BUYYER_PKID
     *
     * @param buyyerPkid the value for shopping_cart.BUYYER_PKID
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    public void setBuyyerPkid(Integer buyyerPkid) {
        this.buyyerPkid = buyyerPkid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shopping_cart.QUANTITY
     *
     * @return the value of shopping_cart.QUANTITY
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shopping_cart.QUANTITY
     *
     * @param quantity the value for shopping_cart.QUANTITY
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shopping_cart.MAKE_EMP
     *
     * @return the value of shopping_cart.MAKE_EMP
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    public Integer getMakeEmp() {
        return makeEmp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shopping_cart.MAKE_EMP
     *
     * @param makeEmp the value for shopping_cart.MAKE_EMP
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    public void setMakeEmp(Integer makeEmp) {
        this.makeEmp = makeEmp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shopping_cart.MAKE_TIME
     *
     * @return the value of shopping_cart.MAKE_TIME
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    public Date getMakeTime() {
        return makeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shopping_cart.MAKE_TIME
     *
     * @param makeTime the value for shopping_cart.MAKE_TIME
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    public void setMakeTime(Date makeTime) {
        this.makeTime = makeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shopping_cart.MODIFY_EMP
     *
     * @return the value of shopping_cart.MODIFY_EMP
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    public Integer getModifyEmp() {
        return modifyEmp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shopping_cart.MODIFY_EMP
     *
     * @param modifyEmp the value for shopping_cart.MODIFY_EMP
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    public void setModifyEmp(Integer modifyEmp) {
        this.modifyEmp = modifyEmp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shopping_cart.MODIFY_TIME
     *
     * @return the value of shopping_cart.MODIFY_TIME
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shopping_cart.MODIFY_TIME
     *
     * @param modifyTime the value for shopping_cart.MODIFY_TIME
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shopping_cart.VER
     *
     * @return the value of shopping_cart.VER
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    public Integer getVer() {
        return ver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shopping_cart.VER
     *
     * @param ver the value for shopping_cart.VER
     *
     * @mbg.generated Sat Aug 26 17:34:55 EET 2017
     */
    public void setVer(Integer ver) {
        this.ver = ver;
    }
}