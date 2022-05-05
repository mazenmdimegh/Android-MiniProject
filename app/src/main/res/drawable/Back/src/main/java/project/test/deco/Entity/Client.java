package project.test.deco.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id ;
    public String nom;
    public  String prenom;
    public  String adresse;
    public  Integer tel;
    public  String mail;
    public  String password;
    public Integer ncin;
    @ManyToMany()
    public List<Produit> panier = new ArrayList<>();



}

