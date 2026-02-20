package alexandramanolache.repositories;

import alexandramanolache.entities.Utenti;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtentiRepository extends JpaRepository<Utenti, Long> {
    Optional<Utenti> findByUsername(String username);
}