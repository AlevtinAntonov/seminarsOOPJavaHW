package HW05.chars;

import java.util.List;

public class Outlaw extends Warrior {

    public Outlaw(List<UnitBase> gang, String name, int x, int y) {
        super(8, 3, new int[]{2, 4}, 10, 6, name, "Outlaw", "Good");
        super.gang = gang;
        super.position = new Vector2(x, y);
    }

    @Override
    public String toString() {
        return "\n Разбойник: " + super.toString();
    }

}
