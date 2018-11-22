package com.kodilla.exception.nullpointer;

import sun.plugin2.message.Message;

public class NullPointerExceptionRunnter {
    public static void main(String[] args) {
        User user = null;

        MessageSender messageSender = new MessageSender();

        try {
            messageSender.sendMessageTo(user, "Hello!");
        } catch (MessageNotSentException e) {
            System.out.println("Message is not sent but the program is still working!");
        }
        System.out.println("Processing other logic!");
    }
}
