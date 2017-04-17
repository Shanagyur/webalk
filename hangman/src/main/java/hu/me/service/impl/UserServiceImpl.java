package hu.me.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import hu.me.entity.UserEntity;
import hu.me.model.User;
import hu.me.repository.UserRepository;
import hu.me.service.UserService;

@Service
public class UserServiceImpl implements UserService {

//		private List<User> users = new ArrayList<>();
	
		UserRepository userReposirtory;
		
		public UserServiceImpl(UserRepository userRepository) {
			super();
			this.userReposirtory = userRepository;
		}
		
		public Iterable<UserEntity> listAllUser() {
			return userReposirtory.findAll();
		}
		
		public void newUser(UserEntity newUser) {
			userReposirtory.save(newUser);
		}
		
		public void deleteUser(long id) {
			userReposirtory.delete(id);
		}

		@Override
		public UserEntity getById(long id) {
			return userReposirtory.findOne(id);
		}

		@Override
		public void updateUser(UserEntity user) {
			UserEntity modifiedUser = getById(user.getId());
			modifiedUser.setFirstname(user.getFirstname());
			modifiedUser.setLastname(user.getLastname());
			userReposirtory.save(modifiedUser);
		}
		
/*		@PostConstruct
		void initUserList() {
			users.add(new User("béla", 0));
			users.add(new User("anna", 1));
			users.add(new User("kata", 2));
		}
*/
}
