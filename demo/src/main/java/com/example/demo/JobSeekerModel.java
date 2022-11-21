package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class JobSeekerModel {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String mobileNumber;
	private String fatherName;
	private String mothername;
	private String birthplace;
	private String hightestEducation;
	@Override
	public String toString() {
		return "JobSeekerModel [name=" + name + ", mobileNumber=" + mobileNumber + ", fatherName=" + fatherName
				+ ", mothername=" + mothername + ", birthplace=" + birthplace + ", hightestEducation="
				+ hightestEducation + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMothername() {
		return mothername;
	}
	public void setMothername(String mothername) {
		this.mothername = mothername;
	}
	public String getBirthplace() {
		return birthplace;
	}
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	public String getHightestEducation() {
		return hightestEducation;
	}
	public void setHightestEducation(String hightestEducation) {
		this.hightestEducation = hightestEducation;
	}
	public JobSeekerModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobSeekerModel(String name, String mobileNumber, String fatherName, String mothername, String birthplace,
			String hightestEducation) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.fatherName = fatherName;
		this.mothername = mothername;
		this.birthplace = birthplace;
		this.hightestEducation = hightestEducation;
	}
	
	public Float count() {
		return (float) getall().size();
	}
	public HashMap<String,String> getall() {
		HashMap<String,String> map=new HashMap<String, String>();
		map.put("name",getName());
		map.put("birthplace",getBirthplace());
		map.put("fatherName",getFatherName());
		map.put("mobileNumber",getMobileNumber());
		map.put("hightestEducation",getHightestEducation());
		map.put("mothername",getMothername());
		return map;	
	}
	

}
