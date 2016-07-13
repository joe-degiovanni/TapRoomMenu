package menu.dao;

import menu.model.beer.Beer;
import menu.model.beer.Menu;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class MenuDao extends AbstractDao<Menu>{

    @PersistenceContext
    private EntityManager em;


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Menu> findAll() {
        return em.createQuery("SELECT b FROM Menu b", Menu.class).getResultList();
    }

    public Menu readByName(Menu menu){
        return (Menu)em.createNativeQuery("SELECT * FROM Menu WHERE name='" + menu.getName()+"'", Menu.class).getResultList().get(0);
    }

    @Transactional
    public void delete(Menu menu) {
        menu = em.find(Menu.class, menu.getId());
        em.remove(menu);
    }
}
