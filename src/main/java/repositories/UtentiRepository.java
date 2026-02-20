package repositories;

import entities.Utenti;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtentiRepository extends JpaRepository<Utenti, Long> {
    Optional<Utenti> findBtUsernamr(String username);
}