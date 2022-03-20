package umb.fpv.ki.bookLibrary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Borrowing {
    @Id
    @GeneratedValue
    public long id;
    @OneToOne
    public Customer borrower;
    @OneToOne
    public Book book;
}
