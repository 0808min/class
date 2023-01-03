package com.app.mall.repository.member;

import com.app.mall.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Integer> {


}
