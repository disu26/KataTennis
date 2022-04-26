
public class TennisGame1 implements TennisGame {

    private final Player player1;
    private final Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")){
            player1.addScore(1);
            return;
        }
        player2.addScore(1);
    }

    public String getScore() {
        if (player1.score().equals(player2.score())){
            return draw();
        }

        if (player1.score()>=4 || player2.score()>=4) {
            return matchPoint();
        }

        return points();
    }

    private String points() {
        StringBuilder scoreBuilder = new StringBuilder();
        Integer tempScore;

        for (int i = 1; i<3; i++)
        {
            if (i == 1){
                tempScore = player1.score();
            }else {
                scoreBuilder.append("-");
                tempScore = player2.score();
            }
            switch(tempScore) {
                case 0 -> scoreBuilder.append("Love");
                case 1 -> scoreBuilder.append("Fifteen");
                case 2 -> scoreBuilder.append("Thirty");
                case 3 -> scoreBuilder.append("Forty");
                default -> scoreBuilder.append("");
            }
        }

        return scoreBuilder.toString();
    }

    private String draw(){
        return switch (player1.score()) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }

    private String matchPoint(){
        Integer minusResult = player1.score() - player2.score();

        if (minusResult.equals(1)){
            return "Advantage player1";
        }

        if (minusResult.equals(-1)){
            return "Advantage player2";
        }

        if (minusResult >= 2){
            return "Win for player1";
        }

        return "Win for player2";
    }

}
