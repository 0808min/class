package com.app.board;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.app.board.mapper")
public class SpringBootBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBoardApplication.class, args);
	}

}
