package HW07.chars;

import java.util.ArrayList;
import java.util.Random;

import static HW07.chars.Init.GANG_SIZE;
//import static HW07.Main.GANG_SIZE;
import static java.lang.String.format;

public abstract class Magic extends UnitBase {
    boolean magic;

    public Magic(int attack, int protect, int[] damage, int maxHealth, int speed, String name, String role, String status) {
        super(attack, protect, damage, maxHealth, speed, name, role, status);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\t";
    }

    @Override
    public void step(ArrayList<UnitBase> heroList) {
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
//        System.out.printf("Максимальный урон: %.2f , Индекс: %s ", maxLostPercent, maxLostIndex);

        if (magic) {
            int healer = 0;
            if (gang.get(maxLostIndex).status.equals("Died")){

                switch (new Random().nextInt(4)) {
                    case 0: gang.get(maxLostIndex).add(new Peasant(darkSide, heroName, x, y++)); break;
                    case 1: darkTeam.add(new Spearman(darkSide, heroName, x, y++)); break;
                    case 2: darkTeam.add(new Crossbowman(darkSide, heroName, x, y++)); break;
                    default: darkSide.add(new Monk(darkSide, heroName, x, y++)); break;
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
            System.out.println("Лечить некого, все здоровы :) ");
        }
    }

}
