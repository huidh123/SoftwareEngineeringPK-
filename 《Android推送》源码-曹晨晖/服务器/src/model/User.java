package model;

import java.sql.Timestamp;

public class User {
	private String uuid;
	private String name;
	private Timestamp createTime;
	private Timestamp lastConnTime;

	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getLastConnTime() {
		return lastConnTime;
	}
	public void setLastConnTime(Timestamp lastConnTime) {
		this.lastConnTime = lastConnTime;
	}
	public User(String uuid, String name, Timestamp createTime,
			Timestamp lastConnTime) {
		this.uuid = uuid;
		this.name = name;
		this.createTime = createTime;
		this.lastConnTime = lastConnTime;
	}


}
