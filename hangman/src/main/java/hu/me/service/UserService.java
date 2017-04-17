package hu.me.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hu.me.entity.UserEntity;
import hu.me.model.User;

@Service
public interface UserService {

	 Iterable<UserEntity> listAllUser();
	 void newUser(UserEntity newUser);
	 void deleteUser(long id);
	 UserEntity getById(long id);
	 void updateUser(UserEntity user);
}
