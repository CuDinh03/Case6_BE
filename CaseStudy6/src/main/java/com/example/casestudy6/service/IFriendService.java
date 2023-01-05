package com.example.casestudy6.service;

import java.util.List;
import com.example.casestudy6.model.Friends;
public interface IFriendService {
    List<Friends> getAll(String account1);
    void addFriend(Friends friend);
    void removeFriend(Friends friend);
    List<Friends> findFriendsByName(String name);
    void blockFriend(Friends friend);

}
