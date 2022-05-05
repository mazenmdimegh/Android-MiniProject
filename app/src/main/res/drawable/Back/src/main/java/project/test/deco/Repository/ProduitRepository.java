package project.test.deco.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import project.test.deco.Entity.Produit;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface ProduitRepository extends JpaRepository<Produit,Long> {
    @RestResource(path = "/byCategorie")
    public List<Produit> findByCategorie(@Param("g") String des);
    @RestResource(path = "/byName")
    public List<Produit> findByNomPContains(@Param("g") String des);
}
