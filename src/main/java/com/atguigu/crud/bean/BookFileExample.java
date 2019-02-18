package com.atguigu.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class BookFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookFileExample() {
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

        public Criteria andFileIdIsNull() {
            addCriterion("file_id is null");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNotNull() {
            addCriterion("file_id is not null");
            return (Criteria) this;
        }

        public Criteria andFileIdEqualTo(Integer value) {
            addCriterion("file_id =", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotEqualTo(Integer value) {
            addCriterion("file_id <>", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThan(Integer value) {
            addCriterion("file_id >", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_id >=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThan(Integer value) {
            addCriterion("file_id <", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThanOrEqualTo(Integer value) {
            addCriterion("file_id <=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdIn(List<Integer> values) {
            addCriterion("file_id in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotIn(List<Integer> values) {
            addCriterion("file_id not in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdBetween(Integer value1, Integer value2) {
            addCriterion("file_id between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotBetween(Integer value1, Integer value2) {
            addCriterion("file_id not between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileOwnerIdIsNull() {
            addCriterion("file_owner_id is null");
            return (Criteria) this;
        }

        public Criteria andFileOwnerIdIsNotNull() {
            addCriterion("file_owner_id is not null");
            return (Criteria) this;
        }

        public Criteria andFileOwnerIdEqualTo(Integer value) {
            addCriterion("file_owner_id =", value, "fileOwnerId");
            return (Criteria) this;
        }

        public Criteria andFileOwnerIdNotEqualTo(Integer value) {
            addCriterion("file_owner_id <>", value, "fileOwnerId");
            return (Criteria) this;
        }

        public Criteria andFileOwnerIdGreaterThan(Integer value) {
            addCriterion("file_owner_id >", value, "fileOwnerId");
            return (Criteria) this;
        }

        public Criteria andFileOwnerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_owner_id >=", value, "fileOwnerId");
            return (Criteria) this;
        }

        public Criteria andFileOwnerIdLessThan(Integer value) {
            addCriterion("file_owner_id <", value, "fileOwnerId");
            return (Criteria) this;
        }

        public Criteria andFileOwnerIdLessThanOrEqualTo(Integer value) {
            addCriterion("file_owner_id <=", value, "fileOwnerId");
            return (Criteria) this;
        }

        public Criteria andFileOwnerIdIn(List<Integer> values) {
            addCriterion("file_owner_id in", values, "fileOwnerId");
            return (Criteria) this;
        }

        public Criteria andFileOwnerIdNotIn(List<Integer> values) {
            addCriterion("file_owner_id not in", values, "fileOwnerId");
            return (Criteria) this;
        }

        public Criteria andFileOwnerIdBetween(Integer value1, Integer value2) {
            addCriterion("file_owner_id between", value1, value2, "fileOwnerId");
            return (Criteria) this;
        }

        public Criteria andFileOwnerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("file_owner_id not between", value1, value2, "fileOwnerId");
            return (Criteria) this;
        }

        public Criteria andFileBookIdIsNull() {
            addCriterion("file_book_id is null");
            return (Criteria) this;
        }

        public Criteria andFileBookIdIsNotNull() {
            addCriterion("file_book_id is not null");
            return (Criteria) this;
        }

        public Criteria andFileBookIdEqualTo(Integer value) {
            addCriterion("file_book_id =", value, "fileBookId");
            return (Criteria) this;
        }

        public Criteria andFileBookIdNotEqualTo(Integer value) {
            addCriterion("file_book_id <>", value, "fileBookId");
            return (Criteria) this;
        }

        public Criteria andFileBookIdGreaterThan(Integer value) {
            addCriterion("file_book_id >", value, "fileBookId");
            return (Criteria) this;
        }

        public Criteria andFileBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_book_id >=", value, "fileBookId");
            return (Criteria) this;
        }

        public Criteria andFileBookIdLessThan(Integer value) {
            addCriterion("file_book_id <", value, "fileBookId");
            return (Criteria) this;
        }

        public Criteria andFileBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("file_book_id <=", value, "fileBookId");
            return (Criteria) this;
        }

        public Criteria andFileBookIdIn(List<Integer> values) {
            addCriterion("file_book_id in", values, "fileBookId");
            return (Criteria) this;
        }

        public Criteria andFileBookIdNotIn(List<Integer> values) {
            addCriterion("file_book_id not in", values, "fileBookId");
            return (Criteria) this;
        }

        public Criteria andFileBookIdBetween(Integer value1, Integer value2) {
            addCriterion("file_book_id between", value1, value2, "fileBookId");
            return (Criteria) this;
        }

        public Criteria andFileBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("file_book_id not between", value1, value2, "fileBookId");
            return (Criteria) this;
        }

        public Criteria andFileTitleIsNull() {
            addCriterion("file_title is null");
            return (Criteria) this;
        }

        public Criteria andFileTitleIsNotNull() {
            addCriterion("file_title is not null");
            return (Criteria) this;
        }

        public Criteria andFileTitleEqualTo(String value) {
            addCriterion("file_title =", value, "fileTitle");
            return (Criteria) this;
        }

        public Criteria andFileTitleNotEqualTo(String value) {
            addCriterion("file_title <>", value, "fileTitle");
            return (Criteria) this;
        }

        public Criteria andFileTitleGreaterThan(String value) {
            addCriterion("file_title >", value, "fileTitle");
            return (Criteria) this;
        }

        public Criteria andFileTitleGreaterThanOrEqualTo(String value) {
            addCriterion("file_title >=", value, "fileTitle");
            return (Criteria) this;
        }

        public Criteria andFileTitleLessThan(String value) {
            addCriterion("file_title <", value, "fileTitle");
            return (Criteria) this;
        }

        public Criteria andFileTitleLessThanOrEqualTo(String value) {
            addCriterion("file_title <=", value, "fileTitle");
            return (Criteria) this;
        }

        public Criteria andFileTitleLike(String value) {
            addCriterion("file_title like", value, "fileTitle");
            return (Criteria) this;
        }

        public Criteria andFileTitleNotLike(String value) {
            addCriterion("file_title not like", value, "fileTitle");
            return (Criteria) this;
        }

        public Criteria andFileTitleIn(List<String> values) {
            addCriterion("file_title in", values, "fileTitle");
            return (Criteria) this;
        }

        public Criteria andFileTitleNotIn(List<String> values) {
            addCriterion("file_title not in", values, "fileTitle");
            return (Criteria) this;
        }

        public Criteria andFileTitleBetween(String value1, String value2) {
            addCriterion("file_title between", value1, value2, "fileTitle");
            return (Criteria) this;
        }

        public Criteria andFileTitleNotBetween(String value1, String value2) {
            addCriterion("file_title not between", value1, value2, "fileTitle");
            return (Criteria) this;
        }

        public Criteria andFileSavaPathIsNull() {
            addCriterion("file_sava_path is null");
            return (Criteria) this;
        }

        public Criteria andFileSavaPathIsNotNull() {
            addCriterion("file_sava_path is not null");
            return (Criteria) this;
        }

        public Criteria andFileSavaPathEqualTo(String value) {
            addCriterion("file_sava_path =", value, "fileSavaPath");
            return (Criteria) this;
        }

        public Criteria andFileSavaPathNotEqualTo(String value) {
            addCriterion("file_sava_path <>", value, "fileSavaPath");
            return (Criteria) this;
        }

        public Criteria andFileSavaPathGreaterThan(String value) {
            addCriterion("file_sava_path >", value, "fileSavaPath");
            return (Criteria) this;
        }

        public Criteria andFileSavaPathGreaterThanOrEqualTo(String value) {
            addCriterion("file_sava_path >=", value, "fileSavaPath");
            return (Criteria) this;
        }

        public Criteria andFileSavaPathLessThan(String value) {
            addCriterion("file_sava_path <", value, "fileSavaPath");
            return (Criteria) this;
        }

        public Criteria andFileSavaPathLessThanOrEqualTo(String value) {
            addCriterion("file_sava_path <=", value, "fileSavaPath");
            return (Criteria) this;
        }

        public Criteria andFileSavaPathLike(String value) {
            addCriterion("file_sava_path like", value, "fileSavaPath");
            return (Criteria) this;
        }

        public Criteria andFileSavaPathNotLike(String value) {
            addCriterion("file_sava_path not like", value, "fileSavaPath");
            return (Criteria) this;
        }

        public Criteria andFileSavaPathIn(List<String> values) {
            addCriterion("file_sava_path in", values, "fileSavaPath");
            return (Criteria) this;
        }

        public Criteria andFileSavaPathNotIn(List<String> values) {
            addCriterion("file_sava_path not in", values, "fileSavaPath");
            return (Criteria) this;
        }

        public Criteria andFileSavaPathBetween(String value1, String value2) {
            addCriterion("file_sava_path between", value1, value2, "fileSavaPath");
            return (Criteria) this;
        }

        public Criteria andFileSavaPathNotBetween(String value1, String value2) {
            addCriterion("file_sava_path not between", value1, value2, "fileSavaPath");
            return (Criteria) this;
        }

        public Criteria andFileOtherIsNull() {
            addCriterion("file_other is null");
            return (Criteria) this;
        }

        public Criteria andFileOtherIsNotNull() {
            addCriterion("file_other is not null");
            return (Criteria) this;
        }

        public Criteria andFileOtherEqualTo(String value) {
            addCriterion("file_other =", value, "fileOther");
            return (Criteria) this;
        }

        public Criteria andFileOtherNotEqualTo(String value) {
            addCriterion("file_other <>", value, "fileOther");
            return (Criteria) this;
        }

        public Criteria andFileOtherGreaterThan(String value) {
            addCriterion("file_other >", value, "fileOther");
            return (Criteria) this;
        }

        public Criteria andFileOtherGreaterThanOrEqualTo(String value) {
            addCriterion("file_other >=", value, "fileOther");
            return (Criteria) this;
        }

        public Criteria andFileOtherLessThan(String value) {
            addCriterion("file_other <", value, "fileOther");
            return (Criteria) this;
        }

        public Criteria andFileOtherLessThanOrEqualTo(String value) {
            addCriterion("file_other <=", value, "fileOther");
            return (Criteria) this;
        }

        public Criteria andFileOtherLike(String value) {
            addCriterion("file_other like", value, "fileOther");
            return (Criteria) this;
        }

        public Criteria andFileOtherNotLike(String value) {
            addCriterion("file_other not like", value, "fileOther");
            return (Criteria) this;
        }

        public Criteria andFileOtherIn(List<String> values) {
            addCriterion("file_other in", values, "fileOther");
            return (Criteria) this;
        }

        public Criteria andFileOtherNotIn(List<String> values) {
            addCriterion("file_other not in", values, "fileOther");
            return (Criteria) this;
        }

        public Criteria andFileOtherBetween(String value1, String value2) {
            addCriterion("file_other between", value1, value2, "fileOther");
            return (Criteria) this;
        }

        public Criteria andFileOtherNotBetween(String value1, String value2) {
            addCriterion("file_other not between", value1, value2, "fileOther");
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