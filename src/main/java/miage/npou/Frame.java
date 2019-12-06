package miage.npou;

public class Frame {

    private Integer lance1;

    private Integer lance2;

    private boolean strike;

    private boolean spare;

    public Frame (Integer l1, Integer l2){

        this.lance1 = l1;

        this.strike = (l1==10);

        this.lance2 = l2;

        if (l2!=null) {
            this.spare = (this.lance1 + this.lance2 == 10);
        }

    }

    public int getScore(){

        int score = 0;

        if (this.lance2 == null){

            score += this.lance1;

        }else{

            score += this.lance1 + this.lance2;

        }

        return score;
    }

    public Integer getLance1(){
        return this.lance1;
    }

    public Integer getLance2(){
        return this.lance2;
    }

    public boolean isSpare() {
        return spare;
    }

    public boolean isStrike() {
        return strike;
    }

}
