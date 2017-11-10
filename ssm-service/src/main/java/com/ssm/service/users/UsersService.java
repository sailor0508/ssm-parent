package com.ssm.service.users;

import com.ssm.model.users.domain.UsersDO;
import com.ssm.service.base.BaseService;

public interface UsersService extends BaseService<UsersDO, Integer> {
	
	int saveUsers(UsersDO usersDO) throws Exception;

}
