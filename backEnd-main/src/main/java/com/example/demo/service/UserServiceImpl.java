package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.User;
import com.example.demo.repositiry.UserRepo;

//import DTO.InscriEtudDto;

@Service
public class UserServiceImpl implements UserIService {

	@Autowired
	private UserRepo uRepository;
	
	@Override
	public List<User> getUsers() {	
		return uRepository.findAll();
	}

	@Override
	public User addUser(User user) {
		return uRepository.save(user);
	}

	@Override
	public Optional<User> getUserBymailandpwd(String mail, String pwd) {
		return uRepository.findUserByMailAndPwd(mail, pwd);
	}
	/*@Transactional
	public User saveEtud(InscriEtudDto etud) {
		return uRepository.save(etud);
	}*/
	@Override
	public User updateUser(Long idUser,User updatedUser)
	{
	// Vérifie si l'offre existe dans la base de données
	 User existingUser = uRepository.findById(idUser)
		.orElseThrow(() -> new EntityNotFoundException("User avec l'ID : " + idUser +" est non trouvée "));
// Log existing Offre details for verification
System.out.println("Existing User Details:");
System.out.println(existingUser.toString());
// Remplace tous les détails de l'utilisateur existante par ceux de user mise à jour
existingUser.setFirstName(updatedUser.getFirstName());
existingUser.setLastName(updatedUser.getLastName());
existingUser.setDateNaissance(updatedUser.getDateNaissance());
existingUser.setMail(updatedUser.getMail());
existingUser.setImage(updatedUser.getImage());
existingUser.setEduLevel(updatedUser.getEduLevel()); 
existingUser.setEtablissement(updatedUser.getEtablissement()); 
existingUser.setTel(updatedUser.getTel()); 
existingUser.setGenre(updatedUser.getGenre()); 
existingUser.setPwd(updatedUser.getPwd()); 
existingUser.setDescription(updatedUser.getDescription());
// Log updated Offre details for verification
System.out.println("Updated user Details:");
System.out.println(existingUser.toString());

// Sauvegarde de l'offre mise à jour
User savedUser = uRepository.save(existingUser);

// Log saved Offre details for verification
System.out.println("SavedUser Details:");
System.out.println(savedUser.toString());

return savedUser;
	}
}