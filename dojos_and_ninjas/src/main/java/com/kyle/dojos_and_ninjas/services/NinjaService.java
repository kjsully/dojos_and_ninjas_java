package com.kyle.dojos_and_ninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyle.dojos_and_ninjas.models.Ninja;
import com.kyle.dojos_and_ninjas.repos.NinjaRepo;

@Service
public class NinjaService {

	@Autowired
	private NinjaRepo ninjaRepo;
	
	
	//CREATE
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	//READ ALL
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
	
	//

}
