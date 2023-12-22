package ru.itis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dish {
    private Integer id_dish;
    private String name;
    private Double price;
    public void getDishById(Dish id_dish){

    }
}
