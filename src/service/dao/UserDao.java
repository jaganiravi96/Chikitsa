package service.dao;

import java.util.ArrayList;

import model.User;

public interface UserDao {
	
	public User userLogin(User u);
	public String createUser(User u);
	public void deleteUser(String id);
	public void updateUser(String id, User u);
	public User getUser(String id);
	public ArrayList<User> getAllUser();

}
