package life.course.pk1.DAO;

import life.course.pk1.Mappers.EstablishmentMapper;
import life.course.pk1.Mappers.StudentMapper;
import life.course.pk1.Models.Establishment;
import life.course.pk1.Models.Student;
import life.course.pk1.Utill.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EstablishmentDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EstablishmentDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public EstablishmentDAO(){
        jdbcTemplate = null;
    }

    /*public int addStudent(Student student){
        return jdbcTemplate.update("INSERT INTO students(email, fio, faculty, department, groupe, password) VALUES(?, ?, ?, ?, ?, ?)",
                student.getEmail(), student.getFio(), student.getFaculty(), student.getDepartment(), student.getGroupe(), student.getPassword());
    }*/
    public Establishment getEstablishment(int id){
        return jdbcTemplate.query("SELECT * FROM establishments WHERE id = ?",  new Object[]{id}, new EstablishmentMapper())
                .stream().findAny().orElseThrow(StudentNotFoundException::new);
    }
}
