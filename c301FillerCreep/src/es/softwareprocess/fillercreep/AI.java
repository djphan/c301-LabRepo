package es.softwareprocess.fillercreep;

public interface AI {
    public FundamentalStuff evaluate(int playernumber, FillerCreep fillerCreep);

    public void MasterAI();
    
    public void ScrollAndDown();

	void ScrollAndDown(int power);
}

