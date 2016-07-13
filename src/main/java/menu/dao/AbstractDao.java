package menu.dao;

import menu.model.beer.AbstractRecord;
import menu.model.beer.Beer;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public abstract class AbstractDao<T extends AbstractRecord> {

    protected abstract EntityManager getEntityManager();

    public void persist(T record) {
        getEntityManager().persist(record);
    }

    public abstract List<T> findAll();

    public T read(T record){
        return (T)getEntityManager().find(record.getClass(), record.getId());
    }

}
