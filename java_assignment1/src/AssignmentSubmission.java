import java.util.Date;

public class AssignmentSubmission {
    private String assignmentId;
    private String courseId;
    private String solution;

    //SETTERS AND GETTERS
    public void setId(String id)
    {
        this.assignmentId = id;
    }
    public String getID()
    {
        return assignmentId;
    }
    public void setCourseId(String courseId)
    {
        this.courseId = courseId;
    }
    public String getCourseId()
    {
        return this.courseId;
    }
    public void setSolution(String solution)
    {
        this.solution = solution;
    }
    public String  getSolution()
    {
        return this.solution;
    }
}
