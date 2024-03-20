package com.example.demo.repositiry;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.User;



@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	public Optional<User> findUserByMailAndPwd(String mail, String pwd);
}