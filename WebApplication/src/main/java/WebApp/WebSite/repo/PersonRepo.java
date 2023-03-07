package WebApp.WebSite.repo;

import WebApp.WebSite.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer>
{
    boolean existsByTgid(Long tgid);

    Person getByTgid(Long tgid);

    @Transactional
    void deleteByTgid(Long id);
}
