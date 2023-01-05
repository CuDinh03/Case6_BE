package com.example.casestudy6.service.impl;




import com.example.casestudy6.model.Friends;
import com.example.casestudy6.repository.IFriendRepo;
import com.example.casestudy6.service.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FriendService implements IFriendService {
    @Autowired
    IFriendRepo iFriendRepo;
    @Override
    public List<Friends> getAll(String account1) {
        return iFriendRepo.getAllFriends(account1) ;
    }

    @Override
    public void addFriend(Friends friend) {

    }

    @Override
    public void removeFriend(Friends friend) {

    }

    @Override
    public List<Friends> findFriendsByName(String name) {
        return null;
    }

    @Override
    public void blockFriend(Friends friend) {

    }
}
