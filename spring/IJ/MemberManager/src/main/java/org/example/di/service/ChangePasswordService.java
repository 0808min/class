package org.example.di.service;

import org.example.di.dao.MemberDao;
import org.example.di.domain.Member;
import org.example.di.exception.IdPasswordNotMatchingException;
import org.example.di.exception.MemberNotFoundException;

public class ChangePasswordService {
	
	private MemberDao memberDao;

	public ChangePasswordService(MemberDao memberDao) {

		this.memberDao = memberDao;
	}

	public void changePassword(String email, String oldPwd, String newPwd) throws IdPasswordNotMatchingException, MemberNotFoundException {
		Member member = memberDao.selectByEmail(email);
		if (member == null)
			throw new MemberNotFoundException();

		member.changePassword(oldPwd, newPwd);

		memberDao.update(member);
	}

}
