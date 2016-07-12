package menu.dao;

import menu.model.beer.Beer;
import org.hibernate.jpa.criteria.CriteriaBuilderImpl;
import org.hibernate.jpa.criteria.CriteriaQueryImpl;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

@Component
public class BeerDao {

    @PersistenceContext
    private EntityManager em;

    public void persist(Beer beer) {
        em.persist(beer);
    }

    public List<Beer> findAll() {
        List<Beer> beers = new ArrayList<Beer>();
        try {
            beers.addAll(em.createQuery("SELECT b FROM Beer b", Beer.class).getResultList());
        } catch (NullPointerException npe) {
            // fine
        }
        return beers;
    }

    public Beer read(Beer beer){
        return em.createQuery("SELECT b FROM Beer b where id="+beer.getId(),Beer.class).getSingleResult();
    }

}
