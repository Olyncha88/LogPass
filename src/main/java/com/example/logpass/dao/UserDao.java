package com.example.logpass.dao;

import com.example.logpass.enteties.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;

import static com.example.logpass.dao.DBConfig.*;

public class UserDao {      // здесь будет работа с DB
    //private final static Map<Long, User> db = new HashMap<>();
    //private static long ID = 1;

    public User save(User user){
        String sql = "INSERT INTO \"user\" (name, login, email) VALUES ('"
                + user.getName() + "','" + user.getLogin() + "','" + user.getEmail() + "');";
        changeDB(sql);
        return user;
    }

    /*public void delete(User user){ //вначале нужно найти User в DB select
        String sql = "DELETE FROM \"user\" WHERE ('"
                + user.getName() + "');";
        changeDB(sql);
    }*/

    /*public User select(User user){ // нужно подумать!!!
        String sql = "SELECT * FROM \"user\" WHERE name = " + user.getName() + ";";
        changeDB(sql);

        return db.get(user.getId());
    }*/

    /*public User update(User user){ //вначале нужно найти User в DB select
        String sql = "UPDATE \"user\" SET (name, login, email) VALUES ('"
                + user.getName() + "','" + user.getLogin() + "','" + user.getEmail() + "');";
        changeDB(sql);
        db.put(user.getId(), user);
        return user;
    }*/

    private void changeDB(String sql) {
        Connection connection;
        Statement statement;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL,USER, PASSWORD);
            statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException |ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    /*public Collection<User> getAll(){
        return db.values();
    }*/

   /* public Optional<User> findUserByEmailAndPassword(User user){
        Collection<User> dbUsers = getAll();
        List<User> filteredUsers = dbUsers.stream().
                filter(u -> u.getEmail().equals(user.getEmail()) &&
                        u.getPassword().equals(user.getPassword())).
                collect(Collectors.toList());
        return filteredUsers.size() > 0 ? Optional.of(filteredUsers.get(0)) : Optional.empty();
    }*/
}
