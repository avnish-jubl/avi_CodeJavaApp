package net.codejava.dao;


//import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByEmail (String email);
    public List<User> findByPassword (String password);
//    public Optional<User> findById(int id);
    public List<User> findAllById(Long Id);

}

