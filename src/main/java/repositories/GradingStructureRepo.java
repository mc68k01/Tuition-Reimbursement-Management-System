package repositories;

import models.GradingStructure;

import java.util.List;

public interface GradingStructureRepo {
    public GradingStructure getGradingStructure(int id);
    public List<GradingStructure> getAllGradingStructures();
    public GradingStructure addGradingStructure(GradingStructure newGradingStructure);
    public GradingStructure updateGradingStructure(GradingStructure modifications);
    public GradingStructure deleteGradingStructure(int id);
}