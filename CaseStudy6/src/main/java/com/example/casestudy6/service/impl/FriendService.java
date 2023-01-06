package com.example.casestudy6.service.impl;



import com.example.casestudy6.model.Account;
import com.example.casestudy6.model.Friends;
import com.example.casestudy6.repository.IAccountRepoF;
import com.example.casestudy6.repository.IFriendRepo;
import com.example.casestudy6.service.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FriendService implements IFriendService {
    @Autowired
    IFriendRepo iFriendRepo;
    @Autowired
    IAccountRepoF iFriendRepof;
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
    public void blockFriend(long account1, long account2_id) {
        if(iFriendRepo.findMeInList(account1, account2_id)!=null) {
            iFriendRepo.blockFriend(account1, account2_id);
            iFriendRepo.deleteRelationship(account2_id,account1);


        }else {
            Friends friend = new Friends();
            friend.setAccount1(account1);
            friend.setStatus(3);
            Account account2 = iFriendRepof.getFriendToBlock(account2_id);
            friend.setAccount2(account2);
            iFriendRepo.save(friend);
        }

    }
}
