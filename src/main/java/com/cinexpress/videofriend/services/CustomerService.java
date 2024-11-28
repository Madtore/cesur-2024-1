package com.cinexpress.videofriend.services;

import java.util.List;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.dtos.CustomerDto;
import com.cinexpress.videofriend.models.dtos.MovieDto;

public interface CustomerService {
    void createCustomer(Customer customer);
    void addClientToCompany(Long customerId, Long companyId);
    List<MovieDto> listAllCustomerMovies(Customer customer);
    boolean hasPremiumSubscription(Long customerId);
    void deactivatePremiumSubscription(Long customerId);
    CustomerDto getCustomerById(Long id);
    void updateCustomer(Customer customer);
    void deleteCustomer(Long id);

}
