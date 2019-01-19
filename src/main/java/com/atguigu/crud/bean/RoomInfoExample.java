package com.atguigu.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class RoomInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomInfoExample() {
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

        public Criteria andRoomNumIsNull() {
            addCriterion("room_num is null");
            return (Criteria) this;
        }

        public Criteria andRoomNumIsNotNull() {
            addCriterion("room_num is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNumEqualTo(Integer value) {
            addCriterion("room_num =", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumNotEqualTo(Integer value) {
            addCriterion("room_num <>", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumGreaterThan(Integer value) {
            addCriterion("room_num >", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_num >=", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumLessThan(Integer value) {
            addCriterion("room_num <", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumLessThanOrEqualTo(Integer value) {
            addCriterion("room_num <=", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumIn(List<Integer> values) {
            addCriterion("room_num in", values, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumNotIn(List<Integer> values) {
            addCriterion("room_num not in", values, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumBetween(Integer value1, Integer value2) {
            addCriterion("room_num between", value1, value2, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumNotBetween(Integer value1, Integer value2) {
            addCriterion("room_num not between", value1, value2, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNull() {
            addCriterion("room_name is null");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNotNull() {
            addCriterion("room_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNameEqualTo(String value) {
            addCriterion("room_name =", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotEqualTo(String value) {
            addCriterion("room_name <>", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThan(String value) {
            addCriterion("room_name >", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThanOrEqualTo(String value) {
            addCriterion("room_name >=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThan(String value) {
            addCriterion("room_name <", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThanOrEqualTo(String value) {
            addCriterion("room_name <=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLike(String value) {
            addCriterion("room_name like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotLike(String value) {
            addCriterion("room_name not like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameIn(List<String> values) {
            addCriterion("room_name in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotIn(List<String> values) {
            addCriterion("room_name not in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameBetween(String value1, String value2) {
            addCriterion("room_name between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotBetween(String value1, String value2) {
            addCriterion("room_name not between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomAddressIsNull() {
            addCriterion("room_address is null");
            return (Criteria) this;
        }

        public Criteria andRoomAddressIsNotNull() {
            addCriterion("room_address is not null");
            return (Criteria) this;
        }

        public Criteria andRoomAddressEqualTo(String value) {
            addCriterion("room_address =", value, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomAddressNotEqualTo(String value) {
            addCriterion("room_address <>", value, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomAddressGreaterThan(String value) {
            addCriterion("room_address >", value, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomAddressGreaterThanOrEqualTo(String value) {
            addCriterion("room_address >=", value, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomAddressLessThan(String value) {
            addCriterion("room_address <", value, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomAddressLessThanOrEqualTo(String value) {
            addCriterion("room_address <=", value, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomAddressLike(String value) {
            addCriterion("room_address like", value, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomAddressNotLike(String value) {
            addCriterion("room_address not like", value, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomAddressIn(List<String> values) {
            addCriterion("room_address in", values, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomAddressNotIn(List<String> values) {
            addCriterion("room_address not in", values, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomAddressBetween(String value1, String value2) {
            addCriterion("room_address between", value1, value2, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomAddressNotBetween(String value1, String value2) {
            addCriterion("room_address not between", value1, value2, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomMaxNumIsNull() {
            addCriterion("room_max_num is null");
            return (Criteria) this;
        }

        public Criteria andRoomMaxNumIsNotNull() {
            addCriterion("room_max_num is not null");
            return (Criteria) this;
        }

        public Criteria andRoomMaxNumEqualTo(Integer value) {
            addCriterion("room_max_num =", value, "roomMaxNum");
            return (Criteria) this;
        }

        public Criteria andRoomMaxNumNotEqualTo(Integer value) {
            addCriterion("room_max_num <>", value, "roomMaxNum");
            return (Criteria) this;
        }

        public Criteria andRoomMaxNumGreaterThan(Integer value) {
            addCriterion("room_max_num >", value, "roomMaxNum");
            return (Criteria) this;
        }

        public Criteria andRoomMaxNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_max_num >=", value, "roomMaxNum");
            return (Criteria) this;
        }

        public Criteria andRoomMaxNumLessThan(Integer value) {
            addCriterion("room_max_num <", value, "roomMaxNum");
            return (Criteria) this;
        }

        public Criteria andRoomMaxNumLessThanOrEqualTo(Integer value) {
            addCriterion("room_max_num <=", value, "roomMaxNum");
            return (Criteria) this;
        }

        public Criteria andRoomMaxNumIn(List<Integer> values) {
            addCriterion("room_max_num in", values, "roomMaxNum");
            return (Criteria) this;
        }

        public Criteria andRoomMaxNumNotIn(List<Integer> values) {
            addCriterion("room_max_num not in", values, "roomMaxNum");
            return (Criteria) this;
        }

        public Criteria andRoomMaxNumBetween(Integer value1, Integer value2) {
            addCriterion("room_max_num between", value1, value2, "roomMaxNum");
            return (Criteria) this;
        }

        public Criteria andRoomMaxNumNotBetween(Integer value1, Integer value2) {
            addCriterion("room_max_num not between", value1, value2, "roomMaxNum");
            return (Criteria) this;
        }

        public Criteria andRoomEquipmentIsNull() {
            addCriterion("room_equipment is null");
            return (Criteria) this;
        }

        public Criteria andRoomEquipmentIsNotNull() {
            addCriterion("room_equipment is not null");
            return (Criteria) this;
        }

        public Criteria andRoomEquipmentEqualTo(String value) {
            addCriterion("room_equipment =", value, "roomEquipment");
            return (Criteria) this;
        }

        public Criteria andRoomEquipmentNotEqualTo(String value) {
            addCriterion("room_equipment <>", value, "roomEquipment");
            return (Criteria) this;
        }

        public Criteria andRoomEquipmentGreaterThan(String value) {
            addCriterion("room_equipment >", value, "roomEquipment");
            return (Criteria) this;
        }

        public Criteria andRoomEquipmentGreaterThanOrEqualTo(String value) {
            addCriterion("room_equipment >=", value, "roomEquipment");
            return (Criteria) this;
        }

        public Criteria andRoomEquipmentLessThan(String value) {
            addCriterion("room_equipment <", value, "roomEquipment");
            return (Criteria) this;
        }

        public Criteria andRoomEquipmentLessThanOrEqualTo(String value) {
            addCriterion("room_equipment <=", value, "roomEquipment");
            return (Criteria) this;
        }

        public Criteria andRoomEquipmentLike(String value) {
            addCriterion("room_equipment like", value, "roomEquipment");
            return (Criteria) this;
        }

        public Criteria andRoomEquipmentNotLike(String value) {
            addCriterion("room_equipment not like", value, "roomEquipment");
            return (Criteria) this;
        }

        public Criteria andRoomEquipmentIn(List<String> values) {
            addCriterion("room_equipment in", values, "roomEquipment");
            return (Criteria) this;
        }

        public Criteria andRoomEquipmentNotIn(List<String> values) {
            addCriterion("room_equipment not in", values, "roomEquipment");
            return (Criteria) this;
        }

        public Criteria andRoomEquipmentBetween(String value1, String value2) {
            addCriterion("room_equipment between", value1, value2, "roomEquipment");
            return (Criteria) this;
        }

        public Criteria andRoomEquipmentNotBetween(String value1, String value2) {
            addCriterion("room_equipment not between", value1, value2, "roomEquipment");
            return (Criteria) this;
        }

        public Criteria andRoomOtherIsNull() {
            addCriterion("room_other is null");
            return (Criteria) this;
        }

        public Criteria andRoomOtherIsNotNull() {
            addCriterion("room_other is not null");
            return (Criteria) this;
        }

        public Criteria andRoomOtherEqualTo(String value) {
            addCriterion("room_other =", value, "roomOther");
            return (Criteria) this;
        }

        public Criteria andRoomOtherNotEqualTo(String value) {
            addCriterion("room_other <>", value, "roomOther");
            return (Criteria) this;
        }

        public Criteria andRoomOtherGreaterThan(String value) {
            addCriterion("room_other >", value, "roomOther");
            return (Criteria) this;
        }

        public Criteria andRoomOtherGreaterThanOrEqualTo(String value) {
            addCriterion("room_other >=", value, "roomOther");
            return (Criteria) this;
        }

        public Criteria andRoomOtherLessThan(String value) {
            addCriterion("room_other <", value, "roomOther");
            return (Criteria) this;
        }

        public Criteria andRoomOtherLessThanOrEqualTo(String value) {
            addCriterion("room_other <=", value, "roomOther");
            return (Criteria) this;
        }

        public Criteria andRoomOtherLike(String value) {
            addCriterion("room_other like", value, "roomOther");
            return (Criteria) this;
        }

        public Criteria andRoomOtherNotLike(String value) {
            addCriterion("room_other not like", value, "roomOther");
            return (Criteria) this;
        }

        public Criteria andRoomOtherIn(List<String> values) {
            addCriterion("room_other in", values, "roomOther");
            return (Criteria) this;
        }

        public Criteria andRoomOtherNotIn(List<String> values) {
            addCriterion("room_other not in", values, "roomOther");
            return (Criteria) this;
        }

        public Criteria andRoomOtherBetween(String value1, String value2) {
            addCriterion("room_other between", value1, value2, "roomOther");
            return (Criteria) this;
        }

        public Criteria andRoomOtherNotBetween(String value1, String value2) {
            addCriterion("room_other not between", value1, value2, "roomOther");
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