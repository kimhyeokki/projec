public class ParseIntException {
    public static void main(String[] args) {
        String strNumber [] = {"10","20","3.14","99"};
        int i=0;
        for(i=0;i<strNumber.length;i++){
                try{
                int result = Integer.parseInt(strNumber[i]);  //Integer.parseInt(문자열) 문자열의 정수로
                System.out.print(result);
            } catch (NumberFormatException e){
                System.out.println(strNumber[i] +"정수로 변환되지 않습니다.");
            }
            }
            
    }
}
