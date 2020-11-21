package dao;

import bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl extends ConnectionDao implements UserDao {



    @Override
    public List<User> getAllData() throws SQLException, ClassNotFoundException {
        List<User> result = new ArrayList<>();
        try {
            Connection c = (Connection) connectToDb();
            Statement stmt = c.createStatement();
            stmt.execute("select * from user");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                result.add(new User(id, name, surname, email, phone));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }


        @Override
        public boolean updateUser(User u) {

            try {
               Connection c = (Connection) connectToDb();
                PreparedStatement stmt= c.prepareStatement("update user set name=? where id=?");
                stmt.setString(1,u.getName());
                stmt.setInt(2,u.getId());
                return stmt.execute();
            }
            catch (Exception ex){
                ex.printStackTrace();
                return false;
            }
        }

        @Override
        public boolean deleteUser(int id){
            try {
                Connection c = (Connection) connectToDb();
                Statement stmt1 = c.createStatement();
                return stmt1.execute("delete from user where id=" + id);
            }
            catch (Exception ex){
                ex.printStackTrace();
                return false;
            }
        }

    @Override
    public boolean addUser(User u) {
        try( Connection c = (Connection) connectToDb();){ //try with resource

            PreparedStatement stmt= c.prepareStatement("insert into user(name,surname,email,phone) values(?,?,?,?)");
            stmt.setString(1,u.getName());
            stmt.setString(2,u.getSurname());
            stmt.setString(3,u.getEmail());
            stmt.setString(4,u.getPhone());

            return stmt.execute();

        }
        catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}
