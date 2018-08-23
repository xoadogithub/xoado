package com.xoado.wx.bean;

import java.util.ArrayList;
import java.util.List;

public class TblComponentverifyticketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblComponentverifyticketExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andWx3AppIdIsNull() {
            addCriterion("WX3_app_id is null");
            return (Criteria) this;
        }

        public Criteria andWx3AppIdIsNotNull() {
            addCriterion("WX3_app_id is not null");
            return (Criteria) this;
        }

        public Criteria andWx3AppIdEqualTo(String value) {
            addCriterion("WX3_app_id =", value, "wx3AppId");
            return (Criteria) this;
        }

        public Criteria andWx3AppIdNotEqualTo(String value) {
            addCriterion("WX3_app_id <>", value, "wx3AppId");
            return (Criteria) this;
        }

        public Criteria andWx3AppIdGreaterThan(String value) {
            addCriterion("WX3_app_id >", value, "wx3AppId");
            return (Criteria) this;
        }

        public Criteria andWx3AppIdGreaterThanOrEqualTo(String value) {
            addCriterion("WX3_app_id >=", value, "wx3AppId");
            return (Criteria) this;
        }

        public Criteria andWx3AppIdLessThan(String value) {
            addCriterion("WX3_app_id <", value, "wx3AppId");
            return (Criteria) this;
        }

        public Criteria andWx3AppIdLessThanOrEqualTo(String value) {
            addCriterion("WX3_app_id <=", value, "wx3AppId");
            return (Criteria) this;
        }

        public Criteria andWx3AppIdLike(String value) {
            addCriterion("WX3_app_id like", value, "wx3AppId");
            return (Criteria) this;
        }

        public Criteria andWx3AppIdNotLike(String value) {
            addCriterion("WX3_app_id not like", value, "wx3AppId");
            return (Criteria) this;
        }

        public Criteria andWx3AppIdIn(List<String> values) {
            addCriterion("WX3_app_id in", values, "wx3AppId");
            return (Criteria) this;
        }

        public Criteria andWx3AppIdNotIn(List<String> values) {
            addCriterion("WX3_app_id not in", values, "wx3AppId");
            return (Criteria) this;
        }

        public Criteria andWx3AppIdBetween(String value1, String value2) {
            addCriterion("WX3_app_id between", value1, value2, "wx3AppId");
            return (Criteria) this;
        }

        public Criteria andWx3AppIdNotBetween(String value1, String value2) {
            addCriterion("WX3_app_id not between", value1, value2, "wx3AppId");
            return (Criteria) this;
        }

        public Criteria andComponentverifyticketIsNull() {
            addCriterion("ComponentVerifyTicket is null");
            return (Criteria) this;
        }

        public Criteria andComponentverifyticketIsNotNull() {
            addCriterion("ComponentVerifyTicket is not null");
            return (Criteria) this;
        }

        public Criteria andComponentverifyticketEqualTo(String value) {
            addCriterion("ComponentVerifyTicket =", value, "componentverifyticket");
            return (Criteria) this;
        }

        public Criteria andComponentverifyticketNotEqualTo(String value) {
            addCriterion("ComponentVerifyTicket <>", value, "componentverifyticket");
            return (Criteria) this;
        }

        public Criteria andComponentverifyticketGreaterThan(String value) {
            addCriterion("ComponentVerifyTicket >", value, "componentverifyticket");
            return (Criteria) this;
        }

        public Criteria andComponentverifyticketGreaterThanOrEqualTo(String value) {
            addCriterion("ComponentVerifyTicket >=", value, "componentverifyticket");
            return (Criteria) this;
        }

        public Criteria andComponentverifyticketLessThan(String value) {
            addCriterion("ComponentVerifyTicket <", value, "componentverifyticket");
            return (Criteria) this;
        }

        public Criteria andComponentverifyticketLessThanOrEqualTo(String value) {
            addCriterion("ComponentVerifyTicket <=", value, "componentverifyticket");
            return (Criteria) this;
        }

        public Criteria andComponentverifyticketLike(String value) {
            addCriterion("ComponentVerifyTicket like", value, "componentverifyticket");
            return (Criteria) this;
        }

        public Criteria andComponentverifyticketNotLike(String value) {
            addCriterion("ComponentVerifyTicket not like", value, "componentverifyticket");
            return (Criteria) this;
        }

        public Criteria andComponentverifyticketIn(List<String> values) {
            addCriterion("ComponentVerifyTicket in", values, "componentverifyticket");
            return (Criteria) this;
        }

        public Criteria andComponentverifyticketNotIn(List<String> values) {
            addCriterion("ComponentVerifyTicket not in", values, "componentverifyticket");
            return (Criteria) this;
        }

        public Criteria andComponentverifyticketBetween(String value1, String value2) {
            addCriterion("ComponentVerifyTicket between", value1, value2, "componentverifyticket");
            return (Criteria) this;
        }

        public Criteria andComponentverifyticketNotBetween(String value1, String value2) {
            addCriterion("ComponentVerifyTicket not between", value1, value2, "componentverifyticket");
            return (Criteria) this;
        }

        public Criteria andPreAuthCodeIsNull() {
            addCriterion("pre_auth_code is null");
            return (Criteria) this;
        }

        public Criteria andPreAuthCodeIsNotNull() {
            addCriterion("pre_auth_code is not null");
            return (Criteria) this;
        }

        public Criteria andPreAuthCodeEqualTo(String value) {
            addCriterion("pre_auth_code =", value, "preAuthCode");
            return (Criteria) this;
        }

        public Criteria andPreAuthCodeNotEqualTo(String value) {
            addCriterion("pre_auth_code <>", value, "preAuthCode");
            return (Criteria) this;
        }

        public Criteria andPreAuthCodeGreaterThan(String value) {
            addCriterion("pre_auth_code >", value, "preAuthCode");
            return (Criteria) this;
        }

        public Criteria andPreAuthCodeGreaterThanOrEqualTo(String value) {
            addCriterion("pre_auth_code >=", value, "preAuthCode");
            return (Criteria) this;
        }

        public Criteria andPreAuthCodeLessThan(String value) {
            addCriterion("pre_auth_code <", value, "preAuthCode");
            return (Criteria) this;
        }

        public Criteria andPreAuthCodeLessThanOrEqualTo(String value) {
            addCriterion("pre_auth_code <=", value, "preAuthCode");
            return (Criteria) this;
        }

        public Criteria andPreAuthCodeLike(String value) {
            addCriterion("pre_auth_code like", value, "preAuthCode");
            return (Criteria) this;
        }

        public Criteria andPreAuthCodeNotLike(String value) {
            addCriterion("pre_auth_code not like", value, "preAuthCode");
            return (Criteria) this;
        }

        public Criteria andPreAuthCodeIn(List<String> values) {
            addCriterion("pre_auth_code in", values, "preAuthCode");
            return (Criteria) this;
        }

        public Criteria andPreAuthCodeNotIn(List<String> values) {
            addCriterion("pre_auth_code not in", values, "preAuthCode");
            return (Criteria) this;
        }

        public Criteria andPreAuthCodeBetween(String value1, String value2) {
            addCriterion("pre_auth_code between", value1, value2, "preAuthCode");
            return (Criteria) this;
        }

        public Criteria andPreAuthCodeNotBetween(String value1, String value2) {
            addCriterion("pre_auth_code not between", value1, value2, "preAuthCode");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenIsNull() {
            addCriterion("component_access_token is null");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenIsNotNull() {
            addCriterion("component_access_token is not null");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenEqualTo(String value) {
            addCriterion("component_access_token =", value, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenNotEqualTo(String value) {
            addCriterion("component_access_token <>", value, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenGreaterThan(String value) {
            addCriterion("component_access_token >", value, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenGreaterThanOrEqualTo(String value) {
            addCriterion("component_access_token >=", value, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenLessThan(String value) {
            addCriterion("component_access_token <", value, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenLessThanOrEqualTo(String value) {
            addCriterion("component_access_token <=", value, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenLike(String value) {
            addCriterion("component_access_token like", value, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenNotLike(String value) {
            addCriterion("component_access_token not like", value, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenIn(List<String> values) {
            addCriterion("component_access_token in", values, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenNotIn(List<String> values) {
            addCriterion("component_access_token not in", values, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenBetween(String value1, String value2) {
            addCriterion("component_access_token between", value1, value2, "componentAccessToken");
            return (Criteria) this;
        }

        public Criteria andComponentAccessTokenNotBetween(String value1, String value2) {
            addCriterion("component_access_token not between", value1, value2, "componentAccessToken");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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
}