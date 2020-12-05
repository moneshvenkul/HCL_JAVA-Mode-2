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
import com.pack.ServerSide.models.Hangars;
import com.pack.ServerSide.models.Pilots;
import com.pack.ServerSide.models.Planes;
import com.pack.ServerSide.models.Role;
import com.pack.ServerSide.models.User;
import com.pack.ServerSide.payload.request.LoginRequest;
import com.pack.ServerSide.payload.request.SignupRequest;
import com.pack.ServerSide.payload.response.JwtResponse;
import com.pack.ServerSide.payload.response.MessageResponse;
import com.pack.ServerSide.repository.PlanesRepository;
import com.pack.ServerSide.repository.PilotsRepository;
import com.pack.ServerSide.repository.RoleRepository;
import com.pack.ServerSide.repository.UserRepository;
import com.pack.ServerSide.repository.HangarRepository;
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
	PlanesRepository planesRepository;
	
	@Autowired
	PilotsRepository pilotsRepository;
	
	@Autowired
	HangarRepository hangarsRepository;

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
		
		
		System.out.println(signUpRequest.getFirstname());
		String strRoles = signUpRequest.getRole();
		System.out.println(strRoles);
		
		Set<Role> roles = new HashSet<>();
		
		System.out.println(strRoles);

		if (strRoles == null) {
			System.out.println("inside null");
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else if (strRoles.equals("admin")) {
			System.out.println("inside else");
			
			Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(adminRole);
	
		}
		else {
			
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			System.out.println("inside user "+strRoles);
			roles.add(userRole);
			
		}
		
		
		
		
		
//		strRoles.forEach(role -> {
//			System.out.println("inside not null");
//			switch (role) {
//			case "admin":
//				Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
//						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//				roles.add(adminRole);
//
//				break;
//			default:
//				Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//				System.out.println("inside user");
//				roles.add(userRole);
//			}
//		});
//		
		System.out.println("outside");
		
		
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
	  
	  @PostMapping(value = "/planes")
	  public ResponseEntity<Planes> postPlanes(@RequestBody Planes planes) {
	    try {
	      Planes _planes = planesRepository.save(new Planes(planes.getName(), planes.getModel()));
	      return new ResponseEntity<>(_planes, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	  
	  @GetMapping("/planes")
	  public ResponseEntity<List<Planes>> getAllPlanes() {
	    List<Planes> planes = new ArrayList<Planes>();
	    try {
	    	planesRepository.findAll().forEach(planes::add);
	     
	      if (planes.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(planes, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @DeleteMapping("/planes")
	  public ResponseEntity<HttpStatus> deleteAllPlanes() {
	    try {
	    	planesRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }

	  }
	 @GetMapping("/planes/{id}")
	  public ResponseEntity<Planes> getPlanesById(@PathVariable("id") long id) {
	    Optional<Planes> planesData = planesRepository.findById(id);

	    if (planesData.isPresent()) {
	      return new ResponseEntity<>(planesData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	 
	 @PutMapping(value = "/planes/update")
	  public Planes updatePlanes(@RequestBody Planes planes) {
	      System.out.println("Into update");
	    System.out.println("into update"+planes.getId()+" "+planes.getName());
	    Planes plane = new Planes(planes.getId(),planes.getName(),planes.getModel());
	         Planes plane1 = planesRepository.save(plane);
	    return plane1;
	  }
	 
	  @DeleteMapping("/planes/{id}")
	  public ResponseEntity<HttpStatus> deletePlanes(@PathVariable("id") long id) {
	    try {
	    	planesRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	  
	  @PostMapping(value = "/pilots")
	  public ResponseEntity<Pilots> postCustomer(@RequestBody Pilots pilots) {
	    try {
	      Pilots _pilots = pilotsRepository.save(new Pilots(pilots.getPilotname(), pilots.getModel()));
	      return new ResponseEntity<>(_pilots, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	  
	  @GetMapping("/pilots")
	  public ResponseEntity<List<Pilots>> getAllPilots() {
	    List<Pilots> pilots = new ArrayList<Pilots>();
	    try {
	    	pilotsRepository.findAll().forEach(pilots::add);
	     
	      if (pilots.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(pilots, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @DeleteMapping("/pilots")
	  public ResponseEntity<HttpStatus> deleteAllPilots() {
	    try {
	    	pilotsRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }

	  }
	 @GetMapping("/pilots/{id}")
	  public ResponseEntity<Pilots> getPilotsById(@PathVariable("id") long id) {
	    Optional<Pilots> pilotsData = pilotsRepository.findById(id);

	    if (pilotsData.isPresent()) {
	      return new ResponseEntity<>(pilotsData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	 
	 @PutMapping(value = "/pilots/update")
	  public Pilots updatePilots(@RequestBody Pilots pilots) {
	      System.out.println("Into update");
	    System.out.println("into update"+pilots.getId()+" "+pilots.getPilotname());
	    Pilots pilot = new Pilots(pilots.getId(),pilots.getPilotname(),pilots.getModel());
	         Pilots pilot1 = pilotsRepository.save(pilot);
	    return pilot1;
	  }
	 
	  @DeleteMapping("/pilots/{id}")
	  public ResponseEntity<HttpStatus> deletePilots(@PathVariable("id") long id) {
	    try {
	    	pilotsRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	  
	  @PostMapping(value = "/hangars")
	  public ResponseEntity<Hangars> postHangars(@RequestBody Hangars hangars) {
	    try {
	      Hangars _hangars = hangarsRepository.save(new Hangars(hangars.getHangarname(), hangars.getModel()));
	      return new ResponseEntity<>(_hangars, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	  
	  @GetMapping("/hangars")
	  public ResponseEntity<List<Hangars>> getAllHangars() {
	    List<Hangars> hangars = new ArrayList<Hangars>();
	    try {
	    	hangarsRepository.findAll().forEach(hangars::add);
	     
	      if (hangars.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(hangars, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @DeleteMapping("/hangars")
	  public ResponseEntity<HttpStatus> deleteAllHangars() {
	    try {
	    	hangarsRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }

	  }
	 @GetMapping("/hangars/{id}")
	  public ResponseEntity<Hangars> getHangarsById(@PathVariable("id") long id) {
	    Optional<Hangars> hangarsData = hangarsRepository.findById(id);

	    if (hangarsData.isPresent()) {
	      return new ResponseEntity<>(hangarsData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	 
	 @PutMapping(value = "/hangars/update")
	  public Hangars hangarsPlanes(@RequestBody Hangars hangars) {
	      System.out.println("Into update");
	    System.out.println("into update"+hangars.getId()+" "+hangars.getHangarname());
	    System.out.println(hangars.getPlaneallocated());
	    Hangars hangar = new Hangars(hangars.getId(),hangars.getHangarname(),hangars.getModel(),hangars.getPlaneallocated());
	    
	         Hangars hangar1 = hangarsRepository.save(hangar);
	    return hangar1;
	  }
	 
	  @DeleteMapping("/hangars/{id}")
	  public ResponseEntity<HttpStatus> deleteHangars(@PathVariable("id") long id) {
	    try {
	    	hangarsRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	  
	  
	  
	
	
}
