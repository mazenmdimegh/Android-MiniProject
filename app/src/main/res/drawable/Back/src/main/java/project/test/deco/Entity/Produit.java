package project.test.deco.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Externalizable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin("*")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomP;
    private  String marque;
    private  String description;
    private  Float prix;
    private  Integer remise;
    private  String categorie;
    private  String imageURL;
    private  Integer qteStock;
    private boolean etat ;



}
