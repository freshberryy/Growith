package com.example.growith.member;

import lombok.Getter;

@Getter
public enum MemberRole {
    ADMIN("ROLE_ADMIN");

    MemberRole(String value) {
        this.value = value;
    }

    private String value;
}
