package DatabaseAPI.DatabaseAPI;

import javax.persistence.*;

@Entity
@Table(name = "[course_names]")
public class CourseNames {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "[id]")
    private Integer id;

    @Column(name = "[name]")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
