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

import ma02_resources.participants.Participant;
import ma02_resources.project.Task;
import ma02_resources.project.exceptions.IllegalNumberOfParticipantType;
import ma02_resources.project.exceptions.IllegalNumberOfTasks;
import ma02_resources.project.exceptions.ParticipantAlreadyInProject;
import ma02_resources.project.exceptions.TaskAlreadyInProject;

/**
 *
 * @author Helde
 */
public class Project implements ma02_resources.project.Project, My_interfaces.My_Interface_project {

    private static int SIZE = 50;

    private final int TAGS_FACTOR = 2;

    private int maxNumTags;
    private int maxNumTasks;
    private int maxNumParticipants;
    private int maxNumStudents;
    private int maxNumPartners;
    private int maxNumFacilitators;

    private String name;
    private String description;

    private int n_Participants;
    private int n_Facilitators;
    private int n_Partners;
    private int n_Students;
    private int n_Tasks;
    private int n_Tags;

    private Participant[] participants;
    private Task[] tasks;
    private String[] tags;

    /**
     *
     * @param name
     * @param description
     * @param tags
     */
    public Project(String name, String description, String[] tags) {
        this.name = name;
        this.description = description;
        this.n_Participants = 0;
        this.n_Facilitators = 0;
        this.n_Partners = 0;
        this.n_Students = 0;
        this.n_Tasks = 0;
        this.n_Tags = 0;

        this.maxNumTags = 10;

        this.participants = new Participant[SIZE];
        this.tasks = new Task[SIZE];
        this.tags = new String[maxNumTags];
    }

    public Project(int maxNumParticipants,
            int maxNumStudents, int maxNumPartners, int maxNumFacilitators,
            String name, String description, String[] tags) {
        this.maxNumParticipants = maxNumParticipants;
        this.maxNumStudents = maxNumStudents;
        this.maxNumPartners = maxNumPartners;
        this.maxNumFacilitators = maxNumFacilitators;
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.maxNumTags = 20;

        this.participants = new Participant[maxNumParticipants];
        this.tasks = new Task[SIZE];
        this.tags = new String[maxNumTags];
    }

    /**
     *
     * @return name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     *
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return description
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     *
     * @param description
     */
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return n_Participants
     */
    @Override
    public int getNumberOfParticipants() {
        return this.n_Participants;
    }

    /**
     *
     * @param n_Participants
     */
    public void setNumberOfParticipants(int n_Participants) {
        this.n_Participants = n_Participants;
    }

    /**
     *
     * @return n_Students
     */
    @Override
    public int getNumberOfStudents() {
        return this.n_Students;
    }

    /**
     *
     * @param n_Students
     */
    @Override
    public void setNumberOfStudents(int n_Students) {
        this.n_Students = n_Students;
    }

    /**
     *
     * @return n_Partners
     */
    @Override
    public int getNumberOfPartners() {
        return this.n_Partners;
    }

    /**
     *
     * @param n_Partners
     */
    public void setNumberOfPartners(int n_Partners) {
        this.n_Partners = n_Partners;
    }

    /**
     *
     * @return n_Facilitators
     */
    @Override
    public int getNumberOfFacilitators() {
        return this.n_Facilitators;
    }

    /**
     *
     * @param n_Facilitators
     */
    public void setNumberOfFacilitators(int n_Facilitators) {
        this.n_Facilitators = n_Facilitators;
    }

    /**
     *
     * @return n_Tasks
     */
    @Override
    public int getNumberOfTasks() {
        return this.n_Tasks;
    }

    /**
     *
     * @param n_Tasks
     */
    @Override
    public void setNumberOfTasks(int n_Tasks) {
        this.n_Tasks = n_Tasks;
    }

    /**
     *
     * @return maxNumTasks
     */
    @Override
    public int getMaximumNumberOfTasks() {
        return maxNumTasks;
    }

    /**
     *
     * @return maxNumParticipants
     */
    @Override
    public long getMaximumNumberOfParticipants() {
        return maxNumParticipants;
    }

    /**
     *
     * @return maxNumStudents
     */
    @Override
    public int getMaximumNumberOfStudents() {
        return maxNumStudents;
    }

    /**
     *
     * @return maxNumPartners
     */
    @Override
    public int getMaximumNumberOfPartners() {
        return maxNumPartners;
    }

    /**
     *
     * @return maxNumFacilitators
     */
    @Override
    public int getMaximumNumberOfFacilitators() {
        return maxNumFacilitators;
    }

    public int getNumberOfTags() {
        return this.n_Tags;
    }

    public void setMaxNumTasks(int maxNumTasks) {
        this.maxNumTasks = maxNumTasks;
    }

