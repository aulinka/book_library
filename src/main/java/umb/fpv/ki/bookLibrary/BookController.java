package umb.fpv.ki.bookLibrary;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {

    @GetMapping("/books")
    public List<Book> getBook(@RequestParam String name){
        return getBook(name);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        return addBook(book);
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable long bookId){
        return getBookById(bookId);
    }

    @PutMapping("/books/{bookId}")
    public Book updateBookById(@PathVariable long bookId, @RequestBody Book book){
        return updateBookById(bookId,book);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBookById(@PathVariable long bookId){
        deleteBookById(bookId);
    }
}


