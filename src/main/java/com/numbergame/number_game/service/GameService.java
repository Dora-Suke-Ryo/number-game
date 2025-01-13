package com.numbergame.number_game.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class GameService {
	private int targetNumber;
	private int numberOfTries;
	
	public void startGame() {
		Random rand = new Random();
		targetNumber = rand.nextInt(100) + 1;
		numberOfTries = 0;
	}
	
	public String guessNumber(int userGuess) {
        numberOfTries++;
        if (userGuess < targetNumber) {
            return "もっと大きい数字を試してください！";
        } else if (userGuess > targetNumber) {
            return "もっと小さい数字を試してください！";
        } else {
            return "おめでとうございます！正解は " + targetNumber + " でした。試行回数: " + numberOfTries;
        }
    }

}
