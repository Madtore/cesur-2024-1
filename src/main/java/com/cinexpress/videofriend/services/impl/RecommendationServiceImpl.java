package com.cinexpress.videofriend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.Recommendation;
import com.cinexpress.videofriend.models.dtos.CustomerDto;
import com.cinexpress.videofriend.repository.RecommendationRepository;
import com.cinexpress.videofriend.services.CustomerService;
import com.cinexpress.videofriend.services.RecommendationService;

@Service
public class RecommendationServiceImpl implements RecommendationService{

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Autowired
    private CustomerService customerService;

    @Override
    public void addRecomendation(Recommendation recommendation) {
        recommendationRepository.save(recommendation);
    }

    @Override
    public List<Recommendation> getCustomerRecomendations(Long idCustomer) {
        CustomerDto customer = customerService.getCustomerById(idCustomer);
        return null;
    }
    
}
