/*
* Nome: <Hélder Henrique Sousa Dias Branco>
* Número: <8200302>
* Turma: <LEI12T3>
*
* Nome: <Ian Costa>
* Número: <8220005>
* Turma: <LEI12T4>
 */
package Menus;

import java.util.Scanner;

/**
 * Manages the menu options.
 *
 * @author iandi
 */
public class MenuManager {

    private static final int MAX_SIZE = 300;
    private int currentOption = 0;
    private MenuDisplay[] menuStack;
    private int lastOption = currentOption--;

    public int getInput() {
        int option;
        Scanner scanner = new Scanner(System.in);
        option = scanner.nextInt();
        currentOption++;
        return option;
    }

    public MenuManager() {
        menuStack = new MenuDisplay[MAX_SIZE];
    }

    public void displayMenu(MenuDisplay menu) {
        if (lastOption < MAX_SIZE - 1) {
            menuStack[++currentOption] = menu;
            menu.display();
        } else {
            System.out.println("Menu stack is full. Can't push new menu.");
        }
    }

    public void goBack() {

        if (lastOption >= 0) {
            MenuDisplay previousMenu = menuStack[lastOption];
            previousMenu.display();
        } else {
            System.out.println("Cannot go back further. Exiting program.");
            System.exit(0);
        }
    }
}
