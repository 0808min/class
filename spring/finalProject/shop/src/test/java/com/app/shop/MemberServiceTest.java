package com.app.shop;

import com.app.shop.domain.members.MemberFormDTO;
import com.app.shop.entity.member.Member;
import com.app.shop.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@TestPropertySource(properties = {"spring.config.location=classpath:application-test.yml"})
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;


    public Member createMember() {
        MemberFormDTO memberFormDTO = MemberFormDTO
                .builder()
                .email("test@gmail.com")
                .name("테스트")
                .address("강동구")
                .password("1234")
                .build();
        return Member.createMember(memberFormDTO,passwordEncoder);
    }

    @Test
    @DisplayName("회원가입")
    public void saveMemberTest() {
        Member member = createMember();
        Member saveMember = memberService.saveMember(member);
        assertEquals(member.getEmail(), saveMember.getEmail());
    }

}
