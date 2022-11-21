package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Limits;

@RestController
public class Controller {
	
	@GetMapping("/limit")
	public Limits retriveAllLimits() {
		return new Limits(0,1000);
	}
}
