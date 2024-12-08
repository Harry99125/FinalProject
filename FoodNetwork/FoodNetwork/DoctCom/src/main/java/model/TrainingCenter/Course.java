package model.TrainingCenter;

import java.util.List;

public class Course {

    private String courseName;
    private String courseNumber;
    private String courseDomain;
    private String courseDuration;
    private List<String> courseInstructors;
    private CourseStatus courseStatus;
    
    // Constructor
    public Course(String courseName, String courseNumber, String courseDomain, String courseDuration,
                  List<String> courseInstructors, CourseStatus courseStatus) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.courseDomain = courseDomain;
        this.courseDuration = courseDuration;
        this.courseInstructors = courseInstructors;
        this.courseStatus = courseStatus;
    }
    
    // Getters and Setters
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseDomain() {
        return courseDomain;
    }

    public void setCourseDomain(String courseDomain) {
        this.courseDomain = courseDomain;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public List<String> getCourseInstructors() {
        return courseInstructors;
    }

    public void setCourseInstructors(List<String> courseInstructors) {
        this.courseInstructors = courseInstructors;
    }

    public CourseStatus getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(CourseStatus courseStatus) {
        this.courseStatus = courseStatus;
    }
}
