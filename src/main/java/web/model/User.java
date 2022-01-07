package web.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users421")
@Getter
@Setter
public class User implements UserDetails{

   @Id
   @Column(name = "id", nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name", nullable = false)
   private String firstName;

   @Column(name = "last_name", nullable = false)
   private String lastName;

   @Column(name = "email", unique = true, nullable = false)
   private String email;

   @Column(name = "age", nullable = false)
   private int age;

   @Column(name="password", nullable = false)
   private String password;

   @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
   @JoinTable(name = "users421_role421",
   joinColumns = @JoinColumn(name = "users421_id"),
   inverseJoinColumns = @JoinColumn(name = "role421_id"))
   private Set<Role> roleList = new HashSet<>();

   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }


   public void addRole(Role role){
      roleList.add(role);
   }


   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return roleList;
   }

   @Override
   public String getUsername() {
      return email;
   }

   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   @Override
   public boolean isAccountNonLocked() {
      return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   @Override
   public boolean isEnabled() {
      return true;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return Objects.equals(id, user.id);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id);
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\'' +
              ", age=" + age +
              ", password='" + password + '\'' +
              ", roleList=" + roleList +
              '}';
   }
}
