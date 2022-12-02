package com.mini.librarymanager.Service;

import com.mini.librarymanager.DAO.*;
import com.mini.librarymanager.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	private NoticeDAO noticeDAO;

	@Autowired
	public NoticeService(NoticeDAO _noticeDAO) {
		this.noticeDAO = _noticeDAO;
	}

	public NoticeDTO uploadNotice(NoticeDTO _noticeDTO) { // 공지사항 업로드
		NoticeDTO noticeDTO = noticeDAO.selectByID(_noticeDTO.getNoticeID());

		if (noticeDTO == null) { // 공지가 존재하지 않음 --> 공지 업로드 진행
			noticeDAO.insertNotice(_noticeDTO);

			return _noticeDTO; // 업로드한 공지 반환
		} else {
			System.out.println("이미 존재하는 공지입니다.");

			return null;
		}
	}

	public void deleteNotice(NoticeDTO _noticeDTO) {
		NoticeDTO noticeDTO = noticeDAO.selectByID(_noticeDTO.getNoticeID());

		if (noticeDTO == null) { // 공지 존재하지 않음
			System.out.println("존재하지 않는 공지입니다.");
		} else {
			noticeDAO.deleteNotice(noticeDTO);
		}
	}
}
