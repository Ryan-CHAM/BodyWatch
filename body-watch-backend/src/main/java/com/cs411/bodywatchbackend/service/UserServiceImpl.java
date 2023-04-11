package com.cs411.bodywatchbackend.service;

import com.cs411.bodywatchbackend.model.User;
import com.cs411.bodywatchbackend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUsers(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {

        Optional<User> usersDb = userRepository.findById(user.getUserId());

        if (usersDb.isPresent()) {
            userRepository.save(user);
        }
        else {
            throw new ResourceNotFoundException(
                    "User not found with id: " + user.getUserId()
            );
        }
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {

        Optional<User> usersDb = userRepository.findById(id);

        if (usersDb.isPresent()) {
            return usersDb.get();
        }
        else {
            throw new ResourceNotFoundException(
                    "User not found with id: " + id
            );
        }
    }

    @Override
    public void deleteUser(int id) {

        Optional<User> usersDb = userRepository.findById(id);

        if (usersDb.isPresent()) {
            userRepository.delete(usersDb.get());
        }
        else {
            throw new ResourceNotFoundException(
                    "User not found with id: " + id
            );
        }
    }

    @Override
    public List<Integer> getAllUserId() {
       return userRepository.findAllUserId();
    }

}
