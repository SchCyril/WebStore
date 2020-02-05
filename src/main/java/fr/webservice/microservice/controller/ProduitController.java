package fr.webservice.microservice.controller;

import fr.webservice.microservice.dao.ProduitDao;
import fr.webservice.microservice.exceptions.UnfindableProduct;
import fr.webservice.microservice.model.Produit;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProduitController {

    private final ProduitDao produitDao;

    public ProduitController(ProduitDao produitDao) {
        this.produitDao = produitDao;
    }

    @GetMapping(path = "/Produits")
    public List<Produit> getAllProduits() {
        return produitDao.findAll();
    }

    @GetMapping(path = "/Produit/{id}")
    public Produit getProduit(@PathVariable int id) {
        Produit produit = produitDao.findById(id);

        if (produit == null) throw new UnfindableProduct(String.format("Le produit avec l'id %s est introuvable", id));
        return produit;
    }

    @PostMapping(value = "/Produits")
    public void addProduit(@RequestBody Produit produit) {
        produitDao.save(produit);
    }

    @DeleteMapping(value = "/Produit/{id}")
    public void deleteProduit(@PathVariable int id) {
        produitDao.deleteById(id);
    }

    @PutMapping(value = "/Produits")
    public void updateProduit(@RequestBody Produit produit) {
        produitDao.save(produit);
    }
}
