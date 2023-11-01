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

import StakeHolders.Partner;
import StakeHolders.Facilitator;
import StakeHolders.Contact;
import StakeHolders.Instituition;
import StakeHolders.Student;
import java.time.LocalDate;
import java.time.LocalDateTime;
import ma02_resources.participants.InstituitionType;
import ma02_resources.project.Status;
import ma02_resources.project.exceptions.IllegalNumberOfTasks;
import ma02_resources.project.exceptions.TaskAlreadyInProject;

/**
 *
 * @author iandi
 */
public class DEMO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] tagList1 = new String[5];

//        Project proj1 = new Project("project1", "desc1", tagList1);
//        Project proj2 = new Project("project2", "desc2", tagList1);
//        Project proj3 = new Project("project3", "desc3", tagList1);
//        Project proj4 = new Project("project4", "desc4", tagList1);
//        Project proj5 = new Project("project5", "desc5", tagList1);
        Contact info1 = new Contact("city", "state", "country", "street", "zipCode", 0, "phone");

        Instituition inst1 = new Instituition(info1, InstituitionType.NGO, "name", "email", "website", "description");

        Student p1 = new Student(info1, inst1, "name1", "email1");
        Partner p2 = new Partner("vat", "website", info1, inst1, "name2", "email2");
        Facilitator p3 = new Facilitator("areaOfExpertise", info1, inst1, "name3", "email3");
        Facilitator p4 = new Facilitator("loplo", info1, inst1, "name4", "email4");

        Edition edition1 = new Edition("ed1", "edition1.txt", LocalDate.MAX, LocalDate.MIN, Status.ACTIVE);
        Edition edition2 = new Edition("ed2", "cu", LocalDate.MAX, LocalDate.MIN, Status.ACTIVE);
        Edition edition3 = new Edition("ed3", "sdawad", LocalDate.MAX, LocalDate.MIN, Status.ACTIVE);

        Manager manager = new Manager();

//Project testing
        //Participants adding and removing test
//        try{
//            proj1.addParticipant(p1);
//            proj1.addParticipant(p2);
//            proj1.addParticipant(p3);
//        }catch(IllegalNumberOfParticipantType e){
//            System.err.println(e.getMessage());
//        }catch(ParticipantAlreadyInProject e){
//           System.err.println(e.getMessage());
//        }catch(Exception e){
//            System.err.println(e.getMessage());
//        }
//        
//        try{
//           proj1.addParticipant(p4);
//        }catch(IllegalNumberOfParticipantType e){
//            System.err.println(e.getMessage());
//        }catch(ParticipantAlreadyInProject e){
//            System.err.println(e.getMessage());
//        }catch(Exception e){
//            System.err.println(e.getMessage());
//        }
//        
//        proj1.listParticipants();
//        System.out.println("first participant listing\n");
//        
//        try{
//            proj1.removeParticipant("email2");
//        }catch(Exception e){
//            System.err.println(e.getMessage());
//        }
//        
//        proj1.listParticipants();
//        System.out.println("second participant listing\n");
        //Tags testing
//        String tag1 = "la";
//        String tag2 = "le";
//        String tag3 = "li";
//        String tag4 = "lo";
//        String tag5 = "lu";
//        String tag6 = "lx";
//        
//        proj1.addTag(tag1);
//        proj1.addTag(tag2);
//        
//        proj1.listTags();
//        System.out.println("haha\n");
//        
//        proj1.addTag(tag3);
//        proj1.addTag(tag4);
//        proj1.addTag(tag5);
//        
//        proj1.listTags();
//        System.out.println("hehe\n");
//        
//        try{
//            proj1.removeTag(tag6);
//            proj1.removeTag(tag4);
//        }catch(NullPointerException e){
//            System.err.println(e.getMessage());
//        }
//        
//        proj1.listTags();
//        System.out.println("hoho\n");
//Edition testing
        try {
            edition1.addProject("proj1", "desc1", tagList1);
            edition1.addProject("proj2", "desc1", tagList1);
            edition1.addProject("proj3", "desc1", tagList1);
            edition1.addProject("proj4", "desc1", tagList1);
            edition1.addProject("proj5", "desc1", tagList1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.out.println("oi");
        }

        edition1.listProjects();
        System.out.println("first projects listing\n");
        Submission subs = new Submission(LocalDateTime.MAX, p1, "t");

        Task task1 = new Task("a", "b", LocalDate.MAX, 0);

//        try{
        task1.addSubmission(subs);

//        }catch(Exception e){
//            System.err.println(e.getMessage());
//        }
        try {
            edition1.getProject("proj1").addTask(task1);
            edition1.getProject("proj2").addTask(task1);
            edition1.getProject("proj4").addTask(task1);

        } catch (IllegalNumberOfTasks e) {
            System.err.println(e.getMessage());
        } catch (TaskAlreadyInProject e) {
            System.err.println(e.getMessage());
        }

//        try{
//            edition1.addProject("project5", "desc5", tagList1);
//        }catch(Exception e){
//            System.err.println(e.getMessage());
//        }
//        
//        edition1.listProjects();
//        System.out.println("second projects listing\n");
//        
//        try{
//            edition1.removeProject("project4");
//        }catch(Exception e){
//            System.err.println(e.getMessage());
//        }
//        
//        edition1.listProjects();
//        System.out.println("third projects listing\n");           
//Manager Testing
        try {
            manager.addEdition(edition1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        //manager.listEditions();
//        try{
//            manager.addEdition(edition2);
//            manager.addEdition(edition3);
//        }catch(Exception e){
//            System.err.println(e.getMessage());
//        }
        //manager.listEditions();
        //manager.removeEdition(edition1);
        try {
            manager.setStatusActive(edition1);

        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }

        //manager.listEditions();
//        System.out.println(task1.getNumberOfSubmissions());
        // System.out.println(manager.progressEdition(edition1));//esta funcionar
        System.out.println(manager.progressProject_Edition(edition1, edition1.getProject("proj1").getName()));
        //System.out.println(manager.Editions_Tasks_in_fault(edition1));//esta funcinar
        edition1.getProject("proj1").getNumberOfTasks();
        //System.out.println(manager.Edition_Project_Tasks_in_fault(edition1, proj1.getName()));

    }

}
