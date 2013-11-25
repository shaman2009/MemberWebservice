package com.dandelion.memberapp.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmailbeanExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table tb_emailbean
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table tb_emailbean
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table tb_emailbean
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_emailbean
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	public EmailbeanExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_emailbean
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_emailbean
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_emailbean
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_emailbean
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_emailbean
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_emailbean
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_emailbean
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_emailbean
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_emailbean
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tb_emailbean
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table tb_emailbean
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("ID is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("ID is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("ID =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("ID <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("ID >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("ID >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("ID <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("ID <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("ID in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("ID not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("ID between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("ID not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andTokenIsNull() {
			addCriterion("token is null");
			return (Criteria) this;
		}

		public Criteria andTokenIsNotNull() {
			addCriterion("token is not null");
			return (Criteria) this;
		}

		public Criteria andTokenEqualTo(String value) {
			addCriterion("token =", value, "token");
			return (Criteria) this;
		}

		public Criteria andTokenNotEqualTo(String value) {
			addCriterion("token <>", value, "token");
			return (Criteria) this;
		}

		public Criteria andTokenGreaterThan(String value) {
			addCriterion("token >", value, "token");
			return (Criteria) this;
		}

		public Criteria andTokenGreaterThanOrEqualTo(String value) {
			addCriterion("token >=", value, "token");
			return (Criteria) this;
		}

		public Criteria andTokenLessThan(String value) {
			addCriterion("token <", value, "token");
			return (Criteria) this;
		}

		public Criteria andTokenLessThanOrEqualTo(String value) {
			addCriterion("token <=", value, "token");
			return (Criteria) this;
		}

		public Criteria andTokenLike(String value) {
			addCriterion("token like", value, "token");
			return (Criteria) this;
		}

		public Criteria andTokenNotLike(String value) {
			addCriterion("token not like", value, "token");
			return (Criteria) this;
		}

		public Criteria andTokenIn(List<String> values) {
			addCriterion("token in", values, "token");
			return (Criteria) this;
		}

		public Criteria andTokenNotIn(List<String> values) {
			addCriterion("token not in", values, "token");
			return (Criteria) this;
		}

		public Criteria andTokenBetween(String value1, String value2) {
			addCriterion("token between", value1, value2, "token");
			return (Criteria) this;
		}

		public Criteria andTokenNotBetween(String value1, String value2) {
			addCriterion("token not between", value1, value2, "token");
			return (Criteria) this;
		}

		public Criteria andExpireIsNull() {
			addCriterion("expire is null");
			return (Criteria) this;
		}

		public Criteria andExpireIsNotNull() {
			addCriterion("expire is not null");
			return (Criteria) this;
		}

		public Criteria andExpireEqualTo(Date value) {
			addCriterion("expire =", value, "expire");
			return (Criteria) this;
		}

		public Criteria andExpireNotEqualTo(Date value) {
			addCriterion("expire <>", value, "expire");
			return (Criteria) this;
		}

		public Criteria andExpireGreaterThan(Date value) {
			addCriterion("expire >", value, "expire");
			return (Criteria) this;
		}

		public Criteria andExpireGreaterThanOrEqualTo(Date value) {
			addCriterion("expire >=", value, "expire");
			return (Criteria) this;
		}

		public Criteria andExpireLessThan(Date value) {
			addCriterion("expire <", value, "expire");
			return (Criteria) this;
		}

		public Criteria andExpireLessThanOrEqualTo(Date value) {
			addCriterion("expire <=", value, "expire");
			return (Criteria) this;
		}

		public Criteria andExpireIn(List<Date> values) {
			addCriterion("expire in", values, "expire");
			return (Criteria) this;
		}

		public Criteria andExpireNotIn(List<Date> values) {
			addCriterion("expire not in", values, "expire");
			return (Criteria) this;
		}

		public Criteria andExpireBetween(Date value1, Date value2) {
			addCriterion("expire between", value1, value2, "expire");
			return (Criteria) this;
		}

		public Criteria andExpireNotBetween(Date value1, Date value2) {
			addCriterion("expire not between", value1, value2, "expire");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table tb_emailbean
	 * @mbggenerated  Mon Nov 25 11:34:32 CST 2013
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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
     * This class corresponds to the database table tb_emailbean
     *
     * @mbggenerated do_not_delete_during_merge Tue Oct 29 17:49:28 CST 2013
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}