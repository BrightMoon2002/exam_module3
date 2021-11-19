package com.c0821H1.service.student;

import com.c0821H1.model.Student;
import config.SingletonConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService {
    private static Connection connection = SingletonConnection.getConnection();
    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id_Student = resultSet.getInt("idStudent");
                String fullName = resultSet.getString("fullName");
                String grade = resultSet.getString("grade");
                studentList.add(new Student(id_Student, fullName, grade));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return studentList;
    }

    @Override
    public void insert(Student student) {

    }

    @Override
    public Student select(int id) {
        Student student = new Student();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students where idStudent = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id_Student = resultSet.getInt("idStudent");
                String fullName = resultSet.getString("fullName");
                String grade = resultSet.getString("grade");
                student = new Student(id_Student, fullName, grade);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return student;
    }

    @Override
    public boolean update(Student student) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
