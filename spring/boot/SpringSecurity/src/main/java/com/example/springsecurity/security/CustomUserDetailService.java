package com.example.springsecurity.security;


import com.example.springsecurity.entity.Member;
import com.example.springsecurity.entity.MemberRole;
import com.example.springsecurity.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("loadUserByUsername => " + username);

        Optional<Member> result = memberRepository.findById(username);

        if(result.isEmpty()) {
            throw new UsernameNotFoundException("Check User Email");
        }

        Member member = result.get();
        log.info(">>>>>>>> member => " + member);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for(MemberRole memberRole : member.getRoleSet()) {
            // ROLE_ADMIN ROLE_USER
            authorities.add(new SimpleGrantedAuthority("ROLE_" + memberRole.name()));
        }

        AuthMemberDTO authMemberDTO = new AuthMemberDTO(
                member.getEmail(), member.getPassword(), authorities, member.getName()
        );


        return authMemberDTO;
    }
}
