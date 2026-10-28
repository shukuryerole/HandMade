package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Contact;
import com.example.demo.repos.ContactRepository;


@RestController
@CrossOrigin("*")
public class ContactController {

    @Autowired
    private ContactRepository repo;

    // ✅ SAVE MESSAGE
    @PostMapping("/contact")
    public Contact saveContact(@RequestBody Contact contact) {
        return repo.save(contact);
    }

    // ✅ GET ALL MESSAGES (ADMIN)
    @GetMapping("/admin/messages")
    public List<Contact> getAllMessages() {
        return repo.findAll();
    }
    
    
 // ✅ DELETE MESSAGE
    @DeleteMapping("/admin/messages/{id}")
    public String deleteMessage(@PathVariable Integer id) {
        repo.deleteById(id);
        return "Deleted Successfully";
    }
}