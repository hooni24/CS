/**
 * FileName: StringUtil.java
 * Author: dev.firepizza@gmail.com
 * Since: 21/12/2018
 * Desc: String 관련 유틸클래스
 **/
public class StringUtil {

	/**
	 * Author: dev.firepizza@gmail.com
	 * Since: 21/12/2018
	 * Desc: 임시 비밀번호 생성
	 * History:
	 **/
	public static String createRandomPassword(int size) {
		String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ1234567890";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int i = 0;
		for (; i < size; i++ ) {
			int index = (int)(random.nextDouble() * letters.length());
			sb.append(letters, index, index + 1);
		}
		return sb.toString();
	}

	/**
	 * Author: dev.firepizza@gmail.com
	 * Since: 21/12/2018
	 * Desc: 숫자에 컴마 추가(파라미터 String)
	 * History:
	 **/
	public static String addComma(String num) {
		// null체크
		if(num == null || num.isEmpty()) { return "0"; }
		
		// 숫자체크
		String numberExpr = "^[-+]?(0|[1-9][0-9]*)(\\.[0-9]+)?([eE][-+]?[0-9]+)?$";
		boolean isNumber = num.matches(numberExpr);
		if (!isNumber) { return "0"; }
		
		String strResult = num;
		Pattern p = Pattern.compile("(^[+-]?\\d+)(\\d{3})"); // 앞그룹$1, 뒷그룹(숫자3개)$2
		Matcher regexMatcher = p.matcher(num);
		
		// 변환하면서 그룹패턴 탐색
		while(regexMatcher.find()) {
			strResult = regexMatcher.replaceAll("$1,$2");
			regexMatcher.reset(strResult);
		}
		return strResult;
	}
	
	/**
	 * Author: dev.firepizza@gmail.com
	 * Since: 21/12/2018
	 * Desc: 숫자에 컴마 추가(Number 오버로딩)
	 * History:
	 **/
	public static String addComma(Number num) {
		if(num == null) { num = 0; }
		return addComma(num.toString());
	}

	/**
	 * Author: dev.firepizza@gmail.com
	 * Since: 21/12/2018
	 * Desc: 숫자에 컴마 제거
	 * History:
	 **/
	public static String removeComma(String commaNum) {
		if(commaNum == null || commaNum.isEmpty()) { return "0"; }
		return commaNum.replaceAll(",", "");
	}

}
