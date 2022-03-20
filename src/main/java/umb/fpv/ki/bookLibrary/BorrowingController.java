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
        Borrowing borrowing = borrowingService.createBorrowing(b.getBookId(),b.getCustomerId());
        BorrowingDTO borrowingDTO = new BorrowingDTO();
        borrowingDTO.setBookId(borrowing.book.id);
        borrowingDTO.setCustomerId(borrowing.borrower.id);
        borrowingDTO.setId(borrowing.id);
        borrowingDTO.setCustomerName(borrowing.borrower.firstName + " " + borrowing.borrower.lastName);
        borrowingDTO.setAuthorName(borrowing.book.authorFirstname + " " + borrowing.book.authorLastname);
        borrowingDTO.setTitle(borrowing.book.name);
        return borrowingDTO;
    }
    @GetMapping("/api/borrowings")
    public List<BorrowingDTO> listBorrowings(){
        List<BorrowingDTO> borrowingDTOS = new ArrayList<>();
        List<Borrowing> borrowings = borrowingService.listBorrowings();
        for (Borrowing b: borrowings){
            BorrowingDTO borrowingDTO = new BorrowingDTO();
            borrowingDTO.setId(b.id);
            borrowingDTO.setCustomerId(b.borrower.id);
            borrowingDTO.setBookId(b.book.id);
            borrowingDTO.setCustomerName(b.borrower.firstName + " " + b.borrower.lastName);
            borrowingDTO.setAuthorName(b.book.authorFirstname + " " + b.book.authorLastname);
            borrowingDTO.setTitle(b.book.name);
            borrowingDTOS.add(borrowingDTO);
        }
        return borrowingDTOS;
    }
    @GetMapping("/api/borrowings/{borrowingId}")
    public BorrowingDTO getBorrowingById(@PathVariable long borrowingId){
        BorrowingDTO borrowingDTO = new BorrowingDTO();
        Borrowing borrowing = borrowingService.getBorrowingById(borrowingId);
        borrowingDTO.setId(borrowing.id);
        borrowingDTO.setCustomerId(borrowing.borrower.id);
        borrowingDTO.setCustomerName(borrowing.borrower.firstName + " " + borrowing.borrower.lastName);
        borrowingDTO.setBookId(borrowing.book.id);
        borrowingDTO.setAuthorName(borrowing.book.authorFirstname + " " + borrowing.book.authorLastname);
        borrowingDTO.setTitle(borrowing.book.name);
        return borrowingDTO;
    }
    @DeleteMapping("/api/borrowings/{borrowingId}")
    public void deleteBorrowingById(@PathVariable long borrowingId){
        borrowingService.deleteBorrowingById(borrowingId);
    }
}
