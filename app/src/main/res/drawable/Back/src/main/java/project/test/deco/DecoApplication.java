package project.test.deco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import project.test.deco.Controller.ClientController;
import project.test.deco.Entity.Admin;
import project.test.deco.Entity.Client;
import project.test.deco.Entity.Commande;
import project.test.deco.Entity.Produit;
import project.test.deco.Repository.ClientRepository;

import java.util.Arrays;

@SpringBootApplication
public class DecoApplication implements CommandLineRunner {
    @Autowired
    private RepositoryRestConfiguration restConfiguration;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(DecoApplication.class, args);
       /* Client C = new Client();

        C.setNom("C");
        C.setPrenom("C");
        C.setMail("c@c.e");
        C.setPassword("c");
        C.setAdresse("qsd");
        C.setTel(54165);
        C.setNcin(56465);

        Produit P = new Produit();

        P.setNomP("BOUILLOIRE SMEG");
        P.setMarque("SMEG");
        P.setDescription("SMEG");
        P.setPrix((float) 60);
        P.setRemise(0);
        P.setCategorie("electromenager");
        P.setImageURL("https://i.pinimg.com/564x/c5/b5/ba/c5b5ba33ad420b8cf06c5a49b09156f0.jpg");
        P.setQteStock(0);
        P.setEtat(false);

        Produit P2 = new Produit();

        P2.setNomP("BOUILLOIRE SMEG2");
        P2.setMarque("SMEG2");
        P2.setDescription("SMEG2");
        P2.setPrix((float) 602);
        P2.setRemise(02);
        P2.setCategorie("electromenager2");
        P2.setImageURL("https://i.pinimg.com/564x/c5/b5/ba/c5b5ba33ad420b8cf06c5a49b09156f0.jpg2");
        P2.setQteStock(02);
        P2.setEtat(false);
        //P.setClient(C);
        C.setPanier(Arrays.asList(P,P2));
        System.out.println(P.toString());
        System.out.println(C.toString());
        //clientRepository.save(C);*/



    }

    @Override
    public void  run(String... args)throws Exception{
        restConfiguration.exposeIdsFor(Admin.class);
        restConfiguration.exposeIdsFor(Produit.class);
        restConfiguration.exposeIdsFor(Client.class);
        restConfiguration.exposeIdsFor(Commande.class);


    }


}
