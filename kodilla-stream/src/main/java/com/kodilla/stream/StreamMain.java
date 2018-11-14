package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.person.People;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();

        Map<Integer, ForumUser> resultMapOfUsers = forum.getForumUserList().stream()
                .filter(user -> user.getGender() == 'M')
                .filter(user -> user.getDateOfBirth().isBefore(LocalDate.of(1998,11,12)))
                .filter(user -> user.getNumberOfPublishedPosts() > 0)
                .collect(Collectors.toMap(ForumUser::getId, user -> user));

        resultMapOfUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

    }
}
