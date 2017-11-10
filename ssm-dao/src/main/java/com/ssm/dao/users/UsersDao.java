package com.ssm.dao.users;
import org.springframework.stereotype.Repository;

import com.ssm.dao.base.BaseDao;
import com.ssm.model.users.domain.UsersDO;

@Repository
public interface UsersDao extends BaseDao<UsersDO, Integer>{
	
}
