package HW07.chars;

import HW07.AnsiColors;

import java.util.ArrayList;
import java.util.Random;

import static HW07.chars.Init.GANG_SIZE;


public abstract class Magic extends UnitBase {
    boolean magic;
    boolean pass;

    public Magic(int attack, int protect, int[] damage, int maxHealth, int speed, String name, String role, String status) {
        super(attack, protect, damage, maxHealth, speed, name, role, status);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\t";
    }

    @Override
    public void step(ArrayList<UnitBase> heroList) {
        if(this.status == "Died"){
            System.out.println(AnsiColors.ANSI_RED + this.role + " " + this.name + " is died ❌");
        }
        double maxLostPercent = 0;
        int maxLostIndex = 0;
        for (int i = 0; i < GANG_SIZE; i++) {
            String[] params = gang.get(i).getMaxLost().split(" ");
            if (Double.parseDouble(params[1]) != Double.parseDouble(params[2])) {
                double temp = (Double.parseDouble(params[1]) - Double.parseDouble(params[2])) /
                        Double.parseDouble(params[1]) * 100;
//                if (temp > maxLostPercent && gang.get(i).status != "Died") {
                if (temp > maxLostPercent) {
                    maxLostPercent = temp;
                    maxLostIndex = i;
                }
            }
        }
        System.out.printf("Максимальный урон: %.2f , Индекс: %s ", maxLostPercent, maxLostIndex);

        if (magic && pass) {
            int healer = 0;
            if (gang.get(maxLostIndex).status.equals("Died")){
                switch (new Random().nextInt(4)) {
                    case 0: gang.set(maxLostIndex, new Peasant(gang, gang.get(maxLostIndex).name,
                            (int) gang.get(maxLostIndex).position.x, (int) gang.get(maxLostIndex).position.y)); this.pass = false; break;
                    case 1: gang.set(maxLostIndex, new Spearman(gang, gang.get(maxLostIndex).name,
                            (int) gang.get(maxLostIndex).position.x, (int) gang.get(maxLostIndex).position.y)); this.pass = false; break;
                    case 2: gang.set(maxLostIndex, new Crossbowman(gang, gang.get(maxLostIndex).name,
                            (int) gang.get(maxLostIndex).position.x, (int) gang.get(maxLostIndex).position.y)); this.pass = false; break;
                    default: gang.set(maxLostIndex, new Monk(gang, gang.get(maxLostIndex).name,
                            (int) gang.get(maxLostIndex).position.x, (int) gang.get(maxLostIndex).position.y)); this.pass = false; break;
                }

            } else {
                healer = (int) (gang.get(maxLostIndex).health + (gang.get(maxLostIndex).maxHealth *
                                                                     maxLostPercent / 100 / 2));
                if (healer <= gang.get(maxLostIndex).maxHealth) {
                    gang.get(maxLostIndex).setHealth(healer);
                } else {
                    gang.get(maxLostIndex).setHealth(gang.get(maxLostIndex).maxHealth);
                }
            }

            System.out.println("Маг: " + name + " вылечил -> " +
                               gang.get(maxLostIndex).role + " имя: " +
                               gang.get(maxLostIndex).name +
                               " здоровье стало -> " + gang.get(maxLostIndex).health);
        } else {
            this.pass = true;
            System.out.println("Лечить некого, все здоровы :) ");
        }
    }

}
