package dao;

import bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public List<User> getAllData() throws SQLException, ClassNotFoundException;
    public boolean updateUser(User user);
    public boolean addUser(User user);
    public boolean deleteUser(int id);
    public User getById(int id);
}
