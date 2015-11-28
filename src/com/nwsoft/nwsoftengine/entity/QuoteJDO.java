package com.nwsoft.nwsoftengine.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.nwsoft.nwsoftengine.MyEncDec;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class QuoteJDO {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	Long id;
	
	String author;
	
	String message;
	String testPass;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String gettestPass() {
		return testPass;
	}

	public void settestPass(String testPass) {
		MyEncDec med = new MyEncDec();
		this.testPass = med.encMD5(testPass);;
	}
}
