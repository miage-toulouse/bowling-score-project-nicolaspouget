package miage.npou;

import java.util.List;

public class Partie {

    private List<Frame> lesFrames;

    public Partie(List<Frame> lesFrames){

        this.lesFrames = lesFrames;

    }

    public Integer calculScore(){

        int score = 0;

        for (int i=0; i<9; i++){

            if (this.lesFrames.get(i).isStrike()){

                score += this.lesFrames.get(i).getScore();

                score += this.lesFrames.get(i+1).getScore();

                if (this.lesFrames.get(i+1).isStrike()){

                    score += this.lesFrames.get(i+2).getLance1();

                }

            }else{

                if (this.lesFrames.get(i).isSpare()){

                    score += this.lesFrames.get(i).getScore() + this.lesFrames.get(i+1).getLance1();

                }else{

                    score += this.lesFrames.get(i).getScore();

                }

            }

        }

        if (this.lesFrames.get(9).isSpare()){

            score += this.lesFrames.get(9).getScore() + this.lesFrames.get(10).getLance1();

        }else {

            if (this.lesFrames.get(9).isStrike()) {

                score += this.lesFrames.get(9).getScore() + this.lesFrames.get(10).getScore();

            } else {

                score += this.lesFrames.get(9).getScore();

            }
        }

        return  new Integer(score);
    }

}
