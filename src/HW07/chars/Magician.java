package HW07.chars;

import java.util.List;


public class Magician extends Magic {

    public Magician(List<UnitBase> gang,String name, int x, int y) {
        super(17, 12, new int[]{-5, -5}, 30, 4,
                name, "Magician", "Good");
        super.magic = true;
        super.gang = gang;
        super.position = new Vector2(x, y);
        super.pass = true;

    }
    @Override
    public String toString() {
        return "\n Колдун: " + super.toString() + ", magic=" + magic + ", status=" + status;
    }


}
