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
import StakeHolders.Contact;
import StakeHolders.Facilitator;
import StakeHolders.Partner;
import StakeHolders.Student;
import java.io.IOException;
import ma02_resources.participants.Instituition;
import ma02_resources.participants.InstituitionType;
import ma02_resources.participants.Participant;

public class ParticipantManagerMenu implements MenuDisplay {

    @Override
    public void display() {
        System.out.println("Participant Manager:");
        System.out.println("1 - Create Participants");
        System.out.println("2 - Create Institution");
        System.out.println("3 - Change Contact Information");
        System.out.println("4 - Set Institution");
        System.out.println("5 - List Participants");
        System.out.println("6 - List Institutions");
        System.out.println("0 - Exit");
    }

    /**
     * Handles the switch menu for the management of Participants.
     *
     * @param menuManager
     * @param manager
     */
    public static void handleParticipantManagerMenu(MenuManager menuManager, Manager manager) {

        ParticipantManagerMenu participantManager = new ParticipantManagerMenu();
        boolean isParticipantMenuRunning = true;

        while (isParticipantMenuRunning) {

            menuManager.displayMenu(participantManager);

            int option;

            try {
                option = menuManager.getInput();
            } catch (Exception e) {
                option = -1;
            }

            switch (option) {
                case 1:
                    participantManager.createParticipant(manager);
                    break;
                case 2:
                    participantManager.createInstitution(manager);
                    break;
                case 3:
                    try {
                    System.out.println("Enter the email of the Participant you want to change the Contact Info:\n");
                    participantManager.changeContactInformation(manager.getParticipant(UserInput.getString()));
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                break;
                case 4:
                    try {
                    System.out.println("Enter the email of the Participant you want to set the Institution:\n");
                    participantManager.setParticipantInstitution(manager, manager.getParticipant(UserInput.getString()));
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                break;
                case 5:
                    manager.listParticipants();
                    break;
                case 6:
                    manager.listInstitutions();
                    break;
                case 0:
                    isParticipantMenuRunning = false;
                    return;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

    /**
     * The submenu used for choosing the participant type.
     */
    public void subMenuParticipantType() {
        System.out.println("Choose Participant Type:");
        System.out.println("1 - Student");
        System.out.println("2 - Partner");
        System.out.println("3 - Facilitator");
        System.out.println("0 - Exit");
    }

    /**
     * receives the user inputs to create a new instance of a type of
     * participant.
     *
     * @param manager
     */
    public void createParticipant(Manager manager) {

        boolean isSubMenuRunning = true;

        Contact info = new Contact();
        Instituition institute = new StakeHolders.Instituition();
        String name, email;

        while (isSubMenuRunning) {

            subMenuParticipantType();

            int option;

            try {
                option = UserInput.getInt();
            } catch (Exception e) {
                option = -1;
            }

            switch (option) {
                case 1://Student
                    int number;
                    do {
                        System.out.println("Enter the Student's name:\n");
                        try {
                            name = UserInput.getString();
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                            name = null;
                        }
                    } while (name == null);

                    do {
                        System.out.println("Enter the Student's number:\n");
                        number = UserInput.getInt();
                    } while (number == -1);

                    do {
                        System.out.println("Enter the Student's email:\n");
                        try {
                            email = UserInput.getString();
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                            email = null;
                        }
                    } while (email == null);

                    Student student = new Student(info, institute, name, email);
                    manager.addParticipant(student);
                    break;
                case 2://Partner
                    String vat,
                     website;

                    do {
                        System.out.println("Enter the Partner's vat:\n");
                        try {
                            vat = UserInput.getString();
                            if (!vat.matches("[0-9]+")) {
                                System.err.println("Vat number cannot contain letters.");
                                throw new IOException();
                            }
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                            vat = null;
                        }
                    } while (vat == null);

                    do {
                        System.out.println("Enter the Partner's website:\n");
                        try {
                            website = UserInput.getString();
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                            website = null;
                        }
                    } while (website == null);

                    do {
                        System.out.println("Enter the Partner's name:\n");
                        try {
                            name = UserInput.getString();
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                            name = null;
                        }
                    } while (name == null);

                    do {
                        System.out.println("Enter the Partner's email:\n");
                        try {
                            email = UserInput.getString();
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                            email = null;
                        }
                    } while (email == null);

                    Partner partner = new Partner(vat, website, info, institute, name, email);
                    manager.addParticipant(partner);
                    break;
                case 3://Facilitator
                    String areaOfExpertise;

                    do {
                        System.out.println("Enter the Facilitator's area of expertise:\n");
                        try {
                            areaOfExpertise = UserInput.getString();
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                            areaOfExpertise = null;
                        }
                    } while (areaOfExpertise == null);

                    do {
                        System.out.println("Enter the Facilitator's name:\n");
                        try {
                            name = UserInput.getString();
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                            name = null;
                        }
                    } while (name == null);

                    do {
                        System.out.println("Enter the Facilitator's email:\n");
                        try {
                            email = UserInput.getString();
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                            email = null;
                        }
                    } while (email == null);

                    Facilitator facilitator = new Facilitator(areaOfExpertise, info, institute, name, email);
                    manager.addParticipant(facilitator);
                    break;
                case 0:
                    isSubMenuRunning = false;
                    break;
                default:
                    System.out.println("Invalid Option.");
                    break;
            }
        }
    }

    /**
     * Submenu used for choosing de institution type
     */
    public void subMenuInstitutionType() {
        System.out.println("Choose the institution type:");
        System.out.println("1 - University");
        System.out.println("2 - Company");
        System.out.println("3 - NGO");
        System.out.println("4 - Other(Not specified)");
    }

    /**
     * Receives User Inputs to create a new instance of an Institution
     *
     * @param manager
     */
    public void createInstitution(Manager manager) {

        boolean isSubMenuRunning = true;

        Contact info;
        InstituitionType type;
        String name, email, website, description;

        info = UserInput.getContact();

        while (isSubMenuRunning) {

            subMenuInstitutionType();

            int option;

            try {
                option = UserInput.getInt();
            } catch (Exception e) {
                option = -1;
            }

            switch (option) {
                case 1:
                    type = InstituitionType.UNIVERSITY;
                    isSubMenuRunning = false;
                    break;
                case 2:
                    type = InstituitionType.COMPANY;
                    isSubMenuRunning = false;
                    break;
                case 3:
                    type = InstituitionType.NGO;
                    isSubMenuRunning = false;
                    break;
                case 4:
                    type = InstituitionType.OTHER;
                    isSubMenuRunning = false;
                    break;
                default:
                    System.out.println("Invalid Option.");
                    break;
            }
        }

        do {
            System.out.println("Enter the Institution's name:\n");
            try {
                name = UserInput.getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                name = null;
            }
        } while (name == null);

        do {
            System.out.println("Enter the Institution's email:\n");
            try {
                email = UserInput.getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                email = null;
            }
        } while (email == null);

        do {
            System.out.println("Enter the Institution's website:\n");
            try {
                website = UserInput.getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                website = null;
            }
        } while (website == null);

        do {
            System.out.println("Enter the Institution's description:\n");
            try {
                description = UserInput.getString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                description = null;
            }
        } while (description == null);

        Instituition institution = new StakeHolders.Instituition(info, InstituitionType.NGO, name, email, website, description);
        manager.addInstitution(institution);
    }

    /**
     * Changes de contact information of a specified Participant.
     *
     * @param p
     */
    public void changeContactInformation(Participant p) {
        Contact info;

        info = UserInput.getContact();

        p.setContact(info);
        System.out.println("Operation Succesful.");
    }

    /**
     * Set the Institution of a specified Participant.
     *
     * @param manager
     * @param p
     */
    public void setParticipantInstitution(Manager manager, Participant p) {
        Instituition institution;

        try {
            System.out.println("Enter the email of the institution:\n");
            institution = manager.getInstitution(UserInput.getString());
            p.setInstituition(institution);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
