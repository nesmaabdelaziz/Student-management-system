import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Student implements person{
    private String id;
    private String name;
    private String email;
    private String mobileNumber;
    private int age;
    private String address;
    private String gender;
    private ArrayList<AssignmentSubmission> assignmentSubmissions = new ArrayList<AssignmentSubmission>();

    //OVERRIDING TO STRING METHOD
    public String toString()
    {
        StringBuilder st = new StringBuilder();
        st.append("Student id: ").append(id).append("\n").append("Student name: ")
                .append(name).append("\n").append("Student Email: ").append(email)
                .append("\n").append("Student mobile number: ").append(mobileNumber)
                .append("\n").append("Student age: ").append(age).append("\n")
                .append("Student address: ").append(address).append("\n")
                .append("Gender: ").append(gender);

        return st.toString();
    }

    //OVERRIDING THE INTERFACE PERSON
    @Override
    public void choose(Database database)
    {
        Scanner scanner = new Scanner(System.in);
        String inputString;
        System.out.println("To view your enrolled courses, enter 1\n" +
                            "To view assignments, enter 2\n" +
                            "To submit an assignment, enter 3\n");

        inputString = scanner.nextLine();

        switch (inputString)
        {
            case "1" -> {
                System.out.println("Enter your id: ");
                inputString = scanner.nextLine();
                this.viewEnrolledCourses(inputString, database.studentCoursesMap);
            }
            case "2" -> {
                System.out.println("Enter course id: ");
                inputString = scanner.nextLine();
                this.viewAssignments(inputString, database.assignmentList);
            }
            case "3" -> {
                AssignmentSubmission assignmentSubmission = new AssignmentSubmission();
                System.out.println("Assignment id: ");
                inputString = scanner.nextLine();
                assignmentSubmission.setId(inputString);
                System.out.println("Course id: ");
                inputString = scanner.nextLine();
                assignmentSubmission.setCourseId(inputString);
                System.out.println("Solution: ");
                inputString = scanner.nextLine();
                assignmentSubmission.setSolution(inputString);

                this.submitAssignment(assignmentSubmission);
            }
        }
    }

    //SETTERS AND GETTERS
    public void setId(String id)
    {
        this.id = id;
    }
    public String getID()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getEmail()
    {
        return this.email;
    }
    public void setMob(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }
    public String getMob()
    {
        return this.mobileNumber;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public int getAge()
    {
        return this.age;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getAddress()
    {
        return this.address;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    public String getGender()
    {
        return this.gender;
    }

    //STUDENT FUNCTIONS
    public void viewEnrolledCourses(String studentId, HashMap<String, ArrayList<String>> studentCourseMap)
    {
        for (String key: studentCourseMap.keySet())
        {
            if (key.equals(studentId))
            {
                for (String courseId: studentCourseMap.get(key))
                {
                    System.out.println("Course id: " + courseId);
                }
            }
        }
    }
    public void viewAssignments(String courseId, LinkedList<Assignment> assignmentList)
    {
        for (Assignment assignment: assignmentList)
        {
            if (assignment.getCourseId().equals(courseId))
            {
                System.out.println(assignment.toString());
            }
        }
    }
    public void submitAssignment(AssignmentSubmission assignmentSubmission)
    {
        this.assignmentSubmissions.add(assignmentSubmission);
    }
}
