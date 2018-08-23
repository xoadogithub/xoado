package com.xoado.tools.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblBoxesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblBoxesExample() {
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

        public Criteria andBoxIdIsNull() {
            addCriterion("box_id is null");
            return (Criteria) this;
        }

        public Criteria andBoxIdIsNotNull() {
            addCriterion("box_id is not null");
            return (Criteria) this;
        }

        public Criteria andBoxIdEqualTo(String value) {
            addCriterion("box_id =", value, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxIdNotEqualTo(String value) {
            addCriterion("box_id <>", value, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxIdGreaterThan(String value) {
            addCriterion("box_id >", value, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxIdGreaterThanOrEqualTo(String value) {
            addCriterion("box_id >=", value, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxIdLessThan(String value) {
            addCriterion("box_id <", value, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxIdLessThanOrEqualTo(String value) {
            addCriterion("box_id <=", value, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxIdLike(String value) {
            addCriterion("box_id like", value, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxIdNotLike(String value) {
            addCriterion("box_id not like", value, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxIdIn(List<String> values) {
            addCriterion("box_id in", values, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxIdNotIn(List<String> values) {
            addCriterion("box_id not in", values, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxIdBetween(String value1, String value2) {
            addCriterion("box_id between", value1, value2, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxIdNotBetween(String value1, String value2) {
            addCriterion("box_id not between", value1, value2, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxNameIsNull() {
            addCriterion("box_name is null");
            return (Criteria) this;
        }

        public Criteria andBoxNameIsNotNull() {
            addCriterion("box_name is not null");
            return (Criteria) this;
        }

        public Criteria andBoxNameEqualTo(String value) {
            addCriterion("box_name =", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameNotEqualTo(String value) {
            addCriterion("box_name <>", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameGreaterThan(String value) {
            addCriterion("box_name >", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameGreaterThanOrEqualTo(String value) {
            addCriterion("box_name >=", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameLessThan(String value) {
            addCriterion("box_name <", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameLessThanOrEqualTo(String value) {
            addCriterion("box_name <=", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameLike(String value) {
            addCriterion("box_name like", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameNotLike(String value) {
            addCriterion("box_name not like", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameIn(List<String> values) {
            addCriterion("box_name in", values, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameNotIn(List<String> values) {
            addCriterion("box_name not in", values, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameBetween(String value1, String value2) {
            addCriterion("box_name between", value1, value2, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameNotBetween(String value1, String value2) {
            addCriterion("box_name not between", value1, value2, "boxName");
            return (Criteria) this;
        }

        public Criteria andScopeofuseIsNull() {
            addCriterion("scopeofuse is null");
            return (Criteria) this;
        }

        public Criteria andScopeofuseIsNotNull() {
            addCriterion("scopeofuse is not null");
            return (Criteria) this;
        }

        public Criteria andScopeofuseEqualTo(String value) {
            addCriterion("scopeofuse =", value, "scopeofuse");
            return (Criteria) this;
        }

        public Criteria andScopeofuseNotEqualTo(String value) {
            addCriterion("scopeofuse <>", value, "scopeofuse");
            return (Criteria) this;
        }

        public Criteria andScopeofuseGreaterThan(String value) {
            addCriterion("scopeofuse >", value, "scopeofuse");
            return (Criteria) this;
        }

        public Criteria andScopeofuseGreaterThanOrEqualTo(String value) {
            addCriterion("scopeofuse >=", value, "scopeofuse");
            return (Criteria) this;
        }

        public Criteria andScopeofuseLessThan(String value) {
            addCriterion("scopeofuse <", value, "scopeofuse");
            return (Criteria) this;
        }

        public Criteria andScopeofuseLessThanOrEqualTo(String value) {
            addCriterion("scopeofuse <=", value, "scopeofuse");
            return (Criteria) this;
        }

        public Criteria andScopeofuseLike(String value) {
            addCriterion("scopeofuse like", value, "scopeofuse");
            return (Criteria) this;
        }

        public Criteria andScopeofuseNotLike(String value) {
            addCriterion("scopeofuse not like", value, "scopeofuse");
            return (Criteria) this;
        }

        public Criteria andScopeofuseIn(List<String> values) {
            addCriterion("scopeofuse in", values, "scopeofuse");
            return (Criteria) this;
        }

        public Criteria andScopeofuseNotIn(List<String> values) {
            addCriterion("scopeofuse not in", values, "scopeofuse");
            return (Criteria) this;
        }

        public Criteria andScopeofuseBetween(String value1, String value2) {
            addCriterion("scopeofuse between", value1, value2, "scopeofuse");
            return (Criteria) this;
        }

        public Criteria andScopeofuseNotBetween(String value1, String value2) {
            addCriterion("scopeofuse not between", value1, value2, "scopeofuse");
            return (Criteria) this;
        }

        public Criteria andMoveableIsNull() {
            addCriterion("moveable is null");
            return (Criteria) this;
        }

        public Criteria andMoveableIsNotNull() {
            addCriterion("moveable is not null");
            return (Criteria) this;
        }

        public Criteria andMoveableEqualTo(String value) {
            addCriterion("moveable =", value, "moveable");
            return (Criteria) this;
        }

        public Criteria andMoveableNotEqualTo(String value) {
            addCriterion("moveable <>", value, "moveable");
            return (Criteria) this;
        }

        public Criteria andMoveableGreaterThan(String value) {
            addCriterion("moveable >", value, "moveable");
            return (Criteria) this;
        }

        public Criteria andMoveableGreaterThanOrEqualTo(String value) {
            addCriterion("moveable >=", value, "moveable");
            return (Criteria) this;
        }

        public Criteria andMoveableLessThan(String value) {
            addCriterion("moveable <", value, "moveable");
            return (Criteria) this;
        }

        public Criteria andMoveableLessThanOrEqualTo(String value) {
            addCriterion("moveable <=", value, "moveable");
            return (Criteria) this;
        }

        public Criteria andMoveableLike(String value) {
            addCriterion("moveable like", value, "moveable");
            return (Criteria) this;
        }

        public Criteria andMoveableNotLike(String value) {
            addCriterion("moveable not like", value, "moveable");
            return (Criteria) this;
        }

        public Criteria andMoveableIn(List<String> values) {
            addCriterion("moveable in", values, "moveable");
            return (Criteria) this;
        }

        public Criteria andMoveableNotIn(List<String> values) {
            addCriterion("moveable not in", values, "moveable");
            return (Criteria) this;
        }

        public Criteria andMoveableBetween(String value1, String value2) {
            addCriterion("moveable between", value1, value2, "moveable");
            return (Criteria) this;
        }

        public Criteria andMoveableNotBetween(String value1, String value2) {
            addCriterion("moveable not between", value1, value2, "moveable");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(Object value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(Object value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(Object value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(Object value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(Object value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(Object value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<Object> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<Object> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(Object value1, Object value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(Object value1, Object value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andOwnerOrgIsNull() {
            addCriterion("owner_org is null");
            return (Criteria) this;
        }

        public Criteria andOwnerOrgIsNotNull() {
            addCriterion("owner_org is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerOrgEqualTo(Object value) {
            addCriterion("owner_org =", value, "ownerOrg");
            return (Criteria) this;
        }

        public Criteria andOwnerOrgNotEqualTo(Object value) {
            addCriterion("owner_org <>", value, "ownerOrg");
            return (Criteria) this;
        }

        public Criteria andOwnerOrgGreaterThan(Object value) {
            addCriterion("owner_org >", value, "ownerOrg");
            return (Criteria) this;
        }

        public Criteria andOwnerOrgGreaterThanOrEqualTo(Object value) {
            addCriterion("owner_org >=", value, "ownerOrg");
            return (Criteria) this;
        }

        public Criteria andOwnerOrgLessThan(Object value) {
            addCriterion("owner_org <", value, "ownerOrg");
            return (Criteria) this;
        }

        public Criteria andOwnerOrgLessThanOrEqualTo(Object value) {
            addCriterion("owner_org <=", value, "ownerOrg");
            return (Criteria) this;
        }

        public Criteria andOwnerOrgIn(List<Object> values) {
            addCriterion("owner_org in", values, "ownerOrg");
            return (Criteria) this;
        }

        public Criteria andOwnerOrgNotIn(List<Object> values) {
            addCriterion("owner_org not in", values, "ownerOrg");
            return (Criteria) this;
        }

        public Criteria andOwnerOrgBetween(Object value1, Object value2) {
            addCriterion("owner_org between", value1, value2, "ownerOrg");
            return (Criteria) this;
        }

        public Criteria andOwnerOrgNotBetween(Object value1, Object value2) {
            addCriterion("owner_org not between", value1, value2, "ownerOrg");
            return (Criteria) this;
        }

        public Criteria andSharetoIsNull() {
            addCriterion("shareto is null");
            return (Criteria) this;
        }

        public Criteria andSharetoIsNotNull() {
            addCriterion("shareto is not null");
            return (Criteria) this;
        }

        public Criteria andSharetoEqualTo(Object value) {
            addCriterion("shareto =", value, "shareto");
            return (Criteria) this;
        }

        public Criteria andSharetoNotEqualTo(Object value) {
            addCriterion("shareto <>", value, "shareto");
            return (Criteria) this;
        }

        public Criteria andSharetoGreaterThan(Object value) {
            addCriterion("shareto >", value, "shareto");
            return (Criteria) this;
        }

        public Criteria andSharetoGreaterThanOrEqualTo(Object value) {
            addCriterion("shareto >=", value, "shareto");
            return (Criteria) this;
        }

        public Criteria andSharetoLessThan(Object value) {
            addCriterion("shareto <", value, "shareto");
            return (Criteria) this;
        }

        public Criteria andSharetoLessThanOrEqualTo(Object value) {
            addCriterion("shareto <=", value, "shareto");
            return (Criteria) this;
        }

        public Criteria andSharetoIn(List<Object> values) {
            addCriterion("shareto in", values, "shareto");
            return (Criteria) this;
        }

        public Criteria andSharetoNotIn(List<Object> values) {
            addCriterion("shareto not in", values, "shareto");
            return (Criteria) this;
        }

        public Criteria andSharetoBetween(Object value1, Object value2) {
            addCriterion("shareto between", value1, value2, "shareto");
            return (Criteria) this;
        }

        public Criteria andSharetoNotBetween(Object value1, Object value2) {
            addCriterion("shareto not between", value1, value2, "shareto");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("creater is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("creater is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(Object value) {
            addCriterion("creater =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(Object value) {
            addCriterion("creater <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(Object value) {
            addCriterion("creater >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(Object value) {
            addCriterion("creater >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(Object value) {
            addCriterion("creater <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(Object value) {
            addCriterion("creater <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<Object> values) {
            addCriterion("creater in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<Object> values) {
            addCriterion("creater not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(Object value1, Object value2) {
            addCriterion("creater between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(Object value1, Object value2) {
            addCriterion("creater not between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeIsNull() {
            addCriterion("creater_time is null");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeIsNotNull() {
            addCriterion("creater_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeEqualTo(Date value) {
            addCriterion("creater_time =", value, "createrTime");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeNotEqualTo(Date value) {
            addCriterion("creater_time <>", value, "createrTime");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeGreaterThan(Date value) {
            addCriterion("creater_time >", value, "createrTime");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creater_time >=", value, "createrTime");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeLessThan(Date value) {
            addCriterion("creater_time <", value, "createrTime");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeLessThanOrEqualTo(Date value) {
            addCriterion("creater_time <=", value, "createrTime");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeIn(List<Date> values) {
            addCriterion("creater_time in", values, "createrTime");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeNotIn(List<Date> values) {
            addCriterion("creater_time not in", values, "createrTime");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeBetween(Date value1, Date value2) {
            addCriterion("creater_time between", value1, value2, "createrTime");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeNotBetween(Date value1, Date value2) {
            addCriterion("creater_time not between", value1, value2, "createrTime");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andUseStateIsNull() {
            addCriterion("use_state is null");
            return (Criteria) this;
        }

        public Criteria andUseStateIsNotNull() {
            addCriterion("use_state is not null");
            return (Criteria) this;
        }

        public Criteria andUseStateEqualTo(Integer value) {
            addCriterion("use_state =", value, "useState");
            return (Criteria) this;
        }

        public Criteria andUseStateNotEqualTo(Integer value) {
            addCriterion("use_state <>", value, "useState");
            return (Criteria) this;
        }

        public Criteria andUseStateGreaterThan(Integer value) {
            addCriterion("use_state >", value, "useState");
            return (Criteria) this;
        }

        public Criteria andUseStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_state >=", value, "useState");
            return (Criteria) this;
        }

        public Criteria andUseStateLessThan(Integer value) {
            addCriterion("use_state <", value, "useState");
            return (Criteria) this;
        }

        public Criteria andUseStateLessThanOrEqualTo(Integer value) {
            addCriterion("use_state <=", value, "useState");
            return (Criteria) this;
        }

        public Criteria andUseStateIn(List<Integer> values) {
            addCriterion("use_state in", values, "useState");
            return (Criteria) this;
        }

        public Criteria andUseStateNotIn(List<Integer> values) {
            addCriterion("use_state not in", values, "useState");
            return (Criteria) this;
        }

        public Criteria andUseStateBetween(Integer value1, Integer value2) {
            addCriterion("use_state between", value1, value2, "useState");
            return (Criteria) this;
        }

        public Criteria andUseStateNotBetween(Integer value1, Integer value2) {
            addCriterion("use_state not between", value1, value2, "useState");
            return (Criteria) this;
        }

        public Criteria andCloseStateIsNull() {
            addCriterion("close_state is null");
            return (Criteria) this;
        }

        public Criteria andCloseStateIsNotNull() {
            addCriterion("close_state is not null");
            return (Criteria) this;
        }

        public Criteria andCloseStateEqualTo(String value) {
            addCriterion("close_state =", value, "closeState");
            return (Criteria) this;
        }

        public Criteria andCloseStateNotEqualTo(String value) {
            addCriterion("close_state <>", value, "closeState");
            return (Criteria) this;
        }

        public Criteria andCloseStateGreaterThan(String value) {
            addCriterion("close_state >", value, "closeState");
            return (Criteria) this;
        }

        public Criteria andCloseStateGreaterThanOrEqualTo(String value) {
            addCriterion("close_state >=", value, "closeState");
            return (Criteria) this;
        }

        public Criteria andCloseStateLessThan(String value) {
            addCriterion("close_state <", value, "closeState");
            return (Criteria) this;
        }

        public Criteria andCloseStateLessThanOrEqualTo(String value) {
            addCriterion("close_state <=", value, "closeState");
            return (Criteria) this;
        }

        public Criteria andCloseStateLike(String value) {
            addCriterion("close_state like", value, "closeState");
            return (Criteria) this;
        }

        public Criteria andCloseStateNotLike(String value) {
            addCriterion("close_state not like", value, "closeState");
            return (Criteria) this;
        }

        public Criteria andCloseStateIn(List<String> values) {
            addCriterion("close_state in", values, "closeState");
            return (Criteria) this;
        }

        public Criteria andCloseStateNotIn(List<String> values) {
            addCriterion("close_state not in", values, "closeState");
            return (Criteria) this;
        }

        public Criteria andCloseStateBetween(String value1, String value2) {
            addCriterion("close_state between", value1, value2, "closeState");
            return (Criteria) this;
        }

        public Criteria andCloseStateNotBetween(String value1, String value2) {
            addCriterion("close_state not between", value1, value2, "closeState");
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