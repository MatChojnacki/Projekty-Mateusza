package com.kodilla.stream.forumUser;
import com.kodilla.stream.immutable.ForumUser;

import java.util.ArrayList;
import java.util.List;

public class Forum {
    private List<ForumUsers> userList;

    public Forum() {
        this.userList = new ArrayList<>();
    }

    public void addUser(ForumUsers user) {
        userList.add(user);
    }

    public List<ForumUsers> getUserList() {
        return userList;
    }
}