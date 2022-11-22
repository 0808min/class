package org.example.di.service;

import java.util.Date;

import org.example.di.dao.Dao;
import org.example.di.domain.Member;
import org.example.di.domain.RegisterRequest;
import org.example.di.exception.AlreadyExistingMemberException;
import org.springframework.stereotype.Service;


@Service
public class MemberRegisterService {

	private final Dao dao;

	public MemberRegisterService(Dao dao) {
		this.dao = dao;
	}

	public void regist(RegisterRequest req) throws AlreadyExistingMemberException {
		
		Member member = dao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new AlreadyExistingMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		dao.insert(newMember);
	}

}
