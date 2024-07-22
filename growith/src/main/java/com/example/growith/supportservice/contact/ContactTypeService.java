package com.example.growith.supportservice.contact;


import org.springframework.stereotype.Controller;

import com.example.growith.member.Member;
import com.example.growith.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;


import java.util.List;

@RequiredArgsConstructor
@Service
public class ContactTypeService {
    private final ContactTypeRepository contactTypeRepository;
    private final ContactRepository contactRepository;

    public void createContactType(ContactType contactType) {
        contactTypeRepository.save(contactType);
    }

    public void deleteContactType(Integer id) {
        contactRepository.updateTypeIdToNull(id);
        contactTypeRepository.deleteById(id);
    }

    public void updateContactType(ContactType contactType) {
        contactTypeRepository.save(contactType);
    }

    public ContactType findById(Integer typeId) {
        ContactType contactType = contactTypeRepository.findById(typeId).orElse(null);
        return contactType;
    }

    public List<ContactType> getAllContactType() {
        return contactTypeRepository.findAll();
    }
}

