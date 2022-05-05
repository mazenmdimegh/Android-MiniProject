package project.test.deco.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import project.test.deco.Repository.LivraisonRepository;
import project.test.deco.Services.LivraisonService;

@RestController
@CrossOrigin("*")
public class LivraisonController {
    @Autowired
    private LivraisonRepository livraisonRepository;
    @Autowired
    private LivraisonService livraisonService;
}
