package umb.fpv.ki.bookLibrary;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

class CreateBorrowingBody{
    public long customerId;
    public long bookId;
}

@RestController
public class BorrowingsController {
    public static final List<Borrowings> borrowings = new ArrayList();

    @PostMapping("/borrowings")
    public Borrowings createBorrowing(@RequestBody CreateBorrowingBody body){
        Borrowings b = new Borrowings();
        Book pom =  BookController.books.stream().filter(book -> book.id == body.bookId).findFirst().get();
        b.id = borrowings.size() + 1;
        b.book = pom;
        pom.bookCount--;
        b.borrower = CustomerController.customers.stream().filter(customer -> customer.id == body.customerId).findFirst().get();
        borrowings.add(b);
        return b;
    }
    @GetMapping("/borrowings")
    public List<Borrowings> listBorrowings(){
        return borrowings;
    }
    @GetMapping("/borrowings/{borrowingId}")
    public Borrowings getBorrowingById(@PathVariable long borrowingId){
        return borrowings.stream().filter(borrowing -> borrowing.id == borrowingId).findFirst().get();
    }
    @DeleteMapping("/borrowings/{borrowingId}")
    public void deleteBorrowingById(@PathVariable long borrowingId){
        borrowings.removeIf(borrowing -> borrowing.id == borrowingId);
    }
}
