package Lab1.Factory;

import Lab1.Model.Student;
import Lab1.Model.Teacher;
import Lab1.Model.User;

// Factory (Фабрика)
// Фабрика, которая создает экземпляры пользователей (студентов и преподавателей) в зависимости от указанного типа.
public class UserFactory {
    public static User createUser(String name, String userType) {
        if ("student".equalsIgnoreCase(userType)) {
            return new Student(name);
        } else if ("teacher".equalsIgnoreCase(userType)) {
            return new Teacher(name);
        }
        throw new IllegalArgumentException("Invalid user type");
    }
}