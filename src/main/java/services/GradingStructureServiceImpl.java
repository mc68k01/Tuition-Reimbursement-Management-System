package services;

import models.GradingStructure;
import repositories.GradingStructureRepo;

import java.util.List;

public class GradingStructureServiceImpl implements GradingStructureService {

    GradingStructureRepo gsr;

    public GradingStructureServiceImpl(GradingStructureRepo gsr) {
        this.gsr=gsr;
    }

    @Override
    public GradingStructure getGradingStructure(int id) {
        return gsr.getGradingStructure(id);
    }

    @Override
    public List<GradingStructure> getAllGradingStructures() {
        return gsr.getAllGradingStructures();
    }

    @Override
    public GradingStructure addGradingStructure(GradingStructure request) {
        return gsr.addGradingStructure(request);
    }

    @Override
    public GradingStructure updateGradingStructure(GradingStructure update) {
        return gsr.updateGradingStructure(update);
    }

    @Override
    public GradingStructure deleteGradingStructure(int id) {
        return gsr.deleteGradingStructure(id);
    }
}
