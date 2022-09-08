package DatabaseAPI.DatabaseAPI;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer studentID;
    private String firstName;
    private String lastName;
    private Integer studentYear;
    private Integer balance;


    public Integer getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(Integer studentYear) {
        this.studentYear = studentYear;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getStudentID(){
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return String.format("Student Info: %n Student ID: %d%n First Name: %s%n Last Name: %s%n Year: %d%n Balance: %d", getStudentID(), getFirstName(), getLastName(), getStudentYear(), getBalance());
    }
}
