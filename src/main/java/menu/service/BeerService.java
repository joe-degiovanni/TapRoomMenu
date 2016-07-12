package menu.service;

import menu.dao.BeerDao;
import menu.model.beer.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class BeerService {

    @Autowired
    private BeerDao beerDao;
    private boolean loaded = false;

    @Transactional
    public void add(Beer beer){
        beerDao.persist(beer);
    }

    @Transactional
    public void addAll(List<Beer> beers){
        for(Beer beer : beers){
            beerDao.persist(beer);
        }
    }

    public Beer read(Beer beer){
        return beerDao.read(beer);
    }

    public void addFirstBeer(){
        Beer beer = new Beer();
        beer.setId(1);
        beer.setName("first");
        beerDao.persist(beer);
    }

    @Transactional
    public List<Beer> listAll() {
        if(!loaded){
            addFirstBeer();
        }
        return beerDao.findAll();
    }
}
