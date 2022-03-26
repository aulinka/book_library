package umb.fpv.ki.bookLibrary;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @PostMapping("/api/books")
    public BookDTO createBook(@RequestBody BookDTO inBook) {
        Book book = bookService.addBook(
               inBook.name, inBook.isbn, inBook.authorFirstName, inBook.authorLastName, inBook.bookCount);
        BookDTO bookDTO = new BookDTO();
        bookDTO.id = (book.id);
        bookDTO.name = (book.name);
        bookDTO.authorFirstName = (book.authorFirstname);
        bookDTO.authorLastName = (book.authorLastname);
        bookDTO.isbn = (book.isbn);
        bookDTO.bookCount = (book.bookCount);
        return bookDTO;
    }

    @GetMapping("/api/books")
    public List<BookDTO> listBooks() {
        List<BookDTO> bookDTOS = new ArrayList<>();
        List<Book> books = bookService.listBooks();
        for (Book bo: books) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.id=bo.id;
            bookDTO.name = bo.name;
            bookDTO.authorFirstName = bo.authorFirstname;
            bookDTO.authorLastName = bo.authorLastname;
            bookDTO.isbn = bo.isbn;
            bookDTO.bookCount = bo.bookCount;
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

    @GetMapping("/api/books/{bookId}")
    public BookDTO getBookById(@PathVariable long bookId){
        BookDTO bookDTO = new BookDTO();
        Book book = bookService.getBookById(bookId);
        bookDTO.id= bookId;
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


