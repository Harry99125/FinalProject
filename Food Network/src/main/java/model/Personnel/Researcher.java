package model.Personnel;

import model.Research.ResearchProject;
import org.bson.types.ObjectId;
import java.util.ArrayList;

public class Researcher{

    private ArrayList<ResearchProject> researchProjectList;
    ObjectId researcherName;
    public Researcher(ObjectId researcherName) {
        this.researcherName = researcherName;
    }

}
