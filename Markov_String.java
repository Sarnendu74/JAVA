import java.util.*;
class Markov_String{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your String: ");
        String str = scan.nextLine();
//       String str ="Is the cold water frozen?";

//      Checking ? or .
        if ((!str.isEmpty()) && ((str.endsWith("?") || str.endsWith(".")))) {
            String str2 = str.substring(0,str.toCharArray().length-1);
            String[] arr = str2.split(" ");
            boolean cond_check = false;
//            System.out.println(arr[0].length());
            int first_length = arr[0].length();
            String list_length = first_length + "";
            for(int i = 1;i<arr.length;i++){
                if ((arr[i].length()) == first_length +i){
                    cond_check = true;
                    list_length = list_length + " " + (arr[i].length());
//                    System.out.print(arr[i].length()+ " " );;
                }
                else{
                    cond_check = false;
//                    System.out.println('a');;
                }
            }
            if(cond_check){
//                System.out.print((first_length+);
                System.out.print(list_length + " It is a Markov String");
            }
            else{
                System.out.print("It's not a Markov String");
            }

        }
//      If not Then.
        else{
            String last_element = str.substring(str.toCharArray().length-1);
            System.out.println(last_element + " Invalid Terminating Character");
        }

    }
}