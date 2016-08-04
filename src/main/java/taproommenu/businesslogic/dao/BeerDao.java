package taproommenu.businesslogic.dao;

import org.springframework.stereotype.Repository;
import taproommenu.businesslogic.model.Beer;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BeerDao extends AbstractDao<Beer> {

    public BeerDao(){
        clazz = Beer.class;
    }

    public List<Beer> findAll() {
        return em.createQuery("SELECT b FROM Beer b", Beer.class).getResultList();
    }

    public Beer readByName(Beer beer){
        return (Beer)em.createNativeQuery("SELECT * FROM Beer WHERE name='" + beer.getName()+"'", Beer.class).getResultList().get(0);
    }
}
