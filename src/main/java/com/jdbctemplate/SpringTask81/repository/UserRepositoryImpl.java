package com.jdbctemplate.SpringTask81.repository;

import com.jdbctemplate.SpringTask81.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String Insert_User_Query = "INSERT INTO USER (name,age,address,email) VALUES (?,?,?,?)";
    private static final String Delete_User_Query = "DELETE FROM USER WHERE id=?";
    private static final String Update_User_Query = "UPDATE USER SET name=?,age=?,address=?,email=? WHERE id=?";
    private static final String Find_User_Query = "SELECT * FROM USER WHERE name=?";
    private static final String Find_All_User_Query = "SELECT * FROM USER";
    private static final String Find_User_By_Id = "SELECT * FROM USER WHERE id=?";

    @Autowired
    private JdbcTemplate template;

    @Override
    public int save(User user) {

      return template.update(Insert_User_Query, user.getName(), user.getAge(), user.getAddress(), user.getEmail());
    }

    @Override
    public User findById(Integer id) {
       return template.queryForObject(Find_User_By_Id,(rs,rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            user.setAddress(rs.getString("address"));
            user.setEmail(rs.getString("email"));
            return user;
        },id);
    }

    @Override
    public User findByName(String name) {
        return template.queryForObject(Find_User_Query,(rs,rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            user.setAddress(rs.getString("address"));
            user.setEmail(rs.getString("email"));
            return user;
        },name);
    }

    @Override
    public int update(User user) {
        return template.update(Update_User_Query, user.getName(), user.getAge(), user.getAddress(), user.getEmail(),user.getId());
    }

    @Override
    public int delete(Integer id) {
        return template.update(Delete_User_Query, id);

    }

    @Override
    public List<User> findAll() {
        return template.query(Find_All_User_Query,(rs,rowNum)->{
            User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                return user;
        });
    }
}
