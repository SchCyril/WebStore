package fr.webservice.microservice.dao;

import fr.webservice.microservice.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao extends JpaRepository<Article, Integer> {
    @Override
    List<Article> findAll();
    Article findById(int id);
}
