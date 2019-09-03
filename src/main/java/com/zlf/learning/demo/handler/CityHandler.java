package com.zlf.learning.demo.handler;

import com.zlf.learning.demo.dao.CityRepository;
import com.zlf.learning.demo.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @ClassName CityHandler
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2019/7/26 14:13
 * @Version 1.0
 */

@Component
public class CityHandler {

    private final CityRepository cityRepository;


    @Autowired
    public CityHandler(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Mono<Long> save(City city){
        return Mono.create(cityMonoSink ->cityMonoSink.success(cityRepository.save(city)));
    }

    public Mono<City>findCitybyId(Long id){
        return Mono.justOrEmpty(cityRepository.findById(id));
    }


    public Flux<City> findAllCity(){
        return Flux.fromIterable(cityRepository.findAll());
    }


    public Mono<Long > modifyCity(City city){
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityRepository.updateCity(city)));
    }


    public Mono<Long > deleteCity(Long id){
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityRepository.deleteCity(id)));
    }

    public Mono<ServerResponse> helloCity(ServerRequest request){
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello City"));
    }




}
