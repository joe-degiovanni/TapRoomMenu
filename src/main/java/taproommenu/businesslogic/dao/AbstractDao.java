package taproommenu.businesslogic.dao;

import org.springframework.stereotype.Repository;
import taproommenu.businesslogic.model.AbstractEntity;
import taproommenu.businesslogic.model.Beer;
import taproommenu.businesslogic.model.Menu;

import javax.persistence.EntityManager;
import javax.persistence.MappedSuperclass;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@MappedSuperclass
public abstract class AbstractDao<T extends AbstractEntity> {

    protected Class<T> clazz;

    @PersistenceContext
    protected EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public void persist(T object) {
        em.persist(object);
    }

    public abstract List<T> findAll();

    public T read(T object){
        return em.find(clazz, object.getId());
    }

    @Transactional
    public void delete(T object) {
        object = em.find(clazz, object);
        em.remove(object);
    }

    public boolean exists(T object) {
        T found = read(object);
        return (found != null);
    }
}
