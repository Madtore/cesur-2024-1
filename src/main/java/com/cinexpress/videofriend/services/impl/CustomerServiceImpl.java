package com.cinexpress.videofriend.services.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinexpress.videofriend.models.Company;
import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.PremiumSubscription;
import com.cinexpress.videofriend.models.dtos.CustomerDto;
import com.cinexpress.videofriend.models.dtos.MovieDto;
import com.cinexpress.videofriend.repository.CompanyRepository;
import com.cinexpress.videofriend.repository.CustomerRepository;
import com.cinexpress.videofriend.repository.PremiumSubscriptionRepository;
import com.cinexpress.videofriend.services.CustomerService;
import com.cinexpress.videofriend.utils.mappers.CustomerMapper;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    PremiumSubscriptionRepository premiumSubscriptionRepository;

    @Override
    public void addClientToCompany(Long customerId, Long companyId) {
        Customer customer = customerRepository.findById(customerId).get();
        Optional<Company> company = companyRepository.findById(companyId);
        if(!company.isEmpty()){
            Company updateCompany = company.get();
            updateCompany.getCustomers().add(customer);
            companyRepository.save(updateCompany);
        }
    }

    public List<MovieDto> listAllCustomerMovies(Customer customer) {
    Customer customerEntity = customerRepository.findById(customer.getId())
            .orElseThrow(() -> new NoSuchElementException("Customer not found"));

    List<MovieDto> movieDtos = customerEntity.getMovies().stream()
            .map(movie -> {
                MovieDto movieDto = new MovieDto();
                movieDto.setId(movie.getId());
                movieDto.setTitle(movie.getTitle());
                movieDto.setFormat(movie.getFormat());
                movieDto.setGenre(movie.getGenre());
                movieDto.setLanguage(movie.getLanguage());
                movieDto.setYear(movie.getYear());
                movieDto.setActors(movie.getActors());
                movieDto.setDirector(movie.getDirector());
                movieDto.setAvailability(movie.getAvailability());
                return movieDto; 
            })
            .collect(Collectors.toList());



    return movieDtos;
}

    @Override
    public boolean hasPremiumSubscription(Long customerId) {
        Customer customer = customerRepository.getReferenceById(customerId);
        return customer.getPremiumSubscription().getExclusiveCatalog();
    }

    @Override
    public void deactivatePremiumSubscription(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if(customer.isPresent()){
            Customer niCustomer = customer.get();
            PremiumSubscription premium = new PremiumSubscription();
            premium.setDiscounts(false);
            premium.setExclusiveCatalog(false);
            premium.setPreReleases(false);
            premium.setCustomer(niCustomer);
            premiumSubscriptionRepository.save(premium);
        }
        
    }

    @Override
    public void createCustomer(Customer customer) {

        customerRepository.save(customer);
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).get();
        return CustomerMapper.INSTANCE.toDTO(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        Customer updateCustomer = customerRepository.findById(customer.getId()).get();
        if (customer.getName() != null) {
            updateCustomer.setName(customer.getName());
        }
        if (customer.getType() != null) {
            updateCustomer.setType(customer.getType());
        }
        if (customer.getCompany() != null) {
            updateCustomer.setCompany(customer.getCompany());
        }
        if (customer.getPremiumSubscription() != null) {
            updateCustomer.setPremiumSubscription(customer.getPremiumSubscription());
        }
        customerRepository.save(updateCustomer);
            
    }


    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
    
}
