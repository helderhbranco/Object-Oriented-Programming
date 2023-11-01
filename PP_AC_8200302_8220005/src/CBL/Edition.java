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

import StakeHolders.Student;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import ma02_resources.participants.Participant;
import ma02_resources.project.Status;
import ma02_resources.project.exceptions.ParticipantAlreadyInProject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import static org.json.simple.JSONValue.parse;

/**
 *
 * @author Helde
 */
public class Edition implements ma02_resources.project.Edition, My_interfaces.My_Interface_edition {

    private final int FATOR = 2;

    private int SIZE = 5;

    private String name;
    private String filename;

    private LocalDate start;
    private LocalDate end;

    private Status status;

    private int n_Projects;

    private Project[] projects;

    public Edition(String name, String template_filename, LocalDate start, LocalDate end, Status status) {
        this.name = name;
        this.filename = template_filename;
        this.start = start;
        this.end = end;
        this.status = status.INACTIVE;
        this.n_Projects = 0;
        this.projects = new Project[SIZE];
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public LocalDate getStart() {
        return this.start;
    }

    @Override
    public String getProjectTemplate() {
        return this.filename;
    }

    @Override
    public Status getStatus() {
        return this.status;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int getNumberOfProjects() {
        return this.n_Projects;
    }

    @Override
    public LocalDate getEnd() {
        return this.end;
    }

    /**
     *
     * @return
     */
    @Override
    public Project[] getProjects() {
        return this.projects;
    }

    @Override
    public void addProject(String string, String string1, String[] strings) throws IOException, ParseException {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("Project name cannot be null or empty.");
        }

        // Check if project already exists
        try {
            findProject(string);
            System.err.println("Project already exist.");
        } catch (IllegalArgumentException e) {

            // Check if description is null or empty
            if (string1 == null || string1.isEmpty()) {
                throw new IllegalArgumentException("Project description cannot be null or empty.");
            }

            // Check if tags array is null or empty
            if (strings == null || strings.length == 0) {
                throw new IllegalArgumentException("Project tags cannot be null or empty.");
            }

            // Check if project template exists
            if (getProjectTemplate() == null) {
                throw new IOException("Project template not found.");
            }

            try (FileReader reader = new FileReader(getProjectTemplate())) {
                // Faz o parsing do arquivo JSON
                JSONObject projectJson = (JSONObject) parse(reader);

                // Extrair informações do projeto do objeto JSON
                int numberOfFacilitators = ((Long) projectJson.get("number_of_facilitors")).intValue();
                int numberOfStudents = ((Long) projectJson.get("number_of_students")).intValue();
                int numberOfPartners = ((Long) projectJson.get("number_of_partners")).intValue();

                // Criar e adicionar as tarefas ao projeto
                JSONArray tasksJson = (JSONArray) projectJson.get("tasks");
                Task[] tasks = new Task[20];
                int counter = 0;
                for (int i = 0; i < tasksJson.size(); i++) {
                    JSONObject taskJson = (JSONObject) tasksJson.get(i);
                    String taskTitle = (String) taskJson.get("title");
                    String taskDescription = (String) taskJson.get("description");
                    int start_at = ((Long) taskJson.get("start_at")).intValue();
                    int duration = ((Long) taskJson.get("duration")).intValue();

                    LocalDate start = LocalDate.ofEpochDay(start_at);

                    // Obtenha outros atributos da tarefa, se houver
                    // Criar objeto Task com os atributos da tarefa
                    Task task = new Task(taskTitle, taskDescription, start, duration);

                    // Adicionar a tarefa ao array de tarefas
                    tasks[i] = task;
                    counter++;
                }

                //Project newProject = new Project(string, string1, strings);
                int numberOfParticipants = numberOfFacilitators + numberOfPartners + numberOfStudents;

                Project newProject = new Project(numberOfParticipants,
                        numberOfStudents, numberOfPartners, numberOfFacilitators, string, string1, strings);

//                newProject.setMaxNumFacilitators(numberOfFacilitators);
//                newProject.setMaxNumPartners(numberOfPartners);
//                newProject.setMaxNumStudents(numberOfStudents);
//                newProject.setMaxNumParticipants(numberOfFacilitators + numberOfPartners + numberOfStudents);
                newProject.setMaxNumTasks(20);
                newProject.setTasks(tasks);

                newProject.setNumberOfTasks(counter);

                projects[n_Projects++] = newProject;

                //Checks if list is already full, and if it is, increase it
                if (this.n_Projects >= this.SIZE) {
                    expandProjects();
                }

            } catch (IOException f) {
                System.err.println("File name can't be found.");
            }
        }
    }

    @Override
    public void removeProject(String string) {

        int index = 0;
        try {
            index = findProject(string);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Project doesn't exist!");

        }

        for (int i = index; i < n_Projects - 1; i++) {

            this.projects[i] = this.projects[i + 1];

        }

        this.projects[n_Projects--] = null;
    }

    public void listProjects() {
        for (int i = 0; i < this.n_Projects; i++) {
            System.out.println(this.projects[i].toString());
        }
        System.out.println(this.n_Projects + "/" + this.projects.length);
    }

    public void listProjectsByTag(String tag) {
        Project[] project = getProjectsByTag(tag);

        for (int i = 0; i < project.length; i++) {
            System.out.println(project[i].toString());
        }
    }

    public void expandProjects() {
        Project[] tempList = new Project[this.projects.length * FATOR];
        System.arraycopy(this.projects, 0, tempList, 0, this.projects.length);
        this.projects = tempList;
        this.SIZE *= FATOR;
    }

    /*
    private void expandProjects() {

        Project[] temp = new Project[n_Projects * Fator];

        for (int i = 0; i < this.projects.length; i++) {

            temp[i] = this.projects[i];

        }

        this.projects = temp;

    }
     */
    /**
     *
     * @param edition
     * @param name
     * @param title
     * @param student
     * @param text
     * @return
     */
    @Override
    public void addSubmission(Edition edition, String name, String title,
            Student student, String text) {
        try {

            if (edition.status == Status.ACTIVE) {

                Project project = getProject(name);
                Submission sbmsn = new Submission(LocalDateTime.now(), student, text);

                try {
                    project.ParticipantExist(student);
                } catch (ParticipantAlreadyInProject e) {
                    project.getTask(title).addSubmission(sbmsn);
                    System.out.println("Submitted.");
                }
            }
            throw new IllegalArgumentException("Edition must be active.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Project getProject(String string) throws IllegalArgumentException {
        for (int i = 0; i < this.n_Projects; i++) {
            if (this.projects[i].getName().equals(string)) {
                return this.projects[i];
            }
        }
        throw new IllegalArgumentException("This project does not exist.");
    }

    /**
     *
     * @param string
     * @return
     */
    @Override
    public Project[] getProjectsByTag(String string) {
        Project[] temp = new Project[n_Projects];
        int counter = 0;

        for (int i = 0; i < this.n_Projects; i++) {
            for (int j = 0; j < this.projects[i].getNumberOfTags(); j++) {
                if (this.projects[i].getTags()[j].equals(string)) {
                    temp[counter++] = this.projects[i];

                }
            }
        }
        Project[] projectsByTag = new Project[counter];
        System.arraycopy(temp, 0, projectsByTag, 0, counter);
        if (counter == 0) {
            throw new NullPointerException("There are no Projects with this tag.");
        }
        return projectsByTag;
    }

    /**
     *
     * @param string
     * @return This method returns all the projects of the edition that have a
     * specific participant. by name of participant
     */
    @Override
    public Project[] getProjectsOf(String string) {

        Project[] projectsOf = new Project[n_Projects];
        int count = 0;

        for (int i = 0; i < n_Projects; i++) {
            for (Participant participant : this.projects[i].getParticipants()) {
                if (participant.getName().equals(string)) {
                    projectsOf[count++] = this.projects[i];
                }
            }

        }
        return projectsOf;
    }

    @Override
    public String getProjectProgress(String name) {

        Project project = getProject(name);
        int count = 0;
        String progress = "";
        String temp = "";

        for (int i = 0; i < project.getNumberOfTasks(); i++) {
            if (project.getTasks()[i].getNumberOfSubmissions() > 0) {
                temp += project.getTasks()[i].toString();
                count++;
            }
        }
        progress = "Project: " + project.getName() + "->" + " Tasks with submissions: " + count + "/" + project.getNumberOfTasks() + temp;
        return progress;
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public String Project_Task_in_fault(String name) {

        Project project = getProject(name);
        int count = 0;
        String progress = "";
        String temp = "";

        for (int i = 0; i < project.getNumberOfTasks(); i++) {
            if (project.getTasks()[i].getNumberOfSubmissions() == 0) {
                temp += project.getTasks()[i].toString();
                count++;
            }
        }
        progress = "Project" + project.getName() + "Tasks without submissions: " + count + "/" + project.getNumberOfTasks() + temp;
        return progress;
    }

    @Override
    public String toString() {
        return "Edition{" + "name=" + name + ", start=" + start + ", end=" + end + ", status=" + status + ", n_Projects=" + n_Projects + '}';
    }

    private int findProject(String string) throws IllegalArgumentException {

        for (int i = 0; i < n_Projects; i++) {

            if (this.projects[i].getName().equals(string)) {

                return i;

            }

        }
        throw new IllegalArgumentException();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Edition other = (Edition) obj;
        return Objects.equals(this.name, other.name);
    }

}
