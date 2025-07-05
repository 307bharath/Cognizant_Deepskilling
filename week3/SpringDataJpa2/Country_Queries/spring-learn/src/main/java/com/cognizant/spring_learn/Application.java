package com.cognizant.spring_learn;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.repository.CountryRepository;

@SpringBootApplication
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    private static CountryRepository countryRepository;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        countryRepository = context.getBean(CountryRepository.class);

        testFindByPartialName();
        testFindByPartialNameSorted();
        testFindByStartingAlphabet();
         System.exit(0); 
    }

    private static void testFindByPartialName() {
        LOGGER.info("Searching countries containing 'ou' (unsorted):");
        List<Country> countries = countryRepository.findByNameContainingIgnoreCase("ou");
        countries.forEach(c -> LOGGER.debug("→ {}", c));
    }

    private static void testFindByPartialNameSorted() {
        LOGGER.info("Searching countries containing 'ou' (sorted):");
        List<Country> countries = countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc("ou");
        countries.forEach(c -> LOGGER.debug("→ {}", c));
    }

    private static void testFindByStartingAlphabet() {
        LOGGER.info("Searching countries starting with 'Z':");
        List<Country> countries = countryRepository.findByNameStartingWithIgnoreCase("Z");
        countries.forEach(c -> LOGGER.debug("→ {}", c));
    }
}