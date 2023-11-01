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

import java.time.LocalDate;
import java.util.Objects;
import ma02_resources.project.Submission;

/**
 *
 * @author Helde
 */
public class Task implements ma02_resources.project.Task {

    private static int SIZE = 20;
    private final int FATOR = 2;

    private String title;
    private String description;

    private LocalDate start;
    private LocalDate end;
    private int duration;
    private int extendDeadline;

    private Submission[] submits;
    private int n_submissions;

    /**
     *
     * @param title
     * @param description
     * @param start
     * @param end
     * @param duration
     * @param extendDeadline
     */
    public Task(String title, String description, LocalDate start,
            LocalDate end, int duration, int extendDeadline) {
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
        this.duration = duration;
        this.extendDeadline = extendDeadline;
        this.submits = new Submission[SIZE];
        this.n_submissions = 0;
    }

    public Task(String title, String description, LocalDate start, int duration) {
        this.title = title;
        this.description = description;
        this.start = start;
        this.duration = duration;
        this.end = start.plusDays(duration);
        this.extendDeadline = 0;
        this.submits = new Submission[SIZE];
        this.n_submissions = 0;
    }

    /**
     *
     * @return start date
     */
    @Override
    public LocalDate getStart() {
        return this.start;
    }

    /**
     *
     * @return end date
     */
    @Override
    public LocalDate getEnd() {
        return this.end;
    }

    /**
     *
     * @return the duration of the task
     */
    @Override
    public int getDuration() {
        return this.duration;
    }

    /**
     *
     * @return title
     */
    @Override
    public String getTitle() {
        return this.title;
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
     * @return array of submissions
     */
    @Override
    public Submission[] getSubmissions() {
        return this.submits;
    }

    /**
     *
     * @return number of submissions
     */
    @Override
    public int getNumberOfSubmissions() {
        return this.n_submissions;
    }

    /**
     *
     * @param sbmsn
     * @throws IllegalArgumentException
     */
    @Override
    public void addSubmission(Submission sbmsn) throws IllegalArgumentException {

        if (sbmsn == null) {
            throw new IllegalArgumentException("Submission cannot be null");
        }
        try {
            SubmissionExist(sbmsn);

        } catch (IllegalArgumentException e) {
            System.out.println("That already exist!");
        }

        if (this.n_submissions == this.submits.length) {
            expandSubmits();
        }

        this.submits[this.n_submissions] = sbmsn;

        this.n_submissions++;
    }

    /**
     *
     * @param i
     * @throws IllegalArgumentException increase i days to the end of the task
     */
    @Override
    public void extendDeadline(int i) throws IllegalArgumentException {

        if (i < 0) {
            throw new IllegalArgumentException("The number is less than 0");
        } else {
            this.end.plusDays(i);
        }

    }

    /**
     * Create a array of Submissions bigger, n_submissions * 2
     */
    private void expandSubmits() {

        Submission[] temp = new Submission[n_submissions * FATOR];

        for (int i = 0; i < n_submissions; i++) {

            temp[i] = submits[i];

        }

        this.submits = temp;

    }

    /**
     *
     * @param task
     * @return a negative integer, zero, or a positive integer as this task is
     * less than, equal to, or greater than the specified task. Compare two
     * dates of start of two diferrent tasks
     */
    @Override
    public int compareTo(ma02_resources.project.Task task) {
        return this.start.compareTo(task.getStart());
    }

    /**
     *
     * @param sbmsn
     * @throws IllegalArgumentException verify if submission already exist in
     * the array
     */
    public void SubmissionExist(Submission sbmsn) throws IllegalArgumentException {

        for (int i = 0; i < n_submissions; i++) {
            if (this.submits[i].equals(sbmsn)) {

                throw new IllegalArgumentException("Object Already exists!");

            }

        }
    }

    @Override
    public String toString() {
        return "Task{" + "title=" + title + ", description=" + description + ", start=" + start + ", end=" + end + ", duration=" + duration + ", extendDeadline=" + extendDeadline + ", n_submissions=" + n_submissions + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.title);
        return hash;
    }

    /**
     *
     * @param obj
     * @return true if the two objects are equal, false otherwise. Compare based
     * in the title of the tasks
     */
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
        final Task other = (Task) obj;
        return Objects.equals(this.title, other.title);
    }

}
