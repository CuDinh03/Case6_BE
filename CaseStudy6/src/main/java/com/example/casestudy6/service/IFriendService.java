package com.example.casestudy6.service;

import java.util.List;

import com.example.casestudy6.model.dto.FriendList;
import com.example.casestudy6.model.Friends;
public interface IFriendService {
    List<FriendList> getAll(String account1);
    void addFriend(long account1, long account2_id);
    void acceptRequest(long account1, long account2_id);
    void removeFriend(Friends friend);
    List<Friends> findFriendsByName(String name);
    void blockFriend(long account1, long account2_id);
    List<FriendList> getMutualFriend(long account1, long account2_id);
    FriendList getAccountByUserName(String name);
    FriendList getAccountById(long id);

}
