import java.util.*;
//import java.util.io;

	public class Solution {
		public static void main(String[] args) {
		    final ArrayList<Integer> petSizes = new ArrayList<Integer>();
			final int nOfTestCases;
			int nPets = 0;
			
			    Scanner sc = new Scanner(System.in);
			    nOfTestCases = sc.nextInt();
			    for(int i = 0; i<nOfTestCases; i++) {
				    nPets = sc.nextInt();
			        for(int m = 0; m<nPets; m++) {
			            petSizes.add(sc.nextInt());
			        }
			        petSizes.add(-3);
			    }
			    sc.close();
			
			Solution sol1 = new Solution(petSizes, nOfTestCases);
			sol1.sortPetSizes();
			sol1.getCases();
			

		}
		
	    private ArrayList<Integer> petSizes;
	    private int nOfTestCases;
	    private int treats;
	    private int treatSize;
	    
	    
	    public Solution(ArrayList<Integer> petSizes, int nOfTestCases) {
	        this.petSizes = petSizes;
	        this.nOfTestCases = nOfTestCases;
	        treats = 0;
	        treatSize = 1;
	    }
	    
	    public void sortPetSizes() {
	    	for(int i = 0; i<nOfTestCases; i++) {
	    		for(int j = 0; j<petSizes.size()-1; j++)
	    			if(petSizes.get(j) != -3) {
	    				int m = -1;
	    				while(m<j) {
	    					int pS1 = petSizes.get(j+1);
	    					int pS2 = petSizes.get(j);
	    					m++;
	    					if(pS1 < pS2) {
	    						petSizes.set(j, pS2);
	    						petSizes.set(j+1, pS1);
	    					}
	    				}
	    			}
	    			else {
	    				petSizes.set(j, -5);
	    				petSizes.remove(petSizes.indexOf(-3));
	    			}
	    	}
	    }
	    
	    public void getCases() {
			int m = 1;
	    	for(int i = 0; i<nOfTestCases; i++) {
	    		for(int j = 0; j< petSizes.size()-1; j++) {
	    			if(petSizes.get(j+1) == -5) {
	    				System.out.println("Case #" + m + ": " + treats);
	    				treats = 0;
	    				treatSize = 1;
	    				m++;
	    			}
	    			else if(petSizes.get(j+1) > petSizes.get(j)) {
	    				treats+=treatSize;
	    				treatSize++;
	    			}
	    			else {
	    				treats+=treatSize;
	    			}
	    		}
	    	}
	    }
	}