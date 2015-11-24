class RecDemo{

void RecPermute(String sofar, String rest){
	if(rest=="")
		print(sofar);
	else{
		for(i to rest.length){
			String next=sofar+rest[i];
			String remaining=rest.substring(0,i)+rest.substring(i+1);
			RecPermute(next, remaining);
		}
	}
}



void RecSubsets(String sofar, String rest){
	if(rest=="")
		print(sofar);
	else{
		RecSubsets(sofar+rest[0], rest.substring(1)); ////add to subset, remove from rest, recur
		RecSubsets(sofar, rest.substring(1)); //dont add to subset, remove from rest, recur
	}
}



public static void main(String[] args){
//RecSubsets("", "abcd");
//RecPermute("", "abcd");
}

}