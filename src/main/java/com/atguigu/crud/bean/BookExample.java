package com.atguigu.crud.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andSerialNumIsNull() {
            addCriterion("serial_num is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumIsNotNull() {
            addCriterion("serial_num is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumEqualTo(Integer value) {
            addCriterion("serial_num =", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumNotEqualTo(Integer value) {
            addCriterion("serial_num <>", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumGreaterThan(Integer value) {
            addCriterion("serial_num >", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("serial_num >=", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumLessThan(Integer value) {
            addCriterion("serial_num <", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumLessThanOrEqualTo(Integer value) {
            addCriterion("serial_num <=", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumIn(List<Integer> values) {
            addCriterion("serial_num in", values, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumNotIn(List<Integer> values) {
            addCriterion("serial_num not in", values, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumBetween(Integer value1, Integer value2) {
            addCriterion("serial_num between", value1, value2, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumNotBetween(Integer value1, Integer value2) {
            addCriterion("serial_num not between", value1, value2, "serialNum");
            return (Criteria) this;
        }

        public Criteria andPrePeopleIdIsNull() {
            addCriterion("pre_people_id is null");
            return (Criteria) this;
        }

        public Criteria andPrePeopleIdIsNotNull() {
            addCriterion("pre_people_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrePeopleIdEqualTo(Integer value) {
            addCriterion("pre_people_id =", value, "prePeopleId");
            return (Criteria) this;
        }

        public Criteria andPrePeopleIdNotEqualTo(Integer value) {
            addCriterion("pre_people_id <>", value, "prePeopleId");
            return (Criteria) this;
        }

        public Criteria andPrePeopleIdGreaterThan(Integer value) {
            addCriterion("pre_people_id >", value, "prePeopleId");
            return (Criteria) this;
        }

        public Criteria andPrePeopleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pre_people_id >=", value, "prePeopleId");
            return (Criteria) this;
        }

        public Criteria andPrePeopleIdLessThan(Integer value) {
            addCriterion("pre_people_id <", value, "prePeopleId");
            return (Criteria) this;
        }

        public Criteria andPrePeopleIdLessThanOrEqualTo(Integer value) {
            addCriterion("pre_people_id <=", value, "prePeopleId");
            return (Criteria) this;
        }

        public Criteria andPrePeopleIdIn(List<Integer> values) {
            addCriterion("pre_people_id in", values, "prePeopleId");
            return (Criteria) this;
        }

        public Criteria andPrePeopleIdNotIn(List<Integer> values) {
            addCriterion("pre_people_id not in", values, "prePeopleId");
            return (Criteria) this;
        }

        public Criteria andPrePeopleIdBetween(Integer value1, Integer value2) {
            addCriterion("pre_people_id between", value1, value2, "prePeopleId");
            return (Criteria) this;
        }

        public Criteria andPrePeopleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pre_people_id not between", value1, value2, "prePeopleId");
            return (Criteria) this;
        }

        public Criteria andPreRoomNumIsNull() {
            addCriterion("pre_room_num is null");
            return (Criteria) this;
        }

        public Criteria andPreRoomNumIsNotNull() {
            addCriterion("pre_room_num is not null");
            return (Criteria) this;
        }

        public Criteria andPreRoomNumEqualTo(String value) {
            addCriterion("pre_room_num =", value, "preRoomNum");
            return (Criteria) this;
        }

        public Criteria andPreRoomNumNotEqualTo(String value) {
            addCriterion("pre_room_num <>", value, "preRoomNum");
            return (Criteria) this;
        }

        public Criteria andPreRoomNumGreaterThan(String value) {
            addCriterion("pre_room_num >", value, "preRoomNum");
            return (Criteria) this;
        }

        public Criteria andPreRoomNumGreaterThanOrEqualTo(String value) {
            addCriterion("pre_room_num >=", value, "preRoomNum");
            return (Criteria) this;
        }

        public Criteria andPreRoomNumLessThan(String value) {
            addCriterion("pre_room_num <", value, "preRoomNum");
            return (Criteria) this;
        }

        public Criteria andPreRoomNumLessThanOrEqualTo(String value) {
            addCriterion("pre_room_num <=", value, "preRoomNum");
            return (Criteria) this;
        }

        public Criteria andPreRoomNumLike(String value) {
            addCriterion("pre_room_num like", value, "preRoomNum");
            return (Criteria) this;
        }

        public Criteria andPreRoomNumNotLike(String value) {
            addCriterion("pre_room_num not like", value, "preRoomNum");
            return (Criteria) this;
        }

        public Criteria andPreRoomNumIn(List<String> values) {
            addCriterion("pre_room_num in", values, "preRoomNum");
            return (Criteria) this;
        }

        public Criteria andPreRoomNumNotIn(List<String> values) {
            addCriterion("pre_room_num not in", values, "preRoomNum");
            return (Criteria) this;
        }

        public Criteria andPreRoomNumBetween(String value1, String value2) {
            addCriterion("pre_room_num between", value1, value2, "preRoomNum");
            return (Criteria) this;
        }

        public Criteria andPreRoomNumNotBetween(String value1, String value2) {
            addCriterion("pre_room_num not between", value1, value2, "preRoomNum");
            return (Criteria) this;
        }

        public Criteria andPreThemeIsNull() {
            addCriterion("pre_theme is null");
            return (Criteria) this;
        }

        public Criteria andPreThemeIsNotNull() {
            addCriterion("pre_theme is not null");
            return (Criteria) this;
        }

        public Criteria andPreThemeEqualTo(String value) {
            addCriterion("pre_theme =", value, "preTheme");
            return (Criteria) this;
        }

        public Criteria andPreThemeNotEqualTo(String value) {
            addCriterion("pre_theme <>", value, "preTheme");
            return (Criteria) this;
        }

        public Criteria andPreThemeGreaterThan(String value) {
            addCriterion("pre_theme >", value, "preTheme");
            return (Criteria) this;
        }

        public Criteria andPreThemeGreaterThanOrEqualTo(String value) {
            addCriterion("pre_theme >=", value, "preTheme");
            return (Criteria) this;
        }

        public Criteria andPreThemeLessThan(String value) {
            addCriterion("pre_theme <", value, "preTheme");
            return (Criteria) this;
        }

        public Criteria andPreThemeLessThanOrEqualTo(String value) {
            addCriterion("pre_theme <=", value, "preTheme");
            return (Criteria) this;
        }

        public Criteria andPreThemeLike(String value) {
            addCriterion("pre_theme like", value, "preTheme");
            return (Criteria) this;
        }

        public Criteria andPreThemeNotLike(String value) {
            addCriterion("pre_theme not like", value, "preTheme");
            return (Criteria) this;
        }

        public Criteria andPreThemeIn(List<String> values) {
            addCriterion("pre_theme in", values, "preTheme");
            return (Criteria) this;
        }

        public Criteria andPreThemeNotIn(List<String> values) {
            addCriterion("pre_theme not in", values, "preTheme");
            return (Criteria) this;
        }

        public Criteria andPreThemeBetween(String value1, String value2) {
            addCriterion("pre_theme between", value1, value2, "preTheme");
            return (Criteria) this;
        }

        public Criteria andPreThemeNotBetween(String value1, String value2) {
            addCriterion("pre_theme not between", value1, value2, "preTheme");
            return (Criteria) this;
        }

        public Criteria andPreDayIsNull() {
            addCriterion("pre_day is null");
            return (Criteria) this;
        }

        public Criteria andPreDayIsNotNull() {
            addCriterion("pre_day is not null");
            return (Criteria) this;
        }

        public Criteria andPreDayEqualTo(Date value) {
            addCriterionForJDBCDate("pre_day =", value, "preDay");
            return (Criteria) this;
        }

        public Criteria andPreDayNotEqualTo(Date value) {
            addCriterionForJDBCDate("pre_day <>", value, "preDay");
            return (Criteria) this;
        }

        public Criteria andPreDayGreaterThan(Date value) {
            addCriterionForJDBCDate("pre_day >", value, "preDay");
            return (Criteria) this;
        }

        public Criteria andPreDayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pre_day >=", value, "preDay");
            return (Criteria) this;
        }

        public Criteria andPreDayLessThan(Date value) {
            addCriterionForJDBCDate("pre_day <", value, "preDay");
            return (Criteria) this;
        }

        public Criteria andPreDayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pre_day <=", value, "preDay");
            return (Criteria) this;
        }

        public Criteria andPreDayIn(List<Date> values) {
            addCriterionForJDBCDate("pre_day in", values, "preDay");
            return (Criteria) this;
        }

        public Criteria andPreDayNotIn(List<Date> values) {
            addCriterionForJDBCDate("pre_day not in", values, "preDay");
            return (Criteria) this;
        }

        public Criteria andPreDayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pre_day between", value1, value2, "preDay");
            return (Criteria) this;
        }

        public Criteria andPreDayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pre_day not between", value1, value2, "preDay");
            return (Criteria) this;
        }

        public Criteria andPreStartTimeIsNull() {
            addCriterion("pre_start_time is null");
            return (Criteria) this;
        }

        public Criteria andPreStartTimeIsNotNull() {
            addCriterion("pre_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andPreStartTimeEqualTo(Date value) {
            addCriterionForJDBCTime("pre_start_time =", value, "preStartTime");
            return (Criteria) this;
        }

        public Criteria andPreStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("pre_start_time <>", value, "preStartTime");
            return (Criteria) this;
        }

        public Criteria andPreStartTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("pre_start_time >", value, "preStartTime");
            return (Criteria) this;
        }

        public Criteria andPreStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("pre_start_time >=", value, "preStartTime");
            return (Criteria) this;
        }

        public Criteria andPreStartTimeLessThan(Date value) {
            addCriterionForJDBCTime("pre_start_time <", value, "preStartTime");
            return (Criteria) this;
        }

        public Criteria andPreStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("pre_start_time <=", value, "preStartTime");
            return (Criteria) this;
        }

        public Criteria andPreStartTimeIn(List<Date> values) {
            addCriterionForJDBCTime("pre_start_time in", values, "preStartTime");
            return (Criteria) this;
        }

        public Criteria andPreStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("pre_start_time not in", values, "preStartTime");
            return (Criteria) this;
        }

        public Criteria andPreStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("pre_start_time between", value1, value2, "preStartTime");
            return (Criteria) this;
        }

        public Criteria andPreStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("pre_start_time not between", value1, value2, "preStartTime");
            return (Criteria) this;
        }

        public Criteria andPreEndTimeIsNull() {
            addCriterion("pre_end_time is null");
            return (Criteria) this;
        }

        public Criteria andPreEndTimeIsNotNull() {
            addCriterion("pre_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andPreEndTimeEqualTo(Date value) {
            addCriterionForJDBCTime("pre_end_time =", value, "preEndTime");
            return (Criteria) this;
        }

        public Criteria andPreEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("pre_end_time <>", value, "preEndTime");
            return (Criteria) this;
        }

        public Criteria andPreEndTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("pre_end_time >", value, "preEndTime");
            return (Criteria) this;
        }

        public Criteria andPreEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("pre_end_time >=", value, "preEndTime");
            return (Criteria) this;
        }

        public Criteria andPreEndTimeLessThan(Date value) {
            addCriterionForJDBCTime("pre_end_time <", value, "preEndTime");
            return (Criteria) this;
        }

        public Criteria andPreEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("pre_end_time <=", value, "preEndTime");
            return (Criteria) this;
        }

        public Criteria andPreEndTimeIn(List<Date> values) {
            addCriterionForJDBCTime("pre_end_time in", values, "preEndTime");
            return (Criteria) this;
        }

        public Criteria andPreEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("pre_end_time not in", values, "preEndTime");
            return (Criteria) this;
        }

        public Criteria andPreEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("pre_end_time between", value1, value2, "preEndTime");
            return (Criteria) this;
        }

        public Criteria andPreEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("pre_end_time not between", value1, value2, "preEndTime");
            return (Criteria) this;
        }

        public Criteria andPreJionIsNull() {
            addCriterion("pre_jion is null");
            return (Criteria) this;
        }

        public Criteria andPreJionIsNotNull() {
            addCriterion("pre_jion is not null");
            return (Criteria) this;
        }

        public Criteria andPreJionEqualTo(Integer value) {
            addCriterion("pre_jion =", value, "preJion");
            return (Criteria) this;
        }

        public Criteria andPreJionNotEqualTo(Integer value) {
            addCriterion("pre_jion <>", value, "preJion");
            return (Criteria) this;
        }

        public Criteria andPreJionGreaterThan(Integer value) {
            addCriterion("pre_jion >", value, "preJion");
            return (Criteria) this;
        }

        public Criteria andPreJionGreaterThanOrEqualTo(Integer value) {
            addCriterion("pre_jion >=", value, "preJion");
            return (Criteria) this;
        }

        public Criteria andPreJionLessThan(Integer value) {
            addCriterion("pre_jion <", value, "preJion");
            return (Criteria) this;
        }

        public Criteria andPreJionLessThanOrEqualTo(Integer value) {
            addCriterion("pre_jion <=", value, "preJion");
            return (Criteria) this;
        }

        public Criteria andPreJionIn(List<Integer> values) {
            addCriterion("pre_jion in", values, "preJion");
            return (Criteria) this;
        }

        public Criteria andPreJionNotIn(List<Integer> values) {
            addCriterion("pre_jion not in", values, "preJion");
            return (Criteria) this;
        }

        public Criteria andPreJionBetween(Integer value1, Integer value2) {
            addCriterion("pre_jion between", value1, value2, "preJion");
            return (Criteria) this;
        }

        public Criteria andPreJionNotBetween(Integer value1, Integer value2) {
            addCriterion("pre_jion not between", value1, value2, "preJion");
            return (Criteria) this;
        }

        public Criteria andPreMemberPathIsNull() {
            addCriterion("pre_member_path is null");
            return (Criteria) this;
        }

        public Criteria andPreMemberPathIsNotNull() {
            addCriterion("pre_member_path is not null");
            return (Criteria) this;
        }

        public Criteria andPreMemberPathEqualTo(String value) {
            addCriterion("pre_member_path =", value, "preMemberPath");
            return (Criteria) this;
        }

        public Criteria andPreMemberPathNotEqualTo(String value) {
            addCriterion("pre_member_path <>", value, "preMemberPath");
            return (Criteria) this;
        }

        public Criteria andPreMemberPathGreaterThan(String value) {
            addCriterion("pre_member_path >", value, "preMemberPath");
            return (Criteria) this;
        }

        public Criteria andPreMemberPathGreaterThanOrEqualTo(String value) {
            addCriterion("pre_member_path >=", value, "preMemberPath");
            return (Criteria) this;
        }

        public Criteria andPreMemberPathLessThan(String value) {
            addCriterion("pre_member_path <", value, "preMemberPath");
            return (Criteria) this;
        }

        public Criteria andPreMemberPathLessThanOrEqualTo(String value) {
            addCriterion("pre_member_path <=", value, "preMemberPath");
            return (Criteria) this;
        }

        public Criteria andPreMemberPathLike(String value) {
            addCriterion("pre_member_path like", value, "preMemberPath");
            return (Criteria) this;
        }

        public Criteria andPreMemberPathNotLike(String value) {
            addCriterion("pre_member_path not like", value, "preMemberPath");
            return (Criteria) this;
        }

        public Criteria andPreMemberPathIn(List<String> values) {
            addCriterion("pre_member_path in", values, "preMemberPath");
            return (Criteria) this;
        }

        public Criteria andPreMemberPathNotIn(List<String> values) {
            addCriterion("pre_member_path not in", values, "preMemberPath");
            return (Criteria) this;
        }

        public Criteria andPreMemberPathBetween(String value1, String value2) {
            addCriterion("pre_member_path between", value1, value2, "preMemberPath");
            return (Criteria) this;
        }

        public Criteria andPreMemberPathNotBetween(String value1, String value2) {
            addCriterion("pre_member_path not between", value1, value2, "preMemberPath");
            return (Criteria) this;
        }

        public Criteria andOtherIsNull() {
            addCriterion("other is null");
            return (Criteria) this;
        }

        public Criteria andOtherIsNotNull() {
            addCriterion("other is not null");
            return (Criteria) this;
        }

        public Criteria andOtherEqualTo(String value) {
            addCriterion("other =", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotEqualTo(String value) {
            addCriterion("other <>", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThan(String value) {
            addCriterion("other >", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThanOrEqualTo(String value) {
            addCriterion("other >=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThan(String value) {
            addCriterion("other <", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThanOrEqualTo(String value) {
            addCriterion("other <=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLike(String value) {
            addCriterion("other like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotLike(String value) {
            addCriterion("other not like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherIn(List<String> values) {
            addCriterion("other in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotIn(List<String> values) {
            addCriterion("other not in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherBetween(String value1, String value2) {
            addCriterion("other between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotBetween(String value1, String value2) {
            addCriterion("other not between", value1, value2, "other");
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