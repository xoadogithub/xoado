package com.xoado.authcenter.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblAppInformationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblAppInformationExample() {
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

        public Criteria andAppIdIsNull() {
            addCriterion("app_Id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_Id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_Id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_Id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_Id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_Id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_Id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_Id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_Id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_Id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_Id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_Id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_Id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_Id not between", value1, value2, "appId");
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

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("creater =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("creater <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("creater >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("creater >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("creater <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("creater <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("creater like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("creater not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("creater in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("creater not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("creater between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("creater not between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNameIsNull() {
            addCriterion("creater_name is null");
            return (Criteria) this;
        }

        public Criteria andCreaterNameIsNotNull() {
            addCriterion("creater_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterNameEqualTo(String value) {
            addCriterion("creater_name =", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameNotEqualTo(String value) {
            addCriterion("creater_name <>", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameGreaterThan(String value) {
            addCriterion("creater_name >", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameGreaterThanOrEqualTo(String value) {
            addCriterion("creater_name >=", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameLessThan(String value) {
            addCriterion("creater_name <", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameLessThanOrEqualTo(String value) {
            addCriterion("creater_name <=", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameLike(String value) {
            addCriterion("creater_name like", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameNotLike(String value) {
            addCriterion("creater_name not like", value, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameIn(List<String> values) {
            addCriterion("creater_name in", values, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameNotIn(List<String> values) {
            addCriterion("creater_name not in", values, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameBetween(String value1, String value2) {
            addCriterion("creater_name between", value1, value2, "createrName");
            return (Criteria) this;
        }

        public Criteria andCreaterNameNotBetween(String value1, String value2) {
            addCriterion("creater_name not between", value1, value2, "createrName");
            return (Criteria) this;
        }

        public Criteria andOrgidIsNull() {
            addCriterion("orgId is null");
            return (Criteria) this;
        }

        public Criteria andOrgidIsNotNull() {
            addCriterion("orgId is not null");
            return (Criteria) this;
        }

        public Criteria andOrgidEqualTo(String value) {
            addCriterion("orgId =", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotEqualTo(String value) {
            addCriterion("orgId <>", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidGreaterThan(String value) {
            addCriterion("orgId >", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidGreaterThanOrEqualTo(String value) {
            addCriterion("orgId >=", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLessThan(String value) {
            addCriterion("orgId <", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLessThanOrEqualTo(String value) {
            addCriterion("orgId <=", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLike(String value) {
            addCriterion("orgId like", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotLike(String value) {
            addCriterion("orgId not like", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidIn(List<String> values) {
            addCriterion("orgId in", values, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotIn(List<String> values) {
            addCriterion("orgId not in", values, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidBetween(String value1, String value2) {
            addCriterion("orgId between", value1, value2, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotBetween(String value1, String value2) {
            addCriterion("orgId not between", value1, value2, "orgid");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNull() {
            addCriterion("app_name is null");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("app_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("app_name =", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("app_name <>", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("app_name >", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("app_name >=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("app_name <", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("app_name <=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("app_name like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("app_name not like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameIn(List<String> values) {
            addCriterion("app_name in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotIn(List<String> values) {
            addCriterion("app_name not in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("app_name between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("app_name not between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppTypeIsNull() {
            addCriterion("app_type is null");
            return (Criteria) this;
        }

        public Criteria andAppTypeIsNotNull() {
            addCriterion("app_type is not null");
            return (Criteria) this;
        }

        public Criteria andAppTypeEqualTo(Long value) {
            addCriterion("app_type =", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotEqualTo(Long value) {
            addCriterion("app_type <>", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeGreaterThan(Long value) {
            addCriterion("app_type >", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("app_type >=", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLessThan(Long value) {
            addCriterion("app_type <", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLessThanOrEqualTo(Long value) {
            addCriterion("app_type <=", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeIn(List<Long> values) {
            addCriterion("app_type in", values, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotIn(List<Long> values) {
            addCriterion("app_type not in", values, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeBetween(Long value1, Long value2) {
            addCriterion("app_type between", value1, value2, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotBetween(Long value1, Long value2) {
            addCriterion("app_type not between", value1, value2, "appType");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andAppImgUrlIsNull() {
            addCriterion("App_img_url is null");
            return (Criteria) this;
        }

        public Criteria andAppImgUrlIsNotNull() {
            addCriterion("App_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andAppImgUrlEqualTo(String value) {
            addCriterion("App_img_url =", value, "appImgUrl");
            return (Criteria) this;
        }

        public Criteria andAppImgUrlNotEqualTo(String value) {
            addCriterion("App_img_url <>", value, "appImgUrl");
            return (Criteria) this;
        }

        public Criteria andAppImgUrlGreaterThan(String value) {
            addCriterion("App_img_url >", value, "appImgUrl");
            return (Criteria) this;
        }

        public Criteria andAppImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("App_img_url >=", value, "appImgUrl");
            return (Criteria) this;
        }

        public Criteria andAppImgUrlLessThan(String value) {
            addCriterion("App_img_url <", value, "appImgUrl");
            return (Criteria) this;
        }

        public Criteria andAppImgUrlLessThanOrEqualTo(String value) {
            addCriterion("App_img_url <=", value, "appImgUrl");
            return (Criteria) this;
        }

        public Criteria andAppImgUrlLike(String value) {
            addCriterion("App_img_url like", value, "appImgUrl");
            return (Criteria) this;
        }

        public Criteria andAppImgUrlNotLike(String value) {
            addCriterion("App_img_url not like", value, "appImgUrl");
            return (Criteria) this;
        }

        public Criteria andAppImgUrlIn(List<String> values) {
            addCriterion("App_img_url in", values, "appImgUrl");
            return (Criteria) this;
        }

        public Criteria andAppImgUrlNotIn(List<String> values) {
            addCriterion("App_img_url not in", values, "appImgUrl");
            return (Criteria) this;
        }

        public Criteria andAppImgUrlBetween(String value1, String value2) {
            addCriterion("App_img_url between", value1, value2, "appImgUrl");
            return (Criteria) this;
        }

        public Criteria andAppImgUrlNotBetween(String value1, String value2) {
            addCriterion("App_img_url not between", value1, value2, "appImgUrl");
            return (Criteria) this;
        }

        public Criteria andAppSigningKeyIsNull() {
            addCriterion("app_signing_key is null");
            return (Criteria) this;
        }

        public Criteria andAppSigningKeyIsNotNull() {
            addCriterion("app_signing_key is not null");
            return (Criteria) this;
        }

        public Criteria andAppSigningKeyEqualTo(String value) {
            addCriterion("app_signing_key =", value, "appSigningKey");
            return (Criteria) this;
        }

        public Criteria andAppSigningKeyNotEqualTo(String value) {
            addCriterion("app_signing_key <>", value, "appSigningKey");
            return (Criteria) this;
        }

        public Criteria andAppSigningKeyGreaterThan(String value) {
            addCriterion("app_signing_key >", value, "appSigningKey");
            return (Criteria) this;
        }

        public Criteria andAppSigningKeyGreaterThanOrEqualTo(String value) {
            addCriterion("app_signing_key >=", value, "appSigningKey");
            return (Criteria) this;
        }

        public Criteria andAppSigningKeyLessThan(String value) {
            addCriterion("app_signing_key <", value, "appSigningKey");
            return (Criteria) this;
        }

        public Criteria andAppSigningKeyLessThanOrEqualTo(String value) {
            addCriterion("app_signing_key <=", value, "appSigningKey");
            return (Criteria) this;
        }

        public Criteria andAppSigningKeyLike(String value) {
            addCriterion("app_signing_key like", value, "appSigningKey");
            return (Criteria) this;
        }

        public Criteria andAppSigningKeyNotLike(String value) {
            addCriterion("app_signing_key not like", value, "appSigningKey");
            return (Criteria) this;
        }

        public Criteria andAppSigningKeyIn(List<String> values) {
            addCriterion("app_signing_key in", values, "appSigningKey");
            return (Criteria) this;
        }

        public Criteria andAppSigningKeyNotIn(List<String> values) {
            addCriterion("app_signing_key not in", values, "appSigningKey");
            return (Criteria) this;
        }

        public Criteria andAppSigningKeyBetween(String value1, String value2) {
            addCriterion("app_signing_key between", value1, value2, "appSigningKey");
            return (Criteria) this;
        }

        public Criteria andAppSigningKeyNotBetween(String value1, String value2) {
            addCriterion("app_signing_key not between", value1, value2, "appSigningKey");
            return (Criteria) this;
        }

        public Criteria andAppPrivateKeyIsNull() {
            addCriterion("app_private_key is null");
            return (Criteria) this;
        }

        public Criteria andAppPrivateKeyIsNotNull() {
            addCriterion("app_private_key is not null");
            return (Criteria) this;
        }

        public Criteria andAppPrivateKeyEqualTo(String value) {
            addCriterion("app_private_key =", value, "appPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAppPrivateKeyNotEqualTo(String value) {
            addCriterion("app_private_key <>", value, "appPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAppPrivateKeyGreaterThan(String value) {
            addCriterion("app_private_key >", value, "appPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAppPrivateKeyGreaterThanOrEqualTo(String value) {
            addCriterion("app_private_key >=", value, "appPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAppPrivateKeyLessThan(String value) {
            addCriterion("app_private_key <", value, "appPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAppPrivateKeyLessThanOrEqualTo(String value) {
            addCriterion("app_private_key <=", value, "appPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAppPrivateKeyLike(String value) {
            addCriterion("app_private_key like", value, "appPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAppPrivateKeyNotLike(String value) {
            addCriterion("app_private_key not like", value, "appPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAppPrivateKeyIn(List<String> values) {
            addCriterion("app_private_key in", values, "appPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAppPrivateKeyNotIn(List<String> values) {
            addCriterion("app_private_key not in", values, "appPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAppPrivateKeyBetween(String value1, String value2) {
            addCriterion("app_private_key between", value1, value2, "appPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAppPrivateKeyNotBetween(String value1, String value2) {
            addCriterion("app_private_key not between", value1, value2, "appPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAppPublicKeyIsNull() {
            addCriterion("app_public_key is null");
            return (Criteria) this;
        }

        public Criteria andAppPublicKeyIsNotNull() {
            addCriterion("app_public_key is not null");
            return (Criteria) this;
        }

        public Criteria andAppPublicKeyEqualTo(String value) {
            addCriterion("app_public_key =", value, "appPublicKey");
            return (Criteria) this;
        }

        public Criteria andAppPublicKeyNotEqualTo(String value) {
            addCriterion("app_public_key <>", value, "appPublicKey");
            return (Criteria) this;
        }

        public Criteria andAppPublicKeyGreaterThan(String value) {
            addCriterion("app_public_key >", value, "appPublicKey");
            return (Criteria) this;
        }

        public Criteria andAppPublicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("app_public_key >=", value, "appPublicKey");
            return (Criteria) this;
        }

        public Criteria andAppPublicKeyLessThan(String value) {
            addCriterion("app_public_key <", value, "appPublicKey");
            return (Criteria) this;
        }

        public Criteria andAppPublicKeyLessThanOrEqualTo(String value) {
            addCriterion("app_public_key <=", value, "appPublicKey");
            return (Criteria) this;
        }

        public Criteria andAppPublicKeyLike(String value) {
            addCriterion("app_public_key like", value, "appPublicKey");
            return (Criteria) this;
        }

        public Criteria andAppPublicKeyNotLike(String value) {
            addCriterion("app_public_key not like", value, "appPublicKey");
            return (Criteria) this;
        }

        public Criteria andAppPublicKeyIn(List<String> values) {
            addCriterion("app_public_key in", values, "appPublicKey");
            return (Criteria) this;
        }

        public Criteria andAppPublicKeyNotIn(List<String> values) {
            addCriterion("app_public_key not in", values, "appPublicKey");
            return (Criteria) this;
        }

        public Criteria andAppPublicKeyBetween(String value1, String value2) {
            addCriterion("app_public_key between", value1, value2, "appPublicKey");
            return (Criteria) this;
        }

        public Criteria andAppPublicKeyNotBetween(String value1, String value2) {
            addCriterion("app_public_key not between", value1, value2, "appPublicKey");
            return (Criteria) this;
        }

        public Criteria andAuditFlagIsNull() {
            addCriterion("Audit_flag is null");
            return (Criteria) this;
        }

        public Criteria andAuditFlagIsNotNull() {
            addCriterion("Audit_flag is not null");
            return (Criteria) this;
        }

        public Criteria andAuditFlagEqualTo(Long value) {
            addCriterion("Audit_flag =", value, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagNotEqualTo(Long value) {
            addCriterion("Audit_flag <>", value, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagGreaterThan(Long value) {
            addCriterion("Audit_flag >", value, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagGreaterThanOrEqualTo(Long value) {
            addCriterion("Audit_flag >=", value, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagLessThan(Long value) {
            addCriterion("Audit_flag <", value, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagLessThanOrEqualTo(Long value) {
            addCriterion("Audit_flag <=", value, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagIn(List<Long> values) {
            addCriterion("Audit_flag in", values, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagNotIn(List<Long> values) {
            addCriterion("Audit_flag not in", values, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagBetween(Long value1, Long value2) {
            addCriterion("Audit_flag between", value1, value2, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagNotBetween(Long value1, Long value2) {
            addCriterion("Audit_flag not between", value1, value2, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNull() {
            addCriterion("audit_Time is null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNotNull() {
            addCriterion("audit_Time is not null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeEqualTo(Date value) {
            addCriterion("audit_Time =", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotEqualTo(Date value) {
            addCriterion("audit_Time <>", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThan(Date value) {
            addCriterion("audit_Time >", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("audit_Time >=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThan(Date value) {
            addCriterion("audit_Time <", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("audit_Time <=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIn(List<Date> values) {
            addCriterion("audit_Time in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotIn(List<Date> values) {
            addCriterion("audit_Time not in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeBetween(Date value1, Date value2) {
            addCriterion("audit_Time between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("audit_Time not between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAppDomainIsNull() {
            addCriterion("app_domain is null");
            return (Criteria) this;
        }

        public Criteria andAppDomainIsNotNull() {
            addCriterion("app_domain is not null");
            return (Criteria) this;
        }

        public Criteria andAppDomainEqualTo(String value) {
            addCriterion("app_domain =", value, "appDomain");
            return (Criteria) this;
        }

        public Criteria andAppDomainNotEqualTo(String value) {
            addCriterion("app_domain <>", value, "appDomain");
            return (Criteria) this;
        }

        public Criteria andAppDomainGreaterThan(String value) {
            addCriterion("app_domain >", value, "appDomain");
            return (Criteria) this;
        }

        public Criteria andAppDomainGreaterThanOrEqualTo(String value) {
            addCriterion("app_domain >=", value, "appDomain");
            return (Criteria) this;
        }

        public Criteria andAppDomainLessThan(String value) {
            addCriterion("app_domain <", value, "appDomain");
            return (Criteria) this;
        }

        public Criteria andAppDomainLessThanOrEqualTo(String value) {
            addCriterion("app_domain <=", value, "appDomain");
            return (Criteria) this;
        }

        public Criteria andAppDomainLike(String value) {
            addCriterion("app_domain like", value, "appDomain");
            return (Criteria) this;
        }

        public Criteria andAppDomainNotLike(String value) {
            addCriterion("app_domain not like", value, "appDomain");
            return (Criteria) this;
        }

        public Criteria andAppDomainIn(List<String> values) {
            addCriterion("app_domain in", values, "appDomain");
            return (Criteria) this;
        }

        public Criteria andAppDomainNotIn(List<String> values) {
            addCriterion("app_domain not in", values, "appDomain");
            return (Criteria) this;
        }

        public Criteria andAppDomainBetween(String value1, String value2) {
            addCriterion("app_domain between", value1, value2, "appDomain");
            return (Criteria) this;
        }

        public Criteria andAppDomainNotBetween(String value1, String value2) {
            addCriterion("app_domain not between", value1, value2, "appDomain");
            return (Criteria) this;
        }

        public Criteria andAppPathIsNull() {
            addCriterion("app_path is null");
            return (Criteria) this;
        }

        public Criteria andAppPathIsNotNull() {
            addCriterion("app_path is not null");
            return (Criteria) this;
        }

        public Criteria andAppPathEqualTo(String value) {
            addCriterion("app_path =", value, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppPathNotEqualTo(String value) {
            addCriterion("app_path <>", value, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppPathGreaterThan(String value) {
            addCriterion("app_path >", value, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppPathGreaterThanOrEqualTo(String value) {
            addCriterion("app_path >=", value, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppPathLessThan(String value) {
            addCriterion("app_path <", value, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppPathLessThanOrEqualTo(String value) {
            addCriterion("app_path <=", value, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppPathLike(String value) {
            addCriterion("app_path like", value, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppPathNotLike(String value) {
            addCriterion("app_path not like", value, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppPathIn(List<String> values) {
            addCriterion("app_path in", values, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppPathNotIn(List<String> values) {
            addCriterion("app_path not in", values, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppPathBetween(String value1, String value2) {
            addCriterion("app_path between", value1, value2, "appPath");
            return (Criteria) this;
        }

        public Criteria andAppPathNotBetween(String value1, String value2) {
            addCriterion("app_path not between", value1, value2, "appPath");
            return (Criteria) this;
        }

        public Criteria andRedirectUriIsNull() {
            addCriterion("redirect_uri is null");
            return (Criteria) this;
        }

        public Criteria andRedirectUriIsNotNull() {
            addCriterion("redirect_uri is not null");
            return (Criteria) this;
        }

        public Criteria andRedirectUriEqualTo(String value) {
            addCriterion("redirect_uri =", value, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andRedirectUriNotEqualTo(String value) {
            addCriterion("redirect_uri <>", value, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andRedirectUriGreaterThan(String value) {
            addCriterion("redirect_uri >", value, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andRedirectUriGreaterThanOrEqualTo(String value) {
            addCriterion("redirect_uri >=", value, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andRedirectUriLessThan(String value) {
            addCriterion("redirect_uri <", value, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andRedirectUriLessThanOrEqualTo(String value) {
            addCriterion("redirect_uri <=", value, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andRedirectUriLike(String value) {
            addCriterion("redirect_uri like", value, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andRedirectUriNotLike(String value) {
            addCriterion("redirect_uri not like", value, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andRedirectUriIn(List<String> values) {
            addCriterion("redirect_uri in", values, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andRedirectUriNotIn(List<String> values) {
            addCriterion("redirect_uri not in", values, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andRedirectUriBetween(String value1, String value2) {
            addCriterion("redirect_uri between", value1, value2, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andRedirectUriNotBetween(String value1, String value2) {
            addCriterion("redirect_uri not between", value1, value2, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlIsNull() {
            addCriterion("app_download_url is null");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlIsNotNull() {
            addCriterion("app_download_url is not null");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlEqualTo(String value) {
            addCriterion("app_download_url =", value, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlNotEqualTo(String value) {
            addCriterion("app_download_url <>", value, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlGreaterThan(String value) {
            addCriterion("app_download_url >", value, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("app_download_url >=", value, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlLessThan(String value) {
            addCriterion("app_download_url <", value, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlLessThanOrEqualTo(String value) {
            addCriterion("app_download_url <=", value, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlLike(String value) {
            addCriterion("app_download_url like", value, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlNotLike(String value) {
            addCriterion("app_download_url not like", value, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlIn(List<String> values) {
            addCriterion("app_download_url in", values, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlNotIn(List<String> values) {
            addCriterion("app_download_url not in", values, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlBetween(String value1, String value2) {
            addCriterion("app_download_url between", value1, value2, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlNotBetween(String value1, String value2) {
            addCriterion("app_download_url not between", value1, value2, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
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