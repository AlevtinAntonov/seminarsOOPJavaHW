package HW07;

import static HW07.chars.Init.*;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        init();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            ConsoleView.view();

            for (int i = 0; i < sortLists.size(); i++) {
                if (sortLists.get(i).getGang().equals(whiteSide)) {
                    for (int j = 0; j < whiteSide.size(); j++) {
                        if (sortLists.get(i).equals(whiteSide.get(j))){
                            whiteSide.get(j).step(darkSide);
                        }
                    }
                } else if (sortLists.get(i).getGang().equals(darkSide)){
                    for (int j = 0; j < darkSide.size(); j++) {
                        if (sortLists.get(i).equals(darkSide.get(j))){
                            darkSide.get(j).step(whiteSide);
                        }
                    }
                }
            }
            scanner.nextLine();
        }
    }
}