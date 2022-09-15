import java.util.*;

public class Admin implements person{
    private String id;
    private String name;
    private String email;
    private String mobileNumber;

    //OVERRIDING THE INTERFACE PERSON
    @Override
    public void choose(Database database)
    {
        Scanner scanner = new Scanner(System.in);
        String inputString;
        System.out.println("To add a student, enter 1\n" +
                        "To remove a student, enter 2\n" +
                        "To add a teacher, enter 3\n" +
                        "To remove a teacher, enter 4\n" +
                        "To view all students, enter 5\n" +
                        "To view all teachers, enter 6\n" +
                        "To view a certain teacher's details, enter 7\n" +
                        "To view a certain student's details, enter 8\n" +
                        "To update a certain teacher's details, enter 9\n" +
                        "To update a certain student's details, enter 10\n" +
                        "To add a course to a certain student, enter 11\n");

        inputString = scanner.nextLine();
        switch (inputString) {
            case "1" -> {
                Student st = new Student();
                System.out.println("Student id: ");
                inputString = scanner.nextLine();
                st.setId(inputString);
                System.out.println("Student name: ");
                inputString = scanner.nextLine();
                st.setName(inputString);
                System.out.println("Student email: ");
                inputString = scanner.nextLine();
                st.setEmail(inputString);
                System.out.println("Student mobile number: ");
                inputString = scanner.nextLine();
                st.setMob(inputString);
                System.out.println("Student age: ");
                inputString = scanner.nextLine();
                st.setAge(Integer.parseInt(inputString));
                System.out.println("Student address: ");
                inputString = scanner.nextLine();
                st.setAddress(inputString);
                System.out.println("Student gender: ");
                inputString = scanner.nextLine();
                st.setGender(inputString);
                this.addStudent(st, database.studentList);
            }
            case "2" -> {
                System.out.println("To remove a student, Enter the student id: ");
                inputString = scanner.nextLine();
                this.removeStudent(inputString, database.studentList);
            }
            case "3" -> {
                Teacher t = new Teacher();
                System.out.println("Teacher id: ");
                inputString = scanner.nextLine();
                t.setId(inputString);
                System.out.println("Teacher name: ");
                inputString = scanner.nextLine();
                t.setName(inputString);
                System.out.println("Teacher email: ");
                inputString = scanner.nextLine();
                t.setEmail(inputString);
                System.out.println("Teacher mobile number: ");
                inputString = scanner.nextLine();
                t.setMob(inputString);

                this.addTeacher(t, database.teacherList);
            }
            case "4" -> {
                System.out.println("To remove a teacher, Enter the student id: ");
                inputString = scanner.nextLine();
                this.removeTeacher(inputString, database.teacherList);
            }
            case "5" -> {
                this.viewAllStudents(database.studentList);
            }
            case "6" -> {
                this.viewAllTeachers(database.teacherList);
            }
            case "7" -> {
                System.out.println("To view a teacher's details, Enter the teacher id: ");
                inputString = scanner.nextLine();
                this.viewTeacherDetails(inputString, database.teacherList);
            }
            case "8" -> {
                System.out.println("To view a student's details, Enter the student id: ");
                inputString = scanner.nextLine();
                this.viewStudentDetails(inputString, database.studentList);
            }
            case "9" -> {
                System.out.println("To update a teacher's details, Enter the teacher id: ");
                String id = scanner.nextLine();
                System.out.println("New name: ");
                String name = scanner.nextLine();
                System.out.println("New email: ");
                String email = scanner.nextLine();
                System.out.println("New mobile number: ");
                String mob = scanner.nextLine();
                this.updateTeacherData(id, name, email, mob, database.teacherList);
            }
            case "10" -> {
                System.out.println("To update a student's details, Enter the student id: ");
                String id = scanner.nextLine();
                System.out.println("New name: ");
                String name = scanner.nextLine();
                System.out.println("New email: ");
                String email = scanner.nextLine();
                System.out.println("New mobile number: ");
                String mob = scanner.nextLine();
                System.out.println("New age: ");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.println("New address: ");
                String address = scanner.nextLine();
                System.out.println("Gender: ");
                String gender = scanner.nextLine();
                this.updateStudentData(id, name, email, mob, age, address, gender, database.studentList);
            }
            case "11" -> {
                System.out.println("Enter student id: ");
                String stId = scanner.nextLine();
                System.out.println("Enter course id: ");
                String cId = scanner.nextLine();
                this.addCourseToStudent(stId, cId, database.studentCoursesMap, database.courseStudentsMap);
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

    //ADMIN FUNCTIONS
    public void addTeacher(Teacher teacher, List<Teacher> teacherList)
    {
        teacherList.add(teacher);
    }
    public void removeTeacher(String id, List<Teacher> teacherList)
    {
        teacherList.removeIf(teacher -> teacher.getID().equals(id));
    }
    public void viewAllTeachers(List<Teacher> teacherList)
    {
        for (Teacher teacher : teacherList) {
            System.out.println(teacher.getName());
        }
    }
    public void viewTeacherDetails(String id, List<Teacher> teacherList)
    {
        for (Teacher teacher : teacherList) {
            if (teacher.getID().equals(id)) {
                System.out.println(teacher.toString());
            }
        }
    }
    public void updateTeacherData(String id, String name, String email, String mobileNumber, List<Teacher> teacherList)
    {
        for (Teacher teacher : teacherList) {
            if (teacher.getID().equals(id)) {
                teacher.setName(name);
                teacher.setEmail(email);
                teacher.setMob(mobileNumber);
            }
        }
    }
    public void addStudent(Student student, List<Student> studentList)
    {
        studentList.add(student);
    }
    public void removeStudent(String id, List<Student> studentList)
    {
        studentList.removeIf(teacher -> teacher.getID().equals(id));
    }
    public void viewAllStudents(List<Student> studentList)
    {
        for (Student student : studentList) {
            System.out.println(student.getName());
        }
    }
    public void viewStudentDetails(String id, List<Student> studentList)
    {
        for (Student student : studentList)
        {
            if(student.getID().equals(id))
            {
                System.out.println(student.toString());
            }
        }
    }
    public void updateStudentData(String id, String name, String email, String mobileNumber, int age, String address, String gender, List<Student> studentList)
    {
        for (Student student : studentList) {
            if (student.getID().equals(id)) {
                student.setName(name);
                student.setEmail(email);
                student.setMob(mobileNumber);
                student.setAge(age);
                student.setAddress(address);
                student.setGender(gender);
            }
        }
    }
    public void addCourseToStudent(String studentId, String courseId, HashMap<String, ArrayList<String>> studentCourseMap, HashMap<String, ArrayList<String>> courseStudentsMap)
    {
        if(!studentCourseMap.containsKey(studentId))
        {
            studentCourseMap.put(studentId, new ArrayList<String>());
        }
        studentCourseMap.get(studentId).add(courseId);

        if(!courseStudentsMap.containsKey(courseId))
        {
            courseStudentsMap.put(courseId, new ArrayList<String>());
        }
        courseStudentsMap.get(courseId).add(studentId);
    }
}
