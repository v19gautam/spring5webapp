package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author vishal = new Author("Vishal", "Gautam");
        Book book = new Book("Spring Framework", "123");
        Publisher publisher = new Publisher("VG", "Patna");

        authorRepository.save(vishal);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        vishal.getBooks().add(book);
        book.getAuthors().add(vishal);
        book.setPublisher(publisher);
        publisher.getBooks().add(book);

        authorRepository.save(vishal);
        bookRepository.save(book);
        publisherRepository.save(publisher);


        Author sirsha = new Author("Sirsha", "Pattanayak");
        Book book2 = new Book("Phd in Management", "124");
        authorRepository.save(sirsha);
        bookRepository.save(book2);

        sirsha.getBooks().add(book2);
        book2.getAuthors().add(sirsha);
        book2.setPublisher(publisher);
        publisher.getBooks().add(book2);
        authorRepository.save(sirsha);
        bookRepository.save(book2);
        publisherRepository.save(publisher);

        System.out.println("Starter in BootStrap");
        System.out.println("Number of books: "+bookRepository.count());
        System.out.println("Publishers Books: "+publisher.getBooks().size());
    }
}
