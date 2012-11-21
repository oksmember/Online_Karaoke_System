package com.klok.service;

import com.klok.entity.User;

public interface IUserService {
	public User getUserByName(String name);
	public int login(User user);
}
