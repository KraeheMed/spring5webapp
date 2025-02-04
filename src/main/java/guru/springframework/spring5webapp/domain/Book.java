package guru.springframework.spring5webapp.domain;

import guru.springframework.spring5webapp.domain.Author;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String isbn;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), 
        inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    
    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }


    public Book() {
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getIsbn() {
        return isbn;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public Set<Author> getAuthors() {
        return authors;
    }


    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Book{" + 
                "id=" + id +
                ", authors=" + authors +
                ", isbn=" + isbn +
                ", title=" + title +
                "}";
    
    }


    public Publisher getPublisher() {
        return publisher;
    }


    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    
}