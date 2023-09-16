package com.app.RentARide.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.app.RentARide.entity.Role;
import com.app.RentARide.entity.User;
import com.app.RentARide.repository.RoleRepository;
import com.app.RentARide.repository.UserRepository;

@Component
public class GoogleOAuth2SuccessHandler implements AuthenticationSuccessHandler{
		@Autowired
		RoleRepository roleRepository;
		@Autowired
		UserRepository userRepository;
		
		private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
		
		@Override
		public void onAuthenticationSuccess(HttpServletRequest httpServletrequest, HttpServletResponse httpServeletresponse,
				Authentication authentication) throws IOException, ServletException {
			
			OAuth2AuthenticationToken token=(OAuth2AuthenticationToken) authentication;
			String email=token.getPrincipal().getAttributes().get("email").toString();
			if(userRepository.findUserByEmail(email).isPresent()) {
				
			}else {
				User user=new User();
				user.setFirstName(token.getPrincipal().getAttributes().get("given_name").toString());
				user.setLastName(token.getPrincipal().getAttributes().get("family_name").toString());
				user.setEmail(email);
				List<Role> roles=new ArrayList<>();
				roles.add(roleRepository.findById(2).get());
				user.setRoles(roles);
				userRepository.save(user);
			}
			redirectStrategy.sendRedirect(httpServletrequest, httpServeletresponse, "/");
		}
		
		
		
}
