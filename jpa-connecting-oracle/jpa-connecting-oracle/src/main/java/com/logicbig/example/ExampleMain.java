package com.logicbig.example;

import javax.persistence.*;
import java.util.List;

public class ExampleMain {
    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("example-unit");

    public static void main(String[] args) {
        try {
            findAllEmployeeEntities();
        } finally {
            entityManagerFactory.close();
        }
    }

    private static void findAllEmployeeEntities() {
        System.out.println("-- finding Person entities -  --");
        EntityManager em = entityManagerFactory.createEntityManager();
        TypedQuery<Person> query = em.createQuery("SELECT p from Person p", Person.class);
        List<Person> resultList = query.getResultList();
        resultList.forEach(System.out::println);
        em.close();
    }
}