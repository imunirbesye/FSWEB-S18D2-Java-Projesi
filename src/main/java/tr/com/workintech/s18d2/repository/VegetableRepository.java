package tr.com.workintech.s18d2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tr.com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {
    @Query(value = "SELECT v.id, v.name, v.is_grown_on_tree, v.price FROM public.vegetable as v ORDER BY v.price DESC", nativeQuery = true)
    List<Vegetable> getByPriceDesc();

    @Query(value = "SELECT v.id, v.name, v.is_grown_on_tree, v.price FROM public.vegetable as v ORDER BY v.price ASC", nativeQuery = true)
    List<Vegetable> getByPriceAsc();

    @Query("SELECT f FROM Fruit f WHERE f.name ILIKE %:name%")
    List<Vegetable> searchByName(String name);
}
