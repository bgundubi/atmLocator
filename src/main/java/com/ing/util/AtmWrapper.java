package com.ing.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.model.Atm;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class AtmWrapper {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ObjectMapper objectMapper = new ObjectMapper();

    public Atm[] getAllAtms(String url) throws JsonProcessingException {

            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
            String atmsList = responseEntity.getBody().substring(responseEntity.getBody().indexOf('['));
            return objectMapper.readValue(atmsList, Atm[].class);
    }
}
