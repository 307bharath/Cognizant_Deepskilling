package com.example.productfilter.service;

import com.example.productfilter.model.Product;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;
import jakarta.persistence.criteria.*;

@Service
public class ProductService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<Product> filterProducts(String keyword, Integer minReview, List<Integer> hddSizes,
                                        List<Integer> ramSizes, Double minCpuSpeed, List<String> osList,
                                        Double maxWeight, List<String> cpuList) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> product = cq.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();

        if (keyword != null && !keyword.isEmpty()) {
            predicates.add(cb.like(cb.lower(product.get("name")), "%" + keyword.toLowerCase() + "%"));
        }
        if (minReview != null) {
            predicates.add(cb.ge(product.get("reviewRating"), minReview));
        }
        if (hddSizes != null && !hddSizes.isEmpty()) {
            predicates.add(product.get("hardDiskSize").in(hddSizes));
        }
        if (ramSizes != null && !ramSizes.isEmpty()) {
            predicates.add(product.get("ramSize").in(ramSizes));
        }
        if (minCpuSpeed != null) {
            predicates.add(cb.ge(product.get("cpuSpeed"), minCpuSpeed));
        }
        if (osList != null && !osList.isEmpty()) {
            predicates.add(product.get("os").in(osList));
        }
        if (maxWeight != null) {
            predicates.add(cb.le(product.get("weight"), maxWeight));
        }
        if (cpuList != null && !cpuList.isEmpty()) {
            predicates.add(product.get("cpu").in(cpuList));
        }

        cq.where(cb.and(predicates.toArray(new Predicate[0])));
        return em.createQuery(cq).getResultList();
    }
}
