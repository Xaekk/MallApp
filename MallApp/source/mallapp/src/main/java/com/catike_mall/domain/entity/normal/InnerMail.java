package com.catike_mall.domain.entity.normal;

import java.util.Date;

public class InnerMail {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column inner_mail.PK_ID
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	private Integer pkId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column inner_mail.FROM
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	private Integer from;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column inner_mail.TO
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	private Integer to;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column inner_mail.CONTENT
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	private String content;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column inner_mail.UNREAD
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	private Boolean unread;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column inner_mail.STATUS
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	private Integer status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column inner_mail.MAKE_EMP
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	private Integer makeEmp;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column inner_mail.MAKE_TIME
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	private Date makeTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column inner_mail.MODIFY_EMP
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	private Integer modifyEmp;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column inner_mail.MODIFY_TIME
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	private Date modifyTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column inner_mail.VER
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	private Integer ver;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column inner_mail.PK_ID
	 * @return  the value of inner_mail.PK_ID
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public Integer getPkId() {
		return pkId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column inner_mail.PK_ID
	 * @param pkId  the value for inner_mail.PK_ID
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public void setPkId(Integer pkId) {
		this.pkId = pkId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column inner_mail.FROM
	 * @return  the value of inner_mail.FROM
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public Integer getFrom() {
		return from;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column inner_mail.FROM
	 * @param from  the value for inner_mail.FROM
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public void setFrom(Integer from) {
		this.from = from;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column inner_mail.TO
	 * @return  the value of inner_mail.TO
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public Integer getTo() {
		return to;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column inner_mail.TO
	 * @param to  the value for inner_mail.TO
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public void setTo(Integer to) {
		this.to = to;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column inner_mail.CONTENT
	 * @return  the value of inner_mail.CONTENT
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public String getContent() {
		return content;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column inner_mail.CONTENT
	 * @param content  the value for inner_mail.CONTENT
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column inner_mail.UNREAD
	 * @return  the value of inner_mail.UNREAD
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public Boolean getUnread() {
		return unread;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column inner_mail.UNREAD
	 * @param unread  the value for inner_mail.UNREAD
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public void setUnread(Boolean unread) {
		this.unread = unread;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column inner_mail.STATUS
	 * @return  the value of inner_mail.STATUS
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column inner_mail.STATUS
	 * @param status  the value for inner_mail.STATUS
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column inner_mail.MAKE_EMP
	 * @return  the value of inner_mail.MAKE_EMP
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public Integer getMakeEmp() {
		return makeEmp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column inner_mail.MAKE_EMP
	 * @param makeEmp  the value for inner_mail.MAKE_EMP
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public void setMakeEmp(Integer makeEmp) {
		this.makeEmp = makeEmp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column inner_mail.MAKE_TIME
	 * @return  the value of inner_mail.MAKE_TIME
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public Date getMakeTime() {
		return makeTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column inner_mail.MAKE_TIME
	 * @param makeTime  the value for inner_mail.MAKE_TIME
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public void setMakeTime(Date makeTime) {
		this.makeTime = makeTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column inner_mail.MODIFY_EMP
	 * @return  the value of inner_mail.MODIFY_EMP
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public Integer getModifyEmp() {
		return modifyEmp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column inner_mail.MODIFY_EMP
	 * @param modifyEmp  the value for inner_mail.MODIFY_EMP
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public void setModifyEmp(Integer modifyEmp) {
		this.modifyEmp = modifyEmp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column inner_mail.MODIFY_TIME
	 * @return  the value of inner_mail.MODIFY_TIME
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column inner_mail.MODIFY_TIME
	 * @param modifyTime  the value for inner_mail.MODIFY_TIME
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column inner_mail.VER
	 * @return  the value of inner_mail.VER
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public Integer getVer() {
		return ver;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column inner_mail.VER
	 * @param ver  the value for inner_mail.VER
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public void setVer(Integer ver) {
		this.ver = ver;
	}
}