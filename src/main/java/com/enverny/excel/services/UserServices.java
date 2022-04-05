package com.enverny.excel.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.enverny.excel.entities.User;
import com.enverny.excel.repositories.UserRepository;

@Service
@Transactional
public class UserServices {

	@Autowired
	private UserRepository userRepo;
	
	public List<User> listAll(){
		return userRepo.findAll(Sort.by("email").ascending());
	}
}
