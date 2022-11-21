package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepoSkills extends JpaRepository<List_of_skills, Integer>{
	
	@Query(value = "SELECT skillscol FROM email.list_of_skills", nativeQuery = true)
    List<String> findAllSkills();

}
