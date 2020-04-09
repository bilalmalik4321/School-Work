package assn2swtest;

public class trigFunc {

	double ans=0;
	boolean step=false;
	
	
		
		public double Sin(double d) {
			ans=0;
			
			for(int i=1;i<10000;i+=2) {
				
				if(step==false) {
					ans+=Math.pow(d,i)/fact(i);
					step=true;
				}
				
				if(step==true) {
					ans-=(Math.pow(d,i))/fact(i);
					step=false;
				}
				
			}
			
			return ans;
		}
		
		
		
		public double Cos(double val) {
			ans=1;
			
			for(int i=2;i<10000;i+=2) {
				
				if(step==false) {
					ans+=Math.pow(val,i)/fact(i);
					step=true;
				}
				
				if(step==true) {
					ans-=(Math.pow(val,i))/fact(i);
					step=false;
				}
				
			}
			
			return ans;
			
		}

		public double Tan(double val) {
			
			ans=Sin(val)/Cos(val);
			return ans;
				
		}

		
	
	
	int fact(int number) {
		 int i,fact=1;  
		 
		 if(number==0) {
			 return 1;
		 }
		      
		  for(i=1;i<=number;i++){    
		      fact=fact*i;    
		  }
		  
		  return fact;
	}
}
