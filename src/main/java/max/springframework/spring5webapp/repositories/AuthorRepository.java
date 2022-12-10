package max.springframework.spring5webapp.repositories;

import max.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository  extends CrudRepository<Author, Long> {
}
