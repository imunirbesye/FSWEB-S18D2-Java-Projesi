package tr.com.workintech.s18d2.controller;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tr.com.workintech.s18d2.dto.FruitResponse;
import tr.com.workintech.s18d2.entity.Fruit;
import tr.com.workintech.s18d2.service.FruitService;

import java.util.List;

@Validated
@RestController
@RequestMapping("/fruit")
public class FruitController {

    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> findAll() {
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public FruitResponse get(@Positive @PathVariable long id) {

        return new FruitResponse("find by succeed", fruitService.getById(id));
    }

    @GetMapping("/desc")
    public List<Fruit> findAllDesc() {
        return fruitService.getByPriceDesc();
    }

    @PostMapping
    public Fruit save(@Validated @RequestBody Fruit f) {
        return fruitService.save(f);
    }

    @GetMapping("/search/{name}")
    public List<Fruit> searchByName(@Size(min = 2, max = 45) @PathVariable String name) {
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@Positive @PathVariable long id) {
        return fruitService.delete(id);
    }
}
