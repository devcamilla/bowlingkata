package com.bowlingkata.tests;

import com.bowlingkata.Bowling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTest {
    @Test
    public void bowl_SumFrame(){
        Bowling bowling = new Bowling();

        int score = bowling.bowl("81");
        assertEquals(9, score);
    }

    @Test
    public void bowl_SumFrame_FirstTurnIsMiss(){
        Bowling bowling = new Bowling();

        int score = bowling.bowl("-6");
        assertEquals(6, score);
    }

    @Test
    public void bowl_SumFrame_SecondTurnIsMiss(){
        Bowling bowling = new Bowling();

        int score = bowling.bowl("4-");
        assertEquals(4, score);
    }

    @Test
    public void bowl_Strike(){
        Bowling bowling = new Bowling();

        int score = bowling.bowl("X 51");
        assertEquals(22, score);
    }

    @Test
    public void bowl_Strike_NoNextFrame_ScoreIsZero(){
        Bowling bowling = new Bowling();

        int score = bowling.bowl("X");
        assertEquals(0, score);
    }

    @Test
    public void bowl_Strike_NextFrameFirstTurnMiss(){
        Bowling bowling = new Bowling();

        int score = bowling.bowl("X -1");
        assertEquals(12, score);
    }

    @Test
    public void bowl_Strike_NextFrameSecondTurnMiss(){
        Bowling bowling = new Bowling();

        int score = bowling.bowl("X 5-");
        assertEquals(20, score);
    }

    @Test
    public void bowl_Spare(){
        Bowling bowling = new Bowling();

        int score = bowling.bowl("5/ 51");
        assertEquals(21, score);
    }

    @Test
    public void bowl_Spare_NoNextFrame_ScoreIsZero(){
        Bowling bowling = new Bowling();

        int score = bowling.bowl("5/");
        assertEquals(0, score);
    }

    @Test
    public void bowl_Spare_NextFrameFirstTurnMiss(){
        Bowling bowling = new Bowling();

        int score = bowling.bowl("5/ -1");
        assertEquals(11, score);
    }

    @Test
    public void bowl_Spare_NextFrameSecondTurnMiss(){
        Bowling bowling = new Bowling();

        int score = bowling.bowl("5/ 5-");
        assertEquals(20, score);
    }

    @Test
    public void bowl_FinalFrame(){
        Bowling bowling = new Bowling();

        int score = bowling.bowl("5/ 5- 54 X 11 21 5/ 51 X 52");
        assertEquals(91, score);
    }

    @Test
    public void bowl_FinalFrame_Spare_BonusTurn(){
        Bowling bowling = new Bowling();

        int score = bowling.bowl("5/ 5- 54 X 11 21 5/ 51 X 5/5");
        assertEquals(102, score);
    }

    @Test
    public void bowl_FinalFrame_Strike_BonusTurn(){
        Bowling bowling = new Bowling();

        int score = bowling.bowl("X 34 23 12 34 34 23 12 X XXX");
        assertEquals(114, score);
    }
}
