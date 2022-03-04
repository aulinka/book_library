package umb.fpv.ki.bookLibrary;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {

    BookService bookService;

    @GetMapping("/api/books")
    public List<Book> getBook(@RequestParam String title){
        return bookService.getBook(title);
    }
    @PostMapping("/api/books")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }
    @GetMapping("/api/books/{bookId}")
    public Book getBookById(@PathVariable long bookId){
        return bookService.getBookById(bookId);
    }
    @PutMapping("/api/books/{bookId}")
    public Book updateBookById(@PathVariable long bookId, @RequestBody Book book){
        return bookService.updateBookById(bookId,book);
    }
    @DeleteMapping("/api/books/{bookId}")
    public void deleteBookById(@PathVariable long bookId){
        bookService.deleteBookById(bookId);
    }
}


