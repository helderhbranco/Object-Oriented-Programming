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

import java.time.LocalDateTime;
import java.util.Objects;
import ma02_resources.participants.Student;

/**
 *
 * @author Helde
 */
public class Submission implements ma02_resources.project.Submission {

    private LocalDateTime date;
    private Student student;
    private String text;

    /**
     *
     * @param date
     * @param student
     * @param text
     */
    public Submission(LocalDateTime date, Student student, String text) {
        this.date = date;
        this.student = student;
        this.text = text;
    }

    /**
     *
     * @return date
     */
    @Override
    public LocalDateTime getDate() {

        return this.date;

    }

    /**
     *
     * @return student
     */
    @Override
    public Student getStudent() {

        return this.student;
    }

    /**
     *
     * @return text
     */
    @Override
    public String getText() {

        return this.text;

    }

    /**
     *
     * @param sbmsn
     * @return compares the date of this submission with the date of another
     * submission sbmsn and returns an integer value that indicates the order of
     * the two submissions. If the date of this submission is before the date of
     * sbmsn, it returns a negative value. If the dates are equal, it returns 0.
     * If the date of this submission is after the date of sbmsn, it returns a
     * positive value
     */
    @Override
    public int compareTo(ma02_resources.project.Submission sbmsn) {
        return this.date.compareTo(sbmsn.getDate());
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Submission other = (Submission) obj;
        if (!Objects.equals(this.text, other.text)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return Objects.equals(this.student, other.student);
    }

}
