package DatabaseAPI.DatabaseAPI;

import javax.persistence.*;

// maybe we assume that the database has all courses available, so relative to the API, we just have to worry about the course ID...

/*
Previously (such as in Student class), I was renaming the fields of the class to syntactically match the syntax of the database columns.
Below, it is shown how to provide "aliases" for the column names.
Note, application.properties must have naming strategies changed.
See the below conversation on GitHub:
https://github.com/spring-projects/spring-boot/issues/2129
 */

@Entity
@Table(name = "[course]")
public class Course {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id", nullable = false)
    private Integer courseID;
    @Column(name = "[cost]")
    private Integer courseCost;

    @Column(name = "[student_id]")
    private Integer studentID;


    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public Integer getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(Integer courseCost) {
        this.courseCost = courseCost;
    }
}
