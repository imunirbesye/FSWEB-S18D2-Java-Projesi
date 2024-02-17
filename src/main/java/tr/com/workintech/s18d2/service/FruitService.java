package tr.com.workintech.s18d2.service;

import tr.com.workintech.s18d2.entity.Fruit;

import java.util.List;

public interface FruitService {
    Fruit getById(long id);
    List<Fruit> getByPriceAsc();
    List<Fruit> getByPriceDesc();
    Fruit save(Fruit fruit);
    Fruit delete(long id);
    List<Fruit> searchByName(String name);
}
