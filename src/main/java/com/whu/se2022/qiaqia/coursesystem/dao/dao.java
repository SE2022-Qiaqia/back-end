public class Dao {
    public User getUserById(Long id);

    public Course getCourseById(Long id);

    public boolean addCourse(Course course);

    public boolean addUser(User user);

    public boolean updateUser(User user);

    public boolean updateCourse(Course course);

    public boolean deleteUser(Long id);

    public boolean deleteCourse(Long id);

    public boolean updateGrade(Long stuId, Long courseId, Float grade);

    public boolean checkCourse(Long stuId, Long courseId);// 选课

    public boolean uncheckCourse(Long stuId, Long courseId);// 撤课

    public List<Object> getAllgrade(Long stuId);// 返回某学生所有成绩

    public Integer getCourseGrade(Long stuId, Long courseId);// 返回某门课程某学生成绩

    public List<Course> getAllCourse(Long stuId);// 返回某学生所有课程

    public List<Course> getCourse(Integer year, Integer term, Long deptId);// 条件返回课程
}