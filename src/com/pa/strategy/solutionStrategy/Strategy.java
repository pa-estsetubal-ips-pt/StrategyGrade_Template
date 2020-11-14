package com.pa.strategy.solutionStrategy;
/*
 *@author patriciamacedo
 */
import java.util.Map;

/**
 *  Interface Strategy define the method that will be implemented in concreteStrategy
 */
public interface Strategy {
    /**
     *
     * @param grades - information about the grade obtained in each course
     * @param courseList - List of courses where the student is enroled
     * @return the final grade
     */
    float calculateFinalGrade(Map<Course,Integer> grades, Map<Integer,Course> courseList);

}
