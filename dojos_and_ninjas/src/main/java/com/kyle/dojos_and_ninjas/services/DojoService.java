package com.kyle.dojos_and_ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyle.dojos_and_ninjas.models.Dojo;
import com.kyle.dojos_and_ninjas.repos.DojoRepo;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepo dojoRepo;
	
	
	//CREATE
	public Dojo createDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	//READ ALL
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	//SHOW ONE
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}


}
