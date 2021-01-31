package com.ing.controller;

import com.ing.model.Address;
import com.ing.model.Atm;
import com.ing.service.AtmLocatorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class AtmLocatorControllerTest {


    @InjectMocks
    AtmLocatorController atmLocatorController;

    @Mock
    AtmLocatorService atmLocatorService;

    private List<Atm> atmsList;

    private List<Atm> atmsCityList;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.openMocks(this);

        atmsList = new ArrayList<>();

        atmsCityList = new ArrayList<>();

        Atm atm = new Atm();
        Address address = new Address();
        address.setCity("Rotterdam");
        address.setHousenumber("52");
        atm.setAddress(address);

        atmsList.add(atm);

        Atm atm2 = new Atm();
        Address address2 = new Address();
        address2.setHousenumber("20");
        address2.setCity("BORNE");
        atm2.setAddress(address2);

        atmsList.add(atm2);

        Atm atm3 = new Atm();
        Address address3 = new Address();
        address3.setHousenumber("48");
        address3.setCity("Breda");
        atm3.setAddress(address3);

        atmsList.add(atm3);


        Atm atm4 = new Atm();
        Address address4 = new Address();
        address4.setCity("Rotterdam");
        address4.setHousenumber("122");
        atm4.setAddress(address4);


        atmsCityList.add(atm);
        atmsCityList.add(atm4);

    }

    @Test
    public void testGetAllAtms() throws Exception {

        when(atmLocatorService.getAllAtms()).thenReturn(atmsList);
        List<Atm> atmList = atmLocatorController.getAllAtms();
        assertEquals(atmList.size(),3);

    }

    @Test
    public void testGetAllAtmsByCity() throws Exception {
        when(atmLocatorService.getAllAtmsByCity(Mockito.anyString())).thenReturn(atmsCityList);
        List<Atm> atmsByCity = atmLocatorController.getAllAtmsByCity("Rotterdam");
        assertEquals(atmsByCity.size(),2);
    }
}

