package project.test.deco.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.test.deco.Entity.Client;
import project.test.deco.Entity.Produit;
import project.test.deco.Repository.ClientRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
    private ClientRepository clientRepository;

    //
    //public List<Produit> create(Client client) {

     //   List<Produit> produit = client.getPanier();
     //   return produit;
    //}
    public void savetoDB(){

    }

}
