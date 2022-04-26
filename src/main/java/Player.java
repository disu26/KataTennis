public final class Player {

    private Integer score;
    private String name;
    private String res;

    public Player(String name) {
        this.name = name;
        score = 0;
        res = "";
    }

    public Integer score() {
        return score;
    }

    public void addScore(Integer score) {
        this.score += score;
    }

    public String name() {
        return name;
    }

    public String res() {
        return res;
    }

    public void updateRes(String res) {
        this.res = res;
    }
}
