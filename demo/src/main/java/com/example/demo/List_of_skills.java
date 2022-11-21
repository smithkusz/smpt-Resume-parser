package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class List_of_skills {
	@Id
	@GeneratedValue
	private Integer	idskills;
	private String skillscol;
	public List_of_skills() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List_of_skills(Integer idskills, String skillscol) {
		super();
		this.idskills = idskills;
		this.skillscol = skillscol;
	}
	@Override
	public String toString() {
		return "List_of_skills [idskills=" + idskills + ", skillscol=" + skillscol + "]";
	}
	public Integer getIdskills() {
		return idskills;
	}
	public void setIdskills(Integer idskills) {
		this.idskills = idskills;
	}
	public String getSkillscol() {
		return skillscol;
	}
	public void setSkillscol(String skillscol) {
		this.skillscol = skillscol;
	}


}
