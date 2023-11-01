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
public class Facilitator extends Participant implements ma02_resources.participants.Facilitator {

    private String areaOfExpertise;

    /**
     *
     * @param areaOfExpertise
     * @param info
     * @param institute
     * @param name
     * @param email
     */
    public Facilitator(String areaOfExpertise, Contact info, Instituition institute, String name, String email) {
        super(info, institute, name, email);
        this.areaOfExpertise = areaOfExpertise;
    }

    /**
     *
     * @return areaOfExpertise
     */
    @Override
    public String getAreaOfExpertise() {
        return this.areaOfExpertise;
    }

    /**
     *
     * @param string
     */
    @Override
    public void setAreaOfExpertise(String string) {
        this.areaOfExpertise = string;
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
     * @param instn
     */
    @Override
    public void setInstituition(Instituition instn) {
        super.setInstituition(instn);
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
     * @return Contact
     */
    @Override
    public Contact getContact() {
        return super.getContact();
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
     * @return name
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Facilitator{" + "number=" + areaOfExpertise + "name=" + this.getName() + "email=" + this.getEmail() + '}';
    }

}
