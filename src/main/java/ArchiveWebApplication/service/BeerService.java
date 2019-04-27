package ArchiveWebApplication.service;

import ArchiveWebApplication.model.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BeerService {


    @Autowired
    private IBeer iBeer;

    @Transactional
    public Beer addBeer(Beer beer) {
        Beer tmpBeer = iBeer.save(beer);
        return tmpBeer;
    }

    @Transactional
    public String getBeerName(long id) {
        return iBeer.getBeerById(id).getName();
    }

    @Transactional
    public void deleteBeer(long id) {
        iBeer.delete(id);
    }

    @Transactional(readOnly = true)
    public List<Beer> findAll() {
        return iBeer.findAll();
    }

    @Transactional
    public void updateBeer(Beer beer) {
        iBeer.save(beer);
    }
}
