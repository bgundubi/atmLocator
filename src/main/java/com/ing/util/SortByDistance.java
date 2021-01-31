package com.ing.util;

import com.ing.model.Atm;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class SortByDistance implements Comparator<Atm> {

    public int compare(Atm a1, Atm a2) {
      return  Integer.compare(a1.getDistance() , a2.getDistance());
    }
}
