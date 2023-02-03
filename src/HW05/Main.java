package HW05;

import HW05.chars.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int GANG_SIZE = 10;
    public static ArrayList<UnitBase> whiteSide;
    public static ArrayList<UnitBase> whitePeasant;
    public static ArrayList<UnitBase> whiteTeam;
    public static ArrayList<UnitBase> darkSide;
    public static ArrayList<UnitBase> darkPeasant;
    public static ArrayList<UnitBase> darkTeam;


    public static void main(String[] args) {
        init();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            ConsoleView.view();
            whiteSide.forEach(n -> n.step(darkSide));
            darkSide.forEach(n -> n.step(whiteSide));
            scanner.nextLine();
        }
    }
    private static void init(){
        Random rand = new Random();
        String heroName;
        whiteSide = new ArrayList<>();
        darkSide = new ArrayList<>();
        whitePeasant = new ArrayList<>();
        whiteTeam = new ArrayList<>();
        darkPeasant = new ArrayList<>();
        darkTeam = new ArrayList<>();

        int x = 1;
        int y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            heroName = String.valueOf(Name.values()[rand.nextInt(Name.values().length)]);
            switch (new Random().nextInt(4)) {
                case 0: whitePeasant.add(new Peasant( whiteSide, heroName, x, y++)); break;
                case 1: whiteTeam.add(new Outlaw(whiteSide, heroName, x, y++)); break;
                case 2: whiteTeam.add(new Sniper(whiteSide, heroName, x, y++)); break;
                default: whiteSide.add(new Magician(whiteSide, heroName, x, y++)); break;
            }
        }

        whiteSide.addAll(whiteTeam);
        whiteSide.addAll(whitePeasant);

        x = GANG_SIZE;
        y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            heroName = String.valueOf(Name.values()[rand.nextInt(Name.values().length)]);

            switch (new Random().nextInt(4)) {
                case 0: darkPeasant.add(new Peasant(darkSide, heroName, x, y++)); break;
                case 1: darkTeam.add(new Spearman(darkSide, heroName, x, y++)); break;
                case 2: darkTeam.add(new Crossbowman(darkSide, heroName, x, y++)); break;
                default: darkSide.add(new Monk(darkSide, heroName, x, y++)); break;
            }
        }
        darkSide.addAll(darkTeam);
        darkSide.addAll(darkPeasant);
    }
}