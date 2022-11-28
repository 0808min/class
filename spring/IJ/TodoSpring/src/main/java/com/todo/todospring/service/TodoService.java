package com.todo.todospring.service;

import com.todo.todospring.dao.TodoDao;
import com.todo.todospring.domain.TodoDTO;
import com.todo.todospring.mapper.TodoMapper;
import com.todo.todospring.util.ConnectionProvider;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

@Log4j2
@Service
public class TodoService {

    @Autowired(required = false)
    private TodoMapper todoMapper;


    public List<TodoDTO> getTodoList() {
        List<TodoDTO> list = null;
        try {
            list = todoMapper.selectAll();
            log.info(list);
        } catch (Exception e) {
            e.printStackTrace();
            // 예외 발생 시 -> 빈 List 생성
            list = Collections.emptyList();
        }
        return list;
    }

    public TodoDTO getTodo(long tno) {
        TodoDTO todoDTO = null;
        try {
            todoDTO = todoMapper.selectByTno(tno);
            log.info(todoDTO);
        } catch (Exception e) {
            e.printStackTrace();
            // 예외 발생 시 -> 빈 List 생성
            todoDTO = new TodoDTO();
        }
        return todoDTO;
    }

    public int insertTodo(TodoDTO todoDTO) {
        int result = 0;

        try {

            result = todoMapper.insertToDo(todoDTO);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public int modify(TodoDTO todoDTO) {
        int result = 0;

        try {
            result = todoMapper.updateTodo(todoDTO);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public int deleteBytno(long tno) {
        int result = 0;
        try {
            result = todoMapper.deleteTodo(tno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
