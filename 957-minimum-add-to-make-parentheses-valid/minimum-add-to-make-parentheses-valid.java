class Solution {
    public int minAddToMakeValid(String s) {
    int c=0;
    int close=0;
    int result=0;
    for(char ch:s.toCharArray()){
      if(ch=='('){
        c++;
      }
      else{
        if(c==0){
          close++;
        }
        else{
          c--;
        }
      }
    }
    result=result+c+close;
    return result;
        
    }
}