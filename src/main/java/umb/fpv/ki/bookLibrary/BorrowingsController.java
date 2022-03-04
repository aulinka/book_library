package umb.fpv.ki.bookLibrary;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BorrowingsController {

    BorrowingsService borrowingsService;

    @PostMapping("/api/borrowings")
    public void createBorrowing(@RequestBody Borrowings b) {
        borrowingsService.createBorrowing(b);
    }
    @GetMapping("/api/borrowings")
    public List<Borrowings> listBorrowings(){
        return borrowingsService.listBorrowings();
    }
    @GetMapping("/api/borrowings/{borrowingId}")
    public Borrowings getBorrowingById(@PathVariable long borrowingId){
        return borrowingsService.getBorrowingById(borrowingId);
    }
    @DeleteMapping("/api/borrowings/{borrowingId}")
    public void deleteBorrowingById(@PathVariable long borrowingId){
        borrowingsService.deleteBorrowingById(borrowingId);
    }
}
