package com.sergio.jwt.backend.services;

import com.sergio.jwt.backend.dtos.CredentialsDto;
import com.sergio.jwt.backend.dtos.SignUpDto;
import com.sergio.jwt.backend.dtos.UserDto;
import com.sergio.jwt.backend.entites.Role;
import com.sergio.jwt.backend.entites.User;
import com.sergio.jwt.backend.entites.UserRole;
import com.sergio.jwt.backend.exceptions.AppException;
import com.sergio.jwt.backend.mappers.UserMapper;
import com.sergio.jwt.backend.repositories.RoleRepository;
import com.sergio.jwt.backend.repositories.UserRepo;
import com.sergio.jwt.backend.repositories.UserRepository;
import com.sergio.jwt.backend.repositories.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.CharBuffer;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserRepo userRepo;
    private final RoleRepository roleRepository;
    @Autowired
    public UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.findByUsername(credentialsDto.login());

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto userDto) {
        User optionalUser = userRepository.findByUsername(userDto.login());

//        if (optionalUser.isPresent()) {
//            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
//        }

        User user = userMapper.signUpToUser(userDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.password())));
        User savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }
    public void assignRoleToUser(int userId, String roleName) {
        User user = userRepository.findById(userId);
        Role role = roleRepository.findByName(roleName);

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        userRoleRepository.save(userRole);
    }
    @Transactional
    public User findByUsername(String username) {
        User user = userRepository.findUserAndRolesByUsername(username);

        return user;
    }

}
