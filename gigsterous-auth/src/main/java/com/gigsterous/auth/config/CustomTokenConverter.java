package com.gigsterous.auth.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import com.gigsterous.auth.domain.User;

import lombok.extern.slf4j.Slf4j;

/**
 * Custom JWT token in which additional information can be stored. For example add the user's ID to each token.
 */
@Slf4j
public class CustomTokenConverter extends JwtAccessTokenConverter {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		log.debug("Enhancing access token: {}", accessToken.toString());
		
		Map<String, Object> info = new LinkedHashMap<>(accessToken.getAdditionalInformation());

		info.put("user_id", ((User) authentication.getPrincipal()).getId());

		DefaultOAuth2AccessToken customAccessToken = new DefaultOAuth2AccessToken(accessToken);
		customAccessToken.setAdditionalInformation(info);
		return super.enhance(customAccessToken, authentication);
	}
}