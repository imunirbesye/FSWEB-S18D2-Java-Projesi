package tr.com.workintech.s18d2.dto;

import tr.com.workintech.s18d2.entity.Fruit;

public record FruitResponse(String msg, Fruit fruit) {
}
