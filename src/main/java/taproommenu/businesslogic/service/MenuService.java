package taproommenu.businesslogic.service;

import taproommenu.businesslogic.dao.BeerDao;
import taproommenu.businesslogic.dao.MenuDao;
import taproommenu.businesslogic.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuDao menuDao;
    @Autowired
    private BeerDao beerDao;
    private boolean loaded = false;

    @Transactional
    public void add(Menu menu){
        menuDao.persist(menu);
    }

    @Transactional
    public void update(Menu menu) {
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
        menu.setName("first menu");
        menu.setBeerList(beerDao.findAll());
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

    public boolean exists(Menu menu) {
        return menuDao.exists(menu);
    }
}
