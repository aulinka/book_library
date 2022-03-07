package umb.fpv.ki.bookLibrary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue
    public long id;
    public String name;
    public String isbn;
    public String authorFirstname;
    public String authorLastname;
    public int bookCount;
}
