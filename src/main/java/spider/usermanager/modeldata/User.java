package spider.usermanager.modeldata;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 35145646513L;

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id=0;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private int age;

    @Column(name = "isAdmin")
    private boolean Admin;

    @Column(name = "createdDate")
    private Date date;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getAdmin() {
        return Admin;
    }

    public void setAdmin(boolean isAdmin) {
        this.Admin = isAdmin;
    }

    public Date getDate() {
        return date;
    }

}

