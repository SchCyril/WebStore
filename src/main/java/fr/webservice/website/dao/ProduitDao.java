package fr.webservice.website.dao;

import fr.webservice.website.model.Produit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitDao {
    Produit findById(int id);
    List<Produit> findAll();
    Produit save(Produit produit);
}
