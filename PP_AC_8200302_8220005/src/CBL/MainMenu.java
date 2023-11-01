/*
* Nome: <Hélder Henrique Sousa Dias Branco>
* Número: <8200302>
* Turma: <LEI12T3>
*
* Nome: <Ian Costa>
* Número: <8220005>
* Turma: <LEI12T4>
 */
package CBL;

import Menus.MenuManager;
import Menus.MenuStartManagement;

/**
 *
 * @author iandi
 */
public class MainMenu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Manager universalManager = new Manager(); //this will be the bridge to manage everything on the program

        MenuManager menuManager = new MenuManager();

        MenuStartManagement.handleStartMenu(menuManager, universalManager);
    }

}
