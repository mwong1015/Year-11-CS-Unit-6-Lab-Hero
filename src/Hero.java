import java.util.Random;

public class Hero {
    private String name;
    private int hitPoints;

    public Hero (String name){
        this.name = name;
        hitPoints = 100;
    }

    public String toString(){
        return "Hero{name='"+name+"', hitPoints="+hitPoints+"}";
    }
    public void attack(Hero opponent){
        Random rand = new Random();
        double double_random = rand.nextDouble();
        if (double_random<0.5){ // hero attack
            opponent.setHitPoints(opponent.getHitPoints()-10);
        }
        else{ // opponent attack
            hitPoints = hitPoints-10;
        }
    }

    public void senzuBean(){
        hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent){
        while ((hitPoints > 0)&&(opponent.getHitPoints()>0)){
            attack(opponent);
        }
    }

    public String fightUntilTheDeath (Hero opponent){
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return toString()+"    "+opponent.toString();
    }

    private int nFightsToTheDeathHelper(Hero opponent, int n) {
        int heroWin = 0;
        for (int i = 0; i < n; i++) {
            fightUntilTheDeath(opponent);
            if (opponent.getHitPoints() == 0)
                heroWin++;
            senzuBean();
            opponent.senzuBean();
        }
        return heroWin;
    }
    public String nFightsToTheDeath(Hero opponent, int n) {
        int heroWins = nFightsToTheDeathHelper(opponent, n);
        if ((heroWins % 2 == 0) && (heroWins == n / 2)) {
            return name + ": " + heroWins + " wins"+ opponent.getName() + ": " + (n - heroWins)+" wins"+"OMG! It was actually a draw!";
        }
        else if(heroWins>n/2){
            return name + ": " + heroWins  +" wins"+ opponent.getName() + ": " + (n - heroWins) +" wins"+name+" wins!";

        }
        return name + ": " + heroWins  +" wins"+ opponent.getName() + ": " + (n - heroWins)+" wins"+opponent.getName()+" wins!";
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

}


