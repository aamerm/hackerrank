class WordLadder{

public static int ladderLength(String s, String d, Set<String> dict){
        if(dict.size()==0) return 0;
        Queue<String> wordq=new LinkedList<String>();
        Queue<Integer> distanceq=new LinkedList<Integer>();
        
        dict.add(d);
        wordq.add(s);
        distanceq.add(1);
        
        while(!wordq.isEmpty()){
            String currWord=wordq.poll();
            Integer currDistance=distanceq.poll();
            
            if(currWord.equals(d))
                return currDistance;
            
            for(int i=0;i<currWord.length();i++){
                char[] currWordArray=currWord.toCharArray();
                for(char c='a';c<='z';c++){
                    currWordArray[i]=c;
                    String newWord=new String(currWordArray);
                    if(dict.contains(newWord)){
                        wordq.add(newWord);
                        distanceq.add(currDistance+1);
                        dict.remove(newWord);
                    }
                }
            }    
        }
        return 0;
    }

}