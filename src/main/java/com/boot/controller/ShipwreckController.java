package com.boot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Shipwreck;
import com.boot.rep.ShipwreckRepository;

@RestController
@RequestMapping("/api/v1/")
public class ShipwreckController {
	
	@Autowired
	private ShipwreckRepository shipRepository;

	@RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
	public List<Shipwreck> list() {
		return shipRepository.findAll();
	}

	@RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck shipwreck) {
		return shipRepository.saveAndFlush(shipwreck);
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
	public Shipwreck get(@PathVariable("id") Long id) {
		return shipRepository.findOne(id);
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
	public Shipwreck update(@PathVariable("id") Long id,
			@RequestBody Shipwreck shipwreck) {
		Shipwreck existingShip = shipRepository.findOne(id);
		BeanUtils.copyProperties(shipwreck, existingShip);
		return shipRepository.saveAndFlush(existingShip);
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
	public Shipwreck delete(@PathVariable("id") Long id) {
		Shipwreck existingShip = shipRepository.findOne(id);
		shipRepository.delete(existingShip);
		return existingShip;
	}
}
