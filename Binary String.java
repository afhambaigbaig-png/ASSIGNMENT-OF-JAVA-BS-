class binarystring{
    public static String toBinaryString(int number){
        String binary="";
        while( number>0){
            binary=(number%2)+binary;
            number=number/2;
    
        }
        return binary;
    }

    public static void main(String[]args){
        int number= 26;
        String result= toBinaryString(number);
        System.out.println("Binary:"+ result);
    }
}