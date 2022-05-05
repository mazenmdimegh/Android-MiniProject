package project.test.deco.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.test.deco.Entity.Client;
import project.test.deco.Entity.Produit;
import project.test.deco.Repository.ClientRepository;
import project.test.deco.Repository.ProduitRepository;

import java.util.Arrays;
import java.util.List;

@CrossOrigin("*")
@RestController
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProduitRepository produitRepository;
    @PostMapping
    public void saveClient(@RequestBody Client client){
     clientRepository.save(client);
    }

    @GetMapping(value = "/client/{id}")
    public Client getClient(@PathVariable(name = "id") int id){
        return clientRepository.findById(id).get();
    }

    @GetMapping(value = "/client/panier/{id}")
    public List<Produit> getProd(@PathVariable(name = "id") int id){
     //   System.out.println(clientRepository.findById(id).get().getPanier().get(0).getId());
       return clientRepository.findById(id).get().getPanier();
    }
    @PostMapping(value = "/client/panier/{id}/{idP}")
    public void postProd(@PathVariable(name = "id") int id,@PathVariable(name = "idP") Long idP){
        Produit produits = produitRepository.findById(idP).get();
        produits.setQteStock(1);
        if (!clientRepository.findById(id).get().getPanier().contains(produits)) {
            clientRepository.findById(id).get().getPanier().add(produits);
            Client client = clientRepository.findById(id).get();
            client.setId(id);
            clientRepository.save(client);
        }
    }
    @PutMapping(value = "/client/panier/{id}/{idP}")
    public void putProd(@PathVariable(name = "id") int id,@PathVariable(name = "idP") Long idP, @RequestBody int value){
        Produit produits = produitRepository.findById(idP).get();
        int index = clientRepository.findById(id).get().getPanier().indexOf(produits);
        int Qt=clientRepository.findById(id).get().getPanier().get(index).getQteStock();
        if(value==(1)) {
            clientRepository.findById(id).get().getPanier().remove(produits);
            produits.setQteStock(Qt + 1);
            clientRepository.findById(id).get().getPanier().add(produits);
            Client client = clientRepository.findById(id).get();
            client.setId(id);
            clientRepository.save(client);
        }else if (value==(-1)& clientRepository.findById(id).get().getPanier().get(index).getQteStock()>1){
            clientRepository.findById(id).get().getPanier().remove(produits);
            produits.setQteStock(Qt - 1);
            clientRepository.findById(id).get().getPanier().add(produits);
            Client client = clientRepository.findById(id).get();
            client.setId(id);
            clientRepository.save(client);
        }

    }
    @DeleteMapping(value = "/client/panier/{id}/{idP}")
    public void DeleteProd(@PathVariable(name = "id") int id,@PathVariable(name = "idP") Long idP){
        Produit produits = produitRepository.findById(idP).get();
        clientRepository.findById(id).get().getPanier().remove(produits);
        List<Produit> pan= clientRepository.findById(id).get().getPanier();
        Client client = clientRepository.findById(id).get();
        client.setPanier(pan);
        clientRepository.save(client);

    }
    @DeleteMapping(value = "/p/{id}")
    public void Delete(@PathVariable(name = "id") int id){
        clientRepository.findById(id).get().getPanier().clear();
        Client client = clientRepository.findById(id).get();
        clientRepository.save(client);

    }

}
