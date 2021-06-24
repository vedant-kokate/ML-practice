public class MDPSolver {
    int numStates; int numActions; double[][][] probabilitiesOfTransitions; 
                     double[][][] rewards;
    int count[];
    public MDPSolver(int numStates, int numActions, double[][][] probabilitiesOfTransitions, 
                     double[][][] rewards) {
                         this.numActions=numActions;
                         this.numStates=numStates;
                         this.probabilitiesOfTransitions=probabilitiesOfTransitions;
                         this.rewards=rewards;
                         this.count=new int[numStates];
        // add your code here
    }
    public double valueOfState(int state, double gamma) {
       if (count[state]>100){
           return 0;
       }
       double max_ans=-10000000;
       for( int i=0;i<numActions;i++){
           double ans=0;
           for (int j=0;j<numStates;j++){
            if(probabilitiesOfTransitions[state][i][j]==0){
                continue;
            }
            count[j]++;
            ans+=rewards[state][i][j]+gamma*probabilitiesOfTransitions[state][i][j]*valueOfState(j, gamma);
            
           }
           max_ans=Math.max(ans,max_ans);
       }
      
       return max_ans;
    }
}
