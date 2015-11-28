package com.nwsoft.nwsoftengine.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.nwsoft.nwsoftengine.MyEncDec;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class NwUser {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	Long id;
	
	String userEmail;
	String userPass;
	String userApps;
	
	String userNick;
	String userEtc;
	String regDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		userPass=MyEncDec.encMD5(userPass);
		this.userPass = userPass;
	}
	public String getUserApps() {
		return userApps;
	}
	public void setUserApps(String userApps) {
		this.userApps = userApps;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getUserEtc() {
		return userEtc;
	}
	public void setUserEtc(String userEtc) {
		this.userEtc = userEtc;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}
