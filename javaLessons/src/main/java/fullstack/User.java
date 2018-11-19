package fullstack;
import com.fasterxml.jackson.annotation.JsonIgnore;
import sun.jvm.hotspot.gc.shared.Generation;

import javax.persistence.*;


@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerators.class,
//        property = "id")

public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//    @JsonIgnore //@JsonBackReference //users don't come with posts though @JsonManagedReference?
//    private Set<Post> posts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}