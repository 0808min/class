import com.app.manager.domain.DeptDTO;
import com.app.manager.domain.DeptSearchOption;
import com.app.manager.mapper.DeptMapper;
import com.app.manager.mapper.TimeMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ConnectionTest {


    @Autowired
    private DataSource dataSource;

    @Autowired(required = false)
    private TimeMapper timeMapper;

    @Autowired(required = false)
    private DeptMapper deptMapper;


    @Test
    public void deptSelectByDeptnosTest() {
        List<Integer> list = new ArrayList<>();
//        list.add(10);
//        list.add(30);
        log.info(">>>>>> IN 연산 테스트" + deptMapper.selectByDeptnos(list));
    }

    @Test
    public void deptSelectByOptionTest() {
        log.info(deptMapper.selectByOption(DeptSearchOption.builder().
                searchType(null).keyword(null).build()));
    }

    @Test
    public void getDeptListTest() {
        log.info("LIST >>>>>>>>>>>>>> " + deptMapper.selectAll());
//        log.info("DEPT 정보 >>>>>>>>>>>>>> " + deptMapper.selectByDeptno(10));
        DeptDTO deptDTO = new DeptDTO(50, "DEV", "SEOUL");
//        log.info("DEPT 입력 >>>>>>>>>>>>>> " + deptMapper.insertDept(deptDTO));
//        log.info("DEPT 수정 >>>>>>>>>>>>>> " + deptMapper.updateDept(deptDTO));
//        log.info("DEPT 삭제 >>>>>>>>>>>>>> " + deptMapper.deleteByDeptno(50));

    }


    @Test
    public void getTimeTest() {
        log.info(timeMapper.getTime());

    }

    @Test
    public void connectionTest() throws SQLException {
        Connection connection = dataSource.getConnection();

        log.info(connection);

        Assertions.assertNotNull(connection);

        connection.close();
    }



}
