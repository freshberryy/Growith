package com.example.growith.admin;

import com.example.growith.supportservice.contact.ContactType;
import com.example.growith.supportservice.contact.ContactTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/admin/ContactType")
@RequiredArgsConstructor
@Controller
public class AdminContactTypeController {
    private final ContactTypeService contactTypeService;

    @GetMapping("/readList")
    public String readList(Model model) {
        model.addAttribute(contactTypeService.getAllContactType());
        return "admin/contactType/list";
    }

    @GetMapping("/create")
    public String create(@ModelAttribute ContactType contactType) {
        contactTypeService.createContactType(contactType);
        return "admin/contactType/create";
    }

    @GetMapping("/delete")
    public String delete(@ModelAttribute ContactType contactType) {
        contactTypeService.deleteContactType(contactType);
        return "admin/contactType/delete";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") Integer id) {
        ContactType contactType = contactTypeService.findById(id);
        model.addAttribute("contactType", contactType);
        return "admin/contactType/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id) {
        ContactType contactType = contactTypeService.findById(id);
//        model.addAttribute("contactType", contactType);
        contactTypeService.updateContactType(contactType);
        return "admin/contactType/update";
    }
}
