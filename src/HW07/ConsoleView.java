package HW07;

import HW07.chars.Vector2;

import java.util.Collections;

import static HW07.chars.Init.*;

public class ConsoleView {

public static int step = 0;
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String mid10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");

    public static void view(){
        if (step++ == 0) {
            System.out.print(AnsiColors.ANSI_RED+"First step!"+AnsiColors.ANSI_RESET);
            System.out.print(AnsiColors.ANSI_BLUE +
                    String.join("", Collections.nCopies(15, formatDiv(" "))) + "White Team" + AnsiColors.ANSI_RESET);
            System.out.println(AnsiColors.ANSI_GREEN +
                    String.join("", Collections.nCopies(45, formatDiv(" "))) + "Dark Team" + AnsiColors.ANSI_RESET);
        } else {
            System.out.print(AnsiColors.ANSI_RED + "Step: "+step+AnsiColors.ANSI_RESET);
            System.out.print(AnsiColors.ANSI_BLUE +
                    String.join("", Collections.nCopies(15, formatDiv(" "))) + "White Team" + AnsiColors.ANSI_RESET);
            System.out.println(AnsiColors.ANSI_GREEN +
                    String.join("", Collections.nCopies(45, formatDiv(" "))) + "Dark Team" + AnsiColors.ANSI_RESET);
        }

        System.out.println(ConsoleView.top10);

        int npcIndex = 0;

        for (int i = 1; i <= GANG_SIZE - 1; i++) {
            for (int j = 1; j <= GANG_SIZE; j++) {
                System.out.print(getChar(new Vector2(j, i)));
            }
            System.out.print("|");
            System.out.println(PrintInfo(npcIndex));
            System.out.println(ConsoleView.mid10);
            npcIndex++;
        }

        for (int j = 1; j <= GANG_SIZE; j++) {
            System.out.print(getChar(new Vector2(j, 10)));
        }
        System.out.print("|");
        System.out.println(PrintInfo(npcIndex));
        System.out.println(ConsoleView.bottom10);
    }

    private static String getChar(Vector2 position){

        String str = "| ";
        boolean alive = false;
        for (int i = 0; i < GANG_SIZE; i++) {
            if (darkSide.get(i).getPosition().isEqual(position))
            {
                if(darkSide.get(i).getStatus().equals("Died"))
                    str ="|"+AnsiColors.ANSI_RED+darkSide.get(i).getName().toUpperCase().charAt(0)+AnsiColors.ANSI_RESET;
                else {
                    str ="|"+AnsiColors.ANSI_GREEN+darkSide.get(i).getName().toUpperCase().charAt(0)+AnsiColors.ANSI_RESET;
                    alive = true;
                }
            }
            if (whiteSide.get(i).getPosition().isEqual(position) && !alive)
            {
                if(whiteSide.get(i).getStatus().equals("Died"))
                    str ="|"+AnsiColors.ANSI_RED+ whiteSide.get(i).getName().toUpperCase().charAt(0)+AnsiColors.ANSI_RESET;
                else str ="|"+AnsiColors.ANSI_BLUE+ whiteSide.get(i).getName().toUpperCase().charAt(0)+AnsiColors.ANSI_RESET;
            }
        }
        return str;
    }

        private static String PrintInfo(int npcIndex)
        {
            String str = "";

            if(whiteSide.get(npcIndex).getStatus().equals("Died"))
                str +="     " + AnsiColors.ANSI_RED+whiteSide.get(npcIndex).getInfo()+AnsiColors.ANSI_RESET;
            else str +="     " + AnsiColors.ANSI_BLUE+ whiteSide.get(npcIndex).getInfo()+AnsiColors.ANSI_RESET;
            if(darkSide.get(npcIndex).getStatus().equals("Died"))
                str +="\t" + AnsiColors.ANSI_RED+darkSide.get(npcIndex).getInfo()+AnsiColors.ANSI_RESET;
            else str +="\t" + AnsiColors.ANSI_GREEN+darkSide.get(npcIndex).getInfo()+AnsiColors.ANSI_RESET;

            return str;
        }

    private static String formatDiv(String str){
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500')
                .replace("s", "...")
                .replace("o", "___");
    }


}
