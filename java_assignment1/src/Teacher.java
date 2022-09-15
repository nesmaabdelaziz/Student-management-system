import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Teacher implements person{
    private String id;
    private String name;
    private String email;
    private String mobileNumber;

    //OVERRIDING TO STRING METHOD
    public String toString()
    {
        StringBuilder st = new StringBuilder();
        st.append("Teacher id: ").append(id).append("\n").append("Teacher name: ")
                .append(name).append("\n").append("Teacher Email: ").append(email)
                .append("\n").append("Teacher mobile number: ").append(mobileNumber);

        return st.toString();
    }

    //OVERRIDING THE INTERFACE PERSON
    @Override
    public void choose(Database database) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String inputString;
        System.out.println("To add an assignment, enter 1\n" +
                "To submit course attendance, enter 2\n" +
                "To view a certain student's details, enter 3\n" +
                "To view a certain student's assigned courses, enter 4\n" +
                "To view all assigned courses, enter 5\n" +
                "To view all students in a certain course, enter 6\n");

        inputString = scanner.nextLine();

        switch (inputString)
        {
            case "1" -> {
                Assignment assignment = new Assignment();
                System.out.println("Assignment id: ");
                inputString = scanner.nextLine();
                assignment.setId(inputString);
                System.out.println("Course id: ");
                inputString = scanner.nextLine();
                assignment.setCourseId(inputString);
                System.out.println("Assignment description: ");
                inputString = scanner.nextLine();
                assignment.setDescription(inputString);
                System.out.println("Assignment due date in the format dd/MM/yyyy: ");
                inputString = scanner.nextLine();
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(inputString);
                assignment.setDueDate(date);

                this.addAssignment(assignment, database.assignmentList);
            }
            case "2" -> {
                CourseAttendance ca = new CourseAttendance();
                System.out.println("Course Attendance id: ");
                inputString = scanner.nextLine();
                ca.setId(inputString);
                System.out.println("Course id: ");
                inputString = scanner.nextLine();
                ca.setCourseId(inputString);
                System.out.println("Student id: ");
                inputString = scanner.nextLine();
                ca.setStudentId(inputString);
                System.out.println("Attendance date in the format dd/MM/yyyy: ");
                inputString = scanner.nextLine();
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(inputString);
                ca.setAttendanceDate(date);
                System.out.println("Status: ");
                inputString = scanner.nextLine();
                ca.setStatus(inputString);

                this.submitStudentsAttendance(ca, database.courseAttendanceList);
            }
            case "3" -> {
                System.out.println("Student id: ");
                inputString = scanner.nextLine();
                this.getStudentData(inputString, database.studentList);
            }
            case "4" -> {
                System.out.println("Student id: ");
                inputString = scanner.nextLine();
                this.viewStudentsAssignedCourses(inputString, database.studentCoursesMap);
            }
            case "5" -> {
                this.getAllAssignedCourses(database.courseList);
            }
            case "6" -> {
                System.out.println("Course id: ");
                inputString = scanner.nextLine();
                this.getStudentsInCourse(inputString, database.courseStudentsMap);
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

    //TEACHER FUNCTIONS
    public void viewStudentsAssignedCourses(String studentId, HashMap<String, ArrayList<String>> studentCourseMap)
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
    public void getStudentsInCourse(String courseId, HashMap<String, ArrayList<String>> courseStudentsMap)
    {
        for (String key: courseStudentsMap.keySet())
        {
            if (key.equals(courseId))
            {
                for (String studentId: courseStudentsMap.get(key))
                {
                    System.out.println("Student id: " + studentId);
                }
            }
        }
    }
    public void getAllAssignedCourses(List<Course> courseList)
    {
        for (Course course : courseList)
        {
                System.out.println(course.toString());
        }
    }
    public void getStudentData(String id, List<Student> studentList)
    {
        for (Student student : studentList)
        {
            if(student.getID().equals(id))
            {
                System.out.println(student.toString());
            }
        }
    }
    public void addAssignment(Assignment assignment, LinkedList<Assignment> assignmentList)
    {
        assignmentList.add(assignment);
    }
    public void submitStudentsAttendance(CourseAttendance courseAttendance, LinkedList<CourseAttendance> courseAttendanceList)
    {
        courseAttendanceList.add(courseAttendance);
    }
}
