package com.moviebuff.mongodb.application.service;

import com.moviebuff.mongodb.application.entity.User;

public interface UserService {
	User save(User user);

	User findByEmail(String email);

}
