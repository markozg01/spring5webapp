package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.respositories.AuthorRepository;
import guru.springframework.spring5webapp.respositories.BookRepository;
import guru.springframework.spring5webapp.respositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

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

        System.out.println("BOOK COUNT INIT "+bookRepository.count());
        System.out.println("AUTHOR COUNT INIT "+authorRepository.count());
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        Author eric = new Author("Ericq", "Evansw");
        Book book = new Book("Domainq Driven Design","12344");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book);

        Author rod = new Author("Rod1","rodic");
        Book noEjb = new Book("J2EE2", "33333");

        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEjb);

        System.out.println("RUNNIN BOOTSTRAPDATA");
        System.out.println("BOOK COUNT"+bookRepository.count());
        System.out.println("AUTHOR COUNT"+authorRepository.count());

        Publisher publisher = new Publisher("aaa","bb","ccc","ddd");
        publisherRepository.save(publisher);

        System.out.println("publisher COUNT"+publisherRepository.count());



    }
}
