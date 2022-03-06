package umb.fpv.ki.bookLibrary;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowingService {

    public  final List<Borrowing> borrowings = new ArrayList();
    private BookService bookService;
    private CustomerService customerService;
    private BorrowingRepository borrowingRepository;

    public BorrowingService(BookService bookService, CustomerService customerService, BorrowingRepository borrowingRepository) {
        this.bookService = bookService;
        this.customerService = customerService;
        this.borrowingRepository = borrowingRepository;
    }

    public Borrowing createBorrowing(long bookid, long customerId){
        Borrowing borrowing = new Borrowing();
        Customer cId = this.customerService.getCustomerById(customerId);
        Book bId = this.bookService.getBookById(bookid);
        borrowing.borrower = cId;
        borrowing.book = bId;
        return borrowingRepository.save(borrowing);


    }
    public List<Borrowing> listBorrowings(){
        return borrowings;
    }
    public Borrowing getBorrowingById(long borrowingId){
        Borrowing b = new Borrowing();
        Book book = bookService.getBookById(b.book.id);
        Customer customer = customerService.getCustomerById(b.borrower.id);
        return b;
    }
    public void deleteBorrowingById(long borrowingId){
        borrowings.removeIf(borrowing -> borrowing.id == borrowingId);
    }
}
