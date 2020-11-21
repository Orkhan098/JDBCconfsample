import bean.User;
import dao.UserDaoImpl;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDaoImpl userDao = new UserDaoImpl();
//        userDao.removeUser(3);
//        System.out.println(userDao.getAll());
//        User u=new User();
//        u.setId(1);
//        u.setName("Orkhan");
//
//        userDao.updateUser(u);
        User user=new User(0,"Widad","Kchikach","widadkc@gmail.com","+2139898399");
        userDao.addUser(user);
        System.out.println(userDao.getAllData());
    }



}


