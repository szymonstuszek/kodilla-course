package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyFacadeTests {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;


    @Test
    public void shouldRetriveEmployee() {
        //Given
        Employee michael = new Employee("Michael", "Stone");

        employeeDao.save(michael);
        int employeeId = michael.getId();

        //When
        List<Employee> retrievedEmployees = employeeDao.retrieveByNameContaining("ton");
        Employee retrievedEmployee = retrievedEmployees.get(0);
        String retrievedLastname = retrievedEmployee.getLastname();

        //Then
        Assert.assertEquals("Stone", retrievedLastname);

        //Cleanup
        employeeDao.deleteById(employeeId);
    }

    @Test
    public void shouldRetrieveCompany() {
        //Given
        Company company = new Company("Southwestern");
        companyDao.save(company);
        int id = company.getId();

        //When
        List<Company> companies = companyDao.retrieveCompanyContaining("wester");


        //Then
        Assert.assertEquals(1, companies.size());

        //Cleanup
        companyDao.delete(company);
    }
}
