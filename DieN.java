public class DieN {
    int numSides; boolean[] isBadSide;
	double avg;
    public DieN(int numSides, boolean[] isBadSide) {
        this.numSides=numSides; this.isBadSide=isBadSide;
		int count=0;
		for( int i=0;i<numSides;i++){
			if (!isBadSide[i]){
				count+=i+1;
			}
		}
		this.avg=count/numSides;
    }
    
    public String actionToTake(int score) {
		double val=0;
		for(int i=0;i<numSides;i++){
			if (isBadSide[i])val-=score/numSides;
			else val+=(i+1)/numSides;
		}
		if (val<0) return("quit");
		else
		return("roll");
	}

	public double expectedValue() {
		return 10;
	}
    
}
