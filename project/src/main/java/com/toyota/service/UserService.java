package com.toyota.service;

import com.toyota.dao.UserRepository;
import com.toyota.domain.User;
import com.toyota.dto.UserDTO;
import com.toyota.security.UserPrincipal;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.*;

@Service
public class UserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       User user = userRepository.findByEmail(s).get();
        return new UserPrincipal(user.getId(),user.getName(),user.getUsername(),user.getEmail(),user.getPassword(),null);
    }

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers()
    {
        Type listType = new TypeToken<List<UserDTO>>(){}.getType();
        return modelMapper.map(userRepository.findAll(),listType);
    }

    public UserDTO authenticate(String email, String password)
    {

        User user = userRepository.authenticate(email,password);
        if(user==null)
            return null;

        UserDTO obj= modelMapper.map(userRepository.authenticate(email,password),UserDTO.class);
        System.out.println("geldi");

        return obj;
    }
    public UserDTO findById(long Id)
    {
        Optional<User> user= userRepository.findById(Id);
        UserDTO obj= modelMapper.map(user.get(),UserDTO.class);
        return obj;
    }

    public UserPrincipal findByIdUserDetails(long Id)
    {
        User user= userRepository.findById(Id).get();
        return new UserPrincipal(user.getId(),user.getName(),user.getUsername(),user.getEmail(),user.getPassword(),null);
    }
}
