package project.test.deco.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.test.deco.Repository.AdminRepository;
import project.test.deco.Services.AdminService;
import java.util.List;
@RestController
@CrossOrigin("*")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AdminService adminService;

}
