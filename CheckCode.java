package tmt;
/*
 * ean-13 条形码校验方法。
 */
public class CheckCode {

	public final static int CODE_LENTH = 13;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(CheckCode.check("6954767430386")){
			System.out.println("Good Number!");
		}else{
			System.out.println("Sorry,please put again!");
		}
	}
	
	
	public static  boolean check(String code){
		if(CODE_LENTH != code.length()){
			return false;
		}
		
		String reCode = reverseString(code);		
		char[] codes =  reCode.toCharArray();
 
		//从第二位开始所有偶数位数字和
		int evenTotal = 0;
		int i=0;
		for(i=1;i<codes.length;){
			evenTotal += Integer.valueOf(codes[i])-48;
			i+=2;
		}
		
		evenTotal = evenTotal*3;
		//从第三位开始所有奇数位数字和
		int unevrnTotal = 0;
		for(i=2;i<codes.length;){
			unevrnTotal += (Integer.valueOf(codes[i])-48);
			i+=2;
		}
		
		
		int total = evenTotal + unevrnTotal;	
		
		//最后一位校验码
		int chackNum = (10-total%10)==10?0:10-total%10;
		if(chackNum != (Integer.valueOf(codes[0])-48)){
			return false;
		}		
		return true;
	}
	
	public static String reverseString(String x){
	  if( x==null || x.length()<2) return x;
	   return reverseString(x.substring(1,x.length()))+ x.charAt(0);
	}

}
