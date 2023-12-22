package ru.itis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishItem {
    private String id;
    private String name;//наименование товара
    private BigDecimal price;//цена за единицу товара
    private Integer num;//Количество покупок
}
