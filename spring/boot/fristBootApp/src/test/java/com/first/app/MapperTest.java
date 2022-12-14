package com.first.app;


import com.first.app.domain.DeptDTO;
import com.first.app.mapper.DeptMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class MapperTest {

    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void deptMapperTest() {

        List<DeptDTO> list = deptMapper.selectAll();
        log.info(list);

    }

}
