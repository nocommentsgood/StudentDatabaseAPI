package DatabaseAPI.DatabaseAPI;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer studentid;
    private String firstName;
    private String lastName;
    private Integer studentyear;
    private Integer balance;


    public Integer getStudentyear() {
        return studentyear;
    }

    public void setStudentyear(Integer studentyear) {
        this.studentyear = studentyear;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getStudentid(){
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
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
}
