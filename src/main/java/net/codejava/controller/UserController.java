
package net.codejava.controller;

        import net.codejava.entity.User;
        import net.codejava.dao.UserRepository;
        import net.codejava.service.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
        import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    public UserService userService;

    @PostMapping("/saveuser")
    public User viewHomePage(@RequestBody User user) {

        User saveUser=userService.addUser(user);
        System.out.println(user.getPassword());
        return saveUser;
    }

    @GetMapping("/login")
    public String loginUser(@RequestBody User user){
//        if(userService.findUser(user.getEmail()))
//            return true;
//        else
//            return false;
        String status =  userService.findUser(user.getEmail(),user.getPassword());
        return status;

    }
//    @GetMapping("/getuser")
//    public List<User> getTheUser(@RequestBody User user){
//        return userService.getUserByEmail(user.getEmail());
//
//    }
    @GetMapping("/getuser/email/{email}")
    public List<User> getTheUser(@PathVariable("email") String email){
        return userService.getUserByEmail(email);

    }
    @GetMapping("/getuser/id/{id}")
    public Optional<User> getTheUser1(@PathVariable("id") Long id){
        System.out.println(id);
//        System.out.println(userService.getUserById1(id));
        return userService.getUserById1(id);
        //return "hi";

    }
    @PostMapping("/getuser/id")
    public Optional<User> getTheUser1(@RequestBody User user){

        return userRepo.findById(user.getId());
        //return "hi";

    }
    @GetMapping("/alluser")
    public List<User> getAllUser(){
        return userRepo.findAll();
    }
    @GetMapping("/alluserbyid/{id}")
    public List<User> getAllUserbyid(@PathVariable("id") Long id){
        return userRepo.findAllById(id);
    }

    //update

    @PutMapping("/updateuser")
    public User updateTheUser(@RequestBody User user){
         User user1 = userRepo.save(user);
         return user;
    }

    @DeleteMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable Long id){
        userRepo.deleteById(id);
        return  "User Deleted Successfully";

    }


}