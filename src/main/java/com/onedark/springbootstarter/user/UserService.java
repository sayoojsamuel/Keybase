package com.onedark.springbootstarter.user;
import com.onedark.springbootstarter.security.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	 
	
	public List<User> getAllUsers() {
		// return topics;
		List<User> users = new ArrayList<>();
		
		userRepository.findAll()
		.forEach(users::add);
		return users;
	}
	
	public User getUser(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return userRepository.findById(id).get();
	}

	public void addUser(User user) {
		//topics.add(topic);
		userRepository.save(user);
	}

	public void updateUser(User user, String id) {
		userRepository.save(user);
	}

	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}

	public String generateKeys(User user, String id) throws NoSuchAlgorithmException, NoSuchProviderException, IOException {
		GenerateKeys secret;
		secret = new GenerateKeys(1024);
		secret.createKeys();
		byte[] secretpub = secret.getPublicKey().getEncoded();
		byte[] secretpriv = secret.getPrivateKey().getEncoded();
		
		user.setPrivkey(new String(secretpub));
		user.setPubkey(new String(secretpriv));
	
		//userRepository.save(user);
		secret.writeToFile("KeyPairs/pubkey_"+id, secretpub);
		secret.writeToFile("KeyPairs/privkey_"+id, secretpriv);
		
		return new String(Base64.getEncoder().encodeToString(secretpub));
		
		
	}
	
	public String getKeys(User user, String id, String password) {
		if (!user.getPassword().equals(password)) {
			return "Password is wrong, sorry no access ";
		}
		String keys = new String();
		try {
			keys += GetKeys.readFromFile("KeyPairs/pubkey_"+id, "Public");
			keys += GetKeys.readFromFile("KeyPairs/privkey_"+id, "Private");
		} catch (IOException e) {
			e.printStackTrace();
			return "Please Generate a public key for this User!";
		}
		
		return keys;
	}

}
