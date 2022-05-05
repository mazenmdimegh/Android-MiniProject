package project.test.deco.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.test.deco.Entity.Produit;
import project.test.deco.Repository.ProduitRepository;
import project.test.deco.Services.ProduitService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class ProduitController {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private ProduitService produitService;
    @GetMapping(value = "/prod")
    public List<Produit> getProduits(){
    return produitRepository.findAll();
    }
}
