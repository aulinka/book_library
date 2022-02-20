package umb.fpv.ki.bookLibrary;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorrowingsController {

    @PostMapping("/borrowings")

    @GetMapping("/borrowings")

    @GetMapping("/borrowings/{borrowingId}")

    @DeleteMapping("/borrowings/{borrowingId}")
}
