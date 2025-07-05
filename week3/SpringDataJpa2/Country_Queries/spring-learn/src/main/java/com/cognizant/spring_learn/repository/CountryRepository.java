package com.cognizant.spring_learn.repository;
import com.cognizant.spring_learn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
     // Part 1 – Matching countries containing a substring (case-insensitive)
    List<Country> findByNameContainingIgnoreCase(String keyword);

    // Part 2 – Same query, but results sorted alphabetically
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String keyword);

    // Part 3 – Countries starting with a specific letter (case-insensitive)
    List<Country> findByNameStartingWithIgnoreCase(String prefix);

}