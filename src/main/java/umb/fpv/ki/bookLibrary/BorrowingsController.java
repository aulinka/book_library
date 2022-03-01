package umb.fpv.ki.bookLibrary;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BorrowingsController {

    @PostMapping("/borrowings")
    public void createBorrowing(@RequestBody Borrowings b) {
        createBorrowing(b);
    }
    @GetMapping("/borrowings")
    public List<Borrowings> listBorrowings(){
        return listBorrowings();
    }
    @GetMapping("/borrowings/{borrowingId}")
    public Borrowings getBorrowingById(@PathVariable long borrowingId){
        return getBorrowingById(borrowingId);
    }
    @DeleteMapping("/borrowings/{borrowingId}")
    public void deleteBorrowingById(@PathVariable long borrowingId){
       deleteBorrowingById(borrowingId);
    }
}
