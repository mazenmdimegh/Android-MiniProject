package project.test.deco.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Commande {
    @Id
    public Integer idCmd;
    public  Integer idClient;
    public Date CmdDate;
    public String clientName;
    public Float TotalCmd;
    @ManyToMany()
    public List<Produit> comm = new ArrayList<>();
}
