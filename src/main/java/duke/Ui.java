package duke;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private static final String LINE_BREAK = "＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿";


    private Scanner sc;

    Ui() {
        sc = new Scanner(System.in);
    }

    /**
     * Displays the given message between horizontal lines
     *
     * @param msg String to output
     */
    public String displayMessage(String msg) {
        String indentedMsg = indent(msg);
        System.out.println(LINE_BREAK);
        System.out.println(indentedMsg);
        System.out.println(LINE_BREAK);

        return indentedMsg;
    }

    public String displayError(String msg) {
        return displayMessage("☹ OOPS!!! \n" + msg);
    }

    public String readNextInput() {
        return sc.nextLine();
    }

    public void list(ArrayList<Task> allTasks) {
        String list = "";
        for (int i = 1; i <= allTasks.size(); i++) {
            list += i + ". " + allTasks.get(i - 1).toString() + "\n";
        }

        if (list.isBlank()) {
            displayMessage("Congrats! You have no tasks!");
            return;
        }

        displayMessage(list.trim());
    }

    private static String indent(String msg) {
        return msg.replaceAll("(?m)^", "\t");
    }
}
