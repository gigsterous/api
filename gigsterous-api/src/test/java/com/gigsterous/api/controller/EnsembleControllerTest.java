package com.gigsterous.api.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.gigsterous.api.model.Ensemble;
import com.gigsterous.api.model.enums.EnsembleType;
import com.gigsterous.api.repository.EnsembleRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EnsembleController.class, secure = false)
public class EnsembleControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private EnsembleRepository ensembleRepo;

	private Ensemble testEnsemble;

	@Before
	public void init() {
		testEnsemble = new Ensemble();
		testEnsemble.setId(1l);
		testEnsemble.setName("Rockers");
		testEnsemble.setEnsembleType(EnsembleType.BAND);
	}

	@Test
	public void responseOkEnsembleTest() throws Exception {
		given(this.ensembleRepo.findOne(1l)).willReturn(testEnsemble);
		mvc.perform(get("/ensembles/1").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.name", is("Rockers")))
				.andExpect(jsonPath("$.ensembleType", is("BAND")));
	}
	
	@Test
	public void responseNotFoundEnsembleTest() throws Exception {
		mvc.perform(get("/ensembles/2").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isNotFound());
	}
	
	@Test
	public void responseOkEnsemblesTest() throws Exception {
		mvc.perform(get("/ensembles").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
	}

}
