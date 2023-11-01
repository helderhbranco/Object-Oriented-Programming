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
import StakeHolders.Student;

/**
 *
 * @author iandi
 */
public interface My_Interface_edition {

    public void addSubmission(Edition edition, String name, String title,
            Student student, String text);

    public String getProjectProgress(String name);

    public String Project_Task_in_fault(String name);
}
