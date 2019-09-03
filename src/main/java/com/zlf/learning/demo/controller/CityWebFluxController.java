package com.zlf.learning.demo.controller;

import com.zlf.learning.demo.dao.CityRepository;
import com.zlf.learning.demo.domain.City;
import com.zlf.learning.demo.handler.CityHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @ClassName CityWebFluxController
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2019/7/29 9:01
 * @Version 1.0
 */


@RestController
@RequestMapping("/city")
public class CityWebFluxController {

    @Autowired
    private CityHandler cityHandler;


    @GetMapping(value="/{id}")
    public Mono<City> findCityById(@PathVariable("id") Long id){
        return cityHandler.findCitybyId(id);
    }

    @GetMapping()
    public Flux<City > findAllCity(){
        return cityHandler.findAllCity();
    }

    @PostMapping()
    public Mono<Long > save(@RequestBody City city){
        return cityHandler.save(city);
    }


    @PutMapping()
    public Mono<Long > motifyCity(@RequestBody City city){
        return cityHandler.modifyCity(city);

    }

    @DeleteMapping(value = "/{id}")
    public Mono<Long > deleteCity(@PathVariable("id") Long id){
        return cityHandler.deleteCity(id);
    }

}
