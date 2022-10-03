package com.padwan.test.controller;

import java.math.BigDecimal;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.padwan.test.service.AngeloService;

@RestController
@RequestMapping("/angelochiarella")
public class AngeloController {

	@Autowired
	private AngeloService angeloService;

	@Autowired
	public AngeloController(AngeloService angeloService) {
		this.angeloService = angeloService;
	}

	@ResponseBody
	@RequestMapping(value = "/skills", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> skills() {
		try {
			JSONObject json = new JSONObject();
			json.put(angeloService.getNome(), angeloService.skills());
			json.accumulate("Status: ", angeloService.status());
			json.accumulate("Mentor: ", angeloService.mentor());
			json.accumulate("Midichlorians : ", angeloService.midichlorians());
			return new ResponseEntity(json.toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
