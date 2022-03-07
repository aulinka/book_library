package umb.fpv.ki.bookLibrary;

public class BookDTO {

    public long id;
    public String name;
    public String isbn;
    public String authorFirstname;
    public String authorLastname;
    public int bookCount;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getTitle() { return name; }
    public void setTitle(String name) { this.name = name; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getAuthorFirstname() { return authorFirstname; }
    public void setAuthorFirstname(String authorFirstname) { this.authorFirstname = authorFirstname; }

    public String getAuthorLastname() { return authorLastname; }
    public void setAuthorLastname(String authorLastname) { this.authorLastname = authorLastname; }

    public int getBookCount() { return bookCount; }
    public void setBookCount(int bookCount) { this.bookCount = bookCount; }
}
