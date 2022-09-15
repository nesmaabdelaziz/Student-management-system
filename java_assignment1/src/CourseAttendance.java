import java.util.Date;

public class CourseAttendance {
    private String id;
    private String courseId;
    private String studentId;
    private Date attendanceDate;
    private String status;

    //SETTERS AND GETTERS
    public void setId(String id)
    {
        this.id = id;
    }
    public String getId()
    {
        return id;
    }
    public void setCourseId(String courseId)
    {
        this.courseId = courseId;
    }
    public String getCourseId()
    {
        return this.courseId;
    }
    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }
    public String  getStudentId()
    {
        return this.studentId;
    }
    public void setAttendanceDate(Date attendanceDate)
    {
        this.attendanceDate = attendanceDate;
    }
    public Date getAttendanceDate()
    {
        return this.attendanceDate;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
    public String getStatus()
    {
        return this.status;
    }
}
