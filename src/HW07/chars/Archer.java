package HW07.chars;

import java.util.ArrayList;

//import static HW07.Main.GANG_SIZE;
import static HW07.chars.Init.GANG_SIZE;
import static java.lang.String.format;

public abstract class Archer extends UnitBase{
    protected int shots;

    public Archer(int attack, int protect, int[] damage, int maxHealth, int speed, String name, String role, String status) {
        super(attack, protect, damage, maxHealth, speed, name, role, status);
    }


    protected int getShots() {
        return shots;
    }

    protected void setShots(int shots) {
        this.shots = shots;
    }

    @Override
    public String getInfo() {
        String archer;
        archer = super.getInfo() + format("\t\uD83C\uDFF9 %d", shots);
        return archer;
    }

    @Override
    public void step(ArrayList<UnitBase> heroesList) {

        Vector2 target = getTarget(heroesList);
        float attackPower;
        if (target.x <= 4){
            attackPower = damage[1];
        } else if (target.x >= 12) {
            attackPower = damage[0];
        } else {
            attackPower = damage[0] + ((target.x - 4) / 8 * (damage[1] - damage[0]));
        }

        if (status != "Died" && shots > 0 && heroesList.get((int) target.y).status != "Died"){
            shots -= 1;
            heroesList.get((int) target.y).getDamage(attackPower);
            System.out.printf("%s %s выстрелил в %s %s, осталось стрел: %s \n", role, name,
                    heroesList.get((int) target.y).role, heroesList.get((int) target.y).name, shots);
            if (heroesList.get((int) target.y).health <= 0){
                heroesList.get((int) target.y).health = 0;
                heroesList.get((int) target.y).status = "Died";
                System.out.println(heroesList.get((int) target.y).role + " " + heroesList.get((int) target.y).name +" Died ❌");
            }
            
        } else if (status == "Died") {
            System.out.printf("%s %s ->Убит :)\n", role, name);
        } else if (shots <= 0){
            System.out.printf("%s %s -> Стрелы закончились :)\n", role, name);
        } else {
            System.out.printf("%s %s -> Не нашел цель :)\n", role, name);
        }

        for (int i = 0; i < GANG_SIZE; i++) {

            if ((gang.get(i).role == "Peasant") && ((Peasant) gang.get(i)).delivery){
                shots +=1;
                ((Peasant) gang.get(i)).setDelivery(false);
                System.out.println("Крестьянин " + ((Peasant) gang.get(i)).name + " принес стрелу Снайперу: "
                                   + name + ", стало стрел -> " + shots);
                break;
            }
        }
    }

}
