package HW07.chars;

import java.util.ArrayList;


public abstract class Warrior extends UnitBase {


    public Warrior(int attack, int protect, int[] damage, int maxHealth, int speed, String name, String role, String status) {
        super(attack, protect, damage, maxHealth, speed, name, role, status);
    }

    @Override
    public void step(ArrayList<UnitBase> heroesList) {
        if (this.status.equals("Died")) return;

        Vector2 target = getTarget(heroesList);
        int x = (int) this.position.x;
        int y = (int) this.position.y;

        if (heroesList.get((int) target.y).position.y > getPosition().y && checkPosition(new Vector2(x, ++y)))
            setPosition(new Vector2(x, y));
        else if (heroesList.get((int) target.y).position.y < getPosition().y && checkPosition(new Vector2(x, --y)))
            setPosition(new Vector2(x, y));
        else if (heroesList.get((int) target.y).position.x < getPosition().x && checkPosition(new Vector2(--x, y)))
            setPosition(new Vector2(x, y));
        else if (heroesList.get((int) target.y).position.x > getPosition().x && checkPosition(new Vector2(++x, y)))
            setPosition(new Vector2(x, y));


    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\t\t\t";
    }
}