package menu.service;

import menu.dao.BeerDao;
import menu.dao.MenuDao;
import menu.model.beer.Beer;
import menu.model.beer.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class MenuService {

    @Autowired
    private MenuDao menuDao;
    private boolean loaded = false;

    @Transactional
    public void add(Menu menu){
        menuDao.persist(menu);
    }

    @Transactional
    public void addAll(List<Menu> menus){
        for(Menu menu : menus){
            menuDao.persist(menu);
        }
    }

    public void delete(Menu menu){
        menuDao.delete(menu);
    }

    public Menu read(Menu menu){
        return menuDao.read(menu);
    }

    public Menu readByName(Menu menu){
        return menuDao.readByName(menu);
    }

    public void addFirstMenu(){
        Menu menu = new Menu();
        menu.setName("first");
        menuDao.persist(menu);
    }

    @Transactional
    public List<Menu> listAll() {
        if(!loaded){
            addFirstMenu();
            loaded = true;
        }
        return menuDao.findAll();
    }
}
