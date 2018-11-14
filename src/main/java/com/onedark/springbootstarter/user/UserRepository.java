package com.onedark.springbootstarter.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User,String> {	

}
