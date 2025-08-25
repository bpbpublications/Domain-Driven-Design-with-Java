package expert.os.books.ddd.chapter12;


public class TennisGame {
    private Player playerOne;
    private Player playerTwo;

    public TennisGame(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void playerScores(Player player) {
        player.setScore(player.getScore() + 1);
    }

    public String getScore() {
        return playerOne.getScore() + " - " + playerTwo.getScore();
    }
}
