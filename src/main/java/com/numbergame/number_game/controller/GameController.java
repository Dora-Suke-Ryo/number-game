package com.numbergame.number_game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.numbergame.number_game.service.GameService;

@Controller
public class GameController {

	@Autowired
	private GameService gameService;

	@GetMapping("/")
	public String gamePage (Model model) {
		gameService.startGame();
		model.addAttribute("message" , "1から100の間の数字を予想してください");
		return "game";
	}
	
	@PostMapping("/guess")
	public String checkGuess(@RequestParam("guess") int userGuess, Model model) {
		String result = gameService.guessNumber(userGuess);
        model.addAttribute("message", result);
        return "game";
	}
}
