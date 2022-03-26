package umb.fpv.ki.bookLibrary;

import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowingService {

    private BookService bookService;
    private CustomerService customerService;
    private BorrowingRepository borrowingRepository;
    private BookRepository bookRepository;

    public BorrowingService(BookService bookService, CustomerService customerService, BorrowingRepository borrowingRepository,
                            BookRepository bookRepository) {
        this.bookService = bookService;
        this.customerService = customerService;
        this.borrowingRepository = borrowingRepository;
        this.bookRepository = bookRepository;
    }

    public Borrowing createBorrowing(long bookid, long customerId){
        Borrowing borrowing = new Borrowing();
        Customer customer = this.customerService.getCustomerById(customerId);
        Book book = this.bookService.getBookById(bookid);
        borrowing.borrower = customer;
        borrowing.book = book;
        borrowing.book.bookCount--;
        bookRepository.save(borrowing.book);
        return borrowingRepository.save(borrowing);


    }
    public List<Borrowing> listBorrowings(){
        return borrowingRepository.findAll();
    }
    public Borrowing getBorrowingById(long borrowingId){
        Optional<Borrowing> optionalBorrowing = borrowingRepository.findById(borrowingId);
        return optionalBorrowing.orElse(null);
    }
    public void deleteBorrowingById(long borrowingId){
        Borrowing borrowing;
        borrowing = borrowingRepository.findById(borrowingId).orElse(null);
        borrowing.book.bookCount++;
        bookRepository.save(borrowing.book);
        borrowingRepository.deleteById(borrowingId);
    }
}
