package DatabaseAPI.DatabaseAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewStudent (@RequestParam Integer studentid, @RequestParam String firstname, @RequestParam String lastname,
                                               @RequestParam Integer studentyear, @RequestParam Integer balance){
        Student student = new Student();
        student.setStudentid(studentid);
        student.setFirstName(firstname);
        student.setLastName(lastname);
        student.setStudentyear(studentyear);
        student.setBalance(balance);
        studentRepository.save(student);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Student> getAllStudents(){
        // this returns a JSON or XML with the students
        return studentRepository.findAll();
    }
}
