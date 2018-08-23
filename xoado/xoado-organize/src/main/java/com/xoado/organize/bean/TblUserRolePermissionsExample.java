package com.xoado.organize.bean;

import java.util.ArrayList;
import java.util.List;

public class TblUserRolePermissionsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblUserRolePermissionsExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andObjectidIsNull() {
            addCriterion("objectId is null");
            return (Criteria) this;
        }

        public Criteria andObjectidIsNotNull() {
            addCriterion("objectId is not null");
            return (Criteria) this;
        }

        public Criteria andObjectidEqualTo(String value) {
            addCriterion("objectId =", value, "objectid");
            return (Criteria) this;
        }

        public Criteria andObjectidNotEqualTo(String value) {
            addCriterion("objectId <>", value, "objectid");
            return (Criteria) this;
        }

        public Criteria andObjectidGreaterThan(String value) {
            addCriterion("objectId >", value, "objectid");
            return (Criteria) this;
        }

        public Criteria andObjectidGreaterThanOrEqualTo(String value) {
            addCriterion("objectId >=", value, "objectid");
            return (Criteria) this;
        }

        public Criteria andObjectidLessThan(String value) {
            addCriterion("objectId <", value, "objectid");
            return (Criteria) this;
        }

        public Criteria andObjectidLessThanOrEqualTo(String value) {
            addCriterion("objectId <=", value, "objectid");
            return (Criteria) this;
        }

        public Criteria andObjectidLike(String value) {
            addCriterion("objectId like", value, "objectid");
            return (Criteria) this;
        }

        public Criteria andObjectidNotLike(String value) {
            addCriterion("objectId not like", value, "objectid");
            return (Criteria) this;
        }

        public Criteria andObjectidIn(List<String> values) {
            addCriterion("objectId in", values, "objectid");
            return (Criteria) this;
        }

        public Criteria andObjectidNotIn(List<String> values) {
            addCriterion("objectId not in", values, "objectid");
            return (Criteria) this;
        }

        public Criteria andObjectidBetween(String value1, String value2) {
            addCriterion("objectId between", value1, value2, "objectid");
            return (Criteria) this;
        }

        public Criteria andObjectidNotBetween(String value1, String value2) {
            addCriterion("objectId not between", value1, value2, "objectid");
            return (Criteria) this;
        }

        public Criteria andRoleoruserIsNull() {
            addCriterion("roleoruser is null");
            return (Criteria) this;
        }

        public Criteria andRoleoruserIsNotNull() {
            addCriterion("roleoruser is not null");
            return (Criteria) this;
        }

        public Criteria andRoleoruserEqualTo(Long value) {
            addCriterion("roleoruser =", value, "roleoruser");
            return (Criteria) this;
        }

        public Criteria andRoleoruserNotEqualTo(Long value) {
            addCriterion("roleoruser <>", value, "roleoruser");
            return (Criteria) this;
        }

        public Criteria andRoleoruserGreaterThan(Long value) {
            addCriterion("roleoruser >", value, "roleoruser");
            return (Criteria) this;
        }

        public Criteria andRoleoruserGreaterThanOrEqualTo(Long value) {
            addCriterion("roleoruser >=", value, "roleoruser");
            return (Criteria) this;
        }

        public Criteria andRoleoruserLessThan(Long value) {
            addCriterion("roleoruser <", value, "roleoruser");
            return (Criteria) this;
        }

        public Criteria andRoleoruserLessThanOrEqualTo(Long value) {
            addCriterion("roleoruser <=", value, "roleoruser");
            return (Criteria) this;
        }

        public Criteria andRoleoruserIn(List<Long> values) {
            addCriterion("roleoruser in", values, "roleoruser");
            return (Criteria) this;
        }

        public Criteria andRoleoruserNotIn(List<Long> values) {
            addCriterion("roleoruser not in", values, "roleoruser");
            return (Criteria) this;
        }

        public Criteria andRoleoruserBetween(Long value1, Long value2) {
            addCriterion("roleoruser between", value1, value2, "roleoruser");
            return (Criteria) this;
        }

        public Criteria andRoleoruserNotBetween(Long value1, Long value2) {
            addCriterion("roleoruser not between", value1, value2, "roleoruser");
            return (Criteria) this;
        }

        public Criteria andOrganizeidIsNull() {
            addCriterion("organizeId is null");
            return (Criteria) this;
        }

        public Criteria andOrganizeidIsNotNull() {
            addCriterion("organizeId is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizeidEqualTo(String value) {
            addCriterion("organizeId =", value, "organizeid");
            return (Criteria) this;
        }

        public Criteria andOrganizeidNotEqualTo(String value) {
            addCriterion("organizeId <>", value, "organizeid");
            return (Criteria) this;
        }

        public Criteria andOrganizeidGreaterThan(String value) {
            addCriterion("organizeId >", value, "organizeid");
            return (Criteria) this;
        }

        public Criteria andOrganizeidGreaterThanOrEqualTo(String value) {
            addCriterion("organizeId >=", value, "organizeid");
            return (Criteria) this;
        }

        public Criteria andOrganizeidLessThan(String value) {
            addCriterion("organizeId <", value, "organizeid");
            return (Criteria) this;
        }

        public Criteria andOrganizeidLessThanOrEqualTo(String value) {
            addCriterion("organizeId <=", value, "organizeid");
            return (Criteria) this;
        }

        public Criteria andOrganizeidLike(String value) {
            addCriterion("organizeId like", value, "organizeid");
            return (Criteria) this;
        }

        public Criteria andOrganizeidNotLike(String value) {
            addCriterion("organizeId not like", value, "organizeid");
            return (Criteria) this;
        }

        public Criteria andOrganizeidIn(List<String> values) {
            addCriterion("organizeId in", values, "organizeid");
            return (Criteria) this;
        }

        public Criteria andOrganizeidNotIn(List<String> values) {
            addCriterion("organizeId not in", values, "organizeid");
            return (Criteria) this;
        }

        public Criteria andOrganizeidBetween(String value1, String value2) {
            addCriterion("organizeId between", value1, value2, "organizeid");
            return (Criteria) this;
        }

        public Criteria andOrganizeidNotBetween(String value1, String value2) {
            addCriterion("organizeId not between", value1, value2, "organizeid");
            return (Criteria) this;
        }

        public Criteria andPermissionsidIsNull() {
            addCriterion("permissionsId is null");
            return (Criteria) this;
        }

        public Criteria andPermissionsidIsNotNull() {
            addCriterion("permissionsId is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionsidEqualTo(String value) {
            addCriterion("permissionsId =", value, "permissionsid");
            return (Criteria) this;
        }

        public Criteria andPermissionsidNotEqualTo(String value) {
            addCriterion("permissionsId <>", value, "permissionsid");
            return (Criteria) this;
        }

        public Criteria andPermissionsidGreaterThan(String value) {
            addCriterion("permissionsId >", value, "permissionsid");
            return (Criteria) this;
        }

        public Criteria andPermissionsidGreaterThanOrEqualTo(String value) {
            addCriterion("permissionsId >=", value, "permissionsid");
            return (Criteria) this;
        }

        public Criteria andPermissionsidLessThan(String value) {
            addCriterion("permissionsId <", value, "permissionsid");
            return (Criteria) this;
        }

        public Criteria andPermissionsidLessThanOrEqualTo(String value) {
            addCriterion("permissionsId <=", value, "permissionsid");
            return (Criteria) this;
        }

        public Criteria andPermissionsidLike(String value) {
            addCriterion("permissionsId like", value, "permissionsid");
            return (Criteria) this;
        }

        public Criteria andPermissionsidNotLike(String value) {
            addCriterion("permissionsId not like", value, "permissionsid");
            return (Criteria) this;
        }

        public Criteria andPermissionsidIn(List<String> values) {
            addCriterion("permissionsId in", values, "permissionsid");
            return (Criteria) this;
        }

        public Criteria andPermissionsidNotIn(List<String> values) {
            addCriterion("permissionsId not in", values, "permissionsid");
            return (Criteria) this;
        }

        public Criteria andPermissionsidBetween(String value1, String value2) {
            addCriterion("permissionsId between", value1, value2, "permissionsid");
            return (Criteria) this;
        }

        public Criteria andPermissionsidNotBetween(String value1, String value2) {
            addCriterion("permissionsId not between", value1, value2, "permissionsid");
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