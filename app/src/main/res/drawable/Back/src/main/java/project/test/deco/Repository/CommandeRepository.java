package project.test.deco.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import project.test.deco.Entity.Commande;

import java.util.List;
@CrossOrigin("*")
@RepositoryRestResource

public interface CommandeRepository extends JpaRepository<Commande,Integer> {
    @RestResource(path = "/byNom")
    public List<Commande>findByClientName(@Param("p") String des);
    @RestResource(path = "/byidClient")
    public List<Commande>findByIdClient(@Param("p") int des);
}
