package ArchiveWebApplication.controller;

import ArchiveWebApplication.model.Beer;
import ArchiveWebApplication.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BeerController {
    @Autowired
    BeerService service;

    @RequestMapping(value = "/beer", method = RequestMethod.GET)
    public String beer(Model model) {
        List<Beer> beerList = service.findAll();
        for (Beer beer : beerList) {
            System.out.println(beer.toString());
        }
        model.addAttribute("beerList", beerList);
        return "beer";
    }


    @RequestMapping(value = "/beer", method = RequestMethod.POST)
    public String addBeer(@RequestParam(value = "name") String name,
                          @RequestParam(value = "alcoholPercent") double alcoholPercent,
                          Model model) {

        System.out.println("beer POST method...");
        if (!name.isEmpty()) {
            System.out.println("Beer is not empty");
            Beer beer = new Beer();
            beer.setName(name);
            beer.setAlcoholPercent(alcoholPercent);
            service.addBeer(beer);
            return beer(model);

        } else {
            System.out.println("NO BEER!");
            model.addAttribute("mess", "No beer !!!");
            return "beer";
        }
    }

    @RequestMapping(value = "/beer", method = RequestMethod.DELETE)
    public String deleteBeer(@PathVariable("beerId") long id, Model model) {
        service.deleteBeer(id);
        return beer(model);
    }

    @RequestMapping(value = "/beer", method = RequestMethod.PUT)
    public String updateBeer(@PathVariable("beerId") long id,
                             @PathVariable("name") String name,
                             @PathVariable("alcoholPercent") double alcoholPercent,
                             Model model) {

        Beer beer = new Beer();
        beer.setId(id);
        beer.setName(name);
        beer.setAlcoholPercent(alcoholPercent);

        service.updateBeer(beer);
        return beer(model);
    }

}
