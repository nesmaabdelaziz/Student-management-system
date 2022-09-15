import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class Database {

    //DATABASE OBJECT
    private static Database databaseObject = new Database();

    //PRIVATE CONSTRUCTOR SO THAT NO OTHER OBJECT OF DATABASE CAN BE CREATED
    private Database(){}

    public static Database getDatabase()
    {
        return databaseObject;
    }

    LinkedList<Teacher> teacherList = new LinkedList<Teacher>();
    LinkedList<Student> studentList = new LinkedList<Student>();
    LinkedList<Assignment> assignmentList = new LinkedList<Assignment>();
    LinkedList<Course> courseList = new LinkedList<Course>();
    LinkedList<CourseAttendance> courseAttendanceList = new LinkedList<CourseAttendance>();
    //MAP BETWEEN THE STUDENT ID AND THE STUDENT COURSES IDS
    HashMap<String, ArrayList<String>> studentCoursesMap = new HashMap<String, ArrayList<String>>();
    //MAP BETWEEN THE COURSE ID AND THE STUDENTS TAKING THE COURSE
    HashMap<String, ArrayList<String>> courseStudentsMap = new HashMap<String, ArrayList<String>>();

}
