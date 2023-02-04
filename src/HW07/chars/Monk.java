package HW07.chars;

import java.util.List;

public class Monk extends Magic {

    public Monk(List<UnitBase> gang, String name, int x, int y) {
        super(12, 7, new int[]{-4,-4}, 30, 4, name,
                "Monk", "Good");
        super.magic = true;
        super.gang = gang;
        super.position = new Vector2(x, y);
    }

    @Override
    public String toString() {
        return "\n Монах: " + super.toString() + ", magic=" + magic + ", status=" + status;
    }
}
