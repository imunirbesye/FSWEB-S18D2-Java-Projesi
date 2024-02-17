package tr.com.workintech.s18d2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tr.com.workintech.s18d2.entity.Fruit;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
    @Query(value = "SELECT f.id, f.name, f.fruit_type, f.price FROM public.fruit as f ORDER BY f.price DESC", nativeQuery = true)
    List<Fruit> getByPriceDesc();

    @Query(value = "SELECT f.id, f.name, f.fruit_type, f.price FROM public.fruit as f ORDER BY f.price ASC", nativeQuery = true)
    List<Fruit> getByPriceAsc();

    @Query("SELECT f FROM Fruit f WHERE f.name ILIKE %:name%")
    List<Fruit> searchByName(String name);

}
