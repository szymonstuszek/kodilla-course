package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQueries({

        @NamedNativeQuery(
                name = "Company.retrieveCompanyStartingWith",
                query = "SELECT * FROM COMPANIES WHERE COMPANY_NAME LIKE CONCAT(LEFT (:COMPANY_NAME, 3), '%')",
                resultClass = Company.class

        ),
//        @NamedNativeQuery(
//                name = "Company.retrieveCompanyStartingWith",
//                query = "SELECT * FROM COMPANIES WHERE COMPANY_NAME = :COMPANY_NAME",
//                resultClass = Company.class
//
//        ),
})

@Entity
@Table(name = "COMPANIES")
public class Company {
    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Company(){}

    public Company(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    private void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}