package com.pa.strategy.solutionStrategy;
/*
 *@author patriciamacedo
 */
import java.util.Map;

public class StrategyNormal implements Strategy {
    /**
     *
     * @param grades
     * @param courseList - List of courses where the student is enroled
     * @return weighted average considering ECTS and all registered courses
     */
    @Override
    public float calculateFinalGrade(Map<Course, Integer> grades, Map<Integer, Course> courseList) {
        float result = 0.0f, finalGrade = 0.0f;
        int count = 0;

        for (Course c : courseList.values()) {
            if (grades.containsKey(c))
                result += (grades.get(c) * c.getECTS());
            count += c.getECTS();
        }
        finalGrade = result / count;
        return finalGrade;
    }
}
