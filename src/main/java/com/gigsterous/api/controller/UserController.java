package com.gigsterous.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gigsterous.api.model.User;
import com.gigsterous.api.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

  private static final Logger log = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserRepository userRepo;

  /**
   * Returns all users in JSON/XML.
   * 
   * @return JSON/XML representation of the User list
   */
  @RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = MediaType.ALL_VALUE)
  public List<User> getUsers() {
    log.debug("Retrieving list of all users.");

    return userRepo.findAll();
  }

  /**
   * Returns user based on id.
   * 
   * @return JSON/XML representation of the User object
   */
  @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = MediaType.ALL_VALUE)
  public User getUser(@PathVariable long id) {
    log.debug("Retrieving a user with id {}.", id);

    return userRepo.findOne(id);
  }

  /**
   * Create new user.
   * 
   * @return created User
   */
  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public User createUser(@RequestBody User user) {
    log.debug("Creating new user.");

    return userRepo.save(user);
  }

  /**
   * Delete user with specified id.
   */
  @RequestMapping(value = "{id}", method = RequestMethod.DELETE, consumes = MediaType.ALL_VALUE)
  public void deleteUser(@PathVariable long id) {
    log.debug("Deleteting user with id {}.", id);

    userRepo.delete(id);
  }

}
