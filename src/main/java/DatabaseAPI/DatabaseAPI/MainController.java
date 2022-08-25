package DatabaseAPI.DatabaseAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping(path="/api")
public class MainController {
    @Autowired
    private StudentRepository studentRepository;

    @CrossOrigin
    @PostMapping(path="/student")
    public @ResponseBody Student addNewStudent (@RequestParam(value="studentID", required = false) Integer studentID, @RequestBody Student passedStudent){
        Student newStudent = new Student();
        if (passedStudent.getStudentID() != null){
            newStudent.setStudentID(passedStudent.getStudentID());
        }
        newStudent.setFirstName(passedStudent.getFirstName());
        newStudent.setLastName(passedStudent.getLastName());
        newStudent.setStudentYear(passedStudent.getStudentYear());
        newStudent.setBalance(passedStudent.getBalance());
        System.out.println(passedStudent);
        studentRepository.save(newStudent);
        return newStudent;
    }

    @CrossOrigin
    @GetMapping(path="/students")
    public @ResponseBody Iterable<Student> getAllStudents(){
        // this returns a JSON or XML with the students
        return studentRepository.findAll();
    }

    @CrossOrigin
    @GetMapping(path="/id")
    public Optional<Student> getStudent(@RequestParam(value="studentID") Integer studentID) {
        return studentRepository.findById(studentID);
    }
}
