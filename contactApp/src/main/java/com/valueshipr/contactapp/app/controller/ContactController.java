package com.valueshipr.contactapp.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.valueshipr.contactapp.app.contactserviceI.ContactServiceI;
import com.valueshipr.contactapp.app.model.Contact;


@RestController
public class ContactController {
	    @Autowired
	    private ContactServiceI csi;

	    //URL : http://localhost:9191/save
	    @PostMapping("/save")
	    public Contact addContact(@RequestBody Contact contact) {
	        return csi.addContact(contact);
	    }

	    //URL : http://localhost:9191/get
	    @GetMapping("/get")
	    public List<Contact> getContacts() {
	        return csi.getContacts();
	    }
	    
	    //URL : http://localhost:9191/update/{id}
	    @PutMapping("/update/{id}")
	    public Contact updateContact(@PathVariable Long id, @RequestBody Contact contact) {
	        return csi.updateContact(id, contact);
	    }
	    
	    //URL : http://localhost:9191/delete/{id}
	    @DeleteMapping("/delete/{id}")
	    public void deleteContact(@PathVariable Long id) {
	    	csi.deleteContact(id);
	    }

	    //URL : http://localhost:9191/getbynumber/{number}
	    @GetMapping("/getbynumber/{number}")
	    public Contact getContactByNumber(@PathVariable String number) {
	        return csi.getContactByNumber(number);
	    }
	    
	    
//	    @PostMapping("/") 
//	    public void addEmergencyContacts() {
//	        List<Contact> emergencyContacts = new ArrayList<Contact>();
//	        csi.addEmergencyContacts();    
//	    }

	}
	
