package com.app.board.security;

import com.app.board.entity.BoardMember;
import com.app.board.repository.BoardMemberRespository;
import com.app.board.repository.BoardRepository;
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

@Service
@Log4j2
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private BoardMemberRespository boardMemberRespository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info(" >>>>> loadUserByUsername => " + username);

        Optional<BoardMember> result = boardMemberRespository.findByUserid(username);

        if(result.isEmpty()){
            throw new UsernameNotFoundException("회원의 아이디 또는 비밀번호 확인");
        }

        // 회원의 정보, 권한 정보 => CustomUser 인스턴스 생성 반환
        BoardMember boardMember = result.get();

        // 권한 데이터 처리
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(
                new SimpleGrantedAuthority("ROLE_" + boardMember.getRole()));

        CustomUser user = new CustomUser(
                boardMember.getUserid(),
                boardMember.getPassword(),
                authorities,
                boardMember
        );

        return user;
    }

}
