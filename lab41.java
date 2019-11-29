package lab4data;

public class lab41 {
	for(int i=0;i<exp.length();i++) {
		espstr=String.valueOf(exp.charAt(i));
		for(int j=0;j<3;j++) {
			if(espstr==brackets1[j])
				st.push(espstr);
			
			else if(espstr==brackets2[j]) {
			String opposite = st.pop();

				 if (st.isEmpty())
	                {
	                    System.out.println("Unbalanced");
	                    break;
	                }
				 else if ( !isMatchingPair( opposite ,espstr ))
	                {
					 	System.out.println("Unbalanced");
					 	break;
	                }
					
			
				}
		
			if (st.isEmpty()) { /*balanced*/
				System.out.println("Balanced");
				break;
		}
	    else
	        {   /*not balanced*/
	        System.out.println("Unbalanced");
	        break;
	        }

		}
	}
}
}
}
