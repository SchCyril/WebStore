package fr.webservice.microservice.dao;

import fr.webservice.microservice.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitDao extends JpaRepository<Produit, Integer> {
    Produit findById(int id);
}
