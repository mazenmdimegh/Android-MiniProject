package project.test.deco.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import project.test.deco.Repository.FactureRepository;
import project.test.deco.Services.FactService;

@RestController
@CrossOrigin("*")
public class FactureController {
    @Autowired
    private FactureRepository factureRepository;
    @Autowired
    private FactService factService;
}
