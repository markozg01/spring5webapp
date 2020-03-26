package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.respositories.AuthorRepository;
import guru.springframework.spring5webapp.respositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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
        //noEjb.getAuthors().add(rod);

        //authorRepository.save(rod);
        //bookRepository.save(noEjb);

        System.out.println("RUNNIN BOOTSTRAPDATA");
        System.out.println("BOOK COUNT"+bookRepository.count());
        System.out.println("AUTHOR COUNT"+authorRepository.count());
        //Iterable<Author> authorList = authorRepository.findAll();
        //authorList.forEach(author -> System.out.println(author));
    }
}
