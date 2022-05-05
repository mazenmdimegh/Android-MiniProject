package project.test.deco.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.test.deco.Entity.Client;
import project.test.deco.Entity.Commande;
import project.test.deco.Entity.Produit;
import project.test.deco.Repository.ClientRepository;
import project.test.deco.Repository.CommandeRepository;
import project.test.deco.Services.CommandeServices;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CommandeController {
    @Autowired
    private CommandeServices commandeServices;
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private ClientRepository clientRepository;
    //@GetMapping(value = "/command/{idC}")
    //public Optional<Commande> getcom(@PathVariable(name = "idC") int idC){
      //  return commandeRepository.findById(idC);
   // }
    @GetMapping(value="/command/{idC}")
    public List<Commande> com(@PathVariable(name = "idC") int idC){
        return commandeRepository.findByIdClient(idC);
    }

    @PostMapping(value = "/command/{idC}")
    public void postProd(@PathVariable(name = "idC") int idC){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        List<Produit> produits = clientRepository.findById(idC).get().getPanier();
        float Tot=0 ;
        for (int i = 0; i < produits.size(); i++) {
           Tot += (produits.get(i).getPrix()*(produits.get(i).getQteStock()));
        }
        Commande commande=new Commande();
        commande.setIdCmd(commandeRepository.findAll().size()+1);
        commande.setIdClient(idC);
        commande.setCmdDate(date);
        commande.setTotalCmd(Tot+10);
        commande.setClientName(clientRepository.findById(idC).get().getNom());
        commande.setComm(produits);
        System.out.println(commande);
        commandeRepository.save(commande);
        clientRepository.findById(idC).get().getPanier().clear();
        Client cl = clientRepository.findById(idC).get();
        clientRepository.save(cl);

    }
    @DeleteMapping(value="/command/{idCmd}")
    public void deleteCmd(@PathVariable(name = "idCmd") int idCmd){
        Commande c =commandeRepository.findById(idCmd).get();
        commandeRepository.delete(c);
    }

}
