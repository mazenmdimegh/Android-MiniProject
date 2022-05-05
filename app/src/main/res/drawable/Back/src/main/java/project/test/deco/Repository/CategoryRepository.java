package project.test.deco.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import project.test.deco.Entity.Category;

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category,String> {
}
