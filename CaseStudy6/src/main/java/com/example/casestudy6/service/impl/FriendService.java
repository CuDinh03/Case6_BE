package com.example.casestudy6.service.impl;



import com.example.casestudy6.model.Account;
import com.example.casestudy6.model.DTO.FriendList;
import com.example.casestudy6.model.Friends;
import com.example.casestudy6.repository.IAccountRepoF;
import com.example.casestudy6.repository.IFriendRepo;
import com.example.casestudy6.service.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FriendService implements IFriendService {
    @Autowired
    IFriendRepo iFriendRepo;
    @Autowired
    IAccountRepoF iFriendRepof;
    List<FriendList> listFriend ;
    List<FriendList> listMutualFriend;
    @Override
    public List<FriendList> getAll(String account1) {

        listFriend = new ArrayList<FriendList>();
        List<Friends> list = iFriendRepo.getAllFriends(account1);
        for (int i = 0; i < list.size(); i++) {
            FriendList friendList = new FriendList();
            friendList.setId(list.get(i).getAccount2().getId());
            friendList.setFistName(list.get(i).getAccount2().getFistName());
            friendList.setAddress(list.get(i).getAccount2().getAddress());
            friendList.setImg(list.get(i).getAccount2().getImg().getName());
            friendList.setLastName(list.get(i).getAccount2().getLastName());
            friendList.setGender(list.get(i).getAccount2().getGender());
            friendList.setBirthDay(list.get(i).getAccount2().getBirthDay());
            friendList.setPhoneNumber(list.get(i).getAccount2().getPhoneNumber());
            listFriend.add(friendList);
        }
        return listFriend ;
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

    @Override
    public List<FriendList> getMutualFriend(long account1, long account2_id) {
        listMutualFriend = new ArrayList<FriendList>();
        List<Friends> list1=  iFriendRepo.getAllFriendsOfAccount1(account1);
        List<Friends> list2=  iFriendRepo.getAllFriendsOfAccount2(account2_id);

        iFriendRepo.getAllFriendsOfAccount2(account2_id);
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).getAccount2().getId()==list2.get(j).getAccount2().getId()){
                    FriendList friendList = new FriendList();
                    friendList.setId(list1.get(i).getAccount2().getId());
                    friendList.setFistName(list1.get(i).getAccount2().getFistName());
                    friendList.setAddress(list1.get(i).getAccount2().getAddress());
                    friendList.setImg(list1.get(i).getAccount2().getImg().getName());
                    friendList.setLastName(list1.get(i).getAccount2().getLastName());
                    friendList.setGender(list1.get(i).getAccount2().getGender());
                    friendList.setBirthDay(list1.get(i).getAccount2().getBirthDay());
                    friendList.setPhoneNumber(list1.get(i).getAccount2().getPhoneNumber());


                    listMutualFriend.add(friendList);
                }
            }
        }
        return listMutualFriend;
    }

    @Override
    public FriendList getAccountByUserName(String name) {
        FriendList friendList = new FriendList();

        friendList.setId(iFriendRepof.findAccountByUserName(name).getId());
        friendList.setFistName(iFriendRepof.findAccountByUserName(name).getFistName());
        friendList.setLastName(iFriendRepof.findAccountByUserName(name).getLastName());
        friendList.setAddress(iFriendRepof.findAccountByUserName(name).getAddress());
        friendList.setPhoneNumber(iFriendRepof.findAccountByUserName(name).getPhoneNumber());
        friendList.setBirthDay(iFriendRepof.findAccountByUserName(name).getBirthDay());
        friendList.setGender(iFriendRepof.findAccountByUserName(name).getGender());
        friendList.setImg(iFriendRepof.findAccountByUserName(name).getImg().getName());

        return friendList;
    }
}
