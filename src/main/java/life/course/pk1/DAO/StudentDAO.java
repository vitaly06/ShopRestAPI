package life.course.pk1.DAO;

import life.course.pk1.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class StudentDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public StudentDAO(){
        jdbcTemplate = null;
    }

    public int addStudent(Student student){
        return jdbcTemplate.update("INSERT INTO test(name, password) VALUES(?, ?)",
                student.getName(), student.getPassword());
    }
}
