package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum() {
        forumUserList.add(new ForumUser(1, "Johny",
                'M', LocalDate.of(2000, 3, 15), 44));
        forumUserList.add(new ForumUser(2, "Megan",
                'F', LocalDate.of(1990, 12, 2), 414));
        forumUserList.add(new ForumUser(3, "Alicia",
                'F', LocalDate.of(1990, 4, 15), 10));
        forumUserList.add(new ForumUser(4, "Kenny",
                'M', LocalDate.of(1990, 10, 11), 60));
        forumUserList.add(new ForumUser(5, "Marc",
                'M', LocalDate.of(1990, 8, 9), 300));
        forumUserList.add(new ForumUser(6, "Michael",
                'M', LocalDate.of(1990, 8, 9), 0));
    }

    public List<ForumUser> getForumUserList() {
        return new ArrayList<>(forumUserList);
    }
 }
