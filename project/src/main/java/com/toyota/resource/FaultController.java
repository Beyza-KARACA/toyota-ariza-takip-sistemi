package com.toyota.resource;

import com.toyota.dto.FaultDTO;
import com.toyota.service.FaultService;
import com.toyota.uicomponent.model.DataSourceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;

@Controller
public class FaultController {

    @Autowired
    private FaultService faultService;

    @RequestMapping(method = RequestMethod.POST, value="/fault/allfaults")

    @ResponseBody
    public List<FaultDTO> getAllFaults(@RequestBody DataSourceRequest request) {
        System.out.println("ariza listesi cagirildi");
        System.out.println(request.getPageSize());
        System.out.println(request.getTake());
        return faultService.getAllFaults();
    }
}
