package com.rhuangal.springreactiveexample.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private Long _id;
    @NonNull private String name;
    @NonNull private BigDecimal price;
    private String description;
    private String imageUrl;

}
