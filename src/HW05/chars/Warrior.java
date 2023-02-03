package HW05.chars;

import java.util.ArrayList;


public abstract class Warrior extends UnitBase {


    public Warrior(int attack, int protect, int[] damage, int maxHealth, int speed, String name, String role, String status) {
        super(attack, protect, damage, maxHealth, speed, name, role, status);
    }

    @Override
    public void step(ArrayList<UnitBase> heroesList) {
        if (this.status.equals("Died")) return;

        Vector2 target = getTarget(heroesList);


    }
}