    /**
     *
     * @param tasks
     */
    @Override
    public void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }

    @Override
    public Participant[] getParticipants() {
        return this.participants;
    }

    public void setMaxNumTags(int maxNumTags) {
        this.maxNumTags = maxNumTags;
    }

    public void setMaxNumParticipants(int maxNumParticipants) {
        this.maxNumParticipants = maxNumParticipants;
    }

    public void setMaxNumStudents(int maxNumStudents) {
        this.maxNumStudents = maxNumStudents;
    }

    public void setMaxNumPartners(int maxNumPartners) {
        this.maxNumPartners = maxNumPartners;
    }

    public void setMaxNumFacilitators(int maxNumFacilitators) {
        this.maxNumFacilitators = maxNumFacilitators;
    }

    /**
     *
     * @param p
     * @throws IllegalNumberOfParticipantType
     * @throws ParticipantAlreadyInProject
     */
    @Override
    public void addParticipant(Participant p) throws IllegalNumberOfParticipantType, ParticipantAlreadyInProject {

        try {
            ParticipantExist(p);

            if (p instanceof StakeHolders.Student && n_Students == maxNumStudents) {
                throw new IllegalNumberOfParticipantType("Maximium number of student reached.");
            } else {
                if (p instanceof StakeHolders.Student) {
                    this.participants[this.n_Participants] = p;
                    this.n_Participants++;
                    this.n_Students++;
                    return;
                }
            }
            if (p instanceof StakeHolders.Facilitator && n_Facilitators == maxNumFacilitators) {
                throw new IllegalNumberOfParticipantType("Maximium number of facilitators reached.");
            } else {
                if (p instanceof StakeHolders.Facilitator) {
                    this.participants[this.n_Participants] = p;
                    this.n_Participants++;
                    this.n_Facilitators++;
                    return;
                }
            }
            if (p instanceof StakeHolders.Partner && n_Partners == maxNumPartners) {
                throw new IllegalNumberOfParticipantType("Maximium number of partners reached.");
            } else {
                if (p instanceof StakeHolders.Partner) {
                    this.participants[this.n_Participants] = p;
                    this.n_Participants++;
                    this.n_Partners++;
                    return;
                }
            }
        } catch (ParticipantAlreadyInProject e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     *
     * @param string
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Participant removeParticipant(String string) throws IllegalArgumentException {
        Participant removed;

        removed = this.participants[findParticipant(string)];

        for (int i = findParticipant(string); i < n_Participants - 1; i++) {
            this.participants[i] = this.participants[i + 1];
        }
        if (removed instanceof StakeHolders.Student) {
            this.n_Students--;
        }
        if (removed instanceof StakeHolders.Facilitator) {
            this.n_Facilitators--;
        }
        if (removed instanceof StakeHolders.Student) {
            this.n_Partners--;
        }
        this.n_Participants--;
        return removed;
    }

    @Override
    public void listParticipants() {
        for (int i = 0; i < this.n_Participants; i++) {
            System.out.println(this.participants[i].toString());;
        }
        System.out.println(this.n_Participants + "/" + this.participants.length);
    }

    @Override
    public void listTags() {
        for (int i = 0; i < this.n_Tags; i++) {
            System.out.println(this.tags[i]);;
        }
        System.out.println(this.n_Tags + "/" + this.tags.length);
    }

    /**
     *
     * @param string
     * @return Participant compare the participants using equals by the email if
     * true return that participant
     */
    @Override
    public Participant getParticipant(String string) {
        for (int i = 0; i < n_Participants; i++) {
            if (this.participants[i].getEmail().equals(string)) {
                return this.participants[i];
            }
        }
        return null;
    }

    public void listParticipantByInstitution(String email) {
        Participant[] participants = getParticipantByInstitution(email);

        for (int i = 0; i < participants.length; i++) {
            System.out.println(participants[i].toString());
        }
    }

    public Participant[] getParticipantByInstitution(String string) {
        Participant[] temp = new Participant[n_Participants];
        int counter = 0;

        for (int i = 0; i < n_Participants; i++) {
            if (this.participants[i].getInstituition().getEmail().equals(string)) {
                temp[counter++] = this.participants[i];
            }
        }
        Participant[] participantsByInst = new Participant[counter];
        System.arraycopy(temp, 0, participantsByInst, 0, counter);
        if (counter == 0) {
            throw new NullPointerException("There are no participants of that institution.");
        }
        return participantsByInst;
    }

    public void listParticipantByCity(String city) {
        Participant[] participants = getParticipantByCity(city);

        for (int i = 0; i < participants.length; i++) {
            System.out.println(participants[i].toString());
        }
    }

    public Participant[] getParticipantByCity(String string) {
        Participant[] temp = new Participant[n_Participants];
        int counter = 0;

        for (int i = 0; i < n_Participants; i++) {
            if (this.participants[i].getContact().getCity().equals(string)) {
                temp[counter++] = this.participants[i];
            }
        }
        Participant[] participantsByCity = new Participant[counter];
        System.arraycopy(temp, 0, participantsByCity, 0, counter);
        if (counter == 0) {
            throw new NullPointerException("There are no participants of that city.");
        }
        return participantsByCity;
    }

    /**
     *
     * @return Tags[]
     */
    @Override
    public String[] getTags() {
        return this.tags;
    }

    /**
     *
     * @param newTag
     */
    @Override
    public void addTag(String newTag) {
        this.tags[this.n_Tags] = newTag;
        this.n_Tags++;

        if (this.n_Tags >= this.maxNumTags) {
            expandTags();
        }
    }

    private int findTag(String tag) {
        for (int i = 0; i < n_Tags; i++) {
            if (this.tags[i].equals(tag)) {
                return i;
            }

        }
        throw new NullPointerException("That Tag does not exist!");
    }

    @Override
    public void removeTag(String tag) {
        int index = findTag(tag);

        for (int i = index; i < n_Tags - 1; i++) {

            this.tags[i] = this.tags[i + 1];

        }

        this.tags[n_Tags--] = null;

    }

    @Override
    public void expandTags() {
        String[] tempList = new String[this.tags.length * TAGS_FACTOR];
        System.arraycopy(this.tags, 0, tempList, 0, this.tags.length);
        this.tags = tempList;
        this.maxNumTags *= TAGS_FACTOR;
    }

    /**
     *
     * @param tags
     */
    @Override
    public void setTags(String[] tags) {
        this.tags = tags;
    }

    /**
     *
     * @param string
     * @return boolean, true if exist the tag, false if not
     */
    @Override
    public boolean hasTag(String string) {
        for (String t : this.tags) {
            if (t == string) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param task
     * @throws IllegalNumberOfTasks
     * @throws TaskAlreadyInProject
     */
    @Override
    public void addTask(Task task) throws IllegalNumberOfTasks,
            TaskAlreadyInProject {

        if (n_Tasks == maxNumTasks) {

            throw new IllegalNumberOfTasks("Reached the maximum of tasks");

        }
        try {
            TaskExist(task);
        } catch (TaskAlreadyInProject e) {
            System.out.println(e.getMessage());

        }
        this.tasks[this.n_Tasks++] = task;

    }

    /**
     *
     * @param string
     * @return Task compare the tasks using equals by the title if true return
     * that task
     */
    @Override
    public Task getTask(String string) {
        for (int i = 0; i < n_Tasks; i++) {
            if (this.tasks[i].getTitle().equals(string)) {
                return this.tasks[i];
            }
        }
        return null;
    }

    /**
     *
     * @return tasks
     */
    @Override
    public Task[] getTasks() {
        return this.tasks;
    }

    /**
     *
     * @return true if all the task have at least one submission, false if
     * length of the array tasks are different of n_task or some tags don't have
     * a single submission
     */
    @Override
    public boolean isCompleted() {
        for (int i = 0; i < n_Tasks; i++) {
            if (tasks[i].getNumberOfSubmissions() == 0) {
                return false;
            }
        }
        return true;

    }

    /**
     *
     * @param p
     * @return
     * @throws ma02_resources.project.exceptions.ParticipantAlreadyInProject
     * @throws IllegalArgumentException verify if submission already exist in
     * the array
     */
    @Override
    public boolean ParticipantExist(Participant p) throws ParticipantAlreadyInProject {

        for (int i = 0; i < n_Participants; i++) {
            if (this.participants[i].equals(p) == true) {
                throw new ParticipantAlreadyInProject("Participant Already exists!");
            }
        }
        /*for (Participant participant : this.participants) {
            if (participant.equals(p)== true) {              
                return true;
            }

        }*/
        return false;
    }

    /**
     *
     * @param task
     * @throws TaskAlreadyInProject
     */
    private void TaskExist(Task task) throws TaskAlreadyInProject {

        for (int i = 0; i < this.n_Tasks; i++) {
            if (this.tasks[i].equals(task)) {

                throw new TaskAlreadyInProject("Task Already in the Project!");

            }

        }

    }

    /**
     *
     * @param email
     * @return i if the participant exist in participants or throws
     * NullPointerException if not
     * @throws NullPointerException
     */
    private int findParticipant(String email) throws NullPointerException {

        for (int i = 0; i < this.n_Participants; i++) {
            if (this.participants[i].getEmail().equals(email)) {
                return i;
            }
        }

        throw new NullPointerException("That email does not exist!");

    }

    @Override
    public String toString() {
        return "Project{" + "name=" + name + ", description=" + description + '}';
    }

    @Override
    public void setNumberOdParticipants(int n_Participants) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addTags(String newTag) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
