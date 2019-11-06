package fr.webservice.website.controller;

import fr.webservice.website.dao.ProduitDao;
import fr.webservice.website.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitController {

    @Autowired
    private ProduitDao produitDao;

    @GetMapping(path = "/Produits")
    public List<Produit> getAllProduits() {
        return produitDao.findAll();
    }

    @GetMapping(path = "/Produits/{id}")
    public Produit getProduit(@PathVariable int id) {
        return produitDao.findById(id);
    }

    @PostMapping(value = "/Produits")
    public void addProduit(@RequestBody Produit produit) {
        produitDao.save(produit);
    }
}
