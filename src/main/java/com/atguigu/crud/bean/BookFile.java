package com.atguigu.crud.bean;

public class BookFile {
    private Integer fileId;

    private Integer fileOwnerId;

    private Integer fileBookId;

    private String fileTitle;

    private String fileSavaPath;

    private String fileOther;

    private String fileOwnerName;
    public String getFileOwnerName() {
		return fileOwnerName;
	}

	public void setFileOwnerName(String fileOwnerName) {
		this.fileOwnerName = fileOwnerName;
	}

	public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Integer getFileOwnerId() {
        return fileOwnerId;
    }

    public void setFileOwnerId(Integer fileOwnerId) {
        this.fileOwnerId = fileOwnerId;
    }

    public Integer getFileBookId() {
        return fileBookId;
    }

    public void setFileBookId(Integer fileBookId) {
        this.fileBookId = fileBookId;
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle == null ? null : fileTitle.trim();
    }

    public String getFileSavaPath() {
        return fileSavaPath;
    }

    public void setFileSavaPath(String fileSavaPath) {
        this.fileSavaPath = fileSavaPath == null ? null : fileSavaPath.trim();
    }

    public String getFileOther() {
        return fileOther;
    }

    public void setFileOther(String fileOther) {
        this.fileOther = fileOther == null ? null : fileOther.trim();
    }
}