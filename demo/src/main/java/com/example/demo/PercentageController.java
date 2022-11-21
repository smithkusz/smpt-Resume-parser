package com.example.demo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PercentageController {
	
	
	
	@Autowired
	public JobSeekerJpa jobSeekerJpa;
	
	@GetMapping("/Percentage")
	public Float per() {
		JobSeekerModel jb=new JobSeekerModel();
		Optional<JobSeekerModel>  jobseeker=jobSeekerJpa.findById(1002);
		Float percentage=(100/jobseeker.get().count());
		//Float totalPercentage=100f;
		System.out.println("Hello");
		System.out.println(percentage);
	
//		List<JobSeekerModel> list=jobseeker.stream().collect(Collectors.toList());
//		System.out.println(jobseeker.get().getall());
//		Set<String> keySet=jobseeker.get().getall().keySet();
//		System.out.println(keySet);
//		Iterator<Entry<String, String>> it = jobseeker.get().getall().entrySet().iterator();
//		while (it.hasNext()) {
//		    Map.Entry<String, String> e = it.next();
//		    String key = e.getKey();
//		    String value = e.getValue();
//		    if (key.isBlank()) {
//		        it.remove();
//		        System.out.println(it);
//		    }
//		}
		List<JobSeekerModel> listStream=jobseeker.stream().collect(Collectors.toList());
		System.out.println("liststream:"+listStream);
		
		List<Entry<String, String>> listNew=jobseeker.get().getall().entrySet().stream().filter(entry -> !entry.getValue().isEmpty()).toList();
		System.out.println("not null list:"+listNew);
		Float total= (listNew.stream().count()*percentage);
		System.out.println(total);
		
		
		//listStream.getCommands().stream().map(jobseeker::getName).collect(Collectors.toList()); 
		
		//System.out.println("filter:"+it.toString());
		//emailList.removeIf(String::isEmpty);
		//emailList.removeAll(invalidEmails);
//		Optional<String> optionalIsbn = jobseeker.get().getall().entrySet().stream()
//				  .filter(e -> "null".equals(e.getValue()))
//				  .map(Map.Entry::getKey).findFirst();
		//have to use stream api
//		if(jobseeker.get().getName()==null) {
//			 totalPercentage=totalPercentage-percentage;
//			System.out.println("name");
//		}
//		if(jobseeker.get().getMothername()==null) {
//			 totalPercentage=totalPercentage-percentage;
//			System.out.println("Mother name");
//			System.out.println( totalPercentage);
//		}
//		if(jobseeker.get().getMobileNumber()==null) {
//			 totalPercentage=totalPercentage-percentage;
//			System.out.println("mo no");
//		}
//		if(jobseeker.get().getFatherName()==null) {
//			 totalPercentage=totalPercentage-percentage;
//			System.out.println("Fathers name");
//			System.out.println( totalPercentage);
//		}
//		
//		if(jobseeker.get().getBirthplace()==null) {
//			 totalPercentage=totalPercentage-percentage;
//			System.out.println("Birth place");
//		}
//		if(jobseeker.get().getHightestEducation()==null) {
//			 totalPercentage=totalPercentage-percentage;
//			System.out.println("education");
//			
//		}
	return  total;
	}
}
