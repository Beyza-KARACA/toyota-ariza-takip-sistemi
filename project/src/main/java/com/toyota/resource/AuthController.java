package com.toyota.resource;


import com.toyota.dto.FaultDTO;
import com.toyota.dto.UserDTO;
import com.toyota.model.LoginRequestModel;
import com.toyota.security.JwtAuthenticationResponse;
import com.toyota.security.JwtTokenProvider;
import com.toyota.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value="api/auth/signinToken")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequestModel requestModel) {
        System.out.println("buraya geldi-------------");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestModel.getEmail(),
                        requestModel.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @RequestMapping(method = RequestMethod.POST, value="/auth/signin")

    @ResponseBody
    public ResponseEntity Login(@RequestBody LoginRequestModel requestModel) {
        System.out.println("mail ve şifre");
        System.out.println(requestModel.getEmail()+ "   " + requestModel.getPassword());
        UserDTO obj= userService.authenticate(requestModel.getEmail(),requestModel.getPassword());
        if(obj==null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return ResponseEntity.ok("haci");
    }


}
