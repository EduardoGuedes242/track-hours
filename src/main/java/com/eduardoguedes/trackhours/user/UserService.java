package com.eduardoguedes.trackhours.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public void createOrUpdateUser(UserEntity user) {
    userRepository.save(user);
  }

  public List<UserEntity> listAllUsers() {
    return userRepository.findAll();
  }

}
