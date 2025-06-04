package com.alten.ecommerce.controller.mapper;

import com.alten.ecommerce.controller.dto.LoginResponseDTO;
import com.alten.ecommerce.controller.dto.ProductDTO;
import com.alten.ecommerce.controller.payload.response.LoginResponse;
import com.alten.ecommerce.storage.model.Product;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IControllerMapper {

    ProductDTO toProductDTO(Product product);

    LoginResponseDTO toLoginResponseDTO(LoginResponse loginResponse);
}