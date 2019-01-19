package com.atguigu.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class ManagePeopleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ManagePeopleExample() {
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

        public Criteria andManageNameIsNull() {
            addCriterion("manage_name is null");
            return (Criteria) this;
        }

        public Criteria andManageNameIsNotNull() {
            addCriterion("manage_name is not null");
            return (Criteria) this;
        }

        public Criteria andManageNameEqualTo(String value) {
            addCriterion("manage_name =", value, "manageName");
            return (Criteria) this;
        }

        public Criteria andManageNameNotEqualTo(String value) {
            addCriterion("manage_name <>", value, "manageName");
            return (Criteria) this;
        }

        public Criteria andManageNameGreaterThan(String value) {
            addCriterion("manage_name >", value, "manageName");
            return (Criteria) this;
        }

        public Criteria andManageNameGreaterThanOrEqualTo(String value) {
            addCriterion("manage_name >=", value, "manageName");
            return (Criteria) this;
        }

        public Criteria andManageNameLessThan(String value) {
            addCriterion("manage_name <", value, "manageName");
            return (Criteria) this;
        }

        public Criteria andManageNameLessThanOrEqualTo(String value) {
            addCriterion("manage_name <=", value, "manageName");
            return (Criteria) this;
        }

        public Criteria andManageNameLike(String value) {
            addCriterion("manage_name like", value, "manageName");
            return (Criteria) this;
        }

        public Criteria andManageNameNotLike(String value) {
            addCriterion("manage_name not like", value, "manageName");
            return (Criteria) this;
        }

        public Criteria andManageNameIn(List<String> values) {
            addCriterion("manage_name in", values, "manageName");
            return (Criteria) this;
        }

        public Criteria andManageNameNotIn(List<String> values) {
            addCriterion("manage_name not in", values, "manageName");
            return (Criteria) this;
        }

        public Criteria andManageNameBetween(String value1, String value2) {
            addCriterion("manage_name between", value1, value2, "manageName");
            return (Criteria) this;
        }

        public Criteria andManageNameNotBetween(String value1, String value2) {
            addCriterion("manage_name not between", value1, value2, "manageName");
            return (Criteria) this;
        }

        public Criteria andManagePasswordIsNull() {
            addCriterion("manage_password is null");
            return (Criteria) this;
        }

        public Criteria andManagePasswordIsNotNull() {
            addCriterion("manage_password is not null");
            return (Criteria) this;
        }

        public Criteria andManagePasswordEqualTo(String value) {
            addCriterion("manage_password =", value, "managePassword");
            return (Criteria) this;
        }

        public Criteria andManagePasswordNotEqualTo(String value) {
            addCriterion("manage_password <>", value, "managePassword");
            return (Criteria) this;
        }

        public Criteria andManagePasswordGreaterThan(String value) {
            addCriterion("manage_password >", value, "managePassword");
            return (Criteria) this;
        }

        public Criteria andManagePasswordGreaterThanOrEqualTo(String value) {
            addCriterion("manage_password >=", value, "managePassword");
            return (Criteria) this;
        }

        public Criteria andManagePasswordLessThan(String value) {
            addCriterion("manage_password <", value, "managePassword");
            return (Criteria) this;
        }

        public Criteria andManagePasswordLessThanOrEqualTo(String value) {
            addCriterion("manage_password <=", value, "managePassword");
            return (Criteria) this;
        }

        public Criteria andManagePasswordLike(String value) {
            addCriterion("manage_password like", value, "managePassword");
            return (Criteria) this;
        }

        public Criteria andManagePasswordNotLike(String value) {
            addCriterion("manage_password not like", value, "managePassword");
            return (Criteria) this;
        }

        public Criteria andManagePasswordIn(List<String> values) {
            addCriterion("manage_password in", values, "managePassword");
            return (Criteria) this;
        }

        public Criteria andManagePasswordNotIn(List<String> values) {
            addCriterion("manage_password not in", values, "managePassword");
            return (Criteria) this;
        }

        public Criteria andManagePasswordBetween(String value1, String value2) {
            addCriterion("manage_password between", value1, value2, "managePassword");
            return (Criteria) this;
        }

        public Criteria andManagePasswordNotBetween(String value1, String value2) {
            addCriterion("manage_password not between", value1, value2, "managePassword");
            return (Criteria) this;
        }

        public Criteria andManagePhoneIsNull() {
            addCriterion("manage_phone is null");
            return (Criteria) this;
        }

        public Criteria andManagePhoneIsNotNull() {
            addCriterion("manage_phone is not null");
            return (Criteria) this;
        }

        public Criteria andManagePhoneEqualTo(String value) {
            addCriterion("manage_phone =", value, "managePhone");
            return (Criteria) this;
        }

        public Criteria andManagePhoneNotEqualTo(String value) {
            addCriterion("manage_phone <>", value, "managePhone");
            return (Criteria) this;
        }

        public Criteria andManagePhoneGreaterThan(String value) {
            addCriterion("manage_phone >", value, "managePhone");
            return (Criteria) this;
        }

        public Criteria andManagePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("manage_phone >=", value, "managePhone");
            return (Criteria) this;
        }

        public Criteria andManagePhoneLessThan(String value) {
            addCriterion("manage_phone <", value, "managePhone");
            return (Criteria) this;
        }

        public Criteria andManagePhoneLessThanOrEqualTo(String value) {
            addCriterion("manage_phone <=", value, "managePhone");
            return (Criteria) this;
        }

        public Criteria andManagePhoneLike(String value) {
            addCriterion("manage_phone like", value, "managePhone");
            return (Criteria) this;
        }

        public Criteria andManagePhoneNotLike(String value) {
            addCriterion("manage_phone not like", value, "managePhone");
            return (Criteria) this;
        }

        public Criteria andManagePhoneIn(List<String> values) {
            addCriterion("manage_phone in", values, "managePhone");
            return (Criteria) this;
        }

        public Criteria andManagePhoneNotIn(List<String> values) {
            addCriterion("manage_phone not in", values, "managePhone");
            return (Criteria) this;
        }

        public Criteria andManagePhoneBetween(String value1, String value2) {
            addCriterion("manage_phone between", value1, value2, "managePhone");
            return (Criteria) this;
        }

        public Criteria andManagePhoneNotBetween(String value1, String value2) {
            addCriterion("manage_phone not between", value1, value2, "managePhone");
            return (Criteria) this;
        }

        public Criteria andManageEmpidIsNull() {
            addCriterion("manage_empid is null");
            return (Criteria) this;
        }

        public Criteria andManageEmpidIsNotNull() {
            addCriterion("manage_empid is not null");
            return (Criteria) this;
        }

        public Criteria andManageEmpidEqualTo(Integer value) {
            addCriterion("manage_empid =", value, "manageEmpid");
            return (Criteria) this;
        }

        public Criteria andManageEmpidNotEqualTo(Integer value) {
            addCriterion("manage_empid <>", value, "manageEmpid");
            return (Criteria) this;
        }

        public Criteria andManageEmpidGreaterThan(Integer value) {
            addCriterion("manage_empid >", value, "manageEmpid");
            return (Criteria) this;
        }

        public Criteria andManageEmpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("manage_empid >=", value, "manageEmpid");
            return (Criteria) this;
        }

        public Criteria andManageEmpidLessThan(Integer value) {
            addCriterion("manage_empid <", value, "manageEmpid");
            return (Criteria) this;
        }

        public Criteria andManageEmpidLessThanOrEqualTo(Integer value) {
            addCriterion("manage_empid <=", value, "manageEmpid");
            return (Criteria) this;
        }

        public Criteria andManageEmpidIn(List<Integer> values) {
            addCriterion("manage_empid in", values, "manageEmpid");
            return (Criteria) this;
        }

        public Criteria andManageEmpidNotIn(List<Integer> values) {
            addCriterion("manage_empid not in", values, "manageEmpid");
            return (Criteria) this;
        }

        public Criteria andManageEmpidBetween(Integer value1, Integer value2) {
            addCriterion("manage_empid between", value1, value2, "manageEmpid");
            return (Criteria) this;
        }

        public Criteria andManageEmpidNotBetween(Integer value1, Integer value2) {
            addCriterion("manage_empid not between", value1, value2, "manageEmpid");
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