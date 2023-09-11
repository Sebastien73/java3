package dungeon.characters;

abstract public class Characters {

    //Attribut commun a tout les personnages.
    protected String name;
    protected int pointLife;
    protected int pointAttack;


    //Constructeur commun de tous les personnages
    protected Characters(String name, int pointLife, int pointAttack) {
        this.name = name;
        this.pointLife = pointLife;
        this.pointAttack = pointAttack;

    }

    //getter
    public String getName() { return this.name; }
    public int getPointLife(){ return this.pointLife; }
    public int getPointAttack(){ return this.pointAttack;}

    //setter
    public void setName(String name) { this.name = name; }
    public void setPointLife(int pointLife) { this.pointLife = pointLife; }
    public void setPointAttack(int pointAttack) { this.pointAttack = pointAttack; }

    public abstract String toString();
}
