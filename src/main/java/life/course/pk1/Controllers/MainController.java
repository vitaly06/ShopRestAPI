package life.course.pk1.Controllers;



import life.course.pk1.DAO.*;
import life.course.pk1.Models.*;
import life.course.pk1.Utill.StudentErrorResponse;
import life.course.pk1.Utill.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
public class MainController {
    @Autowired
    StudentDAO studentDAO;

    // регистрация пользователя
    @PostMapping("/regUser")
    public ResponseEntity<HttpStatus> regUser(@RequestBody Student student){
        studentDAO.addStudent(student);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    // информация о пользователе
    @GetMapping("/getUser/{id}")
    public Student getUser(@PathVariable("id") int id){
        Student student = studentDAO.getUser(id);
        return student;
    }

    // информация о товаре


    @ExceptionHandler
    private ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){
        StudentErrorResponse response = new StudentErrorResponse(
                "Студент с таким id не существует",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // 404
    }
}
