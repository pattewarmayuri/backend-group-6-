package com.example.healthcare;

import com.example.healthcare.entities.User;
import com.example.healthcare.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Rollback(value = true)
public class UserTest {

    @Autowired
    UserService userService;

    @Test
    public void addUserTestPass(){
       User user=new User("Mahesh","password");
       User user2=new User("Rajesh","pass");
        Assert.assertEquals(user,userService.addUser(user));
        Assert.assertEquals(user2,userService.addUser(user2));
    }
    @Test
    public void addUserTestFails(){
        User user2=new User("mahesh",null);
        User user3=new User(null,"Mahesh");
        Assert.assertEquals(user2,userService.addUser(user2));
        Assert.assertEquals(user3,userService.addUser(user3));
    }

    @Test
    public  void validateTestPass(){
        User user=new User("admin","password");
        User user2=new User("demo","demo");
        Assert.assertEquals(user,userService.validateUser("admin","password"));
        Assert.assertEquals(user2,userService.validateUser("demo","demo"));
    }
    @Test
    public  void validateTestFail(){
        User user=new User("","password");
        User user2=new User("demo","demo");
        Assert.assertEquals(user,userService.validateUser("admi","password"));
        Assert.assertEquals(user2,userService.validateUser("dem","demo"));
    }
    @Test
    public void validateUserNotFoundException(){
        User user=new User("ad","pass");
        Assert.assertEquals(user,userService.validateUser("ad","pass"));

    }

}
