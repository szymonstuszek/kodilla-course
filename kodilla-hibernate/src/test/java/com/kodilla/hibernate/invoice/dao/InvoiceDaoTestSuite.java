package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    public static final String INVOICE_NAME = "TEST_INVOICE";

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product shampoo = new Product("Shampoo");
        Product clock = new Product("Clock");
        Product cookingGuide = new Product("Cooking guide");

        Item item = new Item(new BigDecimal(10), 2, new BigDecimal(20));
        Item item2 = new Item(new BigDecimal(50), 1, new BigDecimal(50));
        Item item3 = new Item(new BigDecimal(30), 1, new BigDecimal(30));

        Invoice invoice = new Invoice(INVOICE_NAME);

        item.setProduct(shampoo);
        item2.setProduct(clock);
        item3.setProduct(cookingGuide);

        invoice.getItems().add(item);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();


        //Then
        Assert.assertNotEquals(0, invoiceId);

        //Cleanup
//        try {
//            invoiceDao.deleteById(invoiceId);
//        }catch (Exception e) {
//            //to implement
//        }
    }
}
