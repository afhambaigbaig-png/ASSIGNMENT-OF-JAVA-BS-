class BinaryArrayfunction{
  public static int[] tobinaryArray(int number){

    int a=number;
     int b=0;
     while(a>0){
        a=a/2;
        b++;
     }
     int[] binaryArray= new int[b];

     for(int i= b-1; i>=0 ; i--){
        binaryArray[i]=number%2;
        number=number/2;
     }
       return binaryArray;
  }
    public static void main(String[]args){

        int number=27;
        int[]result= tobinaryArray(number);
        System.out.print("binary Array: ");
        for(int bit: result){
            System.out.print(bit);
        }
    }
}