package com.pa.strategy.solutionStrategy;
/*
 *@author patriciamacedo
 */
import java.util.Map;

public class StrategyEXTERN implements Strategy {

    /**
     *
     * @param grades - information about the grade obtained in each course
     * @param courseList - List of courses where the student is enroled
     * @return simple average considering all assessed  courses
     */
    @Override

    public float calculateFinalGrade(Map<Course, Integer> grades, Map<Integer, Course> courseList) {
        float result = 0.0f, finalGrade = 0.0f;
        int count = 0;
        for (Course c : courseList.values()) {
            if (grades.containsKey(c)) {
                result += (grades.get(c));
                count++;
            }
        }
        finalGrade = result / count;
        return finalGrade;
    }
}
