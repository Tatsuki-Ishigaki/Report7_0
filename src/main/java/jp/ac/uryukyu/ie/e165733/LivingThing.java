package jp.ac.uryukyu.ie.e165733;

public class LivingThing {
    private String name;
    private String stone;
    private boolean dead;

    public LivingThing (String name,String stone) {
        this.name = name;
        this.stone = stone;
        dead = false;
    }

    //a

    public boolean isDead(){
        return dead;
    }

    public void setDead(boolean dead){
        this.dead = dead;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getStone(){
        return stone;
    }

    public void setStone(String stone){this.stone = stone;}

}