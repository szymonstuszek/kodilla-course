package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CompanyDaoTestSuite {

    public static final String COMPANY_SEARCH_STRING = "Software Machine Engineering";

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testRetrieveByLastNameQuery() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");

        employeeDao.save(johnSmith);
        int employeeId = johnSmith.getId();

        //When
        List<Employee> retrievedEmployees = employeeDao.retrieveByLastname("Smith");
        Employee retrievedEmployee = retrievedEmployees.get(0);
        String retrievedLastname = retrievedEmployee.getLastname();

        //Then
        Assert.assertEquals("Smith", retrievedLastname);
        Assert.assertEquals(1, retrievedEmployees.size());

        //Cleanup
        employeeDao.deleteById(employeeId);
    }

    @Test
    public void testFindCompaniesStartingWith() {
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        List<Company> companies = companyDao.retrieveCompanyStartingWith(COMPANY_SEARCH_STRING);

        //Then
        Assert.assertEquals(1, companies.size());

        //CleanUp
        try{
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {

        }
    }

    @Test
    public void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarkson = new Employee("Stephanie", "Clarkson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarkson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarkson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
//        try{
//            companyDao.deleteById(softwareMachineId);
//            companyDao.deleteById(dataMaestersId);
//            companyDao.deleteById(greyMatterId);
//        } catch (Exception e) {
//
//        }
    }
}
