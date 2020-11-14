package com.pa.strategy.solutionStrategy;
/*
 *@author patriciamacedo
 */

public class Course {
    /* id of the course*/
    /* name of the course*/
    /* numeber of ECTS of the course*/

    private int id;
    private String name;
    private int ECTS;

    /**
     * @param id of the course
     * @param name of the course
     * @param ECTS ECTS of the course
     */
    public Course(int id, String name, int ECTS) {
        this.id = id;
        this.name = name;
        this.ECTS = ECTS;
    }

    public int getId() {
        return id;
    }

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }
}
