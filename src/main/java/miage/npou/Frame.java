package miage.npou;

public class Frame {

    private Integer lance1;

    private Integer lance2;

    private boolean strike;

    private boolean spare;

    public Frame (Integer l1, Integer l2){

        this.lance1 = l1;

        this.strike = (l1==10);

        //En cas de strike on instacie le lance 2 à null
        if (isStrike()){
            this.lance2 = null;
        }else{
            int somme = l1+l2;
            //Si la somme est supérieure à 10 on donne le reste de 10 moins le lancé 1 à 2
            if (somme>11){
                this.lance2 = 10 - l1;
            }else {
                this.lance2 = l2;
            }
        }


        if (l2!=null) {
            this.spare = (this.lance1 + this.lance2 == 10);
        }

    }


    public int getScore(){

        int score = 0;

        if (isStrike()){

            score += 10;

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
