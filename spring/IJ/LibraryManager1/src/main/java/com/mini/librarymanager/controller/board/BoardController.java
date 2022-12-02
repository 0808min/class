package com.mini.librarymanager.controller.board;

import com.mini.librarymanager.DAO.BoardDAO;
import com.mini.librarymanager.DAO.CommentDAO;
import com.mini.librarymanager.Service.BoardService;
import com.mini.librarymanager.domain.BoardDTO;
import com.mini.librarymanager.domain.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/board/*")
public class BoardController {

    @Autowired(required = false)
    private BoardService boardService;
    @Autowired(required = false)
    private BoardDAO boardDAO;
    @Autowired(required = false)
    private CommentDAO commentDAO;

    @RequestMapping("/board/detail")
    public String boardDetail(Model model, @RequestParam int boardID) {

        BoardDTO boardDTO = boardDAO.selectByFBID(boardID);
        List<CommentDTO> commentDTOList = commentDAO.selectByFBID(boardID);

        model.addAttribute("commentDTOList", commentDTOList);
        model.addAttribute("boardDTO", boardDTO);

        return "board/detail";


    }

}
