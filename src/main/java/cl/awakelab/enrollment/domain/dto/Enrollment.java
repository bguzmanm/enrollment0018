package cl.awakelab.enrollment.domain.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class Enrollment {
    private Integer studentId;
    private Integer gradeId;
    private Student student;
    private Grade grade;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "studentId=" + studentId +
                ", gradeId=" + gradeId +
                ", student=" + student +
                ", grade=" + grade +
                ", date=" + date +
                '}';
    }
}
