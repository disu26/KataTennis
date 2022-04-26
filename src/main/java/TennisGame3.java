
public class TennisGame3 implements TennisGame {

    private final Player player1;
    private final Player player2;

    public TennisGame3(String p1N, String p2N) {
        player1 = new Player(p1N);
        player2 = new Player(p2N);
    }

    public String getScore() {

        if (Boolean.TRUE.equals(lowerFour()) && Boolean.TRUE.equals(sumDifferentSix())) {
            return lowerFourAndSumDifferrentSix();
        }

        if (player1.score().equals(player2.score())) {
            return "Deuce";
        }

        return advantageOrWin();
    }

    private String playerAhead(){
        return player1.score() > player2.score() ? player1.name() : player2.name();
    }

    private String advantageOrWin(){
        return (powSubtract() == 1) ? "Advantage " + playerAhead() : "Win for " + playerAhead();
    }

    private Double powSubtract(){
        return Math.pow(Double.valueOf(player1.score()) - player2.score(), 2);
    }
    private Boolean lowerFour(){
        return player1.score() < 4 && player2.score() < 4;
    }

    private Boolean sumDifferentSix(){
        return (player1.score() + player2.score()) != 6;
    }

    private String lowerFourAndSumDifferrentSix(){
        String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        String s = p[player1.score()];
        return (player1.score().equals(player2.score())) ? s + "-All" : s + "-" + p[player2.score()];
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            player1.addScore(1);
            return;
        }
        player2.addScore(1);
    }

}
