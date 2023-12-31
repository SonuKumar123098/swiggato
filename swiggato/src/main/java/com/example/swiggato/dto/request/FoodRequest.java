package com.example.swiggato.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FoodRequest {
    int requiredQuantity;
    String customerMobile;
    int menuId;
}
