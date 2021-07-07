package com.toyota.resource;

import com.toyota.domain.User;
import com.toyota.dto.UserDTO;
import com.toyota.service.UserService;
import com.toyota.uicomponent.model.DataSourceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping(method = RequestMethod.GET, value="/user/allusers")

    @ResponseBody
    public List<UserDTO> getAllUsers(@RequestBody DataSourceRequest request) {
        return userService.getAllUsers();
    }
}
