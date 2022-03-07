package umb.fpv.ki.bookLibrary;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {

    BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @PostMapping("/api/books")
    public BookDTO addBook(@RequestBody BookDTO bo) {
        Book book = bookService.addBook(bo.getId(), bo.getTitle(), bo.getAuthorFirstname(), bo.getAuthorLastname(), bo.getIsbn(), bo.getBookCount());
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.id);
        bookDTO.setTitle(book.name);
        bookDTO.setAuthorFirstname(book.authorFirstname);
        bookDTO.setAuthorLastname(book.authorLastname);
        bookDTO.setIsbn(book.isbn);
        bookDTO.setBookCount(book.bookCount);
        return bookDTO;
    }

    @GetMapping("/api/books")
    public List<BookDTO> listBooks() {
        List<BookDTO> bookDTOS = new ArrayList<>();
        List<Book> books = bookService.listBooks();
        for (Book bo: books) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setId(bo.id);
            bookDTO.setTitle(bo.name);
            bookDTO.setAuthorFirstname(bo.authorFirstname);
            bookDTO.setAuthorLastname(bo.authorLastname);
            bookDTO.setIsbn(bo.isbn);
            bookDTO.setBookCount(bo.bookCount);
        }
        return bookDTOS;
    }

    @GetMapping("/api/books/{bookId}")
    public BookDTO getBookById(@PathVariable long bookId){
        BookDTO bookDTO = new BookDTO();
        Book book = bookService.getBookById(bookId);
        bookDTO.setId(bookId);
        return bookDTO;
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


