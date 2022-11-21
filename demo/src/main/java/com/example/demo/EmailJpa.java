package com.example.demo;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailJpa {
	
	@Autowired
	private Repo repo;
	
	@Autowired
	EmailSenderService emailsenderservice; 
	
	public static boolean isValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
	
	public void sendEmailsByJpa() {
		List<Emailid> listEmp=repo.findAll();
		System.out.println(listEmp);
		
		
		for(Emailid e:listEmp) {
			if(isValid(e.getEmaillink())){
				emailsenderservice.sendSimpleEmail(e.getEmaillink(), "via jpa", "Name"+" "+e.getName()+" "+"id"+" "+e.getId());
				System.out.println("mail send in "+"ID"+" "+e.getId()+" "+"Name"+" "+e.getName()+" "+"EmailLink"+" "+e.getEmaillink());
			}	
			else {
				System.out.println();
				System.out.println("Not Vaild email of "+" "+" "+e.getId()+" "+e.getName()+" "+e.getEmaillink());
			}
		}
		
	}
}
