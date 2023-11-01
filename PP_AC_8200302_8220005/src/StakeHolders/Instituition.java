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

import java.util.Objects;
import ma02_resources.participants.Contact;
import ma02_resources.participants.InstituitionType;

/**
 *
 * @author Helde
 */
public class Instituition implements ma02_resources.participants.Instituition {

    private Contact info;
    private InstituitionType type;
    private String name;
    private String email;
    private String website;
    private String description;

    /**
     *
     * @param info
     * @param type
     * @param name
     * @param email
     * @param website
     * @param description
     */
    public Instituition(Contact info, InstituitionType type, String name, String email, String website, String description) {
        this.info = info;
        this.type = type;
        this.name = name;
        this.email = email;
        this.website = website;
        this.description = description;
    }

    public Instituition() {

    }

    /**
     *
     * @return name;
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
     * @return type
     */
    @Override
    public InstituitionType getType() {
        return this.type;
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
     * @return website
     */
    @Override
    public String getWebsite() {
        return this.website;
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
     * @param string
     */
    @Override
    public void setWebsite(String string) {
        this.website = string;
    }

    /**
     *
     * @param string
     */
    @Override
    public void setDescription(String string) {
        this.description = string;
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
     * @param it
     */
    @Override
    public void setType(InstituitionType it) {
        this.type = it;
    }

    /**
     *
     * @return String with Instituition information
     */
    @Override
    public String toString() {
        return "Instituition{" + "info=" + info + ", type=" + type + ", name=" + name + ", email=" + email + ", website=" + website + ", description=" + description + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Instituition other = (Instituition) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }
}
