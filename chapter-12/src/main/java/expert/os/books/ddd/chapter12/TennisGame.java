package expert.os.books.ddd.chapter12;


public class TennisGame {
    private final Player playerOne;
    private final Player playerTwo;

    public TennisGame(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void playerScores(Player player) {
        player.scorePoint();
    }

    public String getScore() {
        return playerOne.getScore() + " - " + playerTwo.getScore();
    }

}
