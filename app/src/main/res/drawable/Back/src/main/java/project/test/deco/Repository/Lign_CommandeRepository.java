package project.test.deco.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import project.test.deco.Entity.Ligne_commande;
@RepositoryRestResource
public interface Lign_CommandeRepository extends JpaRepository<Ligne_commande,Integer> {
}
