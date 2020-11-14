package com.pa.strategy.solutionStrategy;
/*
 *@author patriciamacedo
 */
import java.util.HashMap;
import java.util.Map;

public class Student {

    private Strategy strategy;
    private int id;
    private Map<Integer, Course> courseList;
    private Map<Course, Integer> grades;

    /**
     *
     * @param id - id of the student
     * @param strategy - initial strategy
     */
    public Student(int id,Strategy strategy) {
        this.id = id;
        courseList= new HashMap<>();
        grades= new HashMap<>();
        this.strategy=strategy;
    }

    public Student(int id) {
        this(id,new StrategyNormal());
    }

    public int getId() {
        return id;
    }

    /**
     * Register courses in student process
     * @param courses enroled on Student
     */
    public void addCourse(Course...courses){
        for(Course c: courses)
            courseList.put(c.getId(),c);
    }

    /**
     * Register a grade in the course specified by its id
     * @param id of the course
     * @param grade to be register in the course
     */
    public void setGrade(int id, int grade){
        if(grade >0 && grade < 20) {
            Course course= courseList.get(id);
            grades.put(course,grade);
        }

    }

    /**
     * Change the strategy (type) to the student
     * @param strategy
     */
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    /**
     * calculate the final grade of the student acording to the type of enrolment
     * @return the final grade
     */
    public float calculateFinalGrade()    {
        float finalGrade=strategy.calculateFinalGrade(grades,courseList);
        return finalGrade;
    }


}
