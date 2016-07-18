package menu.dao;

import menu.model.beer.Beer;
import org.hibernate.jpa.criteria.CriteriaBuilderImpl;
import org.hibernate.jpa.criteria.CriteriaQueryImpl;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class BeerDao {

    @PersistenceContext
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public void persist(Beer beer) {
        em.persist(beer);
    }

    public List<Beer> findAll() {
        return em.createQuery("SELECT b FROM Beer b", Beer.class).getResultList();
    }

    public Beer read(Beer beer){
        return em.find(Beer.class, beer.getId());
    }

    public Beer readByName(Beer beer){
        return (Beer)em.createNativeQuery("SELECT * FROM Beer WHERE name='" + beer.getName()+"'", Beer.class).getResultList().get(0);
    }

    @Transactional
    public void delete(Beer beer) {
        beer = em.find(Beer.class, beer.getId());
        em.remove(beer);
    }
}
