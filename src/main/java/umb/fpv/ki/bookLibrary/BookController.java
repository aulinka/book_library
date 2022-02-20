package umb.fpv.ki.bookLibrary;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {
    public static final List<Book> books = new ArrayList<>();

    @GetMapping("/books")
    public List<Book> getBook(@RequestParam String name){
        return books.stream().filter(book -> book.name.contains(name)).collect(Collectors.toList());
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        books.add(book);
        return book;
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable long bookId){
        return books.stream().filter(book -> book.id == bookId).findFirst().get();
    }

    @PutMapping("/books/{bookId}")
    public Book updateBookById(@PathVariable Long bookId, @RequestBody Book book){
        for(Book b: books){
            if(b.id == bookId){
                b = book;
            }
        }
        return book;
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBookById(@PathVariable long bookId){
        books.removeIf(book -> book.id == bookId);
    }
}


