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
    public @ResponseBody String addNewStudent (@RequestParam(value="firstname") String firstname, @RequestParam(value="lastname") String lastname,
                                               @RequestParam(value="studentyear") Integer studentyear, @RequestParam(value="balance") Integer balance){
        Student student = new Student();
        student.setFirstName(firstname);
        student.setLastName(lastname);
        student.setStudentyear(studentyear);
        student.setBalance(balance);
        studentRepository.save(student);
        return "Saved";
    }

    @CrossOrigin
    @GetMapping(path="/students")
    public @ResponseBody Iterable<Student> getAllStudents(){
        // this returns a JSON or XML with the students
        return studentRepository.findAll();
    }

    @CrossOrigin
    @GetMapping(path="/id")
    public Optional<Student> getStudent(@RequestParam(value="studentid") Integer studentid) {
        return studentRepository.findById(studentid);
    }
}
