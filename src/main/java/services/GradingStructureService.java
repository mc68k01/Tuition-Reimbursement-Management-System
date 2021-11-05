package services;

import models.GradingStructure;

import java.util.List;

public interface GradingStructureService {
    public GradingStructure getGradingStructure(int id);
    public List<GradingStructure> getAllGradingStructures();
    public GradingStructure addGradingStructure(GradingStructure request);
    public GradingStructure updateGradingStructure(GradingStructure update);
    public GradingStructure deleteGradingStructure(int id);

}
