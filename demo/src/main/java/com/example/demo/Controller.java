package com.example.demo;



import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class Controller {
	
	@Autowired
	private Skills skills;
	
	@Autowired
	private RepoSkills repoSkills;
	
	@Autowired
	private EmailSenderService senderService;

	@Autowired
	CheckingMails ch;

	@Autowired
	EmailJpa emailjpa;

	@GetMapping("/hello")
	public String home() {
		return "home";
	}

	@PostMapping("/mail/{email}")
	public String emailSender(@PathVariable String email) {
		senderService.sendSimpleEmailWithAttachment(email, "body", "subject");
		return "mail send";
	}

	@PostMapping("/Emails")
	public String saveEmails(@RequestBody List<Emailid> emails) {
		senderService.saveEmails(emails);
		return "Data has been saved";

	}

	@PostMapping("/EmailsByJpa")
	public String JpaEmailsBySmtp() {
		emailjpa.sendEmailsByJpa();
		return "Mail send from database";
	}

	@GetMapping("/allmails")
	public String getAllMails() {
		String host = "pop.gmail.com";// change accordingly
		String mailStoreType = "pop3";
		String username = "mujawarnm2@gmail.com";// change accordingly
		String password ="ebvenqpfibfpiwhe";// "snjruggpjdiffrct";// change accordingly
		ch.check(host, mailStoreType, username, password);
		return "mails are in the console";

	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/parser")
	public List  parser() {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl
		  = "http://localhost:5000";
		LinkedHashMap map=new LinkedHashMap<>();
		map
		  = (LinkedHashMap) restTemplate.getForEntity(fooResourceUrl, Object.class).getBody();
		
//		Set s = map.entrySet();
//		System.out.println(map.get("skills"));
//		Iterator it=s.iterator();
//		while(it.hasNext())   {                   
//		     System.out.println(it.next());
//		}
		@SuppressWarnings("unchecked")
		List<String> sa=(List) map.get("skills");
//		System.out.println(skills.getSa().get(0));
//		Iterator itx=skills.getSa().iterator();
//		
//		while(itx.hasNext())   {                   
//		     System.out.println(itx.next());
//		}
		Stream<String> stream1=sa.stream();
		Stream<String> stream11=stream1.filter(skills.getSa()::contains);
		List<String> commonList=stream11.collect(Collectors.toList());
		System.out.println(commonList);
		
		List<String> mape=repoSkills.findAllSkills();
		Stream<String> stream1222=sa.stream();
		Stream<String> stream11222=stream1222.filter(mape::contains);
		List<String> commonListnew=stream11222.collect(Collectors.toList());
		System.out.println(commonListnew);
		
		return commonListnew;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/parserwithfile")
	public Object parserwithfile(@RequestParam MultipartFile resume) {
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		ByteArrayResource fileAsResource = null;
		try {
			fileAsResource = new ByteArrayResource(resume.getBytes()){
			    @Override
			    public String getFilename(){
			        return resume.getOriginalFilename();
			    }
			};
		} catch (IOException e) {
			e.printStackTrace();
		}
		body.add("file",fileAsResource);

	     HttpHeaders headers = new HttpHeaders();
	     headers.setContentType(MediaType.MULTIPART_FORM_DATA);
	     

	     HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

	     LinkedHashMap map=new LinkedHashMap<>();
			map = (LinkedHashMap) restTemplate.postForEntity("http://localhost:5000/file-upload", requestEntity, Object.class).getBody();
	        
//			Set s = map.entrySet();
//			System.out.println(map.get("skills"));
//			Iterator it=s.iterator();
//			while(it.hasNext())   {                   
//			     System.out.println(it.next());
//			}
			List<String> sa=(List) map.get("skills");
			Stream<String> stream1=sa.stream();
			Stream<String> stream11=stream1.filter(skills.getSa()::contains);
			List<String> commonList=stream11.collect(Collectors.toList());
			System.out.println(commonList);
			
			
			
			return commonList;
	    
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/parserwithfileOwnParser")
	public Object parserwithfileOwnParser(@RequestParam MultipartFile resume) {
		RestTemplate restTemplate = new RestTemplate();
		
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

		ByteArrayResource fileAsResource = null;
		try {
			fileAsResource = new ByteArrayResource(resume.getBytes()){
			    @Override
			    public String getFilename(){
			        return resume.getOriginalFilename();
			    }
			};
		} catch (IOException e) {
			e.printStackTrace();
		}
		body.add("file",fileAsResource);

	     HttpHeaders headers = new HttpHeaders();
	     headers.setContentType(MediaType.MULTIPART_FORM_DATA);
	     

	     HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

	     LinkedHashMap map=new LinkedHashMap<>();
			map = (LinkedHashMap) restTemplate.postForEntity("http://localhost:5000/file-upload", requestEntity, Object.class).getBody();
	        Set s = map.entrySet();
			System.out.println(map.get("skills"));
			Iterator it=s.iterator();
			while(it.hasNext())   {                   
			     System.out.println(it.next());
			}
			List<String> sa=(List) map.get("skills");
			
			System.out.println(sa);
			return sa;
	    
	}

}
