package com.example.growith.admin;

import com.example.growith.supportservice.contact.ContactType;
import com.example.growith.supportservice.contact.ContactTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


@RequiredArgsConstructor
@Service
public class AdminService {
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

    public ContactType findById(Integer id) {
        ContactType contactType = contactTypeRepository.findById(id).get();
        return contactType;
    }
}
