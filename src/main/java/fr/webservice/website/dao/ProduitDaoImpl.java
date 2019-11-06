package fr.webservice.website.dao;

import fr.webservice.website.model.Produit;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProduitDaoImpl implements ProduitDao{

    public static List<Produit> produits = new ArrayList<>();

    static {
        produits.add(new Produit(1, new String("Souris"), new String("Souris Razer"), 70.0));
        produits.add(new Produit(2, "clavier", "Clavier Logitech", 85.5));
    }

    @Override
    public Produit findById(int id) {
        for(Produit produit : produits) {
            if (produit.getId() == id) {
                return produit;
            }
        }
        return null;
    }

    @Override
    public List<Produit> findAll() {
        return produits;
    }

    @Override
    public Produit save(Produit produit) {
        produits.add(produit);
        return produit;
    }


}

