package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserIService;
@RestController
public class UserController {
	
	@Autowired
	private UserIService uService;
	
	@GetMapping("/getusers")
	public List<User> GetUsers() {
		return uService.getUsers();
	}
	
	@GetMapping("/Userbymailandpwd/{mail}/{pwd}")
	public Optional<User> getUserBymailandpwd(@PathVariable String mail, @PathVariable String pwd) {
		return uService.getUserBymailandpwd(mail, pwd);
	}
	
	@PostMapping("/inscri-user")
	public User addUser(@RequestBody User user) {
		return uService.addUser(user);
	}
	/*public ResponseEntity<String> registerUser(@Valid @RequestBody InscriEtudDto studentDto) {
        User user = convertDtoToUser(studentDto);
        uService.addUser(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
	public String postMethodName(@RequestBody String entity) {		
		return entity;
	}
	@PostMapping("/inscri-etud")
	public ResponseEntity<String> registerUser(@Valid @RequestBody InscriEtudDto studentDto, BindingResult result) {
        if (result.hasErrors()) {
            // If there are validation errors, return error response
            return ResponseEntity.badRequest().body("Validation errors: Verify your fields!");
        }

        User user = convertDtoToUser(studentDto);
        uService.addUser(user);
        return ResponseEntity.ok("User registered successfully");
    }
    private User convertDtoToUser(InscriEtudDto studentDto) {
        User user = new User();
        // Set user properties from DTO
        user.setFirstName(studentDto.getFirstName());
		user.setLastName(studentDto.getLastName());
		user.setDateNaissance((Date) studentDto.getDateNaissance());
		user.setEduLevel(studentDto.getEduLevel());
		user.setEtablissement(studentDto.getEtablissement());
		user.setMail(studentDto.getMail());
		user.setTel(studentDto.getTel());
		user.setGenre(studentDto.getGenre());
		user.setPwd(studentDto.getPwd());
		user.setSignInDate((Date) studentDto.getSignInDate());
		user.setDescription(studentDto.getDescription());
		user.setImage(studentDto.getImage());
		user.setRole("etudiant");
        // Set other properties similarly
        return user;
	
	}
	@PostMapping("/inscri-emp")
	public ResponseEntity<String> registerUser(@Valid @RequestBody InscriEmpDto empDto, BindingResult result) {
        if (result.hasErrors()) {
            // If there are validation errors, return error response
            return ResponseEntity.badRequest().body("Validation errors: Verify your fields!");
        }

        User user = convertDtoToUser(empDto);
        uService.addUser(user);
        return ResponseEntity.ok("User registered successfully");
    }
    private User convertDtoToUser(InscriEmpDto emptDto) {
        User user = new User();
        // Set user properties from DTO
        user.setFirstName(emptDto.getFirstName());
		user.setLastName(emptDto.getLastName());
		user.setDateNaissance((Date) emptDto.getDateNaissance());
		user.setMail(emptDto.getMail());
		user.setTel(emptDto.getTel());
		user.setGenre(emptDto.getGenre());
		user.setPwd(emptDto.getPwd());
		user.setSignInDate((Date) emptDto.getSignInDate());
		user.setDescription(emptDto.getDescription());
		user.setImage(emptDto.getImage());
		user.setRole("employeur");
        return user;
	
	}*/
	
}
