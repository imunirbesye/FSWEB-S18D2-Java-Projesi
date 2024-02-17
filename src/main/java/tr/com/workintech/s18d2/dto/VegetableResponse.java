package tr.com.workintech.s18d2.dto;

import tr.com.workintech.s18d2.entity.Vegetable;

public record VegetableResponse(String msg, Vegetable vegetable) {
}
