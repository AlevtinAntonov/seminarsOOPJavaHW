package HW05.chars;

import java.util.List;

public class Crossbowman extends Archer {

    public Crossbowman(List<UnitBase> gang, String name, int x, int y) {
        super(6, 3, new int[]{2, 3}, 10, 4,
                name, "Crossbowman","Good");
        shots = 16;
        super.gang = gang;
        super.position = new Vector2(x, y);
    }

    @Override
    public String toString() {
        return "\n Арбалетчик: " + super.toString() + ", shots=" + shots;
    }

}
