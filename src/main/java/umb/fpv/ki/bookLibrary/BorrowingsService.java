package umb.fpv.ki.bookLibrary;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowingsService {

    public  final List<Borrowings> borrowings = new ArrayList();
    public BookService bookService;
    public CustomerService customerService;

    public void createBorrowing(Borrowings b){
        borrowings.add(b);
    }
    public List<Borrowings> listBorrowings(){
        return borrowings;
    }
    public Borrowings getBorrowingById( long borrowingId){
        Borrowings b = new Borrowings();
        Book book = bookService.getBookById(b.book.id);
        Customer c = customerService.getCustomerById(b.borrower.id);
        return b;
    }
    public void deleteBorrowingById(long borrowingId){
        borrowings.removeIf(borrowing -> borrowing.id == borrowingId);
    }


}
