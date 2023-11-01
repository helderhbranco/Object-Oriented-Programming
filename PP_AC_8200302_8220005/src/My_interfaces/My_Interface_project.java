/*
* Nome: <Hélder Henrique Sousa Dias Branco>
* Número: <8200302>
* Turma: <LEI12T3>
*
* Nome: <Ian Costa>
* Número: <8220005>
* Turma: <LEI12T4>
 */
package My_interfaces;

import ma02_resources.participants.Participant;
import ma02_resources.project.Task;
import ma02_resources.project.exceptions.ParticipantAlreadyInProject;

/**
 *
 * @author Helde
 */
public interface My_Interface_project {

    public void setName(String name);

    public void setDescription(String description);

    public void setNumberOdParticipants(int n_Participants);

    public void setNumberOfStudents(int n_Students);

    public void setNumberOfPartners(int n_Partners);

    public void setNumberOfFacilitators(int n_Facilitators);

    public void setNumberOfTasks(int n_Tasks);

    public void setMaxNumTasks(int maxNumTasks);

    public void setTasks(Task[] tasks);

    public void listParticipants();

    public void listTags();

    public Participant[] getParticipants();

    public void addTags(String newTag);

    public void setTags(String[] tags);

    public boolean ParticipantExist(Participant p) throws ParticipantAlreadyInProject;

    public void expandTags();

    public void removeTag(String tag);

    public void addTag(String newTag);
}
