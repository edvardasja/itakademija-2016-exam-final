package lt.akademija.jpaexam.ex02associaions;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class LibraryReader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<LibraryReaderAddress> addresses;
    
    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Book> borrowedBooks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBorrowedBooks() {
        if (borrowedBooks == null) {
            borrowedBooks = new ArrayList<>();
        }
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public List<LibraryReaderAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<LibraryReaderAddress> addresses) {
        this.addresses = addresses;
    }

    public void addBorrowedBook(Book book) {
    	book.getBookReaders().add(this);
    	this.getBorrowedBooks().add(book);
    }
}
