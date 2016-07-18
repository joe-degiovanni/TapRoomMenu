package taproommenu.businesslogic.dao;

import taproommenu.businesslogic.model.Menu;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class MenuDao extends AbstractDao<Menu> {

    public List<Menu> findAll() {
        return em.createQuery("SELECT b FROM Menu b", Menu.class).getResultList();
    }

    public Menu readByName(Menu menu){
        return (Menu)em.createNativeQuery("SELECT * FROM Menu WHERE name='" + menu.getName()+"'", Menu.class).getResultList().get(0);
    }
}
