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
import java.util.Objects;

/**
 *
 * @author Helde
 */
abstract class Participant implements ma02_resources.participants.Participant {

    private Contact info;
    private Instituition institute;
    private String name;
    private String email;

    /**
     *
     * @param info
     * @param institute
     * @param name
     * @param email
     */
    public Participant(Contact info, Instituition institute, String name, String email) {
        this.info = info;
        this.institute = institute;
        this.name = name;
        this.email = email;
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
     * @return email
     */
    @Override
    public String getEmail() {
        return this.email;
    }

    /**
     *
     * @return info
     */
    @Override
    public Contact getContact() {
        return this.info;
    }

    /**
     *
     * @return institute
     */
    @Override
    public Instituition getInstituition() {
        return this.institute;
    }

    /**
     *
     * @param instn
     */
    @Override
    public void setInstituition(Instituition instn) {
        this.institute = instn;
    }

    /**
     *
     * @param cntct
     */
    @Override
    public void setContact(Contact cntct) {
        this.info = cntct;
    }

    /**
     *
     * @return String with the values of the Participant
     */
    @Override
    public String toString() {
        return "Member{" + "info=" + info + ", institute=" + institute.getName() + ", name=" + name + ", email=" + email + '}';
    }

    /**
     *
     * @param o
     * @return true if the objects are equal, false otherwise This method
     * compares two objects of type Participant. If the email of the objects are
     * equal, true is returned.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        final Participant other = (Participant) o;
        return Objects.equals(this.email, other.email);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.email);
        return hash;
    }

}
