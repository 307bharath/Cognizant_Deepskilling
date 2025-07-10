
package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
public class CountryController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/country")
    public Country getCountryIndia() {
        return (Country) context.getBean("in");
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return (List<Country>) context.getBean("countryList");
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        List<Country> countries = (List<Country>) context.getBean("countryList");
        return countries.stream()
            .filter(c -> c.getCode().equalsIgnoreCase(code))
            .findFirst()
            .orElseThrow(() -> new com.cognizant.spring_learn.service.exception.CountryNotFoundException("Country not found"));
    }
}
