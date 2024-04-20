package life.course.pk1.DAO;

import life.course.pk1.Mappers.DepartmentMapper;
import life.course.pk1.Mappers.EstablishmentMapper;
import life.course.pk1.Models.Department;
import life.course.pk1.Models.Establishment;
import life.course.pk1.Utill.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DepartmentDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DepartmentDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public DepartmentDAO(){
        jdbcTemplate = null;
    }

    /*public int addStudent(Student student){
        return jdbcTemplate.update("INSERT INTO students(email, fio, faculty, department, groupe, password) VALUES(?, ?, ?, ?, ?, ?)",
                student.getEmail(), student.getFio(), student.getFaculty(), student.getDepartment(), student.getGroupe(), student.getPassword());
    }*/
    public Department getDepartment(int id){
        return jdbcTemplate.query("SELECT * FROM departments WHERE id = ?",  new Object[]{id}, new DepartmentMapper())
                .stream().findAny().orElseThrow(StudentNotFoundException::new);
    }
}
