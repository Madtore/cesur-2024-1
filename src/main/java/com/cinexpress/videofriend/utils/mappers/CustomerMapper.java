package com.cinexpress.videofriend.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.dtos.CustomerDto;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "company", ignore = true)
    CustomerDto toDTO(Customer customer);

    
    
    
    
}
