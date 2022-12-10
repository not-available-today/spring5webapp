package max.springframework.spring5webapp.bootstrap;

import max.springframework.spring5webapp.domain.Author;
import max.springframework.spring5webapp.domain.Book;
import max.springframework.spring5webapp.domain.Publisher;
import max.springframework.spring5webapp.repositories.AuthorRepository;
import max.springframework.spring5webapp.repositories.BookRepository;
import max.springframework.spring5webapp.repositories.PublisherRepository;
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

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG publishing");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author henry = new Author("Henry", "Miller");
        Book tropic = new Book("Tropic of Capricorn","213124");
        henry.getBooks().add(tropic);
        tropic.getAuthors().add(henry);

        tropic.setPublisher(publisher);
        publisher.getBooks().add(tropic);

        authorRepository.save(henry);
        bookRepository.save(tropic);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB","23423415");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books  " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());

    }
}
