package model.Business;

import model.Personnel.Researcher;
import model.Research.ResearchProject;

import java.util.ArrayList;
import org.bson.types.ObjectId;

public class ResearchDirectory {
    private ArrayList<Researcher> researcherList;
    private ArrayList<ResearchProject> researchProjectList;

    public ResearchDirectory() {
        researcherList = new ArrayList<>();
        researchProjectList = new ArrayList<>();
    }

    public Researcher createResearcher(ObjectId researcherName) {
        Researcher researcher1 = new Researcher(researcherName);
        researcherList.add(researcher1);
        return researcher1;
    }
}
