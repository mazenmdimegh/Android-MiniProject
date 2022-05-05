package project.test.deco.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Ligne_commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer Code_LCmd ;
    public Integer Code_Cmd;
    public Integer id_produit;
    public float prix_produit;
    public Integer qte;
    public float prix_total;
}