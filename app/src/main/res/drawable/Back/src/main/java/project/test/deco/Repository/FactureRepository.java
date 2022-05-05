package project.test.deco.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import project.test.deco.Entity.Facture;
@RepositoryRestResource
@CrossOrigin("*")
public interface FactureRepository extends JpaRepository<Facture,Long> {
}
