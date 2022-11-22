package com.todo.todofinal.service;

import com.todo.todofinal.dao.TodoDaoOld;
import com.todo.todofinal.domain.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class TodoServiceOld {

    //@Autowired
    private final TodoDaoOld dao;

    public TodoServiceOld(TodoDaoOld dao) {
        this.dao = dao;
    }

    public void test(){
        log.info("TodoService.test() 메소드가 실행 되었습니다.");
        dao.selectAll();
    }

    public List<TodoDTO> getTodoList() {

        List<TodoDTO> list = null;


        return list;
    }



}
