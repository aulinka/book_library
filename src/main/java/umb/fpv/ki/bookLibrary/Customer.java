package umb.fpv.ki.bookLibrary;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    public long id;
    public String firstName;
    public String lastName;
    public  String email;
}
