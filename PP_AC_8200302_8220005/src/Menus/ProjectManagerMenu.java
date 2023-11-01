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
import CBL.Project;
import StakeHolders.Student;

public class ProjectManagerMenu implements MenuDisplay {

    @Override
    public void display() {
        System.out.println("Project Manager:");
        System.out.println("1 - Add Participant to Project");
        System.out.println("2 - Remove Participant from Project");
        System.out.println("3 - Add Submission to Edition");
        System.out.println("4 - Add Tag to Project");
        System.out.println("5 - Remove Tag from Project");
        System.out.println("6 - Add Task to Project");
        System.out.println("7 - List Projects");
        System.out.println("8 - List Projects by Tag");
        System.out.println("9 - List Project Participants");
        System.out.println("10 - List Participants by Institution");
        System.out.println("11 - List Participants by City");
        System.out.println("0 - Exit");
    }

    /**
     * Will handle the switch menu for the management of Projects.
     *
     * @param menuManager
     * @param manager
     * @param edition
     */
    public static void handleProjectManagerMenu(MenuManager menuManager,
            Manager manager, Edition edition) {

        ProjectManagerMenu projectManager = new ProjectManagerMenu();
        boolean isProjectMenuRunning = true;

        while (isProjectMenuRunning) {

            menuManager.displayMenu(projectManager);

            int option;

            try {
                option = menuManager.getInput();
            } catch (Exception e) {
                option = -1;
            }

            switch (option) {
                case 1:
                    projectManager.addParticipantToProject(manager, edition);
                    break;
                case 2:
                    projectManager.removeParticipantFromProject(manager, edition);
                    break;
                case 3:
                    projectManager.addSubmissionToEdition(edition);
                    break;
                case 4:
                    projectManager.addTagToProject(edition);
                    break;
                case 5:
                    projectManager.removeTagFromProject(edition);
                    break;
                case 6:
                    projectManager.addTaskToProject(edition);
                    break;
                case 7:
                    edition.listProjects();
                    break;
                case 8:
                    try {
                    System.out.println("Enter the Tag:\n");
                    edition.listProjectsByTag(UserInput.getString());
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                break;
                case 9:
                    try {
                    System.out.println("Enter the name of the project you want "
                            + "to list the Participants:\n");
                    edition.getProject(UserInput.getString()).listParticipants();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                break;
                case 10:
                    try {
                    System.out.println("Enter the name of the project you want "
                            + "to list the Participants by Institution:\n");
                    projectManager.participantsByInstitution(edition.getProject(UserInput.getString()));
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                break;
                case 11:
                    try {
                    System.out.println("Enter the name of the project you want "
                            + "to list the Participants by city:\n");
                    projectManager.participantsByCity(edition.getProject(UserInput.getString()));
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                break;
                case 0:
                    isProjectMenuRunning = false; //goes out of menuAdmin
                    return;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

    /**
     * Will ask the User inputs for the desired project, and for the participant
     * that will be then added to the aforementioned project, in case the
     * project or participant doesnt exist, an exception will be thrown.
     *
     * @param manager
     * @param edition
     */
    public void addParticipantToProject(Manager manager, Edition edition) {
        String participantEmail, projectName;

        try {
            System.out.println("Enter the name of the Project you want to add "
                    + "the Participant:\n");
            projectName = UserInput.getString();

            System.out.println("Enter the email of the Participant you want to "
                    + "add:\n");
            participantEmail = UserInput.getString();

            edition.getProject(projectName).addParticipant(
                    manager.getParticipant(participantEmail));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Will receive the User input to identify a participant to be removed from
     * a specified project.
     *
     * @param manager
     * @param edition
     */
    public void removeParticipantFromProject(Manager manager, Edition edition) {
        String participantEmail, projectName;

        try {
            System.out.println("Enter the name of the Project you want to remove "
                    + "the Participant:\n");
            projectName = UserInput.getString();

            System.out.println("Enter the email of the Participant you want to "
                    + "remove:\n");
            participantEmail = UserInput.getString();

            edition.getProject(projectName).removeParticipant(participantEmail);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Will add a custom tag to a specified project.
     *
     * @param edition
     */
    public void addTagToProject(Edition edition) {
        String tag, projectName;

        try {
            System.out.println("Enter the name of the Project you want to add "
                    + "the Tag:\n");
            projectName = UserInput.getString();

            System.out.println("Enter the Tag you want to add:\n");
            tag = UserInput.getString();

            edition.getProject(projectName).addTag(tag);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * will remove a tag from a project.
     *
     * @param edition
     */
    public void removeTagFromProject(Edition edition) {
        String tag, projectName;

        try {
            System.out.println("Enter the name of the Project you want to "
                    + "remove the Tag from:\n");
            projectName = UserInput.getString();

            System.out.println("Enther the Tag you want to remove:\n");
            tag = UserInput.getString();

            edition.getProject(projectName).removeTag(tag);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * adds a submission for a task in a project in the current edition.
     *
     * @param edition
     */
    public void addSubmissionToEdition(Edition edition) {
        String projectName, taskTitle, taskText, studentEmail;

        try {
            System.out.println("Enter the name of the Project being submitted:\n");
            projectName = UserInput.getString();

            System.out.println("Enter the email of the Student submitting the "
                    + "project:\n");
            studentEmail = UserInput.getString();

            System.out.println("Enter the title of the Task being submitted:\n");
            taskTitle = UserInput.getString();

            System.out.println("Enter the text of the Task being submitted:\n");
            taskText = UserInput.getString();

            edition.addSubmission(edition, projectName, taskTitle,
                    (Student) edition.getProject(projectName).getParticipant(
                            studentEmail), taskText);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Adds a new task to a project
     *
     * @param edition
     */
    public void addTaskToProject(Edition edition) {
        String projectName;

        try {
            System.out.println("Enter the name of the Project you want to add "
                    + "the Task:\n");
            projectName = UserInput.getString();

            edition.getProject(projectName).addTask(UserInput.getTask());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * asks for a specific Institution identifier, this case the email, and will
     * list every participant belonging to this institution. fails if
     * institution doesn't exist.
     *
     * @param project
     */
    public void participantsByInstitution(Project project) {
        String email;

        try {
            System.out.println("Enter the email of the institution:\n");
            email = UserInput.getString();
            project.listParticipantByInstitution(email);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    /**
     * Asks for a specific City identifier, this case the name, and will list
     * every participant from that city. fails if city doesn't exist.
     *
     * @param project
     */
    public void participantsByCity(Project project) {
        String name;

        try {
            System.out.println("Enter the name of the city:\n");
            name = UserInput.getString();
            project.listParticipantByCity(name);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
