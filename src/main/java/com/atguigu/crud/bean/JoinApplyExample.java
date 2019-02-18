package com.atguigu.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class JoinApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JoinApplyExample() {
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

        public Criteria andJoinIdIsNull() {
            addCriterion("join_id is null");
            return (Criteria) this;
        }

        public Criteria andJoinIdIsNotNull() {
            addCriterion("join_id is not null");
            return (Criteria) this;
        }

        public Criteria andJoinIdEqualTo(Integer value) {
            addCriterion("join_id =", value, "joinId");
            return (Criteria) this;
        }

        public Criteria andJoinIdNotEqualTo(Integer value) {
            addCriterion("join_id <>", value, "joinId");
            return (Criteria) this;
        }

        public Criteria andJoinIdGreaterThan(Integer value) {
            addCriterion("join_id >", value, "joinId");
            return (Criteria) this;
        }

        public Criteria andJoinIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("join_id >=", value, "joinId");
            return (Criteria) this;
        }

        public Criteria andJoinIdLessThan(Integer value) {
            addCriterion("join_id <", value, "joinId");
            return (Criteria) this;
        }

        public Criteria andJoinIdLessThanOrEqualTo(Integer value) {
            addCriterion("join_id <=", value, "joinId");
            return (Criteria) this;
        }

        public Criteria andJoinIdIn(List<Integer> values) {
            addCriterion("join_id in", values, "joinId");
            return (Criteria) this;
        }

        public Criteria andJoinIdNotIn(List<Integer> values) {
            addCriterion("join_id not in", values, "joinId");
            return (Criteria) this;
        }

        public Criteria andJoinIdBetween(Integer value1, Integer value2) {
            addCriterion("join_id between", value1, value2, "joinId");
            return (Criteria) this;
        }

        public Criteria andJoinIdNotBetween(Integer value1, Integer value2) {
            addCriterion("join_id not between", value1, value2, "joinId");
            return (Criteria) this;
        }

        public Criteria andJoinPeopleIdIsNull() {
            addCriterion("join_people_id is null");
            return (Criteria) this;
        }

        public Criteria andJoinPeopleIdIsNotNull() {
            addCriterion("join_people_id is not null");
            return (Criteria) this;
        }

        public Criteria andJoinPeopleIdEqualTo(Integer value) {
            addCriterion("join_people_id =", value, "joinPeopleId");
            return (Criteria) this;
        }

        public Criteria andJoinPeopleIdNotEqualTo(Integer value) {
            addCriterion("join_people_id <>", value, "joinPeopleId");
            return (Criteria) this;
        }

        public Criteria andJoinPeopleIdGreaterThan(Integer value) {
            addCriterion("join_people_id >", value, "joinPeopleId");
            return (Criteria) this;
        }

        public Criteria andJoinPeopleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("join_people_id >=", value, "joinPeopleId");
            return (Criteria) this;
        }

        public Criteria andJoinPeopleIdLessThan(Integer value) {
            addCriterion("join_people_id <", value, "joinPeopleId");
            return (Criteria) this;
        }

        public Criteria andJoinPeopleIdLessThanOrEqualTo(Integer value) {
            addCriterion("join_people_id <=", value, "joinPeopleId");
            return (Criteria) this;
        }

        public Criteria andJoinPeopleIdIn(List<Integer> values) {
            addCriterion("join_people_id in", values, "joinPeopleId");
            return (Criteria) this;
        }

        public Criteria andJoinPeopleIdNotIn(List<Integer> values) {
            addCriterion("join_people_id not in", values, "joinPeopleId");
            return (Criteria) this;
        }

        public Criteria andJoinPeopleIdBetween(Integer value1, Integer value2) {
            addCriterion("join_people_id between", value1, value2, "joinPeopleId");
            return (Criteria) this;
        }

        public Criteria andJoinPeopleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("join_people_id not between", value1, value2, "joinPeopleId");
            return (Criteria) this;
        }

        public Criteria andJoinBookIdIsNull() {
            addCriterion("join_book_id is null");
            return (Criteria) this;
        }

        public Criteria andJoinBookIdIsNotNull() {
            addCriterion("join_book_id is not null");
            return (Criteria) this;
        }

        public Criteria andJoinBookIdEqualTo(Integer value) {
            addCriterion("join_book_id =", value, "joinBookId");
            return (Criteria) this;
        }

        public Criteria andJoinBookIdNotEqualTo(Integer value) {
            addCriterion("join_book_id <>", value, "joinBookId");
            return (Criteria) this;
        }

        public Criteria andJoinBookIdGreaterThan(Integer value) {
            addCriterion("join_book_id >", value, "joinBookId");
            return (Criteria) this;
        }

        public Criteria andJoinBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("join_book_id >=", value, "joinBookId");
            return (Criteria) this;
        }

        public Criteria andJoinBookIdLessThan(Integer value) {
            addCriterion("join_book_id <", value, "joinBookId");
            return (Criteria) this;
        }

        public Criteria andJoinBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("join_book_id <=", value, "joinBookId");
            return (Criteria) this;
        }

        public Criteria andJoinBookIdIn(List<Integer> values) {
            addCriterion("join_book_id in", values, "joinBookId");
            return (Criteria) this;
        }

        public Criteria andJoinBookIdNotIn(List<Integer> values) {
            addCriterion("join_book_id not in", values, "joinBookId");
            return (Criteria) this;
        }

        public Criteria andJoinBookIdBetween(Integer value1, Integer value2) {
            addCriterion("join_book_id between", value1, value2, "joinBookId");
            return (Criteria) this;
        }

        public Criteria andJoinBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("join_book_id not between", value1, value2, "joinBookId");
            return (Criteria) this;
        }

        public Criteria andJoinBookOwnerIdIsNull() {
            addCriterion("join_book_owner_id is null");
            return (Criteria) this;
        }

        public Criteria andJoinBookOwnerIdIsNotNull() {
            addCriterion("join_book_owner_id is not null");
            return (Criteria) this;
        }

        public Criteria andJoinBookOwnerIdEqualTo(Integer value) {
            addCriterion("join_book_owner_id =", value, "joinBookOwnerId");
            return (Criteria) this;
        }

        public Criteria andJoinBookOwnerIdNotEqualTo(Integer value) {
            addCriterion("join_book_owner_id <>", value, "joinBookOwnerId");
            return (Criteria) this;
        }

        public Criteria andJoinBookOwnerIdGreaterThan(Integer value) {
            addCriterion("join_book_owner_id >", value, "joinBookOwnerId");
            return (Criteria) this;
        }

        public Criteria andJoinBookOwnerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("join_book_owner_id >=", value, "joinBookOwnerId");
            return (Criteria) this;
        }

        public Criteria andJoinBookOwnerIdLessThan(Integer value) {
            addCriterion("join_book_owner_id <", value, "joinBookOwnerId");
            return (Criteria) this;
        }

        public Criteria andJoinBookOwnerIdLessThanOrEqualTo(Integer value) {
            addCriterion("join_book_owner_id <=", value, "joinBookOwnerId");
            return (Criteria) this;
        }

        public Criteria andJoinBookOwnerIdIn(List<Integer> values) {
            addCriterion("join_book_owner_id in", values, "joinBookOwnerId");
            return (Criteria) this;
        }

        public Criteria andJoinBookOwnerIdNotIn(List<Integer> values) {
            addCriterion("join_book_owner_id not in", values, "joinBookOwnerId");
            return (Criteria) this;
        }

        public Criteria andJoinBookOwnerIdBetween(Integer value1, Integer value2) {
            addCriterion("join_book_owner_id between", value1, value2, "joinBookOwnerId");
            return (Criteria) this;
        }

        public Criteria andJoinBookOwnerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("join_book_owner_id not between", value1, value2, "joinBookOwnerId");
            return (Criteria) this;
        }

        public Criteria andJoinDealStateIsNull() {
            addCriterion("join_deal_state is null");
            return (Criteria) this;
        }

        public Criteria andJoinDealStateIsNotNull() {
            addCriterion("join_deal_state is not null");
            return (Criteria) this;
        }

        public Criteria andJoinDealStateEqualTo(Integer value) {
            addCriterion("join_deal_state =", value, "joinDealState");
            return (Criteria) this;
        }

        public Criteria andJoinDealStateNotEqualTo(Integer value) {
            addCriterion("join_deal_state <>", value, "joinDealState");
            return (Criteria) this;
        }

        public Criteria andJoinDealStateGreaterThan(Integer value) {
            addCriterion("join_deal_state >", value, "joinDealState");
            return (Criteria) this;
        }

        public Criteria andJoinDealStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("join_deal_state >=", value, "joinDealState");
            return (Criteria) this;
        }

        public Criteria andJoinDealStateLessThan(Integer value) {
            addCriterion("join_deal_state <", value, "joinDealState");
            return (Criteria) this;
        }

        public Criteria andJoinDealStateLessThanOrEqualTo(Integer value) {
            addCriterion("join_deal_state <=", value, "joinDealState");
            return (Criteria) this;
        }

        public Criteria andJoinDealStateIn(List<Integer> values) {
            addCriterion("join_deal_state in", values, "joinDealState");
            return (Criteria) this;
        }

        public Criteria andJoinDealStateNotIn(List<Integer> values) {
            addCriterion("join_deal_state not in", values, "joinDealState");
            return (Criteria) this;
        }

        public Criteria andJoinDealStateBetween(Integer value1, Integer value2) {
            addCriterion("join_deal_state between", value1, value2, "joinDealState");
            return (Criteria) this;
        }

        public Criteria andJoinDealStateNotBetween(Integer value1, Integer value2) {
            addCriterion("join_deal_state not between", value1, value2, "joinDealState");
            return (Criteria) this;
        }

        public Criteria andJoinOtherIsNull() {
            addCriterion("join_other is null");
            return (Criteria) this;
        }

        public Criteria andJoinOtherIsNotNull() {
            addCriterion("join_other is not null");
            return (Criteria) this;
        }

        public Criteria andJoinOtherEqualTo(String value) {
            addCriterion("join_other =", value, "joinOther");
            return (Criteria) this;
        }

        public Criteria andJoinOtherNotEqualTo(String value) {
            addCriterion("join_other <>", value, "joinOther");
            return (Criteria) this;
        }

        public Criteria andJoinOtherGreaterThan(String value) {
            addCriterion("join_other >", value, "joinOther");
            return (Criteria) this;
        }

        public Criteria andJoinOtherGreaterThanOrEqualTo(String value) {
            addCriterion("join_other >=", value, "joinOther");
            return (Criteria) this;
        }

        public Criteria andJoinOtherLessThan(String value) {
            addCriterion("join_other <", value, "joinOther");
            return (Criteria) this;
        }

        public Criteria andJoinOtherLessThanOrEqualTo(String value) {
            addCriterion("join_other <=", value, "joinOther");
            return (Criteria) this;
        }

        public Criteria andJoinOtherLike(String value) {
            addCriterion("join_other like", value, "joinOther");
            return (Criteria) this;
        }

        public Criteria andJoinOtherNotLike(String value) {
            addCriterion("join_other not like", value, "joinOther");
            return (Criteria) this;
        }

        public Criteria andJoinOtherIn(List<String> values) {
            addCriterion("join_other in", values, "joinOther");
            return (Criteria) this;
        }

        public Criteria andJoinOtherNotIn(List<String> values) {
            addCriterion("join_other not in", values, "joinOther");
            return (Criteria) this;
        }

        public Criteria andJoinOtherBetween(String value1, String value2) {
            addCriterion("join_other between", value1, value2, "joinOther");
            return (Criteria) this;
        }

        public Criteria andJoinOtherNotBetween(String value1, String value2) {
            addCriterion("join_other not between", value1, value2, "joinOther");
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