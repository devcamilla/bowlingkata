package com.bowlingkata;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bowling {
    public int bowl(String line) {
        String[] frames = line.split(" ");
        Queue<String> queue = new LinkedList<>(Arrays.asList(frames));

        int score = 0;
        while(queue.size() > 0){
            String frame = queue.poll();
            char[] frameTurns = frame.toCharArray();

            if (frameTurns.length > 2){
                score += sumFrame(frameTurns, 3);
            } else if (frame.contains("/")){
                String nextFrame = queue.peek();
                if (nextFrame == null) break;
                char[] nextFrameTurns = nextFrame.toCharArray();
                score += 10 + sumFrame(nextFrameTurns, 1);
            }else if (frameTurns[0] == 'X'){
                String nextFrame = queue.peek();
                if (nextFrame == null) break;
                char[] nextFrameTurns = nextFrame.toCharArray();
                score += 10 + sumFrame(nextFrameTurns, 2);
            }else{
                score += sumFrame(frameTurns, 2);
            }
        }
        return score;
    }

    private int getPoints(char turn){
        return turn == '-' ? 0 : turn == 'X' || turn == '/' ? 10 : Integer.parseInt(String.valueOf(turn));
    }

    private int sumFrame(char[] turns, int turnCount){
        int sum = 0;
        for (int i = 0; i < turnCount; i++) {
            sum += getPoints(turns[i]);
            if (turns[i] == '/'){
                sum -= getPoints(turns[i-1]);
            }
        }
        return sum;
    }
}
