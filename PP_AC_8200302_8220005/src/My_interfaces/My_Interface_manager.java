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

import CBL.Edition;
import ma02_resources.participants.Instituition;
import ma02_resources.participants.Participant;

/**
 *
 * @author Helde
 */
public interface My_Interface_manager {

    public int getN_editions();

    public Edition[] getEditions();

    public void addEdition(Edition ed);

    public void removeEdition(String name);

    public int getN_Projects(Edition edition);

    public void setStatusActive(Edition ed);

    public String progressEdition(Edition edition);

    public String progressProject_Edition(Edition edition, String name);

    public String Edition_Project_Tasks_in_fault(Edition edition, String name);

    public String Editions_Tasks_in_fault(Edition edition);

    public void listEditions();

    public void expandInstitutions();

    public void addInstitution(Instituition i);

    public void expandParticipants();

    public void addParticipant(Participant p);

    public Edition getEdition(String name);

    public void listInstitutions();

    public Instituition getInstitution(String email);

    public Instituition[] getInstitutions();

    public void listParticipants();

    public Participant getParticipant(String email);

    public Participant[] getParticipants();

    public int getN_participants();

    public int getN_institutions();
}
