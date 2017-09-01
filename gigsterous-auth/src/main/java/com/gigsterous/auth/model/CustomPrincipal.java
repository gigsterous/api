package com.gigsterous.auth.model;

import java.security.Principal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomPrincipal implements Principal {

	private String username;

	@Override
	public String getName() {
		return username;
	}

}
