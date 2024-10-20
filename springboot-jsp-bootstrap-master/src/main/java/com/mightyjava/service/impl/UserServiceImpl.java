package com.mightyjava.service.impl;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mightyjava.model.Role;
import com.mightyjava.model.Users;
import com.mightyjava.repository.RoleRepository;
import com.mightyjava.repository.UserRepository;
import com.mightyjava.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Users> userList() {
		return userRepository.findAll();
	}

	@Override
	public Users findOne(Long id) {
		// Substituindo findOne por findById
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public String addUser(Users user) {
		String message = null;
		JSONObject jsonObject = new JSONObject();
		try {
			if (user.getId() == null) {
				message = "Added";
			} else {
				message = "Updated";
			}

			// Verifica se a senha não é nula antes de codificá-la
			if (user.getPassword() != null && !user.getPassword().isEmpty()) {
				user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			} else {
				throw new IllegalArgumentException("Password cannot be null or empty");
			}

			// Define a role correta para o usuário
			user.setRole(roleRepository.findById(user.getRoleId()).orElse(null));

			jsonObject.put("status", "success");
			jsonObject.put("title", message + " Confirmation");
			jsonObject.put("message", userRepository.save(user).getFullName() + " " + message + " successfully.");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}


	@Override
	public String deleteUser(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			userRepository.deleteById(id);  // Usando deleteById para deletar
			jsonObject.put("message", "User Deleted Successfully.");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	@Override
	public List<Role> roleList() {
		return roleRepository.findAll();
	}
}
