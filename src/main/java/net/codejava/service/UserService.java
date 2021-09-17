package net.codejava.service;

import net.codejava.dao.UserRepository;
import net.codejava.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
     @Autowired
  public  UserRepository userRepository;

     public User addUser(User u){
         User u1 = userRepository.save(u);
         return u1;
     }

     public String findUser(String email, String password){

         List<User> listEmail = userRepository.findByEmail(email);
         List<User> listPassword = userRepository.findByPassword(password);
         if(listEmail.isEmpty()||listPassword.isEmpty())
             return "User not find";
         else
             return "Login Sucessfully";
        //return u2.get(0);
     }
     public List<User> getUserByEmail(String email){
         return userRepository.findByEmail(email);
     }
     public Optional<User> getUserById1(Long id){
         return userRepository.findById(id);
     }


}
