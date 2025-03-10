// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
        int n = 8;
        int l =n;
        for(int i = 0;i<n;i++){
            for (int j=1;j<=n;j++){
                if(j<=l){
                    System.out.print(j+" ");
                }
                else{
                    System.out.print("  ");
                }
            }
            for(int k=n-1;k>=1;k--){
                if(k<=l){
                    if(k==1){
                    System.out.print(k);
                    }
                    else{
                    System.out.print(k+" ");}
                }
                else{
                    System.out.print("  ");
                }
            }
            l--;
            System.out.println();
        }
    }
}