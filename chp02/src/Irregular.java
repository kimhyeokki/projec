public class Irregular {
    public static void main(String[] args) {
        int intArray[][] =new int[4][];
        intArray[0] = new int[3];
        intArray[1] = new int[2];
        intArray[2] = new int[3];
        intArray[3] = new int[2];

        intArray[0][0] =10;
        intArray[0][1] =20;
        intArray[0][2] =30;
        intArray[1][0] =40;
        intArray[1][1] =50;
        intArray[2][0] =60;
        intArray[2][1] =70;
        intArray[2][2] =80;
        intArray[3][0] =90;
        intArray[3][1] =100;

        int intArray02[][] ={{11,21,31},{41,51},{61,71,81},{91,101}};
        for(int i=0;i<4;i++){
            for(int j=0;j<intArray[i].length;j++){
                System.out.println('\t');
                System.out.println(intArray[i][j]);
            }
        }
            for(int i=0;i<4;i++){
            for(int j=0;j<intArray02[i].length;j++){
                System.out.println('\t');
                System.out.println(intArray02[i][j]);
            }
        }
    }
}
