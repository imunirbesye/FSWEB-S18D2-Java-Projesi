package tr.com.workintech.s18d2.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tr.com.workintech.s18d2.entity.Vegetable;
import tr.com.workintech.s18d2.exceptions.PlantException;
import tr.com.workintech.s18d2.repository.VegetableRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService {

    private VegetableRepository vegetableRepository;

    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public Vegetable getById(long id) {
        Optional<Vegetable> optionalVegetable = vegetableRepository.findById(id);
        if(optionalVegetable.isPresent()) {
            return optionalVegetable.get();
        }

        if(id < 0)
            throw new PlantException("Given id can not be below 0: " + id, HttpStatus.BAD_REQUEST);

        throw new PlantException("Plant with given id is not exist: " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        if(vegetable.getName().isEmpty() || vegetable.getPrice() < 0) {
            throw new PlantException("Given information is missing", HttpStatus.BAD_REQUEST);
        }

        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable delete(long id) {
        Vegetable vegetable = getById(id);
        vegetableRepository.delete(vegetable);
        return vegetable;
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }
}
