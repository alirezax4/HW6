package Repository;

import Entity.User;
import Service.ApplicationConstant;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public User findUserById(long id) throws SQLException {
        User foundUser = new User();
        PreparedStatement stm = ApplicationConstant.getConnection().prepareStatement("select * from user_table where id = ?");
        stm.setLong(1, id);

        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            foundUser.setId(rs.getLong(1));
            foundUser.setUserName(rs.getString(2));
            foundUser.setNationalCode(rs.getString(3));
            foundUser.setBirthDay(rs.getString(4));
            foundUser.setPassword(rs.getString(5));
        }
        return foundUser;
    }

    public User findUserByUsername(String username) throws SQLException {
        User foundUser = new User();
        PreparedStatement stm = ApplicationConstant.getConnection().prepareStatement("select * from User_table where username = ?");
        stm.setString(1,username);
        ResultSet rs = stm.executeQuery();
        if (rs.next()){
            foundUser.setId(rs.getLong(1));
            foundUser.setUserName(rs.getString(2));
            foundUser.setNationalCode(rs.getString(3));
            foundUser.setBirthDay(rs.getString(4));
            foundUser.setPassword(rs.getString(5));
        }
        return foundUser;




    }

    public User createUser(User user) throws SQLException {
        if (isUsernameExist(user.getUserName())) {
            System.out.println("username already exists");
            return null;
        } else {
            String sql = "insert into user_table(username,nationalcode,birthday,password) values (?,?,?,?)";
            PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getNationalCode());
            ps.setString(3, user.getBirthDay());
            ps.setString(4, user.getPassword());

            ps.executeUpdate();
            if (ps.getGeneratedKeys().next()) {
                user.setId(ps.getGeneratedKeys().getLong(1));
            }
            System.out.println("user created successfully");
            return user;
        }
    }

    public void deleteUser(long id) throws SQLException {
        String sql = "delete from User_table where id = ?";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setLong(1,id);
        int x = ps.executeUpdate();
        if (x==1){
            System.out.println("user delete successfully");
        }

    }

    public void updateUser(long id , User user) throws SQLException {
        String sql = "update user_table set username = ?,nationalcode=?,birthday=?,password=? where id=?";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getNationalCode());
        ps.setString(3, user.getBirthDay());
        ps.setString(4, user.getPassword());
        ps.setLong(5,id);

        int result = ps.executeUpdate();
        if (result==1){
            System.out.println(id+" update is successfully");
        }

    }

    public List<User> findAllUser() throws SQLException {

        List<User> allUser = new ArrayList<>();
        String sql = "select * from user_table";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            while (rs.next()) {
                allUser.add(new User(rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        }else{
            System.out.println("user not exists !!!!");
        }
        return allUser;
    }

    public boolean isUsernameExist(String username) throws SQLException {

        PreparedStatement stm = ApplicationConstant.getConnection().prepareStatement("select * from user_table where username = ?");
        stm.setString(1,username);
        ResultSet rs = stm.executeQuery();
        if(rs.next()){
            System.out.println(username+" already exists");
            return true;
        }else{
            System.out.println("username is correct");
            return false;
        }

    }
}
