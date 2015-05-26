package model;

import java.sql.Timestamp;

import javax.management.j2ee.statistics.TimeStatistic;

import org.apache.mina.core.session.IoSession;

public class Connector {
	private String uuid;
	private String name;
	private Timestamp createTime;
	private Timestamp lastConnTime;
	private boolean isOnline;
	private IoSession ioSession;
	
	
	public Connector(String uuid, String name, Timestamp createTime,
			Timestamp lastConnTime, boolean isOnline, IoSession ioSession) {
		super();
		this.uuid = uuid;
		this.name = name;
		this.createTime = createTime;
		this.lastConnTime = lastConnTime;
		this.isOnline = isOnline;
		this.ioSession = ioSession;
	}
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
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	public IoSession getIoSession() {
		return ioSession;
	}
	public void setIoSession(IoSession ioSession) {
		this.ioSession = ioSession;
	}
	
	
}
