package umb.fpv.ki.bookLibrary;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BorrowingController {

    BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService){
        this.borrowingService = borrowingService;
    }

    @PostMapping("/api/borrowings")
    public BorrowingDTO createBorrowing(@RequestBody BorrowingDTO b) {
        Borrowing borrowing = borrowingService.createBorrowing(b.bookId,b.customerId);
        BorrowingDTO borrowingDTO = new BorrowingDTO();
        borrowingDTO.bookId = (borrowing.book.id);
        borrowingDTO.customerId = (borrowing.borrower.id);
        borrowingDTO.id = (borrowing.id);
        borrowingDTO.customerName = (borrowing.borrower.firstName + " " + borrowing.borrower.lastName);
        borrowingDTO.authorName = (borrowing.book.authorFirstname + " " + borrowing.book.authorLastname);
        borrowingDTO.title = (borrowing.book.name);
        return borrowingDTO;
    }
    @GetMapping("/api/borrowings")
    public List<BorrowingDTO> listBorrowings(){
        List<BorrowingDTO> borrowingDTOS = new ArrayList<>();
        List<Borrowing> borrowings = borrowingService.listBorrowings();
        for (Borrowing b: borrowings){
            BorrowingDTO borrowingDTO = new BorrowingDTO();
            borrowingDTO.id = (b.id);
            borrowingDTO.customerId = (b.borrower.id);
            borrowingDTO.bookId = (b.book.id);
            borrowingDTO.customerName = (b.borrower.firstName + " " + b.borrower.lastName);
            borrowingDTO.authorName = (b.book.authorFirstname + " " + b.book.authorLastname);
            borrowingDTO.title = (b.book.name);
            borrowingDTOS.add(borrowingDTO);
        }
        return borrowingDTOS;
    }
    @GetMapping("/api/borrowings/{borrowingId}")
    public BorrowingDTO getBorrowingById(@PathVariable long borrowingId){
        BorrowingDTO borrowingDTO = new BorrowingDTO();
        Borrowing borrowing = borrowingService.getBorrowingById(borrowingId);
        borrowingDTO.id = (borrowing.id);
        borrowingDTO.customerId = (borrowing.borrower.id);
        borrowingDTO.customerName = (borrowing.borrower.firstName + " " + borrowing.borrower.lastName);
        borrowingDTO.bookId = (borrowing.book.id);
        borrowingDTO.authorName = (borrowing.book.authorFirstname + " " + borrowing.book.authorLastname);
        borrowingDTO.title = (borrowing.book.name);
        return borrowingDTO;
    }
    @DeleteMapping("/api/borrowings/{borrowingId}")
    public void deleteBorrowingById(@PathVariable long borrowingId){
        borrowingService.deleteBorrowingById(borrowingId);
    }
}
