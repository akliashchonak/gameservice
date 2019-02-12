package gameservice;

public class GameInfo {
// ================ Valid Contract ======================
    String name;
    Integer bet;
    Integer win;
    String message;

    public GameInfo(String name, Integer bet, Integer win, String message) {
        this.name = name;
        this.bet = bet;
        this.win = win;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBet() {
        return bet;
    }

    public void setBet(Integer bet) {
        this.bet = bet;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

// ============== Invalid Contract ======================
/*    String name;
    Integer bet;
    String win;
    String message;

    public GameInfo(String name, Integer bet, String win, String message) {
        this.name = name;
        this.bet = bet;
        this.win = win;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBet() {
        return bet;
    }

    public void setBet(Integer bet) {
        this.bet = bet;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }*/
}
