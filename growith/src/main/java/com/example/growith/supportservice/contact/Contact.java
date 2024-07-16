package com.example.growith.supportservice.contact;

import com.example.growith.supportservice.PhoneNumber;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private ContactType type;

    @NotEmpty(message = "이름을 입력해주세요.")
    private String name;

    @Email
    @NotEmpty(message = "이메일을 입력해주세요.")
    private String email;

    @PhoneNumber
    @NotEmpty(message = "전화번호를 입력해주세요.")
    private String phone;

    private String content;
    private LocalDateTime date;
}
