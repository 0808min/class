package org.example.di.service;

import org.example.di.dao.Dao;
import org.example.di.dao.MemberDao;
import org.example.di.domain.Member;
import org.example.di.exception.IdPasswordNotMatchingException;
import org.example.di.exception.MemberNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordService {

	@Autowired(required = true)
//	@Qualifier("member")
	private Dao dao;

//	public ChangePasswordService(MemberDao memberDao) {
//
//		this.memberDao = memberDao;
//	}

	public void changePassword(String email, String oldPwd, String newPwd) throws IdPasswordNotMatchingException, MemberNotFoundException {
		Member member = dao.selectByEmail(email);
		if (member == null)
			throw new MemberNotFoundException();

		member.changePassword(oldPwd, newPwd);

		dao.update(member);
	}

}
