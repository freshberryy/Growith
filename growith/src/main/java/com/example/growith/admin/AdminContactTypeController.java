package com.example.growith.admin;

import com.example.growith.supportservice.contact.ContactType;
import com.example.growith.supportservice.contact.ContactTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//현재 미사용
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/admin/contactType")
@RequiredArgsConstructor
@Controller
public class AdminContactTypeController {
    private final ContactTypeService contactTypeService;

    @GetMapping("/manager")
    public String readList(Model model) {
        model.addAttribute("contactTypes", contactTypeService.getAllContactType());
        return "admin_contactType";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("contactType", new ContactType());
        return "admin_contactType_create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute ContactType contactType) {
        contactTypeService.createContactType(contactType);
        return "redirect:/admin/contactType/manager";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        contactTypeService.deleteContactType(id);
        return "redirect:/admin/contactType/manager";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") Integer id) {
        ContactType contactType = contactTypeService.findById(id);
        model.addAttribute("contactType", contactType);
        return "admin_contactType_create";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute ContactType contactType) {
        contactTypeService.updateContactType(contactType);
        return "redirect:/admin/contactType/manager";
    }
}
