package com.cognizant.spring_learn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.CountryService;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@SpringBootApplication
public class Application {
private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	@Autowired
private static CountryService countryService;

private static void getAllCountriesTest() throws CountryNotFoundException {
    LOGGER.info("Start");
    Country country = countryService.findCountryByCode("IN");
    LOGGER.debug("Country: {}", country);
    LOGGER.info("End");
}

private static void testAddCountry() throws CountryNotFoundException {
    Country newCountry = new Country();
    newCountry.setCode("XX");
    newCountry.setName("Xanadu");
    countryService.addCountry(newCountry);

    Country country = countryService.findCountryByCode("XX");
    LOGGER.debug("Added Country: {}", country);
}

private static void testUpdateCountry() throws CountryNotFoundException {
    countryService.updateCountry("XX", "Xenovia");
    Country updated = countryService.findCountryByCode("XX");
    LOGGER.debug("Updated Country: {}", updated);
}

private static void testDeleteCountry() {
    countryService.deleteCountry("XX");
    // Try fetching or check DB manually
}

public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
    countryService = context.getBean(CountryService.class);
    
    try {
        getAllCountriesTest();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();
    } catch (Exception e) {
        e.printStackTrace();
    }
        System.exit(0); // 👉 This line tells the app to exit

}

}
