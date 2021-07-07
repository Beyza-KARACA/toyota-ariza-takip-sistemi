package com.toyota.service;

import com.toyota.dao.FaultRepository;
import com.toyota.dto.FaultDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class FaultService {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private FaultRepository faultRepository;


    public List<FaultDTO> getAllFaults()
    {
        Type listType = new TypeToken<List<FaultDTO>>(){}.getType();
        return modelMapper.map(faultRepository.findAllNecessaryFaults(),listType);
    }
}
