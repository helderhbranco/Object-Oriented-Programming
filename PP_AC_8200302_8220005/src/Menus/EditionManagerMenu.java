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

import CBL.Edition;
import CBL.Manager;
import java.time.LocalDate;
import ma02_resources.project.Status;

/**
 *
 * @author iandi
 */
public class EditionManagerMenu implements MenuDisplay {

    @Override
    public void display() {
        System.out.println("Edition Manager:");
        System.out.println("1 - Create new Edition"); //needs input
        System.out.println("2 - Remove Edition"); //needs input
        System.out.println("3 - Editions List");
        System.out.println("4 - Set Edition status to Active"); //needs input
        System.out.println("5 - Create new Project and add to Edition"); //needs input
        System.out.println("6 - Remove Project from Edition"); //needs input
        System.out.println("7 - Check Edition progress"); //needs..
        System.out.println("8 - Check Edition Project progress"); //needs
        System.out.println("9 - Check Edition tasks in fault"); //needs
        System.out.println("10 - Check Edition Project tasks in fault"); //needs
        System.out.println("0 - Exit");
    }

    public static void handleEditionManagerMenu(MenuManager menuManager,
            Manager manager) {

        EditionManagerMenu editionManager = new EditionManagerMenu();
        boolean isEditionMenuRunning = true;

        String editionName;
        String projectName;

        while (isEditionMenuRunning) {

            menuManager.displayMenu(editionManager);

            int option;

            try {
                option = menuManager.getInput();
            } catch (Exception e) {
                option = -1;
            }

            switch (option) {
                case 1:
                    try {
                    manager.addEdition(editionManager.createEdition(manager));
                    System.out.println("Operation succesful");
                } catch (Exception e) {
                    System.err.println(e.getMessage()
                            + "Edition creation failed.");
                }
                break;
                case 2:
                    editionManager.removeEdition(manager);
                    break;
                case 3:
                    manager.listEditions();
                    break;
                case 4:
                    try {
                    System.out.println("Enter the name of the Edition you "
                            + "wish to Activate:\n");
                    manager.setStatusActive(
                            manager.getEdition(UserInput.getString()));
                    System.out.println("Operation succesful.");
                } catch (Exception e) {
                    System.err.println(e.getMessage()
                            + "Edition name is invalid.");
                }
                break;
                case 5:
                    editionManager.createProject(manager);
                    break;
                case 6:
                    editionManager.removeProject(manager);
                    break;
                case 7:
                    try {
                    System.out.println("Enter the name of the Edition you "
                            + "wish to Check Progression:\n");
                    System.out.println(manager.progressEdition(
                            manager.getEdition(UserInput.getString())));
                    System.out.println("Operation succesful.");
                } catch (Exception e) {
                    System.err.println(e.getMessage()
                            + "Edition name is invalid.");
                }
                break;
                case 8:
                    try {
                    System.out.println("Enter the name of the Edition you "
                            + "wish to Check a Project's progression:\n");
                    editionName = UserInput.getString();

                    System.out.println("Enter the name of the Project you "
                            + "wish to Check progression:\n");
                    projectName = UserInput.getString();

                    System.out.println(manager.progressProject_Edition(
                            manager.getEdition(editionName), projectName));
                    System.out.println("Operation succesful.");
                } catch (Exception e) {
                    System.err.println(e.getMessage() + "Edition name or "
                            + "Project name is invalid.");
                }
                break;
                case 9:
                    try {
                    System.out.println("Enter the name of the Edition you "
                            + "wish to Check the tasks in fault:\n");
                    System.out.println(manager.Editions_Tasks_in_fault(
                            manager.getEdition(UserInput.getString())));
                    System.out.println("Operation succesful.");
                } catch (Exception e) {
                    System.err.println(e.getMessage()
                            + "Edition name is Invalid.");
                }
                break;
                case 10:
                    try {
                    System.out.println("Enter the name of the Edition you "
                            + "wish to Check a Project's tasks in fault:\n");
                    editionName = UserInput.getString();

                    System.out.println("Enter the name of the Project you "
                            + "wish to Check the tasks in fault:\n");
                    projectName = UserInput.getString();

                    System.out.println(manager.Edition_Project_Tasks_in_fault(
                            manager.getEdition(editionName), projectName));
                    System.out.println("Operation succesful.");
                } catch (Exception e) {
                    System.err.println(e.getMessage()
                            + "Edition name or Project name is invalid.");
                }
                break;
                case 0:
                    isEditionMenuRunning = false;
                    return;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

    }

    public Edition createEdition(Manager manager) {

        String editionName;
        String fileName;
        LocalDate start;
        LocalDate end;

        do {
            System.out.println("Enter the name of the new Edition:\n");
            try {
                editionName = UserInput.getString();

            } catch (Exception e) {
                System.err.println(e.getMessage());
                editionName = null;
            }
        } while (editionName == null);

        do {
            System.out.println("Enter the name of the file for the edition:\n");
            try {
                fileName = UserInput.getString();

            } catch (Exception e) {
                System.err.println(e.getMessage());
                fileName = null;
            }
        } while (fileName == null);

        do {
            System.out.println("Enter the starting date of the Edition: "
                    + "(YYYY-MM-DD)\n");
            try {
                start = UserInput.getLocalDate();

            } catch (Exception e) {
                System.err.println(e.getMessage());
                start = null;
            }
        } while (start == null);

        do {
            System.out.println("Enter the finishing date of the Edition: "
                    + "(YYYY-MM-DD)\n");
            try {
                end = UserInput.getLocalDate();

            } catch (Exception e) {
                System.err.println(e.getMessage());
                end = null;
            }
        } while (end == null);

        Edition edition = new Edition(editionName, fileName, start, end,
                Status.INACTIVE);

        return edition;
    }

    public void removeEdition(Manager manager) {
        UserInput input = new UserInput();

        try {
            System.out.println("Enter the name of the Edition you wish to "
                    + "remove:\n");

            manager.removeEdition(input.getString());

            System.out.println("Edition removal succesful");
        } catch (Exception e) {
            System.err.println(e.getMessage() + "Edition removal failed.");
        }
    }

    public void createProject(Manager manager) {

        String projectName;
        String projectDesc;
        String editionName;
        String[] tags = new String[1];

        do {
            System.out.println("Enter the name of the new Project:\n");
            try {
                projectName = UserInput.getString();

            } catch (Exception e) {
                System.err.println(e.getMessage());
                projectName = null;
            }
        } while (projectName == null);

        do {
            System.out.println("Enter the description of the new Project:\n");
            try {
                projectDesc = UserInput.getString();

            } catch (Exception e) {
                System.err.println(e.getMessage());
                projectDesc = null;
            }
        } while (projectDesc == null);

        do {
            System.out.println("Enter the name of the Edition that will "
                    + "contain the project:\n");
            try {
                editionName = UserInput.getString();

            } catch (Exception e) {
                System.err.println(e.getMessage());
                editionName = null;
            }
        } while (editionName == null);

        try {
            manager.getEdition(editionName).addProject(projectName,
                    projectDesc, tags);
            System.out.println("Project Creation succesful.");
        } catch (Exception e) {
            System.err.println(e.getMessage() + "Project creation failed.");
        }
    }

    public void removeProject(Manager manager) {

        String editionName;
        String projectName;

        do {
            System.out.println("Enter the name of the Edition you "
                    + "wish to remove the Project from:\n");
            try {
                editionName = UserInput.getString();

            } catch (Exception e) {
                System.err.println(e.getMessage());
                editionName = null;
            }
        } while (editionName == null);

        do {
            System.out.println("Enter the name of the Project you wish to "
                    + "remove:\n");
            try {
                projectName = UserInput.getString();

            } catch (Exception e) {
                System.err.println(e.getMessage());
                projectName = null;
            }
        } while (projectName == null);

        try {
            manager.getEdition(editionName).removeProject(projectName);
            System.out.println("Project removal succesful.");
        } catch (Exception e) {
            System.err.println(e.getMessage() + "Project removal failed.");
        }
    }
}
