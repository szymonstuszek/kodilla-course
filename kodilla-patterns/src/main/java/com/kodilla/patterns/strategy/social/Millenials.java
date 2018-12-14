package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;

public class Millenials extends User {

    public Millenials(String name) {
        super(name);
        this.socialPublisher = new SnapchatPublisher();
    }
}
