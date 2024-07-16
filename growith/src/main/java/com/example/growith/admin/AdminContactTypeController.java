package com.example.growith.admin;

import com.example.growith.supportservice.contact.ContactType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/admin/ContactType")
@RequiredArgsConstructor
@Controller
public class AdminContactTypeController {
    private final AdminService adminService;

    @GetMapping("/create")
    public String create(@ModelAttribute ContactType contactType) {
        adminService.createContactType(contactType);
        return "admin/ContactType/create";
    }

    @GetMapping("/delete")
    public String delete(@ModelAttribute ContactType contactType) {
        adminService.deleteContactType(contactType);
        return "admin/ContactType/delete";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") Integer id) {
        ContactType contactType = adminService.findById(id);
        model.addAttribute("contactType", contactType);
        return "admin/ContactType/update";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id) {
        ContactType contactType = adminService.findById(id);
//        model.addAttribute("contactType", contactType);
        adminService.updateContactType(contactType);
        return "admin/ContactType/update";
    }
}
