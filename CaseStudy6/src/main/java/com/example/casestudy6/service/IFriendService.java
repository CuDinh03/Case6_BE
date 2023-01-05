package com.example.casestudy6.service;

import com.example.casestudy6.model.Friends;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IFriendService extends PagingAndSortingRepository< Friends, Long> {
}
