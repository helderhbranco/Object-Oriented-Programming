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

import ma02_resources.participants.Instituition;
import ma02_resources.participants.Participant;
import ma02_resources.project.Status;

/**
 *
 * @author Helde
 */
public class Manager implements My_interfaces.My_Interface_manager {

    private final int FACTOR = 2;

    private static int editionsSize = 2;
    private int participantsSize = 5;
    private int institutionsSize = 5;

    private int n_editions;
    private int n_participants;
    private int n_institutions;

    private Edition[] editions;
    private Participant[] participants;
    private Instituition[] institutions;

    public Manager() {
        this.n_editions = 0;
        this.n_participants = 0;
        this.n_institutions = 0;
        this.editions = new Edition[this.editionsSize];
        this.participants = new Participant[this.participantsSize];
        this.institutions = new Instituition[this.institutionsSize];
    }

    @Override
    public int getN_editions() {
        return this.n_editions;
    }

    /**
     *
     * @return
     */
    @Override
    public int getN_participants() {
        return this.n_participants;
    }

    /**
     *
     * @return
     */
    @Override
    public int getN_institutions() {
        return this.n_institutions;
    }

    @Override
    public Edition[] getEditions() {
        return this.editions;
    }

    /**
     *
     * @return
     */
    @Override
    public Participant[] getParticipants() {
        return this.participants;
    }

    /**
     *
     * @param email
     * @return
     */
    @Override
    public Participant getParticipant(String email) {
        for (int i = 0; i < n_participants; i++) {
            if (this.participants[i].getEmail().equals(email)) {
                return this.participants[i];
            }
        }
        throw new NullPointerException("That email does not exist!");
    }

    @Override
    public void listParticipants() {
        for (int i = 0; i < this.n_participants; i++) {
            System.out.println(this.participants[i].toString());;
        }
        System.out.println(this.n_participants + "/" + this.participants.length);
    }

    /**
     *
     * @return
     */
    @Override
    public Instituition[] getInstitutions() {
        return this.institutions;
    }

    /**
     *
     * @param email
     * @return
     */
    @Override
    public Instituition getInstitution(String email) {
        for (int i = 0; i < n_institutions; i++) {
            if (this.institutions[i].getEmail().equals(email)) {
                return this.institutions[i];
            }
        }
        return null;
    }

    @Override
    public void listInstitutions() {
        for (int i = 0; i < this.n_institutions; i++) {
            System.out.println(this.institutions[i].toString());;
        }
        System.out.println(this.n_institutions + "/" + this.institutions.length);
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public Edition getEdition(String name) {
        return this.editions[findEdition(name)];
    }

    /**
     *
     * @param p
     */
    @Override
    public void addParticipant(Participant p) {
        expandParticipants();

        this.participants[n_participants++] = p;

    }

    @Override
    public void expandParticipants() {
        Participant[] tempList = new Participant[this.participants.length * FACTOR];
        System.arraycopy(this.participants, 0, tempList, 0, this.participants.length);
        this.participants = tempList;
        this.participantsSize *= FACTOR;
    }

    @Override
    public void addInstitution(Instituition i) {
        expandInstitutions();

        if (getInstitution(i.getEmail()) != null) {
            throw new IllegalArgumentException("An institution with this email already exists.");
        }

        this.institutions[n_institutions++] = i;

    }

    @Override
    public void expandInstitutions() {
        Instituition[] tempList = new Instituition[this.institutions.length * FACTOR];
        System.arraycopy(this.institutions, 0, tempList, 0, this.institutions.length);
        this.institutions = tempList;
        this.institutionsSize *= FACTOR;
    }

    @Override
    public void addEdition(Edition ed) {

        expandEditions();

        try {
            existEdition(ed.getName());
            this.editions[n_editions++] = ed;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeEdition(String edName) {

        int index = findEdition(edName);

        for (int i = index; i < n_editions - 1; i++) {

            this.editions[i] = this.editions[i + 1];

        }

        this.editions[n_editions--] = null;

    }

    @Override
    public void listEditions() {
        for (int i = 0; i < this.n_editions; i++) {
            System.out.println(this.editions[i].toString());
        }
        System.out.println(this.n_editions + "/" + this.editions.length);
    }

    @Override
    public int getN_Projects(Edition edition) {

        return edition.getNumberOfProjects();

    }

    /**
     *
     * @param ed
     */
    @Override
    public void setStatusActive(Edition ed) {

        try {
            int index = findEdition(ed.getName());

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < this.n_editions; i++) {
            if (this.editions[i].equals(ed)) {

                this.editions[i].setStatus(Status.ACTIVE);

            } else {
                this.editions[i].setStatus(Status.INACTIVE);
            }

        }

    }

    /**
     *
     * @param edition
     * @return
     */
    @Override
    public String progressEdition(Edition edition) {
        int count = 0;
        String temp = "";
        String progress = "";
        for (int i = 0; i < edition.getNumberOfProjects(); i++) {
            if (edition.getProjects()[i].isCompleted()) {
                temp += edition.getProjects()[i].toString() + "\n";
                count++;
            }
        }
        progress = "Progress=" + count + "/" + edition.getNumberOfProjects() + "Projects Completed:\n" + temp;
        return progress;
    }

    /**
     *
     * @param edition
     * @param name
     * @return
     */
    @Override
    public String progressProject_Edition(Edition edition, String name) {

        String progress = edition.toString() + "\n" + edition.getProjectProgress(name);

        return progress;
    }

    /**
     *
     * @param edition
     * @param name
     * @return
     */
    @Override
    public String Edition_Project_Tasks_in_fault(Edition edition, String name) {

        String temp = edition.toString() + "\n" + edition.Project_Task_in_fault(name);

        return temp;
    }

    /**
     *
     * @param edition
     * @return
     */
    @Override
    public String Editions_Tasks_in_fault(Edition edition) {
        int count = 0;
        String temp = "";

        for (int i = 0; i < edition.getNumberOfProjects(); i++) {
            if (edition.getProjects()[i].isCompleted() == false) {
                count++;
                temp += edition.toString() + "Projetos com Tasks em falta" + count + "/" + edition.getProjects().length + edition.getProjects()[i].getName() + "," + "\n";
            }
        }
        return temp;
    }

    private void existEdition(String name) throws IllegalArgumentException {

        for (int i = 0; i < n_editions; i++) {
            if (this.editions[i].getName().equals(name)) {

                throw new IllegalArgumentException("Edition Already exists!");

            }

        }

    }

    private int findEdition(String name) throws NullPointerException {

        for (int i = 0; i < n_editions; i++) {
            if (this.editions[i].getName().equals(name)) {

                return i;
            }

        }
        throw new NullPointerException("That Edition does not exist!");

    }

    private void expandEditions() {

        Edition[] temp = new Edition[n_editions * FACTOR];
        if (n_editions == this.editions.length) {
            {
                for (int i = 0; i < n_editions; i++) {

                    temp[i] = this.editions[i];

                }
            }

            this.editions = temp;

        }

    }
}
