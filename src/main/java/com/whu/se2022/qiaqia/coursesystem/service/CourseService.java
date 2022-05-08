public class CourseService
{
    public boolean addCourse(Course course);
    public boolean deleteCourse(Long id);
    public boolean alterCourse(Course course);
    public Course getCourse(Long id);
    public List<Course> getAllCourse();
}
