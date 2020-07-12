package com.hoodwink.hoodwinkbreweryclient.web.client;

import com.hoodwink.hoodwinkbreweryclient.web.model.BeerDto;
import com.hoodwink.hoodwinkbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    // Beer
    @Test
    void getBeerById() {

        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());

        assertNotNull(beerDto);
    }

    @Test
    void saveNewBeer() {

        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        URI uri = breweryClient.saveNewBeer(beerDto);

        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void updateBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        breweryClient.updateBeer(UUID.randomUUID(),beerDto);
    }

    @Test
    void deleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }

    // Custoer
    @Test
    void getCustomerById() {
        CustomerDto customerDto = breweryClient.getCustomerById(UUID.randomUUID());

        assertNotNull(customerDto);
    }

    @Test
    void saveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("KJ").build();

        URI uri = breweryClient.saveNewCustomer(customerDto);
        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void updateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("KJ").build();
        breweryClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomer() {
        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}