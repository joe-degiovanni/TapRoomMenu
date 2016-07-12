package menu.dao;

import menu.model.beer.Beer;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class BeerDao {

    @PersistenceContext
    private EntityManager em;

    public void persist(Beer beer) {
        em.persist(beer);
    }

    public List<Beer> findAll() {
        return em.createQuery("SELECT * FROM Beer").getResultList();
    }

}
