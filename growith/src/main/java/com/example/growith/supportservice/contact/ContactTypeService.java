package com.example.growith.supportservice.contact;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
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
}
