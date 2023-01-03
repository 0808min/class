package com.app.mall.repository.member;

import com.app.mall.entity.member.Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Query("select u from Member u where u.uid = ?1 and u.password= ?2")
    Optional<Member>
    findByUid(String uid, String password);

    @Query("select u from Member u where u.uid = :uid")
    Optional<Member>
    findByMemberID(@Param("uid") String uid);

}
