public class UserService
{
    public boolean addUser(String userName,String password);
    public boolean deleteUser(Long id);
    public boolean alterTeacherInfo(Teacher teacher);
    public boolean alterStudentInfo(Student student);
    public Teacher getTeacherInfo(Long id);
    public Student getStudentInfo(Long id);
}
