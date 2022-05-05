package project.test.deco.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import project.test.deco.Entity.Commande;
import project.test.deco.Repository.CommandeRepository;

import java.util.List;

@Service

public class CommandeServices {
    @Autowired
    public  CommandeRepository commandeRepository;
    @GetMapping
    public List<Commande> getcom(int id){return commandeRepository.findByIdClient(id);}
}
