package fr.webservice.website.dao;

import fr.webservice.website.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitDao extends JpaRepository<Produit, Integer> {
    Produit findById(int id);
}
