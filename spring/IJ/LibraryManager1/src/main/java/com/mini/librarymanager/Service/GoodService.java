package com.mini.librarymanager.Service;

import com.mini.librarymanager.DAO.*;
import com.mini.librarymanager.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodService {
	private GoodDAO goodDAO;

	@Autowired
	public GoodService(GoodDAO _goodDAO) {
		this.goodDAO = _goodDAO;
	}

	public GoodDTO uploadGood(GoodDTO _goodDTO) { // 추천 도서 업로드
		GoodDTO goodDTO = goodDAO.selectByID(_goodDTO.getGoodID());

		if (goodDTO == null) { // 추천 도서 업로드 진행
			goodDAO.insertGood(_goodDTO);

			return _goodDTO; // 업로드한 도서 반환
		} else {
			System.out.println("이미 업로드된 도서입니다.");

			return null;
		}
	}

	public void deleteGood(GoodDTO _goodDTO) {
		GoodDTO goodDTO = goodDAO.selectByID(_goodDTO.getGoodID());

		if (goodDTO == null) {
			System.out.println("존재하지 않는 도서입니다.");
		} else {
			goodDAO.deleteGood(goodDTO);
		}
	}
}
