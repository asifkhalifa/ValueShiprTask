package com.valueshipr.contactapp.app.serviceImpl;

import java.util.Arrays;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valueshipr.contactapp.app.contactserviceI.ContactServiceI;
import com.valueshipr.contactapp.app.model.Contact;

import com.valueshipr.contactapp.app.repository.ContactRepository;


@Service
public class ContactService implements ContactServiceI{
    @Autowired
    private ContactRepository contactRepository;

    public Contact addContact(Contact contact) {
    	
        // Check if the company name is in the correct format
        if (!contact.getCompanyName().matches("Valueshipr[0-9]+")) {
            throw new RuntimeException("Invalid company name format");
        }
        
        // Check if the phone number is unique
        if (contactRepository.findByNumber(contact.getNumber()) != null) {
            throw new RuntimeException("Phone number already exists");
        }
        return contactRepository.save(contact);
    }

    //Return list of contact
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    // add emergency contact
    public void addEmergencyContacts() {
        // Add emergency contacts
        Contact contact1 = new Contact();
        contact1.setName("Citizens Call Centre");
        contact1.setNumber("155300");        
        contactRepository.save(contact1);

        Contact contact2 = new Contact();
        contact2.setName("Child Helpline");
        contact2.setNumber("1098");
        contactRepository.save(contact2);

        Contact contact3 = new Contact();
        contact3.setName("Women Helpline");
        contact3.setNumber("1091");
        contactRepository.save(contact3);

        Contact contact4 = new Contact();
        contact4.setName("Crime Stopper");
        contact4.setNumber("1090");
        contactRepository.save(contact4);

        Contact contact5 = new Contact();
        contact5.setName("Rescue and Relief");
        contact5.setNumber("1070");
        contactRepository.save(contact5);

        Contact contact6 = new Contact();
        contact6.setName("Ambulance");
        contact6.setNumber("102");
        contact6.setAlternativeNumbers(Arrays.asList("108"));
        contactRepository.save(contact6);

        Contact contact7 = new Contact();
        contact7.setName("Police Helpline");
        contact7.setNumber("100");
        contactRepository.save(contact7);

        Contact contact8 = new Contact();
        contact8.setName("Railway Helpline");
        contact8.setNumber("23004000");
        contactRepository.save(contact8);
    }

     // Update the fields of the existing contact with the new fields
    public Contact updateContact(Long id, Contact contact) {
        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contact ID"));

        
        existingContact.setName(contact.getName());
        existingContact.setAddress(contact.getAddress());
        existingContact.setPic(contact.getPic());
        existingContact.setCompanyName(contact.getCompanyName());
        existingContact.setNumber(contact.getNumber());
        existingContact.setAlternativeNumbers(contact.getAlternativeNumbers());

        return contactRepository.save(existingContact);
    }
    
    //delete the contact using number
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
    
    //find the contact using number
    public Contact getContactByNumber(String number) {
        return contactRepository.findByNumber(number);
    }
}
	

