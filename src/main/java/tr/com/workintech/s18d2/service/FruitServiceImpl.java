package tr.com.workintech.s18d2.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tr.com.workintech.s18d2.entity.Fruit;
import tr.com.workintech.s18d2.exceptions.PlantException;
import tr.com.workintech.s18d2.repository.FruitRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {

    private FruitRepository fruitRepository;

    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit getById(long id) {
        Optional<Fruit> optionalFruit = fruitRepository.findById(id);
        if(optionalFruit.isPresent()) {
            return optionalFruit.get();
        }

        if(id < 0)
            throw new PlantException("Given id can not be below 0: " + id, HttpStatus.BAD_REQUEST);

        throw new PlantException("Plant with given id is not exist: " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public Fruit save(Fruit fruit) {
        if(fruit.getName().isEmpty() || fruit.getFruitType().toString().isEmpty() || fruit.getPrice() < 0) {
            throw new PlantException("Given information is missing", HttpStatus.BAD_REQUEST);
        }

        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit delete(long id) {
        Fruit fruit = getById(id);
        fruitRepository.delete(fruit);
        return fruit;
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }
}
