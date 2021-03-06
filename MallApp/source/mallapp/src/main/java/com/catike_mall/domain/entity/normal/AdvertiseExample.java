package com.catike_mall.domain.entity.normal;

import java.util.ArrayList;
import java.util.List;

public class AdvertiseExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table advertise
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table advertise
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table advertise
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table advertise
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public AdvertiseExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table advertise
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table advertise
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table advertise
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table advertise
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table advertise
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table advertise
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table advertise
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table advertise
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table advertise
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table advertise
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table advertise
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andPkIdIsNull() {
			addCriterion("PK_ID is null");
			return (Criteria) this;
		}

		public Criteria andPkIdIsNotNull() {
			addCriterion("PK_ID is not null");
			return (Criteria) this;
		}

		public Criteria andPkIdEqualTo(Integer value) {
			addCriterion("PK_ID =", value, "pkId");
			return (Criteria) this;
		}

		public Criteria andPkIdNotEqualTo(Integer value) {
			addCriterion("PK_ID <>", value, "pkId");
			return (Criteria) this;
		}

		public Criteria andPkIdGreaterThan(Integer value) {
			addCriterion("PK_ID >", value, "pkId");
			return (Criteria) this;
		}

		public Criteria andPkIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("PK_ID >=", value, "pkId");
			return (Criteria) this;
		}

		public Criteria andPkIdLessThan(Integer value) {
			addCriterion("PK_ID <", value, "pkId");
			return (Criteria) this;
		}

		public Criteria andPkIdLessThanOrEqualTo(Integer value) {
			addCriterion("PK_ID <=", value, "pkId");
			return (Criteria) this;
		}

		public Criteria andPkIdIn(List<Integer> values) {
			addCriterion("PK_ID in", values, "pkId");
			return (Criteria) this;
		}

		public Criteria andPkIdNotIn(List<Integer> values) {
			addCriterion("PK_ID not in", values, "pkId");
			return (Criteria) this;
		}

		public Criteria andPkIdBetween(Integer value1, Integer value2) {
			addCriterion("PK_ID between", value1, value2, "pkId");
			return (Criteria) this;
		}

		public Criteria andPkIdNotBetween(Integer value1, Integer value2) {
			addCriterion("PK_ID not between", value1, value2, "pkId");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("NAME is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("NAME is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("NAME =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("NAME <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("NAME >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("NAME >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("NAME <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("NAME <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("NAME like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("NAME not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("NAME in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("NAME not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("NAME between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("NAME not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andEnableIsNull() {
			addCriterion("ENABLE is null");
			return (Criteria) this;
		}

		public Criteria andEnableIsNotNull() {
			addCriterion("ENABLE is not null");
			return (Criteria) this;
		}

		public Criteria andEnableEqualTo(Boolean value) {
			addCriterion("ENABLE =", value, "enable");
			return (Criteria) this;
		}

		public Criteria andEnableNotEqualTo(Boolean value) {
			addCriterion("ENABLE <>", value, "enable");
			return (Criteria) this;
		}

		public Criteria andEnableGreaterThan(Boolean value) {
			addCriterion("ENABLE >", value, "enable");
			return (Criteria) this;
		}

		public Criteria andEnableGreaterThanOrEqualTo(Boolean value) {
			addCriterion("ENABLE >=", value, "enable");
			return (Criteria) this;
		}

		public Criteria andEnableLessThan(Boolean value) {
			addCriterion("ENABLE <", value, "enable");
			return (Criteria) this;
		}

		public Criteria andEnableLessThanOrEqualTo(Boolean value) {
			addCriterion("ENABLE <=", value, "enable");
			return (Criteria) this;
		}

		public Criteria andEnableIn(List<Boolean> values) {
			addCriterion("ENABLE in", values, "enable");
			return (Criteria) this;
		}

		public Criteria andEnableNotIn(List<Boolean> values) {
			addCriterion("ENABLE not in", values, "enable");
			return (Criteria) this;
		}

		public Criteria andEnableBetween(Boolean value1, Boolean value2) {
			addCriterion("ENABLE between", value1, value2, "enable");
			return (Criteria) this;
		}

		public Criteria andEnableNotBetween(Boolean value1, Boolean value2) {
			addCriterion("ENABLE not between", value1, value2, "enable");
			return (Criteria) this;
		}

		public Criteria andPositionIsNull() {
			addCriterion("POSITION is null");
			return (Criteria) this;
		}

		public Criteria andPositionIsNotNull() {
			addCriterion("POSITION is not null");
			return (Criteria) this;
		}

		public Criteria andPositionEqualTo(Integer value) {
			addCriterion("POSITION =", value, "position");
			return (Criteria) this;
		}

		public Criteria andPositionNotEqualTo(Integer value) {
			addCriterion("POSITION <>", value, "position");
			return (Criteria) this;
		}

		public Criteria andPositionGreaterThan(Integer value) {
			addCriterion("POSITION >", value, "position");
			return (Criteria) this;
		}

		public Criteria andPositionGreaterThanOrEqualTo(Integer value) {
			addCriterion("POSITION >=", value, "position");
			return (Criteria) this;
		}

		public Criteria andPositionLessThan(Integer value) {
			addCriterion("POSITION <", value, "position");
			return (Criteria) this;
		}

		public Criteria andPositionLessThanOrEqualTo(Integer value) {
			addCriterion("POSITION <=", value, "position");
			return (Criteria) this;
		}

		public Criteria andPositionIn(List<Integer> values) {
			addCriterion("POSITION in", values, "position");
			return (Criteria) this;
		}

		public Criteria andPositionNotIn(List<Integer> values) {
			addCriterion("POSITION not in", values, "position");
			return (Criteria) this;
		}

		public Criteria andPositionBetween(Integer value1, Integer value2) {
			addCriterion("POSITION between", value1, value2, "position");
			return (Criteria) this;
		}

		public Criteria andPositionNotBetween(Integer value1, Integer value2) {
			addCriterion("POSITION not between", value1, value2, "position");
			return (Criteria) this;
		}

		public Criteria andUrlIsNull() {
			addCriterion("URL is null");
			return (Criteria) this;
		}

		public Criteria andUrlIsNotNull() {
			addCriterion("URL is not null");
			return (Criteria) this;
		}

		public Criteria andUrlEqualTo(String value) {
			addCriterion("URL =", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotEqualTo(String value) {
			addCriterion("URL <>", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlGreaterThan(String value) {
			addCriterion("URL >", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlGreaterThanOrEqualTo(String value) {
			addCriterion("URL >=", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLessThan(String value) {
			addCriterion("URL <", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLessThanOrEqualTo(String value) {
			addCriterion("URL <=", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLike(String value) {
			addCriterion("URL like", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotLike(String value) {
			addCriterion("URL not like", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlIn(List<String> values) {
			addCriterion("URL in", values, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotIn(List<String> values) {
			addCriterion("URL not in", values, "url");
			return (Criteria) this;
		}

		public Criteria andUrlBetween(String value1, String value2) {
			addCriterion("URL between", value1, value2, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotBetween(String value1, String value2) {
			addCriterion("URL not between", value1, value2, "url");
			return (Criteria) this;
		}

		public Criteria andImageDirIsNull() {
			addCriterion("IMAGE_DIR is null");
			return (Criteria) this;
		}

		public Criteria andImageDirIsNotNull() {
			addCriterion("IMAGE_DIR is not null");
			return (Criteria) this;
		}

		public Criteria andImageDirEqualTo(String value) {
			addCriterion("IMAGE_DIR =", value, "imageDir");
			return (Criteria) this;
		}

		public Criteria andImageDirNotEqualTo(String value) {
			addCriterion("IMAGE_DIR <>", value, "imageDir");
			return (Criteria) this;
		}

		public Criteria andImageDirGreaterThan(String value) {
			addCriterion("IMAGE_DIR >", value, "imageDir");
			return (Criteria) this;
		}

		public Criteria andImageDirGreaterThanOrEqualTo(String value) {
			addCriterion("IMAGE_DIR >=", value, "imageDir");
			return (Criteria) this;
		}

		public Criteria andImageDirLessThan(String value) {
			addCriterion("IMAGE_DIR <", value, "imageDir");
			return (Criteria) this;
		}

		public Criteria andImageDirLessThanOrEqualTo(String value) {
			addCriterion("IMAGE_DIR <=", value, "imageDir");
			return (Criteria) this;
		}

		public Criteria andImageDirLike(String value) {
			addCriterion("IMAGE_DIR like", value, "imageDir");
			return (Criteria) this;
		}

		public Criteria andImageDirNotLike(String value) {
			addCriterion("IMAGE_DIR not like", value, "imageDir");
			return (Criteria) this;
		}

		public Criteria andImageDirIn(List<String> values) {
			addCriterion("IMAGE_DIR in", values, "imageDir");
			return (Criteria) this;
		}

		public Criteria andImageDirNotIn(List<String> values) {
			addCriterion("IMAGE_DIR not in", values, "imageDir");
			return (Criteria) this;
		}

		public Criteria andImageDirBetween(String value1, String value2) {
			addCriterion("IMAGE_DIR between", value1, value2, "imageDir");
			return (Criteria) this;
		}

		public Criteria andImageDirNotBetween(String value1, String value2) {
			addCriterion("IMAGE_DIR not between", value1, value2, "imageDir");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNull() {
			addCriterion("DESCRIPTION is null");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNotNull() {
			addCriterion("DESCRIPTION is not null");
			return (Criteria) this;
		}

		public Criteria andDescriptionEqualTo(String value) {
			addCriterion("DESCRIPTION =", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotEqualTo(String value) {
			addCriterion("DESCRIPTION <>", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThan(String value) {
			addCriterion("DESCRIPTION >", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("DESCRIPTION >=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThan(String value) {
			addCriterion("DESCRIPTION <", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThanOrEqualTo(String value) {
			addCriterion("DESCRIPTION <=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLike(String value) {
			addCriterion("DESCRIPTION like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotLike(String value) {
			addCriterion("DESCRIPTION not like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionIn(List<String> values) {
			addCriterion("DESCRIPTION in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotIn(List<String> values) {
			addCriterion("DESCRIPTION not in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionBetween(String value1, String value2) {
			addCriterion("DESCRIPTION between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotBetween(String value1, String value2) {
			addCriterion("DESCRIPTION not between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andPriceIsNull() {
			addCriterion("PRICE is null");
			return (Criteria) this;
		}

		public Criteria andPriceIsNotNull() {
			addCriterion("PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andPriceEqualTo(Long value) {
			addCriterion("PRICE =", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotEqualTo(Long value) {
			addCriterion("PRICE <>", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThan(Long value) {
			addCriterion("PRICE >", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThanOrEqualTo(Long value) {
			addCriterion("PRICE >=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThan(Long value) {
			addCriterion("PRICE <", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThanOrEqualTo(Long value) {
			addCriterion("PRICE <=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceIn(List<Long> values) {
			addCriterion("PRICE in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotIn(List<Long> values) {
			addCriterion("PRICE not in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceBetween(Long value1, Long value2) {
			addCriterion("PRICE between", value1, value2, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotBetween(Long value1, Long value2) {
			addCriterion("PRICE not between", value1, value2, "price");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table advertise
	 * @mbg.generated  Sat Aug 26 17:34:55 EET 2017
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table advertise
     *
     * @mbg.generated do_not_delete_during_merge Sun Aug 20 19:15:19 EET 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}