/*
* Nome: <Hélder Henrique Sousa Dias Branco>
* Número: <8200302>
* Turma: <LEI12T3>
*
* Nome: <Ian Costa>
* Número: <8220005>
* Turma: <LEI12T4>
 */
package StakeHolders;

import ma02_resources.participants.Contact;
import ma02_resources.participants.Instituition;

/**
 *
 * @author Helde
 */
public class Student extends Participant implements ma02_resources.participants.Student {

    private static int n = 0;

    private int number;

    /**
     *
     * @param info
     * @param institute
     * @param name
     * @param email
     */
    public Student(Contact info, Instituition institute, String name, String email) {
        super(info, institute, name, email);
        this.number = n++;
    }

    /**
     *
     * @return number;
     */
    @Override
    public int getNumber() {
        return this.number;
    }

    /**
     *
     * @return name;
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     *
     * @return email
     */
    @Override
    public String getEmail() {
        return super.getEmail();
    }

    /**
     *
     * @return contact/info
     */
    @Override
    public Contact getContact() {
        return super.getContact();
    }

    /**
     *
     * @return Instituition
     */
    @Override
    public Instituition getInstituition() {
        return super.getInstituition();
    }

    /**
     *
     * @param instn
     */
    @Override
    public void setInstituition(Instituition instn) {
        super.setInstituition(instn);
    }

    /**
     *
     * @param cntct
     */
    @Override
    public void setContact(Contact cntct) {
        super.setContact(cntct);
    }

    /**
     *
     * @return String with Student number
     */
    @Override
    public String toString() {
        return "Student{" + "number=" + number + "name=" + this.getName() + "email=" + this.getEmail() + '}';
    }

}
