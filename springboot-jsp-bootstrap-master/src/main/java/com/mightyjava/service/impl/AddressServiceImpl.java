package com.mightyjava.service.impl;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mightyjava.model.Address;
import com.mightyjava.model.Users;
import com.mightyjava.repository.AddressRepository;
import com.mightyjava.repository.UserRepository;
import com.mightyjava.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	private AddressRepository addressRepository;
	private UserRepository userRepository;

	@Autowired
	public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository) {
		this.addressRepository = addressRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<Address> addressList() {
		return addressRepository.findAll();
	}

	@Override
	public Address findOne(Long id) {
		// Substituindo findOne por findById e usando orElse para evitar Optional vazio
		return addressRepository.findById(id).orElse(null);
	}

	@Override
	public String addAddress(Address address) {
		String message = null;
		JSONObject jsonObject = new JSONObject();
		try {
			if (address.getId() == null) {
				message = "Added";
			} else {
				message = "Updated";
			}
			// Substituindo findOne por findById para o UserRepository
			Users user = userRepository.findById(address.getUserId()).orElse(null);
			if (user != null) {
				address.setUser(user);
				addressRepository.save(address);
				jsonObject.put("status", "success");
				jsonObject.put("title", message + " Confirmation");
				jsonObject.put("message", "Address for " + user.getFullName() + " " + message + " successfully.");
			} else {
				jsonObject.put("status", "error");
				jsonObject.put("message", "User not found.");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	@Override
	public String deleteAddress(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			// Substituindo delete por deleteById
			addressRepository.deleteById(id);
			jsonObject.put("message", "Address Deleted Successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

}
