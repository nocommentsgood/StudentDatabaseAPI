package DatabaseAPI.DatabaseAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/api")
public class MainController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository coursesRepository;

    @CrossOrigin
    @PostMapping(path = "/student")
    public @ResponseBody Student addNewStudent(@RequestBody Student passedStudent) {
        Student newStudent = new Student();
        if (passedStudent.getStudentID() != null) {
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
    @GetMapping(path = "/students")
    public @ResponseBody Iterable<Student> getAllStudents() {
        // this returns a JSON or XML with the students
        return studentRepository.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "/id")
    public @ResponseBody Optional<Student> getStudent(@RequestParam Integer studentID) {
        return studentRepository.findById(studentID);
    }

    @CrossOrigin
    @DeleteMapping(path = "/id/delete")
    public void deleteStudent(@RequestParam Integer studentID) {
        studentRepository.deleteById(studentID);
    }

    @CrossOrigin
    @PutMapping(path = "/update")
    public @ResponseBody Optional<Student> updateStudent(@RequestBody Student passedStudent) {
        if (!studentRepository.existsById(passedStudent.getStudentID())) {
            addNewStudent(passedStudent);
            return Optional.of(passedStudent);
        }

        return studentRepository.findById(passedStudent.getStudentID()).map(student -> {
            student.setFirstName(passedStudent.getFirstName());
            student.setLastName(passedStudent.getLastName());
            student.setStudentYear(passedStudent.getStudentYear());
            student.setBalance(passedStudent.getBalance());
            studentRepository.save(student);
            return student;
        });
    }

    @CrossOrigin
    @GetMapping(path = "/courses")
    public @ResponseBody Iterable<Course> getAllCourses() {
        return coursesRepository.findAll();
    }

/*
    @CrossOrigin
    @PutMapping(path="/id/addcourse")
    public @ResponseBody Optional<Student> updateCourses(@RequestBody Student passedStudent, @RequestBody ArrayList<Integer> coursesToAdd) {
        passedStudent.courses.get(0);
        for (int i = 0; i < passedStudent.courses.size(); i ++){
            if (!Objects.equals(passedStudent.courses.get(i).getCourseID(), coursesToAdd.get(i))) {
                passedStudent.courses.add(coursesToAdd.)
            }
        }
    }*/

    /*
    To add courses, student id will be passed from front end.
    JSON containing courses will also be passed
    Find student by id
    sanitize listOfPassedCourses
    student.addCourses(listOfPassedCourses)
     */
}
