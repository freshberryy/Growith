package com.example.growith.supportservice.contact;

<<<<<<<< Updated upstream:growith/src/main/java/com/example/growith/supportservice/contact/ContactTypeService.java
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
========
import com.example.growith.member.Member;
import com.example.growith.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;
>>>>>>>> Stashed changes:growith/src/main/java/com/example/growith/admin/AdminService.java

import java.util.List;

@RequiredArgsConstructor
<<<<<<<< Updated upstream:growith/src/main/java/com/example/growith/supportservice/contact/ContactTypeService.java
@Controller
public class ContactTypeService {
    private final ContactTypeRepository contactTypeRepository;

    public void createContactType(ContactType contactType) {
        contactTypeRepository.save(contactType);
    }

    public void deleteContactType(ContactType contactType) {
        contactTypeRepository.delete(contactType);
    }

    public void updateContactType(ContactType contactType) {
        contactTypeRepository.save(contactType);
    }

    public ContactType findById(Integer typeId) {
        ContactType contactType = contactTypeRepository.findById(typeId).orElseThrow(() -> new IllegalArgumentException("Invalid contact type Id: " + typeId));
        return contactType;
    }

    public List<ContactType> getAllContactType() { return contactTypeRepository.findAll(); }
========
@Service
public class AdminService {

>>>>>>>> Stashed changes:growith/src/main/java/com/example/growith/admin/AdminService.java
}

