package com.example.growith.member;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    @Lazy
    private final PasswordEncoder passwordEncoder;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Member member = memberRepository.findByEmail(username).orElse(null);
//        if (member != null) {
//            List<GrantedAuthority> authorities = new ArrayList<>();
//            if ("ROLE_ADMIN".equals(member.getRole())) {
//                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//            }
//            return new User(member.getEmail(), member.getPassword(), authorities);
//        } else {
//            throw new UsernameNotFoundException("유저를 찾을 수 없습니다: " + username);
//        }
//
//    }

//    public void create(Member member) {
//        member.setRole("ROLE_USER");
////        member.setDate(LocalDateTime.now());
//        member.setPassword(passwordEncoder.encode(member.getPassword()));
//        memberRepository.save(member);
//    }

    public void create(String username, String password) {
        Member member = new Member();
        member.setEmail(username);
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        member.setRole("ROLE_ADMIN");
        memberRepository.save(member);
    }

//    public Member findByEmail(String email) {
//        Member member = memberRepository.findByEmail(email).orElse(null);
//        return member;
//    }

    public Member authen() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<Member> author = memberRepository.findByEmail(userDetails.getUsername());
        return author.get();
    }
}
