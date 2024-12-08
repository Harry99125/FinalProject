package model.TrainingCenter;

import java.util.ArrayList;
import java.util.List;

public class CourseDirectory {
    ArrayList<Course> courseList;
    
    public CourseDirectory(){
        courseList = new ArrayList();
    }
    
    public ArrayList<Course> getCourseList(){
        return courseList;
    }
    
    public Course addNewCourse(String courseName, String courseNumber, String courseDomain,
                               String courseDuration, List<String> courseInstructors, CourseStatus courseStatus) {
        Course newCourse = new Course(courseName, courseNumber, courseDomain, courseDuration, courseInstructors, courseStatus);
        courseList.add(newCourse);
        return newCourse;
    }
    
    
}
