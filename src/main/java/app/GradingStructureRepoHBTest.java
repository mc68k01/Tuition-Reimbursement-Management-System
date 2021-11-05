package app;

import repositories.GradingStructureRepo;
import repositories.GradingStructureRepoHBImpl;

public class GradingStructureRepoHBTest {

    public static void main(String[] args){
        GradingStructureRepo gsr = new GradingStructureRepoHBImpl();
        System.out.println(gsr.getAllGradingStructures());

    }
}
