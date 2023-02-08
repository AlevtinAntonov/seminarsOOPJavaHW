package HW07.chars;

import java.util.List;

public class Sniper extends Archer {


    public Sniper(List<UnitBase> gang, String name, int x, int y) {
        super(12, 10, new int[]{8, 10}, 15, 8, name,
                "Sniper", "Good");
        shots = 32;
        super.gang = gang;
        super.position = new Vector2(x, y);
    }


    @Override
    public String toString() {
        return "\n Снайпер: " + super.toString() + ", shots=" + shots;
    }


}
