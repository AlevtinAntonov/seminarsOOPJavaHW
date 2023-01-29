package HW05.chars;

import java.util.List;

public class Spearman extends Warrior {

    public Spearman(List<UnitBase> gang, String name, int x, int y) {
        super(4, 5, new int[]{1, 3}, 10, 4, name,
                "Spearman", "Good");
        super.gang = gang;
        super.position = new Vector2(x, y);
    }

    @Override
    public String toString() {
        return "\n Копейщик: " + super.toString();
    }

}
