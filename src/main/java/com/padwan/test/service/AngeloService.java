package com.padwan.test.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.padwan.test.entities.Warrior;
import com.padwan.test.enums.StatusEnum;

@Service
public class AngeloService {

	Warrior angelo = new Warrior(2L, "Angelo Chiarella", StatusEnum.JEDI, "João Alcides", 10.102f, skills());

	public List<String> skills() {
		List<String> skills = new ArrayList<>();
		skills.addAll(Arrays.asList("Java", "SQL", "HTML", "CSS", "Js"));
		return skills;
	}

	public String mentor() {
		return angelo.getMentor();
	}

	public String status() {
		return angelo.getStatus().toString();
	}

	public String getNome() {
		return angelo.getNome();
	}

	public Float midichlorians() {
		return angelo.getMidichlorians();
	}
}
