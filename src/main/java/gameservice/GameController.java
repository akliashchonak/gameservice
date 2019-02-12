package gameservice;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class GameController {

    // =================== VALID CONTRACT ====================

    @RequestMapping("game/{gameName}/{bet}")
    public GameInfo game(@PathVariable String gameName, @PathVariable Integer bet) {
        Integer win = getWinBasedOnGameAndBet(gameName, bet);
        String msg;
        if ( win > 0 ){
            msg = "Congratulation! You won $" + win + "!";
        } else {
            msg = "No luck... Try again!";
        }
        GameInfo g = new GameInfo(gameName, bet, win, msg);
        return g;

    }

    private Integer getWinBasedOnGameAndBet(String gameName, Integer bet){
        Integer win = 0;
        switch(gameName) {
            case "777":
                win = getWin777BasedOnBet(bet);
                break;
            case "dice8":
                //win = getWinDice8BasedOnBet(bet);
                break;
        }
        return win;
    }

    private Integer getWin777BasedOnBet(Integer bet){
        int min = 1;
        int max = 9;
        Integer win = 0;
        Random rn = new Random();
        Integer a = (rn.nextInt((max - min) + 1) + min);
        Integer b = (rn.nextInt((max - min) + 1) + min);
        Integer c = (rn.nextInt((max - min) + 1) + min);

        if(a.equals(7) && b.equals(7) && c.equals(7)) {
            win = bet * 1000;
        } else if(a.equals(b) && b.equals(c)){
            win = bet * 10;
        } else if (a.equals(b) || b.equals(c) || c.equals(a)) {
            win = bet * 2;
        }
        return win;
    }

    private Integer getWinDice8BasedOnBet(Integer bet){
        int min = 1;
        int max = 6;
        Integer win = 0;
        Random rn = new Random();
        Integer a = (rn.nextInt((max - min) + 1) + min);
        Integer b = (rn.nextInt((max - min) + 1) + min);
        if( (a+b) == 8 ) {
            win = bet * 2;
        }
        return win;
    }

    // =================== INVALID CONTRACT ====================
/*

    @RequestMapping("game/{gameName}/{bet}")
    public GameInfo game(@PathVariable String gameName, @PathVariable Integer bet) {
        String win = getWinBasedOnGameAndBet(gameName, bet);
        String msg;
        if ( Integer.valueOf(win) == 0){
            msg = "No luck... Try again!";
        } else {
            msg = "Congratulation! You won $" + win + "!";
        }
        GameInfo g = new GameInfo(gameName, bet, win, msg);
        return g;

    }

    private String getWinBasedOnGameAndBet(String gameName, Integer bet){
        String win="";
        switch(gameName) {
            case "777":
                win = getWin777BasedOnBet(bet);
                break;
            case "dice8":
                win = getWinDice8BasedOnBet(bet);
                break;
        }
        return win;
    }

    private String getWin777BasedOnBet(Integer bet){
        int min = 1;
        int max = 9;
        Integer win = 0;
        Random rn = new Random();
        Integer a = (rn.nextInt((max - min) + 1) + min);
        Integer b = (rn.nextInt((max - min) + 1) + min);
        Integer c = (rn.nextInt((max - min) + 1) + min);

        if(a.equals(7) && b.equals(7) && c.equals(7)) {
            win = bet * 1000;
        } else if(a.equals(b) && b.equals(c)){
            win = bet * 10;
        } else if (a.equals(b) || b.equals(c) || c.equals(a)) {
            win = bet * 2;
        }
        return String.valueOf(win);
    }

    private String getWinDice8BasedOnBet(Integer bet){
        int min = 1;
        int max = 6;
        Integer win = 0;
        Random rn = new Random();
        Integer a = (rn.nextInt((max - min) + 1) + min);
        Integer b = (rn.nextInt((max - min) + 1) + min);
        if( (a+b) == 8 ) {
            win = bet * 2;
        }
        return String.valueOf(win);
    }
*/

}
