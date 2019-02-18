package com.atguigu.crud.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReplyExample() {
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

        public Criteria andReplyIdIsNull() {
            addCriterion("reply_id is null");
            return (Criteria) this;
        }

        public Criteria andReplyIdIsNotNull() {
            addCriterion("reply_id is not null");
            return (Criteria) this;
        }

        public Criteria andReplyIdEqualTo(Integer value) {
            addCriterion("reply_id =", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotEqualTo(Integer value) {
            addCriterion("reply_id <>", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdGreaterThan(Integer value) {
            addCriterion("reply_id >", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_id >=", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdLessThan(Integer value) {
            addCriterion("reply_id <", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("reply_id <=", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdIn(List<Integer> values) {
            addCriterion("reply_id in", values, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotIn(List<Integer> values) {
            addCriterion("reply_id not in", values, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdBetween(Integer value1, Integer value2) {
            addCriterion("reply_id between", value1, value2, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_id not between", value1, value2, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdIsNull() {
            addCriterion("reply_peo_id is null");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdIsNotNull() {
            addCriterion("reply_peo_id is not null");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdEqualTo(Integer value) {
            addCriterion("reply_peo_id =", value, "replyPeoId");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdNotEqualTo(Integer value) {
            addCriterion("reply_peo_id <>", value, "replyPeoId");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdGreaterThan(Integer value) {
            addCriterion("reply_peo_id >", value, "replyPeoId");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_peo_id >=", value, "replyPeoId");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdLessThan(Integer value) {
            addCriterion("reply_peo_id <", value, "replyPeoId");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdLessThanOrEqualTo(Integer value) {
            addCriterion("reply_peo_id <=", value, "replyPeoId");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdIn(List<Integer> values) {
            addCriterion("reply_peo_id in", values, "replyPeoId");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdNotIn(List<Integer> values) {
            addCriterion("reply_peo_id not in", values, "replyPeoId");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdBetween(Integer value1, Integer value2) {
            addCriterion("reply_peo_id between", value1, value2, "replyPeoId");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_peo_id not between", value1, value2, "replyPeoId");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdNameIsNull() {
            addCriterion("reply_peo_id_name is null");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdNameIsNotNull() {
            addCriterion("reply_peo_id_name is not null");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdNameEqualTo(String value) {
            addCriterion("reply_peo_id_name =", value, "replyPeoIdName");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdNameNotEqualTo(String value) {
            addCriterion("reply_peo_id_name <>", value, "replyPeoIdName");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdNameGreaterThan(String value) {
            addCriterion("reply_peo_id_name >", value, "replyPeoIdName");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdNameGreaterThanOrEqualTo(String value) {
            addCriterion("reply_peo_id_name >=", value, "replyPeoIdName");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdNameLessThan(String value) {
            addCriterion("reply_peo_id_name <", value, "replyPeoIdName");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdNameLessThanOrEqualTo(String value) {
            addCriterion("reply_peo_id_name <=", value, "replyPeoIdName");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdNameLike(String value) {
            addCriterion("reply_peo_id_name like", value, "replyPeoIdName");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdNameNotLike(String value) {
            addCriterion("reply_peo_id_name not like", value, "replyPeoIdName");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdNameIn(List<String> values) {
            addCriterion("reply_peo_id_name in", values, "replyPeoIdName");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdNameNotIn(List<String> values) {
            addCriterion("reply_peo_id_name not in", values, "replyPeoIdName");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdNameBetween(String value1, String value2) {
            addCriterion("reply_peo_id_name between", value1, value2, "replyPeoIdName");
            return (Criteria) this;
        }

        public Criteria andReplyPeoIdNameNotBetween(String value1, String value2) {
            addCriterion("reply_peo_id_name not between", value1, value2, "replyPeoIdName");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyIdIsNull() {
            addCriterion("reply_to_ply_id is null");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyIdIsNotNull() {
            addCriterion("reply_to_ply_id is not null");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyIdEqualTo(Integer value) {
            addCriterion("reply_to_ply_id =", value, "replyToPlyId");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyIdNotEqualTo(Integer value) {
            addCriterion("reply_to_ply_id <>", value, "replyToPlyId");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyIdGreaterThan(Integer value) {
            addCriterion("reply_to_ply_id >", value, "replyToPlyId");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_to_ply_id >=", value, "replyToPlyId");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyIdLessThan(Integer value) {
            addCriterion("reply_to_ply_id <", value, "replyToPlyId");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyIdLessThanOrEqualTo(Integer value) {
            addCriterion("reply_to_ply_id <=", value, "replyToPlyId");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyIdIn(List<Integer> values) {
            addCriterion("reply_to_ply_id in", values, "replyToPlyId");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyIdNotIn(List<Integer> values) {
            addCriterion("reply_to_ply_id not in", values, "replyToPlyId");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyIdBetween(Integer value1, Integer value2) {
            addCriterion("reply_to_ply_id between", value1, value2, "replyToPlyId");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_to_ply_id not between", value1, value2, "replyToPlyId");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoIdIsNull() {
            addCriterion("reply_to_ply_peo_id is null");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoIdIsNotNull() {
            addCriterion("reply_to_ply_peo_id is not null");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoIdEqualTo(Integer value) {
            addCriterion("reply_to_ply_peo_id =", value, "replyToPlyPeoId");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoIdNotEqualTo(Integer value) {
            addCriterion("reply_to_ply_peo_id <>", value, "replyToPlyPeoId");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoIdGreaterThan(Integer value) {
            addCriterion("reply_to_ply_peo_id >", value, "replyToPlyPeoId");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_to_ply_peo_id >=", value, "replyToPlyPeoId");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoIdLessThan(Integer value) {
            addCriterion("reply_to_ply_peo_id <", value, "replyToPlyPeoId");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoIdLessThanOrEqualTo(Integer value) {
            addCriterion("reply_to_ply_peo_id <=", value, "replyToPlyPeoId");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoIdIn(List<Integer> values) {
            addCriterion("reply_to_ply_peo_id in", values, "replyToPlyPeoId");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoIdNotIn(List<Integer> values) {
            addCriterion("reply_to_ply_peo_id not in", values, "replyToPlyPeoId");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoIdBetween(Integer value1, Integer value2) {
            addCriterion("reply_to_ply_peo_id between", value1, value2, "replyToPlyPeoId");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_to_ply_peo_id not between", value1, value2, "replyToPlyPeoId");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoNameIsNull() {
            addCriterion("reply_to_ply_peo_name is null");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoNameIsNotNull() {
            addCriterion("reply_to_ply_peo_name is not null");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoNameEqualTo(String value) {
            addCriterion("reply_to_ply_peo_name =", value, "replyToPlyPeoName");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoNameNotEqualTo(String value) {
            addCriterion("reply_to_ply_peo_name <>", value, "replyToPlyPeoName");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoNameGreaterThan(String value) {
            addCriterion("reply_to_ply_peo_name >", value, "replyToPlyPeoName");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoNameGreaterThanOrEqualTo(String value) {
            addCriterion("reply_to_ply_peo_name >=", value, "replyToPlyPeoName");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoNameLessThan(String value) {
            addCriterion("reply_to_ply_peo_name <", value, "replyToPlyPeoName");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoNameLessThanOrEqualTo(String value) {
            addCriterion("reply_to_ply_peo_name <=", value, "replyToPlyPeoName");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoNameLike(String value) {
            addCriterion("reply_to_ply_peo_name like", value, "replyToPlyPeoName");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoNameNotLike(String value) {
            addCriterion("reply_to_ply_peo_name not like", value, "replyToPlyPeoName");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoNameIn(List<String> values) {
            addCriterion("reply_to_ply_peo_name in", values, "replyToPlyPeoName");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoNameNotIn(List<String> values) {
            addCriterion("reply_to_ply_peo_name not in", values, "replyToPlyPeoName");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoNameBetween(String value1, String value2) {
            addCriterion("reply_to_ply_peo_name between", value1, value2, "replyToPlyPeoName");
            return (Criteria) this;
        }

        public Criteria andReplyToPlyPeoNameNotBetween(String value1, String value2) {
            addCriterion("reply_to_ply_peo_name not between", value1, value2, "replyToPlyPeoName");
            return (Criteria) this;
        }

        public Criteria andReplytTimeIsNull() {
            addCriterion("replyt_time is null");
            return (Criteria) this;
        }

        public Criteria andReplytTimeIsNotNull() {
            addCriterion("replyt_time is not null");
            return (Criteria) this;
        }

        public Criteria andReplytTimeEqualTo(Date value) {
            addCriterion("replyt_time =", value, "replytTime");
            return (Criteria) this;
        }

        public Criteria andReplytTimeNotEqualTo(Date value) {
            addCriterion("replyt_time <>", value, "replytTime");
            return (Criteria) this;
        }

        public Criteria andReplytTimeGreaterThan(Date value) {
            addCriterion("replyt_time >", value, "replytTime");
            return (Criteria) this;
        }

        public Criteria andReplytTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("replyt_time >=", value, "replytTime");
            return (Criteria) this;
        }

        public Criteria andReplytTimeLessThan(Date value) {
            addCriterion("replyt_time <", value, "replytTime");
            return (Criteria) this;
        }

        public Criteria andReplytTimeLessThanOrEqualTo(Date value) {
            addCriterion("replyt_time <=", value, "replytTime");
            return (Criteria) this;
        }

        public Criteria andReplytTimeIn(List<Date> values) {
            addCriterion("replyt_time in", values, "replytTime");
            return (Criteria) this;
        }

        public Criteria andReplytTimeNotIn(List<Date> values) {
            addCriterion("replyt_time not in", values, "replytTime");
            return (Criteria) this;
        }

        public Criteria andReplytTimeBetween(Date value1, Date value2) {
            addCriterion("replyt_time between", value1, value2, "replytTime");
            return (Criteria) this;
        }

        public Criteria andReplytTimeNotBetween(Date value1, Date value2) {
            addCriterion("replyt_time not between", value1, value2, "replytTime");
            return (Criteria) this;
        }

        public Criteria andReplyMessageIsNull() {
            addCriterion("reply_message is null");
            return (Criteria) this;
        }

        public Criteria andReplyMessageIsNotNull() {
            addCriterion("reply_message is not null");
            return (Criteria) this;
        }

        public Criteria andReplyMessageEqualTo(String value) {
            addCriterion("reply_message =", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageNotEqualTo(String value) {
            addCriterion("reply_message <>", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageGreaterThan(String value) {
            addCriterion("reply_message >", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageGreaterThanOrEqualTo(String value) {
            addCriterion("reply_message >=", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageLessThan(String value) {
            addCriterion("reply_message <", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageLessThanOrEqualTo(String value) {
            addCriterion("reply_message <=", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageLike(String value) {
            addCriterion("reply_message like", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageNotLike(String value) {
            addCriterion("reply_message not like", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageIn(List<String> values) {
            addCriterion("reply_message in", values, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageNotIn(List<String> values) {
            addCriterion("reply_message not in", values, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageBetween(String value1, String value2) {
            addCriterion("reply_message between", value1, value2, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageNotBetween(String value1, String value2) {
            addCriterion("reply_message not between", value1, value2, "replyMessage");
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