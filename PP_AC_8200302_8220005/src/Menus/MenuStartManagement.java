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

import CBL.Manager;

public class MenuStartManagement implements MenuDisplay {

    @Override
    public void display() {
        System.out.println("Welcome to the main menu");
        System.out.println("1 - Edition manager");
        System.out.println("2 - Project Manager");
        System.out.println("3 - Participant Manager");
        System.out.println("0 - Exit");
    }

    /**
     * Will handle the Start menu, giving the possibility for the user to
     * navigate through the many Management menus of the application.
     *
     * @param menuManager
     * @param manager
     */
    public static void handleStartMenu(MenuManager menuManager, Manager manager) {

        MenuStartManagement menuStart = new MenuStartManagement();
        boolean isRunning = true;

        while (isRunning) {
            menuManager.displayMenu(menuStart);

            int option;

            try {
                option = menuManager.getInput();
            } catch (Exception e) {
                option = -1;
            }

            switch (option) {
                case 1:
                    EditionManagerMenu.handleEditionManagerMenu(menuManager,
                            manager);
                    break;
                case 2:
                    try {
                    System.out.println("Enter the name of the Edition you "
                            + "wish to manage the projects.");
                    ProjectManagerMenu.handleProjectManagerMenu(menuManager,
                            manager, manager.getEdition(UserInput.getString()));
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                break;
                case 3:
                    ParticipantManagerMenu.handleParticipantManagerMenu(
                            menuManager, manager);
                    break;
                case 0:
                    isRunning = false;
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

    }
}
