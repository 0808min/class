package com.app.shop;

import com.app.shop.entity.member.Member;
import com.app.shop.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

@SpringBootTest
@Transactional
@TestPropertySource(properties = {"spring.config.location=classpath:application-test.yml"})
public class MemberTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager manager;


    @Test
    @DisplayName("Auditing 테스트")
    @WithMockUser(username = "mockUser", roles = "USER")
    public void auditingTest() {
        Member newMember = new Member();
        memberRepository.save(newMember);

        manager.flush();
        manager.clear();

        Member member = memberRepository.findById(newMember.getId())
                .orElseThrow(EntityNotFoundException::new);

    }

}
