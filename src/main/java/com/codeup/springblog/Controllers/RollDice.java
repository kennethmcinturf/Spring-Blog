package com.codeup.springblog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RollDice {
    @Controller
    class diceRoll{
        @GetMapping("/roll-dice")
        public String makeGuess(){
            return "GuessNumber";
        }

        @GetMapping(path = "/roll-dice/{guess}")
        public String userGuess(@PathVariable int guess, Model model){
            int rightCounter = 0;
            int dice1 = (int)(Math.random() * 6 + 1);
            int dice2 = (int)(Math.random() * 6 + 1);
            int dice3 = (int)(Math.random() * 6 + 1);
            int dice4 = (int)(Math.random() * 6 + 1);
            int dice5 = (int)(Math.random() * 6 + 1);
            if (dice1 == guess){
                rightCounter++;
            }
            if (dice2 == guess){
                rightCounter++;
            }
            if (dice3 == guess){
                rightCounter++;
            }
            if (dice4 == guess){
                rightCounter++;
            }
            if (dice5 == guess){
                rightCounter++;
            }
            model.addAttribute("dice1", dice1);
            model.addAttribute("dice2", dice2);
            model.addAttribute("dice3", dice3);
            model.addAttribute("dice4", dice4);
            model.addAttribute("dice5", dice5);
            model.addAttribute("guess", guess);
            model.addAttribute("rightCounter", rightCounter);
            return "DiceRoll";
        }
    }
}
