package umb.fpv.ki.bookLibrary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Borrowing {
    @Id
    @GeneratedValue
    public long id;
    public Customer borrower;
    public Book book;
}
