package dungeon.game;

import dungeon.cases.cases.Case;
import dungeon.cases.cases.EmptyCase;
import dungeon.cases.cases.StartCase;
import dungeon.cases.ennemies.dragons.FireDragon;
import dungeon.cases.ennemies.dragons.IceDragon;
import dungeon.cases.ennemies.dragons.ThunderDragon;
import dungeon.cases.ennemies.dragons.WaterDragon;
import dungeon.cases.ennemies.gobelins.DwarfGobelin;
import dungeon.cases.ennemies.gobelins.GiantGobelin;
import dungeon.cases.ennemies.gobelins.MaleficentGobelin;
import dungeon.cases.ennemies.gobelins.MutantGobelin;
import dungeon.cases.ennemies.wizards.Gandalf;
import dungeon.cases.ennemies.wizards.Saruman;
import dungeon.cases.ennemies.wizards.Sauron;
import dungeon.cases.ennemies.wizards.Voldemort;
import dungeon.cases.stuffs.defensiveStuffs.potions.BigPotion;
import dungeon.cases.stuffs.defensiveStuffs.potions.LittlePotion;
import dungeon.cases.stuffs.defensiveStuffs.shields.IronShield;
import dungeon.cases.stuffs.defensiveStuffs.shields.WoodShield;
import dungeon.cases.stuffs.offensiveStuffs.spells.FireballSpell;
import dungeon.cases.stuffs.offensiveStuffs.spells.ThunderSpell;
import dungeon.cases.stuffs.offensiveStuffs.weapons.maces.HeavyMace;
import dungeon.cases.stuffs.offensiveStuffs.weapons.maces.LightMace;
import dungeon.cases.stuffs.offensiveStuffs.weapons.maces.MagicMace;
import dungeon.cases.stuffs.offensiveStuffs.weapons.swords.LongSword;
import dungeon.cases.stuffs.offensiveStuffs.weapons.swords.MagicSword;
import dungeon.cases.stuffs.offensiveStuffs.weapons.swords.ShortSword;
import dungeon.characters.Characters;

import java.util.ArrayList;
import java.util.Collections;

public class Board {
    /**
     * Attribute board typeof ArrayList of Case
     */
    private final ArrayList<Case> board = new ArrayList<>();

    /**
     * Constructor without parameters and call initBoard method
     */
    public Board(){
        initBoard();
    }

    /**
     * Return an Integer value of size of board
     * @return int
     */
    public int sizeBoard(){
        return board.size();
    }

    /**
     * return string with toString method of Object who implement Case interface
     * Integer i = index
     * @param i integer
     * @return string
     */
    public String caseInfo(int i){
        return board.get(i).toString();
    }

    public void interaction(int i, Characters current) throws CharacterDeadException {
        board.get(i).interaction(current);
    }

    /**
     * return object of this Case
     * Integer i = index of arrayList
     * @param i integer
     * @return Object
     */
    public Object getObject(int i){ return board.get(i); }

    /**
     * Set a StartCase object on index 0 of board
     */
    public void startPlace(){
        board.set(0, new StartCase());
    }

    /**
     * Set a DragonCase object on both index of board
     */
    public void dragonsPlace(){
        board.set(45,new IceDragon());
        board.set(52,new WaterDragon());
        board.set(56,new FireDragon());
        board.set(62,new ThunderDragon());
    }
    /**
     * Set a WizardCase object on both index of board
     */
    public void wizardsPlace(){
        board.set(10,new Gandalf());
        board.set(20,new Sauron());
        board.set(25,new Saruman());
        board.set(32,new Voldemort());
        board.set(35,new Gandalf());
        board.set(36,new Voldemort());
        board.set(37,new Saruman());
        board.set(40,new Voldemort());
    }
    /**
     * Set a GobelinCase object on both index of board
     */
    public void gobelinsPlace(){
        board.set(3,new MaleficentGobelin());
        board.set(6,new DwarfGobelin());
        board.set(9,new GiantGobelin());
        board.set(12,new MutantGobelin());
        board.set(15,new GiantGobelin());
        board.set(18,new DwarfGobelin());
        board.set(21,new MutantGobelin());
        board.set(24,new MaleficentGobelin());
    }
    /**
     * Set a MaceCase object on both index of board
     */
    public void macesPlace(){
        board.set(18,new LightMace());
        board.set(21,new HeavyMace());
        board.set(24,new LightMace());
        board.set(27,new HeavyMace());
        board.set(30,new MagicMace());
    }
    /**
     * Set a SwordCase object on both index of board
     */
    public void swordsPlace(){
        board.set(19,new MagicSword());
        board.set(26,new ShortSword());
        board.set(42,new LongSword());
        board.set(53,new MagicSword());
    }
    /**
     * Set a ThunderSpellCase object on both index of board
     */
    public void thundersSpellPlace(){
        board.set(1,new ThunderSpell());
        board.set(4,new ThunderSpell());
        board.set(8,new ThunderSpell());
    }
    /**
     * Set a FireballSpellCase object on both index of board
     */
    public void fireballsSpellPlace(){
        board.set(48,new FireballSpell());
        board.set(49,new FireballSpell());
    }
    /**
     * Set a LittleHealthPotionCase object on both index of board
     */
    public void littlePotionPlace(){
        board.set(7,new LittlePotion());
        board.set(13,new LittlePotion());
        board.set(31,new LittlePotion());
        board.set(33,new LittlePotion());
        board.set(39,new LittlePotion());
        board.set(43,new LittlePotion());
    }
    /**
     * Set a BigHealthPotionCase object on both index of board
     */
    public void bigPotionPlace(){
        board.set(28,new BigPotion());
        board.set(41,new BigPotion());
    }
    /**
     * Set a IronShieldCase object on both index of board
     */
    public void ironShieldPlace(){
        board.set(17,new IronShield());
        board.set(23,new IronShield());
        board.set(27,new IronShield());
    }
    /**
     * Set a WoodShieldCase object on both index of board
     */
    public void woodShieldPlace(){
        board.set(44,new WoodShield());
        board.set(47,new WoodShield());
        board.set(30,new WoodShield());
    }

    /**
     * Method for swap case's placement for each new party.
     */
    public void swap(){
        for (int i=0;i<100;i++) {
            int firstIndex = (int) ((Math.random() * 62) + 1);
            int secondIndex = (int) ((Math.random() * 62) + 1);
            Collections.swap(board, firstIndex, secondIndex);
        }
    }

    /**
     * Initialize board
     */
    private void initBoard(){
        for (int i = 0; i < 64; i++) {
            board.add(new EmptyCase());
        }
        allPlace();
    }

    private void allPlace(){
        startPlace();
        dragonsPlace();
        wizardsPlace();
        gobelinsPlace();
        macesPlace();
        swordsPlace();
        thundersSpellPlace();
        fireballsSpellPlace();
        ironShieldPlace();
        woodShieldPlace();
        littlePotionPlace();
        bigPotionPlace();
        swap();
    }

}
