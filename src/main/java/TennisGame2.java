
public class TennisGame2 implements TennisGame {
    private final Player player1;
    private final Player player2;
    private static final String THIRTY = "Thirty";
    private static final String FORTY = "Forty";
    private static final String FIFTEEN = "Fifteen";


    private String score;

    public TennisGame2(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public String getScore(){
        if (player1.score().equals(player2.score())) {
            greaterThreeOrLowerFour();
        }

        oneGraterZeroOneEqualsZero();

        oneGreaterAndLowerFour();

        advantage();
        
        win();

        return score;
    }

    private void greaterThreeOrLowerFour(){
        if (player1.score() < 4) {
            score = scorePlayer1();
            score += "-All";
        }

        if (player1.score()>=3){
            score = "Deuce";
        }
    }

    private void oneGraterZeroOneEqualsZero(){
        defineOneGraterZeroOneEqualsZero(player1, player2);
        defineOneGraterZeroOneEqualsZero(player2, player1);
    }

    private void defineOneGraterZeroOneEqualsZero(Player player1, Player player2){
        if (player1.score() > 0 && player2.score().equals(0)) {

            player1.updateRes(resPlayer(player1));

            player2.updateRes("Love");
            score = this.player1.res() + "-" + this.player2.res();
        }
    }

    private void oneGreaterAndLowerFour(){
        defineOneGreaterAndLowerFour(player1, player2);
        defineOneGreaterAndLowerFour(player2, player1);
    }

    private void defineOneGreaterAndLowerFour(Player player1, Player player2){
        if (player1.score() > player2.score() && player1.score() < 4) {
            evaluatePoints(player1, player2);
            score = this.player1.res() + "-" + this.player2.res();
        }
    }

    private void advantage(){
        defineAdvantage(player1, player2);
        defineAdvantage(player2, player1);
    }

    private void defineAdvantage(Player player1, Player player2){
        if (player1.score() > player2.score() && player2.score() >= 3) {
            score = "Advantage "+ player1.name();
        }
    }

    private void win(){
        defineWin(player1, player2);
        defineWin(player2, player1);
    }

    private void defineWin(Player player1, Player player2){
        if (player1.score()>=4 && player2.score()>=0 && (player1.score()- player2.score())>=2) {
            score = "Win for "+player1.name();
        }
    }

    private void evaluatePoints(Player player1, Player player2){
        if (player1.score().equals(2)) {
            player1.updateRes(THIRTY);
        }

        if (player1.score().equals(3)) {
            player1.updateRes(FORTY);
        }

        if (player2.score().equals(1)) {
            player2.updateRes(FIFTEEN);
        }

        if (player2.score().equals(2)){
            player2.updateRes(THIRTY);
        }

    }

    private String scorePlayer1(){
        if(player1.score().equals(0)){
            return "Love";
        }

        if (player1.score().equals(1)){
            return FIFTEEN;
        }

        return THIRTY;
    }

    private String resPlayer(Player player){
        if(player.score().equals(1)){
            return FIFTEEN;
        }

        if (player.score().equals(2)){
            return THIRTY;
        }

        return FORTY;
    }
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            player1.addScore(1);
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            player2.addScore(1);
        }
            
    }

    public void wonPoint(String player) {
        if (player.equals("player1")) {
            player1.addScore(1);
            return;
        }
        player2.addScore(1);
    }
}