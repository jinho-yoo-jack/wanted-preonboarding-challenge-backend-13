package com.wanted.preonboarding.clean.code.meanginful_name;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class MeaninglessName {
    private static final int[][] theList = new int[5][5];

    @PostConstruct
    public void init(){
        log.info("After call constructor function, this function Run");
        for (int i = 0; i < theList.length; i++) {
            for (int j = 0; j < theList[i].length; j++) {
                theList[i][j] = ((int) (Math.random() * 5));
            }
        }
    }

    public List<int[]> getThem() {
        List<int[]> list1 = new ArrayList<>();

        for (int[] x : theList) {
            if (x[0] == 4)
                list1.add(x);
        }
        return list1;
    }
}
