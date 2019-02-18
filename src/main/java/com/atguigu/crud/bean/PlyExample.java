package com.atguigu.crud.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlyExample() {
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

        public Criteria andPlyIdIsNull() {
            addCriterion("ply_id is null");
            return (Criteria) this;
        }

        public Criteria andPlyIdIsNotNull() {
            addCriterion("ply_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlyIdEqualTo(Integer value) {
            addCriterion("ply_id =", value, "plyId");
            return (Criteria) this;
        }

        public Criteria andPlyIdNotEqualTo(Integer value) {
            addCriterion("ply_id <>", value, "plyId");
            return (Criteria) this;
        }

        public Criteria andPlyIdGreaterThan(Integer value) {
            addCriterion("ply_id >", value, "plyId");
            return (Criteria) this;
        }

        public Criteria andPlyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ply_id >=", value, "plyId");
            return (Criteria) this;
        }

        public Criteria andPlyIdLessThan(Integer value) {
            addCriterion("ply_id <", value, "plyId");
            return (Criteria) this;
        }

        public Criteria andPlyIdLessThanOrEqualTo(Integer value) {
            addCriterion("ply_id <=", value, "plyId");
            return (Criteria) this;
        }

        public Criteria andPlyIdIn(List<Integer> values) {
            addCriterion("ply_id in", values, "plyId");
            return (Criteria) this;
        }

        public Criteria andPlyIdNotIn(List<Integer> values) {
            addCriterion("ply_id not in", values, "plyId");
            return (Criteria) this;
        }

        public Criteria andPlyIdBetween(Integer value1, Integer value2) {
            addCriterion("ply_id between", value1, value2, "plyId");
            return (Criteria) this;
        }

        public Criteria andPlyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ply_id not between", value1, value2, "plyId");
            return (Criteria) this;
        }

        public Criteria andPlyPeoIdIsNull() {
            addCriterion("ply_peo_id is null");
            return (Criteria) this;
        }

        public Criteria andPlyPeoIdIsNotNull() {
            addCriterion("ply_peo_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlyPeoIdEqualTo(Integer value) {
            addCriterion("ply_peo_id =", value, "plyPeoId");
            return (Criteria) this;
        }

        public Criteria andPlyPeoIdNotEqualTo(Integer value) {
            addCriterion("ply_peo_id <>", value, "plyPeoId");
            return (Criteria) this;
        }

        public Criteria andPlyPeoIdGreaterThan(Integer value) {
            addCriterion("ply_peo_id >", value, "plyPeoId");
            return (Criteria) this;
        }

        public Criteria andPlyPeoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ply_peo_id >=", value, "plyPeoId");
            return (Criteria) this;
        }

        public Criteria andPlyPeoIdLessThan(Integer value) {
            addCriterion("ply_peo_id <", value, "plyPeoId");
            return (Criteria) this;
        }

        public Criteria andPlyPeoIdLessThanOrEqualTo(Integer value) {
            addCriterion("ply_peo_id <=", value, "plyPeoId");
            return (Criteria) this;
        }

        public Criteria andPlyPeoIdIn(List<Integer> values) {
            addCriterion("ply_peo_id in", values, "plyPeoId");
            return (Criteria) this;
        }

        public Criteria andPlyPeoIdNotIn(List<Integer> values) {
            addCriterion("ply_peo_id not in", values, "plyPeoId");
            return (Criteria) this;
        }

        public Criteria andPlyPeoIdBetween(Integer value1, Integer value2) {
            addCriterion("ply_peo_id between", value1, value2, "plyPeoId");
            return (Criteria) this;
        }

        public Criteria andPlyPeoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ply_peo_id not between", value1, value2, "plyPeoId");
            return (Criteria) this;
        }

        public Criteria andPlyPeoNameIsNull() {
            addCriterion("ply_peo_name is null");
            return (Criteria) this;
        }

        public Criteria andPlyPeoNameIsNotNull() {
            addCriterion("ply_peo_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlyPeoNameEqualTo(String value) {
            addCriterion("ply_peo_name =", value, "plyPeoName");
            return (Criteria) this;
        }

        public Criteria andPlyPeoNameNotEqualTo(String value) {
            addCriterion("ply_peo_name <>", value, "plyPeoName");
            return (Criteria) this;
        }

        public Criteria andPlyPeoNameGreaterThan(String value) {
            addCriterion("ply_peo_name >", value, "plyPeoName");
            return (Criteria) this;
        }

        public Criteria andPlyPeoNameGreaterThanOrEqualTo(String value) {
            addCriterion("ply_peo_name >=", value, "plyPeoName");
            return (Criteria) this;
        }

        public Criteria andPlyPeoNameLessThan(String value) {
            addCriterion("ply_peo_name <", value, "plyPeoName");
            return (Criteria) this;
        }

        public Criteria andPlyPeoNameLessThanOrEqualTo(String value) {
            addCriterion("ply_peo_name <=", value, "plyPeoName");
            return (Criteria) this;
        }

        public Criteria andPlyPeoNameLike(String value) {
            addCriterion("ply_peo_name like", value, "plyPeoName");
            return (Criteria) this;
        }

        public Criteria andPlyPeoNameNotLike(String value) {
            addCriterion("ply_peo_name not like", value, "plyPeoName");
            return (Criteria) this;
        }

        public Criteria andPlyPeoNameIn(List<String> values) {
            addCriterion("ply_peo_name in", values, "plyPeoName");
            return (Criteria) this;
        }

        public Criteria andPlyPeoNameNotIn(List<String> values) {
            addCriterion("ply_peo_name not in", values, "plyPeoName");
            return (Criteria) this;
        }

        public Criteria andPlyPeoNameBetween(String value1, String value2) {
            addCriterion("ply_peo_name between", value1, value2, "plyPeoName");
            return (Criteria) this;
        }

        public Criteria andPlyPeoNameNotBetween(String value1, String value2) {
            addCriterion("ply_peo_name not between", value1, value2, "plyPeoName");
            return (Criteria) this;
        }

        public Criteria andPlyPeoPicturePathIsNull() {
            addCriterion("ply_peo_picture_path is null");
            return (Criteria) this;
        }

        public Criteria andPlyPeoPicturePathIsNotNull() {
            addCriterion("ply_peo_picture_path is not null");
            return (Criteria) this;
        }

        public Criteria andPlyPeoPicturePathEqualTo(String value) {
            addCriterion("ply_peo_picture_path =", value, "plyPeoPicturePath");
            return (Criteria) this;
        }

        public Criteria andPlyPeoPicturePathNotEqualTo(String value) {
            addCriterion("ply_peo_picture_path <>", value, "plyPeoPicturePath");
            return (Criteria) this;
        }

        public Criteria andPlyPeoPicturePathGreaterThan(String value) {
            addCriterion("ply_peo_picture_path >", value, "plyPeoPicturePath");
            return (Criteria) this;
        }

        public Criteria andPlyPeoPicturePathGreaterThanOrEqualTo(String value) {
            addCriterion("ply_peo_picture_path >=", value, "plyPeoPicturePath");
            return (Criteria) this;
        }

        public Criteria andPlyPeoPicturePathLessThan(String value) {
            addCriterion("ply_peo_picture_path <", value, "plyPeoPicturePath");
            return (Criteria) this;
        }

        public Criteria andPlyPeoPicturePathLessThanOrEqualTo(String value) {
            addCriterion("ply_peo_picture_path <=", value, "plyPeoPicturePath");
            return (Criteria) this;
        }

        public Criteria andPlyPeoPicturePathLike(String value) {
            addCriterion("ply_peo_picture_path like", value, "plyPeoPicturePath");
            return (Criteria) this;
        }

        public Criteria andPlyPeoPicturePathNotLike(String value) {
            addCriterion("ply_peo_picture_path not like", value, "plyPeoPicturePath");
            return (Criteria) this;
        }

        public Criteria andPlyPeoPicturePathIn(List<String> values) {
            addCriterion("ply_peo_picture_path in", values, "plyPeoPicturePath");
            return (Criteria) this;
        }

        public Criteria andPlyPeoPicturePathNotIn(List<String> values) {
            addCriterion("ply_peo_picture_path not in", values, "plyPeoPicturePath");
            return (Criteria) this;
        }

        public Criteria andPlyPeoPicturePathBetween(String value1, String value2) {
            addCriterion("ply_peo_picture_path between", value1, value2, "plyPeoPicturePath");
            return (Criteria) this;
        }

        public Criteria andPlyPeoPicturePathNotBetween(String value1, String value2) {
            addCriterion("ply_peo_picture_path not between", value1, value2, "plyPeoPicturePath");
            return (Criteria) this;
        }

        public Criteria andPlyBookNumIsNull() {
            addCriterion("ply_book_num is null");
            return (Criteria) this;
        }

        public Criteria andPlyBookNumIsNotNull() {
            addCriterion("ply_book_num is not null");
            return (Criteria) this;
        }

        public Criteria andPlyBookNumEqualTo(Integer value) {
            addCriterion("ply_book_num =", value, "plyBookNum");
            return (Criteria) this;
        }

        public Criteria andPlyBookNumNotEqualTo(Integer value) {
            addCriterion("ply_book_num <>", value, "plyBookNum");
            return (Criteria) this;
        }

        public Criteria andPlyBookNumGreaterThan(Integer value) {
            addCriterion("ply_book_num >", value, "plyBookNum");
            return (Criteria) this;
        }

        public Criteria andPlyBookNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ply_book_num >=", value, "plyBookNum");
            return (Criteria) this;
        }

        public Criteria andPlyBookNumLessThan(Integer value) {
            addCriterion("ply_book_num <", value, "plyBookNum");
            return (Criteria) this;
        }

        public Criteria andPlyBookNumLessThanOrEqualTo(Integer value) {
            addCriterion("ply_book_num <=", value, "plyBookNum");
            return (Criteria) this;
        }

        public Criteria andPlyBookNumIn(List<Integer> values) {
            addCriterion("ply_book_num in", values, "plyBookNum");
            return (Criteria) this;
        }

        public Criteria andPlyBookNumNotIn(List<Integer> values) {
            addCriterion("ply_book_num not in", values, "plyBookNum");
            return (Criteria) this;
        }

        public Criteria andPlyBookNumBetween(Integer value1, Integer value2) {
            addCriterion("ply_book_num between", value1, value2, "plyBookNum");
            return (Criteria) this;
        }

        public Criteria andPlyBookNumNotBetween(Integer value1, Integer value2) {
            addCriterion("ply_book_num not between", value1, value2, "plyBookNum");
            return (Criteria) this;
        }

        public Criteria andPlyTimeIsNull() {
            addCriterion("ply_time is null");
            return (Criteria) this;
        }

        public Criteria andPlyTimeIsNotNull() {
            addCriterion("ply_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlyTimeEqualTo(Date value) {
            addCriterion("ply_time =", value, "plyTime");
            return (Criteria) this;
        }

        public Criteria andPlyTimeNotEqualTo(Date value) {
            addCriterion("ply_time <>", value, "plyTime");
            return (Criteria) this;
        }

        public Criteria andPlyTimeGreaterThan(Date value) {
            addCriterion("ply_time >", value, "plyTime");
            return (Criteria) this;
        }

        public Criteria andPlyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ply_time >=", value, "plyTime");
            return (Criteria) this;
        }

        public Criteria andPlyTimeLessThan(Date value) {
            addCriterion("ply_time <", value, "plyTime");
            return (Criteria) this;
        }

        public Criteria andPlyTimeLessThanOrEqualTo(Date value) {
            addCriterion("ply_time <=", value, "plyTime");
            return (Criteria) this;
        }

        public Criteria andPlyTimeIn(List<Date> values) {
            addCriterion("ply_time in", values, "plyTime");
            return (Criteria) this;
        }

        public Criteria andPlyTimeNotIn(List<Date> values) {
            addCriterion("ply_time not in", values, "plyTime");
            return (Criteria) this;
        }

        public Criteria andPlyTimeBetween(Date value1, Date value2) {
            addCriterion("ply_time between", value1, value2, "plyTime");
            return (Criteria) this;
        }

        public Criteria andPlyTimeNotBetween(Date value1, Date value2) {
            addCriterion("ply_time not between", value1, value2, "plyTime");
            return (Criteria) this;
        }

        public Criteria andPlyMessageIsNull() {
            addCriterion("ply_message is null");
            return (Criteria) this;
        }

        public Criteria andPlyMessageIsNotNull() {
            addCriterion("ply_message is not null");
            return (Criteria) this;
        }

        public Criteria andPlyMessageEqualTo(String value) {
            addCriterion("ply_message =", value, "plyMessage");
            return (Criteria) this;
        }

        public Criteria andPlyMessageNotEqualTo(String value) {
            addCriterion("ply_message <>", value, "plyMessage");
            return (Criteria) this;
        }

        public Criteria andPlyMessageGreaterThan(String value) {
            addCriterion("ply_message >", value, "plyMessage");
            return (Criteria) this;
        }

        public Criteria andPlyMessageGreaterThanOrEqualTo(String value) {
            addCriterion("ply_message >=", value, "plyMessage");
            return (Criteria) this;
        }

        public Criteria andPlyMessageLessThan(String value) {
            addCriterion("ply_message <", value, "plyMessage");
            return (Criteria) this;
        }

        public Criteria andPlyMessageLessThanOrEqualTo(String value) {
            addCriterion("ply_message <=", value, "plyMessage");
            return (Criteria) this;
        }

        public Criteria andPlyMessageLike(String value) {
            addCriterion("ply_message like", value, "plyMessage");
            return (Criteria) this;
        }

        public Criteria andPlyMessageNotLike(String value) {
            addCriterion("ply_message not like", value, "plyMessage");
            return (Criteria) this;
        }

        public Criteria andPlyMessageIn(List<String> values) {
            addCriterion("ply_message in", values, "plyMessage");
            return (Criteria) this;
        }

        public Criteria andPlyMessageNotIn(List<String> values) {
            addCriterion("ply_message not in", values, "plyMessage");
            return (Criteria) this;
        }

        public Criteria andPlyMessageBetween(String value1, String value2) {
            addCriterion("ply_message between", value1, value2, "plyMessage");
            return (Criteria) this;
        }

        public Criteria andPlyMessageNotBetween(String value1, String value2) {
            addCriterion("ply_message not between", value1, value2, "plyMessage");
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