package com.example;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    //  Custom JPQL query using @Query
    @Query("SELECT u FROM User u WHERE u.name = :name")
    List<User> searchByName(@Param("name") String name);
}
