package com.atguigu.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class PeopleInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PeopleInfoExample() {
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

        public Criteria andPeoSerialNumIsNull() {
            addCriterion("peo_serial_num is null");
            return (Criteria) this;
        }

        public Criteria andPeoSerialNumIsNotNull() {
            addCriterion("peo_serial_num is not null");
            return (Criteria) this;
        }

        public Criteria andPeoSerialNumEqualTo(Integer value) {
            addCriterion("peo_serial_num =", value, "peoSerialNum");
            return (Criteria) this;
        }

        public Criteria andPeoSerialNumNotEqualTo(Integer value) {
            addCriterion("peo_serial_num <>", value, "peoSerialNum");
            return (Criteria) this;
        }

        public Criteria andPeoSerialNumGreaterThan(Integer value) {
            addCriterion("peo_serial_num >", value, "peoSerialNum");
            return (Criteria) this;
        }

        public Criteria andPeoSerialNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("peo_serial_num >=", value, "peoSerialNum");
            return (Criteria) this;
        }

        public Criteria andPeoSerialNumLessThan(Integer value) {
            addCriterion("peo_serial_num <", value, "peoSerialNum");
            return (Criteria) this;
        }

        public Criteria andPeoSerialNumLessThanOrEqualTo(Integer value) {
            addCriterion("peo_serial_num <=", value, "peoSerialNum");
            return (Criteria) this;
        }

        public Criteria andPeoSerialNumIn(List<Integer> values) {
            addCriterion("peo_serial_num in", values, "peoSerialNum");
            return (Criteria) this;
        }

        public Criteria andPeoSerialNumNotIn(List<Integer> values) {
            addCriterion("peo_serial_num not in", values, "peoSerialNum");
            return (Criteria) this;
        }

        public Criteria andPeoSerialNumBetween(Integer value1, Integer value2) {
            addCriterion("peo_serial_num between", value1, value2, "peoSerialNum");
            return (Criteria) this;
        }

        public Criteria andPeoSerialNumNotBetween(Integer value1, Integer value2) {
            addCriterion("peo_serial_num not between", value1, value2, "peoSerialNum");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeIdIsNull() {
            addCriterion("peo_employee_id is null");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeIdIsNotNull() {
            addCriterion("peo_employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeIdEqualTo(Integer value) {
            addCriterion("peo_employee_id =", value, "peoEmployeeId");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeIdNotEqualTo(Integer value) {
            addCriterion("peo_employee_id <>", value, "peoEmployeeId");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeIdGreaterThan(Integer value) {
            addCriterion("peo_employee_id >", value, "peoEmployeeId");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("peo_employee_id >=", value, "peoEmployeeId");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeIdLessThan(Integer value) {
            addCriterion("peo_employee_id <", value, "peoEmployeeId");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeIdLessThanOrEqualTo(Integer value) {
            addCriterion("peo_employee_id <=", value, "peoEmployeeId");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeIdIn(List<Integer> values) {
            addCriterion("peo_employee_id in", values, "peoEmployeeId");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeIdNotIn(List<Integer> values) {
            addCriterion("peo_employee_id not in", values, "peoEmployeeId");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeIdBetween(Integer value1, Integer value2) {
            addCriterion("peo_employee_id between", value1, value2, "peoEmployeeId");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("peo_employee_id not between", value1, value2, "peoEmployeeId");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeNameIsNull() {
            addCriterion("peo_employee_name is null");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeNameIsNotNull() {
            addCriterion("peo_employee_name is not null");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeNameEqualTo(String value) {
            addCriterion("peo_employee_name =", value, "peoEmployeeName");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeNameNotEqualTo(String value) {
            addCriterion("peo_employee_name <>", value, "peoEmployeeName");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeNameGreaterThan(String value) {
            addCriterion("peo_employee_name >", value, "peoEmployeeName");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeNameGreaterThanOrEqualTo(String value) {
            addCriterion("peo_employee_name >=", value, "peoEmployeeName");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeNameLessThan(String value) {
            addCriterion("peo_employee_name <", value, "peoEmployeeName");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeNameLessThanOrEqualTo(String value) {
            addCriterion("peo_employee_name <=", value, "peoEmployeeName");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeNameLike(String value) {
            addCriterion("peo_employee_name like", value, "peoEmployeeName");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeNameNotLike(String value) {
            addCriterion("peo_employee_name not like", value, "peoEmployeeName");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeNameIn(List<String> values) {
            addCriterion("peo_employee_name in", values, "peoEmployeeName");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeNameNotIn(List<String> values) {
            addCriterion("peo_employee_name not in", values, "peoEmployeeName");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeNameBetween(String value1, String value2) {
            addCriterion("peo_employee_name between", value1, value2, "peoEmployeeName");
            return (Criteria) this;
        }

        public Criteria andPeoEmployeeNameNotBetween(String value1, String value2) {
            addCriterion("peo_employee_name not between", value1, value2, "peoEmployeeName");
            return (Criteria) this;
        }

        public Criteria andPeoPasswordIsNull() {
            addCriterion("peo_password is null");
            return (Criteria) this;
        }

        public Criteria andPeoPasswordIsNotNull() {
            addCriterion("peo_password is not null");
            return (Criteria) this;
        }

        public Criteria andPeoPasswordEqualTo(String value) {
            addCriterion("peo_password =", value, "peoPassword");
            return (Criteria) this;
        }

        public Criteria andPeoPasswordNotEqualTo(String value) {
            addCriterion("peo_password <>", value, "peoPassword");
            return (Criteria) this;
        }

        public Criteria andPeoPasswordGreaterThan(String value) {
            addCriterion("peo_password >", value, "peoPassword");
            return (Criteria) this;
        }

        public Criteria andPeoPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("peo_password >=", value, "peoPassword");
            return (Criteria) this;
        }

        public Criteria andPeoPasswordLessThan(String value) {
            addCriterion("peo_password <", value, "peoPassword");
            return (Criteria) this;
        }

        public Criteria andPeoPasswordLessThanOrEqualTo(String value) {
            addCriterion("peo_password <=", value, "peoPassword");
            return (Criteria) this;
        }

        public Criteria andPeoPasswordLike(String value) {
            addCriterion("peo_password like", value, "peoPassword");
            return (Criteria) this;
        }

        public Criteria andPeoPasswordNotLike(String value) {
            addCriterion("peo_password not like", value, "peoPassword");
            return (Criteria) this;
        }

        public Criteria andPeoPasswordIn(List<String> values) {
            addCriterion("peo_password in", values, "peoPassword");
            return (Criteria) this;
        }

        public Criteria andPeoPasswordNotIn(List<String> values) {
            addCriterion("peo_password not in", values, "peoPassword");
            return (Criteria) this;
        }

        public Criteria andPeoPasswordBetween(String value1, String value2) {
            addCriterion("peo_password between", value1, value2, "peoPassword");
            return (Criteria) this;
        }

        public Criteria andPeoPasswordNotBetween(String value1, String value2) {
            addCriterion("peo_password not between", value1, value2, "peoPassword");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneIsNull() {
            addCriterion("peo_phone is null");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneIsNotNull() {
            addCriterion("peo_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneEqualTo(String value) {
            addCriterion("peo_phone =", value, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneNotEqualTo(String value) {
            addCriterion("peo_phone <>", value, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneGreaterThan(String value) {
            addCriterion("peo_phone >", value, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("peo_phone >=", value, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneLessThan(String value) {
            addCriterion("peo_phone <", value, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneLessThanOrEqualTo(String value) {
            addCriterion("peo_phone <=", value, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneLike(String value) {
            addCriterion("peo_phone like", value, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneNotLike(String value) {
            addCriterion("peo_phone not like", value, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneIn(List<String> values) {
            addCriterion("peo_phone in", values, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneNotIn(List<String> values) {
            addCriterion("peo_phone not in", values, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneBetween(String value1, String value2) {
            addCriterion("peo_phone between", value1, value2, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneNotBetween(String value1, String value2) {
            addCriterion("peo_phone not between", value1, value2, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPostIsNull() {
            addCriterion("peo_post is null");
            return (Criteria) this;
        }

        public Criteria andPeoPostIsNotNull() {
            addCriterion("peo_post is not null");
            return (Criteria) this;
        }

        public Criteria andPeoPostEqualTo(String value) {
            addCriterion("peo_post =", value, "peoPost");
            return (Criteria) this;
        }

        public Criteria andPeoPostNotEqualTo(String value) {
            addCriterion("peo_post <>", value, "peoPost");
            return (Criteria) this;
        }

        public Criteria andPeoPostGreaterThan(String value) {
            addCriterion("peo_post >", value, "peoPost");
            return (Criteria) this;
        }

        public Criteria andPeoPostGreaterThanOrEqualTo(String value) {
            addCriterion("peo_post >=", value, "peoPost");
            return (Criteria) this;
        }

        public Criteria andPeoPostLessThan(String value) {
            addCriterion("peo_post <", value, "peoPost");
            return (Criteria) this;
        }

        public Criteria andPeoPostLessThanOrEqualTo(String value) {
            addCriterion("peo_post <=", value, "peoPost");
            return (Criteria) this;
        }

        public Criteria andPeoPostLike(String value) {
            addCriterion("peo_post like", value, "peoPost");
            return (Criteria) this;
        }

        public Criteria andPeoPostNotLike(String value) {
            addCriterion("peo_post not like", value, "peoPost");
            return (Criteria) this;
        }

        public Criteria andPeoPostIn(List<String> values) {
            addCriterion("peo_post in", values, "peoPost");
            return (Criteria) this;
        }

        public Criteria andPeoPostNotIn(List<String> values) {
            addCriterion("peo_post not in", values, "peoPost");
            return (Criteria) this;
        }

        public Criteria andPeoPostBetween(String value1, String value2) {
            addCriterion("peo_post between", value1, value2, "peoPost");
            return (Criteria) this;
        }

        public Criteria andPeoPostNotBetween(String value1, String value2) {
            addCriterion("peo_post not between", value1, value2, "peoPost");
            return (Criteria) this;
        }

        public Criteria andPeoAddressIsNull() {
            addCriterion("peo_address is null");
            return (Criteria) this;
        }

        public Criteria andPeoAddressIsNotNull() {
            addCriterion("peo_address is not null");
            return (Criteria) this;
        }

        public Criteria andPeoAddressEqualTo(String value) {
            addCriterion("peo_address =", value, "peoAddress");
            return (Criteria) this;
        }

        public Criteria andPeoAddressNotEqualTo(String value) {
            addCriterion("peo_address <>", value, "peoAddress");
            return (Criteria) this;
        }

        public Criteria andPeoAddressGreaterThan(String value) {
            addCriterion("peo_address >", value, "peoAddress");
            return (Criteria) this;
        }

        public Criteria andPeoAddressGreaterThanOrEqualTo(String value) {
            addCriterion("peo_address >=", value, "peoAddress");
            return (Criteria) this;
        }

        public Criteria andPeoAddressLessThan(String value) {
            addCriterion("peo_address <", value, "peoAddress");
            return (Criteria) this;
        }

        public Criteria andPeoAddressLessThanOrEqualTo(String value) {
            addCriterion("peo_address <=", value, "peoAddress");
            return (Criteria) this;
        }

        public Criteria andPeoAddressLike(String value) {
            addCriterion("peo_address like", value, "peoAddress");
            return (Criteria) this;
        }

        public Criteria andPeoAddressNotLike(String value) {
            addCriterion("peo_address not like", value, "peoAddress");
            return (Criteria) this;
        }

        public Criteria andPeoAddressIn(List<String> values) {
            addCriterion("peo_address in", values, "peoAddress");
            return (Criteria) this;
        }

        public Criteria andPeoAddressNotIn(List<String> values) {
            addCriterion("peo_address not in", values, "peoAddress");
            return (Criteria) this;
        }

        public Criteria andPeoAddressBetween(String value1, String value2) {
            addCriterion("peo_address between", value1, value2, "peoAddress");
            return (Criteria) this;
        }

        public Criteria andPeoAddressNotBetween(String value1, String value2) {
            addCriterion("peo_address not between", value1, value2, "peoAddress");
            return (Criteria) this;
        }

        public Criteria andPeoEmailIsNull() {
            addCriterion("peo_email is null");
            return (Criteria) this;
        }

        public Criteria andPeoEmailIsNotNull() {
            addCriterion("peo_email is not null");
            return (Criteria) this;
        }

        public Criteria andPeoEmailEqualTo(String value) {
            addCriterion("peo_email =", value, "peoEmail");
            return (Criteria) this;
        }

        public Criteria andPeoEmailNotEqualTo(String value) {
            addCriterion("peo_email <>", value, "peoEmail");
            return (Criteria) this;
        }

        public Criteria andPeoEmailGreaterThan(String value) {
            addCriterion("peo_email >", value, "peoEmail");
            return (Criteria) this;
        }

        public Criteria andPeoEmailGreaterThanOrEqualTo(String value) {
            addCriterion("peo_email >=", value, "peoEmail");
            return (Criteria) this;
        }

        public Criteria andPeoEmailLessThan(String value) {
            addCriterion("peo_email <", value, "peoEmail");
            return (Criteria) this;
        }

        public Criteria andPeoEmailLessThanOrEqualTo(String value) {
            addCriterion("peo_email <=", value, "peoEmail");
            return (Criteria) this;
        }

        public Criteria andPeoEmailLike(String value) {
            addCriterion("peo_email like", value, "peoEmail");
            return (Criteria) this;
        }

        public Criteria andPeoEmailNotLike(String value) {
            addCriterion("peo_email not like", value, "peoEmail");
            return (Criteria) this;
        }

        public Criteria andPeoEmailIn(List<String> values) {
            addCriterion("peo_email in", values, "peoEmail");
            return (Criteria) this;
        }

        public Criteria andPeoEmailNotIn(List<String> values) {
            addCriterion("peo_email not in", values, "peoEmail");
            return (Criteria) this;
        }

        public Criteria andPeoEmailBetween(String value1, String value2) {
            addCriterion("peo_email between", value1, value2, "peoEmail");
            return (Criteria) this;
        }

        public Criteria andPeoEmailNotBetween(String value1, String value2) {
            addCriterion("peo_email not between", value1, value2, "peoEmail");
            return (Criteria) this;
        }

        public Criteria andPeoImagePathIsNull() {
            addCriterion("peo_image_path is null");
            return (Criteria) this;
        }

        public Criteria andPeoImagePathIsNotNull() {
            addCriterion("peo_image_path is not null");
            return (Criteria) this;
        }

        public Criteria andPeoImagePathEqualTo(String value) {
            addCriterion("peo_image_path =", value, "peoImagePath");
            return (Criteria) this;
        }

        public Criteria andPeoImagePathNotEqualTo(String value) {
            addCriterion("peo_image_path <>", value, "peoImagePath");
            return (Criteria) this;
        }

        public Criteria andPeoImagePathGreaterThan(String value) {
            addCriterion("peo_image_path >", value, "peoImagePath");
            return (Criteria) this;
        }

        public Criteria andPeoImagePathGreaterThanOrEqualTo(String value) {
            addCriterion("peo_image_path >=", value, "peoImagePath");
            return (Criteria) this;
        }

        public Criteria andPeoImagePathLessThan(String value) {
            addCriterion("peo_image_path <", value, "peoImagePath");
            return (Criteria) this;
        }

        public Criteria andPeoImagePathLessThanOrEqualTo(String value) {
            addCriterion("peo_image_path <=", value, "peoImagePath");
            return (Criteria) this;
        }

        public Criteria andPeoImagePathLike(String value) {
            addCriterion("peo_image_path like", value, "peoImagePath");
            return (Criteria) this;
        }

        public Criteria andPeoImagePathNotLike(String value) {
            addCriterion("peo_image_path not like", value, "peoImagePath");
            return (Criteria) this;
        }

        public Criteria andPeoImagePathIn(List<String> values) {
            addCriterion("peo_image_path in", values, "peoImagePath");
            return (Criteria) this;
        }

        public Criteria andPeoImagePathNotIn(List<String> values) {
            addCriterion("peo_image_path not in", values, "peoImagePath");
            return (Criteria) this;
        }

        public Criteria andPeoImagePathBetween(String value1, String value2) {
            addCriterion("peo_image_path between", value1, value2, "peoImagePath");
            return (Criteria) this;
        }

        public Criteria andPeoImagePathNotBetween(String value1, String value2) {
            addCriterion("peo_image_path not between", value1, value2, "peoImagePath");
            return (Criteria) this;
        }

        public Criteria andPeoOtherIsNull() {
            addCriterion("peo_other is null");
            return (Criteria) this;
        }

        public Criteria andPeoOtherIsNotNull() {
            addCriterion("peo_other is not null");
            return (Criteria) this;
        }

        public Criteria andPeoOtherEqualTo(String value) {
            addCriterion("peo_other =", value, "peoOther");
            return (Criteria) this;
        }

        public Criteria andPeoOtherNotEqualTo(String value) {
            addCriterion("peo_other <>", value, "peoOther");
            return (Criteria) this;
        }

        public Criteria andPeoOtherGreaterThan(String value) {
            addCriterion("peo_other >", value, "peoOther");
            return (Criteria) this;
        }

        public Criteria andPeoOtherGreaterThanOrEqualTo(String value) {
            addCriterion("peo_other >=", value, "peoOther");
            return (Criteria) this;
        }

        public Criteria andPeoOtherLessThan(String value) {
            addCriterion("peo_other <", value, "peoOther");
            return (Criteria) this;
        }

        public Criteria andPeoOtherLessThanOrEqualTo(String value) {
            addCriterion("peo_other <=", value, "peoOther");
            return (Criteria) this;
        }

        public Criteria andPeoOtherLike(String value) {
            addCriterion("peo_other like", value, "peoOther");
            return (Criteria) this;
        }

        public Criteria andPeoOtherNotLike(String value) {
            addCriterion("peo_other not like", value, "peoOther");
            return (Criteria) this;
        }

        public Criteria andPeoOtherIn(List<String> values) {
            addCriterion("peo_other in", values, "peoOther");
            return (Criteria) this;
        }

        public Criteria andPeoOtherNotIn(List<String> values) {
            addCriterion("peo_other not in", values, "peoOther");
            return (Criteria) this;
        }

        public Criteria andPeoOtherBetween(String value1, String value2) {
            addCriterion("peo_other between", value1, value2, "peoOther");
            return (Criteria) this;
        }

        public Criteria andPeoOtherNotBetween(String value1, String value2) {
            addCriterion("peo_other not between", value1, value2, "peoOther");
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