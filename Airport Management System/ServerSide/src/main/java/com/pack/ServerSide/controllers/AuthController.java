package com.pack.ServerSide.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.pack.ServerSide.models.ERole;
import com.pack.ServerSide.models.Role;
import com.pack.ServerSide.models.User;
import com.pack.ServerSide.payload.request.LoginRequest;
import com.pack.ServerSide.payload.request.SignupRequest;
import com.pack.ServerSide.payload.response.JwtResponse;
import com.pack.ServerSide.payload.response.MessageResponse;
import com.pack.ServerSide.repository.RoleRepository;
import com.pack.ServerSide.repository.UserRepository;
import com.pack.ServerSide.security.jwt.JwtUtils;
import com.pack.ServerSide.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getFirstname(), signUpRequest.getLastname(), signUpRequest.getAge(),
				signUpRequest.getGender(), signUpRequest.getPhonenumber(), signUpRequest.getUsername(),
				signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	

	
	
	@GetMapping("/users")
	  public ResponseEntity<List<User>> getAllUsers() {
	    List<User> users = new ArrayList<User>();
	    try {
	    	userRepository.findAll().forEach(users::add);
	     
	      if (users.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(users, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	 @DeleteMapping("/users")
	  public ResponseEntity<HttpStatus> deleteAllUsers() {
	    try {
	    	userRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }

	  }
	 @GetMapping("/users/{id}")
	  public ResponseEntity<User> getUsersById(@PathVariable("id") long id) {
	    Optional<User> userData = userRepository.findById(id);

	    if (userData.isPresent()) {
	      return new ResponseEntity<>(userData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	 
	 @PutMapping(value = "/users/update")
	  public User updateUsers(@RequestBody User user) {
	      System.out.println("Into update");
	    System.out.println("into update"+user.getId()+" "+user.getFirstname());
	    User users = new User(user.getId(),user.getFirstname(),user.getLastname(),user.getAge(),user.getGender(),user.getPhonenumber(),user.getUsername(),user.getEmail(),user.getPassword(),user.getRoles());
	         User user1 = userRepository.save(users);
	    return user1;
	  }
	 
	  @DeleteMapping("/users/{id}")
	  public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
	    try {
	    	userRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	
	
}
