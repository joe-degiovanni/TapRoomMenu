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
        return em.createQuery("SELECT b FROM Beer b", Beer.class).getResultList();
    }

    public Beer read(Beer beer){
        return em.createQuery("SELECT b FROM Beer b where id="+beer.getId(),Beer.class).getSingleResult();
    }

    public Beer readByName(Beer beer){
        return (Beer)em.createNativeQuery("SELECT * FROM Beer WHERE name='" + beer.getName()+"'", Beer.class).getResultList().get(0);
    }

}
