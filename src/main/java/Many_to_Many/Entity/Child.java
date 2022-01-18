package Many_to_Many.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "my_db.children")
public class Child {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Column (name = "name")
    private String firstname;

    @Column (name = "age")
    private int age;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable ( name = "child_section",
    joinColumns = @JoinColumn (name = "child_id"),
    inverseJoinColumns = @JoinColumn (name = "section_id"))
    private List<Section> sections;

    public Child() {
    }

    public Child(String firstname, int age) {
        this.firstname = firstname;
        this.age = age;
    }

    public void addSectionToChild (Section section) {

        if (sections == null) {
            sections = new ArrayList<>();
        }
        sections.add(section);

    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", firstName='" + firstname + '\'' +
                ", age=" + age +
                '}';
    }
}
