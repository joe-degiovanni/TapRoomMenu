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

    @Transactional
    public List<Beer> listAll() {
        return beerDao.findAll();

    }
}
