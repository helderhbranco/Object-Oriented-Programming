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
public class Partner extends Participant implements ma02_resources.participants.Partner {

    private String vat;
    private String website;

    /**
     *
     * @param vat
     * @param website
     * @param info
     * @param institute
     * @param name
     * @param email
     */
    public Partner(String vat, String website, Contact info, Instituition institute, String name, String email) {
        super(info, institute, name, email);
        this.vat = vat;
        this.website = website;
    }

    /**
     *
     * @return vat
     */
    @Override
    public String getVat() {
        return this.vat;
    }

    /**
     *
     * @return website
     */
    @Override
    public String getWebsite() {
        return this.website;
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
     * @return contact
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
        return "Partner{" + "number=" + vat + "Website=" + website + "name=" + this.getName() + "email=" + this.getEmail() + '}';
    }

}
