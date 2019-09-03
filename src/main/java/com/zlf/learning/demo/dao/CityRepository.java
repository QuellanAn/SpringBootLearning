package com.zlf.learning.demo.dao;

import com.zlf.learning.demo.domain.City;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName CityRepository
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2019/7/26 17:59
 * @Version 1.0
 */

@Repository
public class CityRepository {

    private ConcurrentMap<Long,City> repository =new ConcurrentHashMap<>();
    private static final AtomicLong idGenerator =new AtomicLong(0);


    public Long save(City city){
        Long id=idGenerator.incrementAndGet();
        city.setId(id);
        repository.put(id,city);
        return id;
    }

    public Collection<City> findAll(){
        return repository.values();
    }

    public City findById(Long id){
        return repository.get(id);
    }


    public Long updateCity(City city){
        repository.put(city.getId(),city);
        return city.getId();
    }

    public Long deleteCity(Long id){
        repository.remove(id);
        return id;
    }













}
