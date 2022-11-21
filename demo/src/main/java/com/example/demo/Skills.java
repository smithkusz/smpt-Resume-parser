package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Skills {

	@Override
	public String toString() {
		return "Skills " + sa + "]";
	}

	private List<String> sa = Arrays.asList("machine learning", "c", "java", "aws", "mysql", "h2", "oracle", "ruby",
			"html", "css", "ajax", "data science", "python", "word", "excel", "C#", "C++", "HTML", "JavaScript", "XML",
			"C", "Perl", "Python", "PHP", "Objective-C", "AJAX", "ASP.NET", "Python", "Oracle","Database", "Programming",
			"C", "Jsp", "Css", "Html", "Java","C++", "Mysql", "Ui");

	public List<String> getSa() {
		return sa;
	}

	public void setSa(List<String> sa) {
		this.sa = sa;
	}

	public Skills() {
		super();
	}

}
