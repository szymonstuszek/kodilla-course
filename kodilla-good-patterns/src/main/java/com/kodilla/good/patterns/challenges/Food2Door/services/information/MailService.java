package com.kodilla.good.patterns.challenges.Food2Door.services.information;


public class MailService implements InfoService {

    @Override
    public void sendOrderStatusInformation(boolean isSuccessful) {

        if(isSuccessful) {
            System.out.println("Order has been placed successfully.");
        } else {
            System.out.println("Error while placing order.");
        }
    }
}
