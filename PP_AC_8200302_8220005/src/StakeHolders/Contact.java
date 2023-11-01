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

/**
 *
 * @author Helde
 */
public class Contact implements ma02_resources.participants.Contact {

    private String city;
    private String state;
    private String country;
    private String street;
    private String zipCode;
    private int n_door;
    private String phone;

    /**
     *
     * @param city
     * @param state
     * @param country
     * @param street
     * @param zipCode
     * @param n_door
     * @param phone
     */
    public Contact(String city, String state, String country, String street, String zipCode, int n_door, String phone) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.street = street;
        this.zipCode = zipCode;
        this.n_door = n_door;
        this.phone = phone;
    }

    public Contact() {
    }

    /**
     *
     * @return street
     */
    @Override
    public String getStreet() {
        return this.street;
    }

    /**
     *
     * @return city
     */
    @Override
    public String getCity() {
        return this.city;
    }

    /**
     *
     * @return @throws UnsupportedOperationException
     */
    @Override
    public String getState() {
        return this.state;
    }

    /**
     *
     * @return zipCode
     */
    @Override
    public String getZipCode() {
        return this.zipCode;
    }

    /**
     *
     * @return country
     */
    @Override
    public String getCountry() {
        return this.country;
    }

    /**
     *
     * @return phone
     */
    @Override
    public String getPhone() {
        return this.phone;
    }

    /**
     *
     * @return String with the values of info
     */
    @Override
    public String toString() {
        return "Info{" + "city=" + city + ", country=" + country + ", street=" + street + ", zipCode=" + zipCode + ", n_door=" + n_door + ", phone=" + phone + '}';
    }

    public static Contact parse(String text) {
        return parse(text);
    }

}
