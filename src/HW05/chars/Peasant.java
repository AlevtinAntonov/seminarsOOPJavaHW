package HW05.chars;

import java.util.ArrayList;
import java.util.List;

public class Peasant extends UnitBase {
    protected boolean delivery;

    public Peasant(List<UnitBase> gang, String name, int x, int y) {
        super(1, 1, new int[]{1, 1}, 1, 3, name,
                "Peasant", "Stand");
        delivery = true;
        super.gang = gang;
        super.position = new Vector2(x, y);


    }


    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public void setStatus(String status) {this.status = status;}

    @Override
    public String toString() {
        return "\n Крестьянин: " + super.toString() + ", delivery=" + delivery + ", status=" + status;
    }

    @Override
    public void step(ArrayList<UnitBase> heroesList) {
        if (health <= 0){
            delivery = false;
            status = "Died";
        } else {
        status = "Stand";
        delivery = true;
        }
    }
}
