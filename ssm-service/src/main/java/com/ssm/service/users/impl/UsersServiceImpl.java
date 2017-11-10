package com.ssm.service.users.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.users.UsersDao;
import com.ssm.model.users.domain.UsersDO;
import com.ssm.service.base.impl.BaseServiceImpl;
import com.ssm.service.users.UsersService;

@Service
public class UsersServiceImpl extends BaseServiceImpl<UsersDO, Integer> implements UsersService{

	@Autowired
	UsersDao usersDao;
	
	@Override
	public int saveUsers(UsersDO usersDO) throws Exception {
		usersDao.save(usersDO);
		//int i = 1/0;
		return usersDO.getId();
	}

}
