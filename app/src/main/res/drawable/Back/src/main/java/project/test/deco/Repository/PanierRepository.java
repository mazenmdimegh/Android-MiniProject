package project.test.deco.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import project.test.deco.Entity.Panier;

import java.util.List;
@CrossOrigin("*")
@RepositoryRestResource
public interface PanierRepository extends JpaRepository<Panier,Integer> {
    @RestResource(path = "/byIdClient")
    public List<Panier> findByIdClient(@Param("id") Integer des);
}
