package com.atguigu.crud.bean;

public class RoomInfo {
    private Integer roomNum;

    private String roomName;

    private String roomAddress;

    private Integer roomMaxNum;

    private String roomEquipment;

    private String roomOther;

    public RoomInfo(Integer roomNum, String roomName, String roomAddress, Integer roomMaxNum, String roomEquipment,
			String roomOther) {
		super();
		this.roomNum = roomNum;
		this.roomName = roomName;
		this.roomAddress = roomAddress;
		this.roomMaxNum = roomMaxNum;
		this.roomEquipment = roomEquipment;
		this.roomOther = roomOther;
	}

	public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    public String getRoomAddress() {
        return roomAddress;
    }

    public void setRoomAddress(String roomAddress) {
        this.roomAddress = roomAddress == null ? null : roomAddress.trim();
    }

    public Integer getRoomMaxNum() {
        return roomMaxNum;
    }

    public void setRoomMaxNum(Integer roomMaxNum) {
        this.roomMaxNum = roomMaxNum;
    }

    public String getRoomEquipment() {
        return roomEquipment;
    }

    public void setRoomEquipment(String roomEquipment) {
        this.roomEquipment = roomEquipment == null ? null : roomEquipment.trim();
    }

    public String getRoomOther() {
        return roomOther;
    }

    public void setRoomOther(String roomOther) {
        this.roomOther = roomOther == null ? null : roomOther.trim();
    }
}