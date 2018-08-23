package com.xoado.FilingCabinet.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblCurrentArchivesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblCurrentArchivesExample() {
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

        public Criteria andOwneridIsNull() {
            addCriterion("ownerid is null");
            return (Criteria) this;
        }

        public Criteria andOwneridIsNotNull() {
            addCriterion("ownerid is not null");
            return (Criteria) this;
        }

        public Criteria andOwneridEqualTo(String value) {
            addCriterion("ownerid =", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotEqualTo(String value) {
            addCriterion("ownerid <>", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridGreaterThan(String value) {
            addCriterion("ownerid >", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridGreaterThanOrEqualTo(String value) {
            addCriterion("ownerid >=", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridLessThan(String value) {
            addCriterion("ownerid <", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridLessThanOrEqualTo(String value) {
            addCriterion("ownerid <=", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridLike(String value) {
            addCriterion("ownerid like", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotLike(String value) {
            addCriterion("ownerid not like", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridIn(List<String> values) {
            addCriterion("ownerid in", values, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotIn(List<String> values) {
            addCriterion("ownerid not in", values, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridBetween(String value1, String value2) {
            addCriterion("ownerid between", value1, value2, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotBetween(String value1, String value2) {
            addCriterion("ownerid not between", value1, value2, "ownerid");
            return (Criteria) this;
        }

        public Criteria andArchiveIdIsNull() {
            addCriterion("archive_id is null");
            return (Criteria) this;
        }

        public Criteria andArchiveIdIsNotNull() {
            addCriterion("archive_id is not null");
            return (Criteria) this;
        }

        public Criteria andArchiveIdEqualTo(String value) {
            addCriterion("archive_id =", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdNotEqualTo(String value) {
            addCriterion("archive_id <>", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdGreaterThan(String value) {
            addCriterion("archive_id >", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdGreaterThanOrEqualTo(String value) {
            addCriterion("archive_id >=", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdLessThan(String value) {
            addCriterion("archive_id <", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdLessThanOrEqualTo(String value) {
            addCriterion("archive_id <=", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdLike(String value) {
            addCriterion("archive_id like", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdNotLike(String value) {
            addCriterion("archive_id not like", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdIn(List<String> values) {
            addCriterion("archive_id in", values, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdNotIn(List<String> values) {
            addCriterion("archive_id not in", values, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdBetween(String value1, String value2) {
            addCriterion("archive_id between", value1, value2, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdNotBetween(String value1, String value2) {
            addCriterion("archive_id not between", value1, value2, "archiveId");
            return (Criteria) this;
        }

        public Criteria andOwnertypeIsNull() {
            addCriterion("ownertype is null");
            return (Criteria) this;
        }

        public Criteria andOwnertypeIsNotNull() {
            addCriterion("ownertype is not null");
            return (Criteria) this;
        }

        public Criteria andOwnertypeEqualTo(String value) {
            addCriterion("ownertype =", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeNotEqualTo(String value) {
            addCriterion("ownertype <>", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeGreaterThan(String value) {
            addCriterion("ownertype >", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeGreaterThanOrEqualTo(String value) {
            addCriterion("ownertype >=", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeLessThan(String value) {
            addCriterion("ownertype <", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeLessThanOrEqualTo(String value) {
            addCriterion("ownertype <=", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeLike(String value) {
            addCriterion("ownertype like", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeNotLike(String value) {
            addCriterion("ownertype not like", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeIn(List<String> values) {
            addCriterion("ownertype in", values, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeNotIn(List<String> values) {
            addCriterion("ownertype not in", values, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeBetween(String value1, String value2) {
            addCriterion("ownertype between", value1, value2, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeNotBetween(String value1, String value2) {
            addCriterion("ownertype not between", value1, value2, "ownertype");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Integer> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Integer> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andHoldfromIsNull() {
            addCriterion("holdfrom is null");
            return (Criteria) this;
        }

        public Criteria andHoldfromIsNotNull() {
            addCriterion("holdfrom is not null");
            return (Criteria) this;
        }

        public Criteria andHoldfromEqualTo(Object value) {
            addCriterion("holdfrom =", value, "holdfrom");
            return (Criteria) this;
        }

        public Criteria andHoldfromNotEqualTo(Object value) {
            addCriterion("holdfrom <>", value, "holdfrom");
            return (Criteria) this;
        }

        public Criteria andHoldfromGreaterThan(Object value) {
            addCriterion("holdfrom >", value, "holdfrom");
            return (Criteria) this;
        }

        public Criteria andHoldfromGreaterThanOrEqualTo(Object value) {
            addCriterion("holdfrom >=", value, "holdfrom");
            return (Criteria) this;
        }

        public Criteria andHoldfromLessThan(Object value) {
            addCriterion("holdfrom <", value, "holdfrom");
            return (Criteria) this;
        }

        public Criteria andHoldfromLessThanOrEqualTo(Object value) {
            addCriterion("holdfrom <=", value, "holdfrom");
            return (Criteria) this;
        }

        public Criteria andHoldfromIn(List<Object> values) {
            addCriterion("holdfrom in", values, "holdfrom");
            return (Criteria) this;
        }

        public Criteria andHoldfromNotIn(List<Object> values) {
            addCriterion("holdfrom not in", values, "holdfrom");
            return (Criteria) this;
        }

        public Criteria andHoldfromBetween(Object value1, Object value2) {
            addCriterion("holdfrom between", value1, value2, "holdfrom");
            return (Criteria) this;
        }

        public Criteria andHoldfromNotBetween(Object value1, Object value2) {
            addCriterion("holdfrom not between", value1, value2, "holdfrom");
            return (Criteria) this;
        }

        public Criteria andHolddateIsNull() {
            addCriterion("holddate is null");
            return (Criteria) this;
        }

        public Criteria andHolddateIsNotNull() {
            addCriterion("holddate is not null");
            return (Criteria) this;
        }

        public Criteria andHolddateEqualTo(Date value) {
            addCriterion("holddate =", value, "holddate");
            return (Criteria) this;
        }

        public Criteria andHolddateNotEqualTo(Date value) {
            addCriterion("holddate <>", value, "holddate");
            return (Criteria) this;
        }

        public Criteria andHolddateGreaterThan(Date value) {
            addCriterion("holddate >", value, "holddate");
            return (Criteria) this;
        }

        public Criteria andHolddateGreaterThanOrEqualTo(Date value) {
            addCriterion("holddate >=", value, "holddate");
            return (Criteria) this;
        }

        public Criteria andHolddateLessThan(Date value) {
            addCriterion("holddate <", value, "holddate");
            return (Criteria) this;
        }

        public Criteria andHolddateLessThanOrEqualTo(Date value) {
            addCriterion("holddate <=", value, "holddate");
            return (Criteria) this;
        }

        public Criteria andHolddateIn(List<Date> values) {
            addCriterion("holddate in", values, "holddate");
            return (Criteria) this;
        }

        public Criteria andHolddateNotIn(List<Date> values) {
            addCriterion("holddate not in", values, "holddate");
            return (Criteria) this;
        }

        public Criteria andHolddateBetween(Date value1, Date value2) {
            addCriterion("holddate between", value1, value2, "holddate");
            return (Criteria) this;
        }

        public Criteria andHolddateNotBetween(Date value1, Date value2) {
            addCriterion("holddate not between", value1, value2, "holddate");
            return (Criteria) this;
        }

        public Criteria andTaskidIsNull() {
            addCriterion("taskid is null");
            return (Criteria) this;
        }

        public Criteria andTaskidIsNotNull() {
            addCriterion("taskid is not null");
            return (Criteria) this;
        }

        public Criteria andTaskidEqualTo(String value) {
            addCriterion("taskid =", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotEqualTo(String value) {
            addCriterion("taskid <>", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidGreaterThan(String value) {
            addCriterion("taskid >", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidGreaterThanOrEqualTo(String value) {
            addCriterion("taskid >=", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLessThan(String value) {
            addCriterion("taskid <", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLessThanOrEqualTo(String value) {
            addCriterion("taskid <=", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLike(String value) {
            addCriterion("taskid like", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotLike(String value) {
            addCriterion("taskid not like", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidIn(List<String> values) {
            addCriterion("taskid in", values, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotIn(List<String> values) {
            addCriterion("taskid not in", values, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidBetween(String value1, String value2) {
            addCriterion("taskid between", value1, value2, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotBetween(String value1, String value2) {
            addCriterion("taskid not between", value1, value2, "taskid");
            return (Criteria) this;
        }

        public Criteria andHandoverIdIsNull() {
            addCriterion("handover_id is null");
            return (Criteria) this;
        }

        public Criteria andHandoverIdIsNotNull() {
            addCriterion("handover_id is not null");
            return (Criteria) this;
        }

        public Criteria andHandoverIdEqualTo(String value) {
            addCriterion("handover_id =", value, "handoverId");
            return (Criteria) this;
        }

        public Criteria andHandoverIdNotEqualTo(String value) {
            addCriterion("handover_id <>", value, "handoverId");
            return (Criteria) this;
        }

        public Criteria andHandoverIdGreaterThan(String value) {
            addCriterion("handover_id >", value, "handoverId");
            return (Criteria) this;
        }

        public Criteria andHandoverIdGreaterThanOrEqualTo(String value) {
            addCriterion("handover_id >=", value, "handoverId");
            return (Criteria) this;
        }

        public Criteria andHandoverIdLessThan(String value) {
            addCriterion("handover_id <", value, "handoverId");
            return (Criteria) this;
        }

        public Criteria andHandoverIdLessThanOrEqualTo(String value) {
            addCriterion("handover_id <=", value, "handoverId");
            return (Criteria) this;
        }

        public Criteria andHandoverIdLike(String value) {
            addCriterion("handover_id like", value, "handoverId");
            return (Criteria) this;
        }

        public Criteria andHandoverIdNotLike(String value) {
            addCriterion("handover_id not like", value, "handoverId");
            return (Criteria) this;
        }

        public Criteria andHandoverIdIn(List<String> values) {
            addCriterion("handover_id in", values, "handoverId");
            return (Criteria) this;
        }

        public Criteria andHandoverIdNotIn(List<String> values) {
            addCriterion("handover_id not in", values, "handoverId");
            return (Criteria) this;
        }

        public Criteria andHandoverIdBetween(String value1, String value2) {
            addCriterion("handover_id between", value1, value2, "handoverId");
            return (Criteria) this;
        }

        public Criteria andHandoverIdNotBetween(String value1, String value2) {
            addCriterion("handover_id not between", value1, value2, "handoverId");
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