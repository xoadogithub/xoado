package com.xoado.tools.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TblArchivesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblArchivesExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
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

        public Criteria andArchiveNameIsNull() {
            addCriterion("archive_name is null");
            return (Criteria) this;
        }

        public Criteria andArchiveNameIsNotNull() {
            addCriterion("archive_name is not null");
            return (Criteria) this;
        }

        public Criteria andArchiveNameEqualTo(String value) {
            addCriterion("archive_name =", value, "archiveName");
            return (Criteria) this;
        }

        public Criteria andArchiveNameNotEqualTo(String value) {
            addCriterion("archive_name <>", value, "archiveName");
            return (Criteria) this;
        }

        public Criteria andArchiveNameGreaterThan(String value) {
            addCriterion("archive_name >", value, "archiveName");
            return (Criteria) this;
        }

        public Criteria andArchiveNameGreaterThanOrEqualTo(String value) {
            addCriterion("archive_name >=", value, "archiveName");
            return (Criteria) this;
        }

        public Criteria andArchiveNameLessThan(String value) {
            addCriterion("archive_name <", value, "archiveName");
            return (Criteria) this;
        }

        public Criteria andArchiveNameLessThanOrEqualTo(String value) {
            addCriterion("archive_name <=", value, "archiveName");
            return (Criteria) this;
        }

        public Criteria andArchiveNameLike(String value) {
            addCriterion("archive_name like", value, "archiveName");
            return (Criteria) this;
        }

        public Criteria andArchiveNameNotLike(String value) {
            addCriterion("archive_name not like", value, "archiveName");
            return (Criteria) this;
        }

        public Criteria andArchiveNameIn(List<String> values) {
            addCriterion("archive_name in", values, "archiveName");
            return (Criteria) this;
        }

        public Criteria andArchiveNameNotIn(List<String> values) {
            addCriterion("archive_name not in", values, "archiveName");
            return (Criteria) this;
        }

        public Criteria andArchiveNameBetween(String value1, String value2) {
            addCriterion("archive_name between", value1, value2, "archiveName");
            return (Criteria) this;
        }

        public Criteria andArchiveNameNotBetween(String value1, String value2) {
            addCriterion("archive_name not between", value1, value2, "archiveName");
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

        public Criteria andOwnerUserIsNull() {
            addCriterion("owner_user is null");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIsNotNull() {
            addCriterion("owner_user is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerUserEqualTo(Object value) {
            addCriterion("owner_user =", value, "ownerUser");
            return (Criteria) this;
        }

        public Criteria andOwnerUserNotEqualTo(Object value) {
            addCriterion("owner_user <>", value, "ownerUser");
            return (Criteria) this;
        }

        public Criteria andOwnerUserGreaterThan(Object value) {
            addCriterion("owner_user >", value, "ownerUser");
            return (Criteria) this;
        }

        public Criteria andOwnerUserGreaterThanOrEqualTo(Object value) {
            addCriterion("owner_user >=", value, "ownerUser");
            return (Criteria) this;
        }

        public Criteria andOwnerUserLessThan(Object value) {
            addCriterion("owner_user <", value, "ownerUser");
            return (Criteria) this;
        }

        public Criteria andOwnerUserLessThanOrEqualTo(Object value) {
            addCriterion("owner_user <=", value, "ownerUser");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIn(List<Object> values) {
            addCriterion("owner_user in", values, "ownerUser");
            return (Criteria) this;
        }

        public Criteria andOwnerUserNotIn(List<Object> values) {
            addCriterion("owner_user not in", values, "ownerUser");
            return (Criteria) this;
        }

        public Criteria andOwnerUserBetween(Object value1, Object value2) {
            addCriterion("owner_user between", value1, value2, "ownerUser");
            return (Criteria) this;
        }

        public Criteria andOwnerUserNotBetween(Object value1, Object value2) {
            addCriterion("owner_user not between", value1, value2, "ownerUser");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNull() {
            addCriterion("comments is null");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNotNull() {
            addCriterion("comments is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsEqualTo(Object value) {
            addCriterion("comments =", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotEqualTo(Object value) {
            addCriterion("comments <>", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThan(Object value) {
            addCriterion("comments >", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThanOrEqualTo(Object value) {
            addCriterion("comments >=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThan(Object value) {
            addCriterion("comments <", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThanOrEqualTo(Object value) {
            addCriterion("comments <=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsIn(List<Object> values) {
            addCriterion("comments in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotIn(List<Object> values) {
            addCriterion("comments not in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsBetween(Object value1, Object value2) {
            addCriterion("comments between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotBetween(Object value1, Object value2) {
            addCriterion("comments not between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andAttachmentPictureIsNull() {
            addCriterion("attachment_picture is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentPictureIsNotNull() {
            addCriterion("attachment_picture is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentPictureEqualTo(Object value) {
            addCriterion("attachment_picture =", value, "attachmentPicture");
            return (Criteria) this;
        }

        public Criteria andAttachmentPictureNotEqualTo(Object value) {
            addCriterion("attachment_picture <>", value, "attachmentPicture");
            return (Criteria) this;
        }

        public Criteria andAttachmentPictureGreaterThan(Object value) {
            addCriterion("attachment_picture >", value, "attachmentPicture");
            return (Criteria) this;
        }

        public Criteria andAttachmentPictureGreaterThanOrEqualTo(Object value) {
            addCriterion("attachment_picture >=", value, "attachmentPicture");
            return (Criteria) this;
        }

        public Criteria andAttachmentPictureLessThan(Object value) {
            addCriterion("attachment_picture <", value, "attachmentPicture");
            return (Criteria) this;
        }

        public Criteria andAttachmentPictureLessThanOrEqualTo(Object value) {
            addCriterion("attachment_picture <=", value, "attachmentPicture");
            return (Criteria) this;
        }

        public Criteria andAttachmentPictureIn(List<Object> values) {
            addCriterion("attachment_picture in", values, "attachmentPicture");
            return (Criteria) this;
        }

        public Criteria andAttachmentPictureNotIn(List<Object> values) {
            addCriterion("attachment_picture not in", values, "attachmentPicture");
            return (Criteria) this;
        }

        public Criteria andAttachmentPictureBetween(Object value1, Object value2) {
            addCriterion("attachment_picture between", value1, value2, "attachmentPicture");
            return (Criteria) this;
        }

        public Criteria andAttachmentPictureNotBetween(Object value1, Object value2) {
            addCriterion("attachment_picture not between", value1, value2, "attachmentPicture");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocumentIsNull() {
            addCriterion("attachment_document is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocumentIsNotNull() {
            addCriterion("attachment_document is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocumentEqualTo(Object value) {
            addCriterion("attachment_document =", value, "attachmentDocument");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocumentNotEqualTo(Object value) {
            addCriterion("attachment_document <>", value, "attachmentDocument");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocumentGreaterThan(Object value) {
            addCriterion("attachment_document >", value, "attachmentDocument");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocumentGreaterThanOrEqualTo(Object value) {
            addCriterion("attachment_document >=", value, "attachmentDocument");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocumentLessThan(Object value) {
            addCriterion("attachment_document <", value, "attachmentDocument");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocumentLessThanOrEqualTo(Object value) {
            addCriterion("attachment_document <=", value, "attachmentDocument");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocumentIn(List<Object> values) {
            addCriterion("attachment_document in", values, "attachmentDocument");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocumentNotIn(List<Object> values) {
            addCriterion("attachment_document not in", values, "attachmentDocument");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocumentBetween(Object value1, Object value2) {
            addCriterion("attachment_document between", value1, value2, "attachmentDocument");
            return (Criteria) this;
        }

        public Criteria andAttachmentDocumentNotBetween(Object value1, Object value2) {
            addCriterion("attachment_document not between", value1, value2, "attachmentDocument");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCTime("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCTime("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCTime("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("create_time not between", value1, value2, "createTime");
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