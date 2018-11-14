package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String textToBeautify, PoemDecorator poemDecorator) {
        String textAfterBeautification = poemDecorator.decorate(textToBeautify);
        System.out.println(textAfterBeautification);
    }
}
