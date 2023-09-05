package com.wanted.preonboarding.clean.code.meanginful_name;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class MeaningfulName {

    private static final int[][] gameBoard = new int[5][5];
    private static final int STATUS_VALUE = 0;
    private static final int FLAGGED = 4;

    @PostConstruct
    public void afterConstructorCallInit(){
        log.info("After Constructor call, this function call");
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = ((int) (Math.random() * 5));
            }
        }
    }

    public List<int[]> getFlaggedCell(){
        List<int[]> flaggedCells = new ArrayList<>();
        for(int[] cell : gameBoard){
            if(cell[STATUS_VALUE] == FLAGGED)
                flaggedCells.add(cell);
        }
        return flaggedCells;
    }
}
