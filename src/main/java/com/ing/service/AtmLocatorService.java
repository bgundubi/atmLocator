package com.ing.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ing.exception.NoAtmFound;
import com.ing.model.Atm;
import com.ing.util.AtmWrapper;
import com.ing.util.SortByDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtmLocatorService {

    @Autowired
    AtmWrapper atmWrapper;

    @Value("${atm.locator.api.url}")
    private String atmLocatorApiUrl;

    @Autowired
    SortByDistance sortByDistance;

    public List<Atm> getAllAtms() throws JsonProcessingException {

      List<Atm> atmList = Arrays.stream( atmWrapper.getAllAtms(atmLocatorApiUrl)).sorted(sortByDistance).collect(Collectors.toList());

      if(atmList.size() == 0)
          throw new NoAtmFound();

      return atmList;
    }

    public List<Atm> getAllAtmsByCity(String cityName) throws JsonProcessingException {

        List<Atm> atmList =  Arrays.stream(atmWrapper.getAllAtms(atmLocatorApiUrl)).filter(atm -> atm.getAddress().getCity().equals(cityName)).sorted(sortByDistance).collect(Collectors.toList());

        if(atmList.size() == 0)
            throw new NoAtmFound(" No Atms Found in the city: "+cityName);

        return atmList;
    }


}
