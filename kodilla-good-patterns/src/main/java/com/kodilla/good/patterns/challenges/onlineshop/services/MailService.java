package com.kodilla.good.patterns.challenges.onlineshop.services;

import com.kodilla.good.patterns.challenges.onlineshop.model.User;

public class MailService implements InfoService {

    @Override
    public void sendInformation(User user) {
        System.out.println("Sending mail to user.");
    }
}
