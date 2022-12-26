package com.mini.librarymanager.Service;

import com.mini.librarymanager.DAO.*;

import com.mini.librarymanager.domain.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	private BookDAO bookDAO;

	@Autowired
	public BookService(BookDAO _bookDAO) {
		this.bookDAO = _bookDAO;
	}

	public BookDTO addBook(BookDTO _bookDTO) { // 도서 추가
		BookDTO bookDTO = bookDAO.selectByISBN(_bookDTO.getBookISBN());

		if (bookDTO == null) { // 도서 존재하지 않음 --> 추가 진행
			bookDAO.insertBook(_bookDTO);

			return _bookDTO; // 추가한 도서 반환
		} else {
			System.out.println("이미 존재하는 도서입니다.");

			return null;
		}
	}

	public void deleteBook(BookDTO _bookDTO) { // 도서 삭제
		BookDTO bookDTO = bookDAO.selectByISBN(_bookDTO.getBookISBN());

		if (bookDTO == null) {
			System.out.println("존재하지 않는 도서입니다.");
		} else {
			bookDAO.deleteBook(bookDTO);
		}
	}

	public BookDTO updateBook(BookDTO _bookDTO) { // 도서 수정
		BookDTO bookDTO = bookDAO.selectByISBN(_bookDTO.getBookISBN());

		if (bookDTO == null) { // 도서 존재하지 않음
			System.out.println("수정할 도서가 없습니다.");

			return null;
		} else { // 도서가 존재함
			bookDAO.updateBook(_bookDTO);

			return _bookDTO;
		}
	}
}
