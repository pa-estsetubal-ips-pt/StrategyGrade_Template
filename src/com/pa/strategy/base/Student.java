package com.pa.strategy.base;
/**
 * @author patricia.macedo
 *
 */
import java.util.HashMap;
import java.util.Map;

public class Student {

    public enum TYPE {NORMAL,WORKER,EXTERN};

    private TYPE type;
    private int id;
    private Map<Integer, Course> courseList;
    private Map<Course, Integer> grades;

    /**
     *
     * @param id of the Student
     * @param type of Student (NORMAL,WORKER,EXTERN)
     */
    public Student(int id, Student.TYPE type) {
        this.id = id;
        this.type=type;
        courseList= new HashMap<>();
        grades= new HashMap<>();
    }

    /**
     * Enroll the student to a new one or more courses
     * @param courses to be added to the course repository of the student
     */
    public void addCourse(Course ...courses){
        for(Course c: courses)
            courseList.put(c.getId(),c);
    }

    /**
     * set a grade to a course where the student is enroled
     * @param id id of the course
     * @param grade grade to be registered
     */
    public void setGrade(int id, int grade){
        if(grade >0 && grade < 20) {
            Course course= courseList.get(id);
            grades.put(course,grade);
        }

    }

    public int getId() {
        return id;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    /**
     * calculate the final grade of the student according to the type of enrolment
     * NORMAl - weighted average considering ECTS and all registered courses
     * WORKER - weighted average,   considering ECTS and all assessed  courses
     * EXTERN - simple average considering all assessed  courses
     *
     * @return the final grade
     */
    public float calculateFinalGrade()    {
        float result=0.0f, finalGrade=0.0f;
        int count=0;

        switch (type) {

            case NORMAL:
                for (Course c : courseList.values()) {
                    if (grades.containsKey(c))
                        result += (grades.get(c) * c.getECTS());
                    count += c.getECTS();
                }
                finalGrade = result / count;
                break;

            case WORKER:
                for (Course c : courseList.values()) {
                    if (grades.containsKey(c)) {
                        result += (grades.get(c) * c.getECTS());
                        count += c.getECTS();
                    }
                }
                finalGrade = result / count;
                break;
            case EXTERN:
                for (Course c : courseList.values()) {
                    if (grades.containsKey(c)) {
                        result += (grades.get(c));
                        count++;
                    }
                }
                finalGrade = result / count;
                break;
        }
        return finalGrade;
    }

}
