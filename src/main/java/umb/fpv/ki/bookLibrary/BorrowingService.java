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
        return borrowingRepository.findAll();
    }
    public Borrowing getBorrowingById(long borrowingId){
        Optional<Borrowing> optionalBorrowing = borrowingRepository.findById((int)borrowingId);
        return optionalBorrowing.orElse(null);
    }
    public void deleteBorrowingById(long borrowingId){
        borrowingRepository.deleteById((int)borrowingId);
    }
}
