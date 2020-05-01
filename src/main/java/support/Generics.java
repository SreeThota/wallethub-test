package support;

public class Generics {
	
	public static String randomString(String type, int length) {
		char[] arr = type.toCharArray();
		String fullString = "";
		String toReturn = "";
		for(int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
			case 'a':
				fullString+="abcdefghijklmnopqrstuvwxyz";
				break;
			case 'A':
				fullString+="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				break;
			case '1':
				fullString+="1234567890";
				break;
			default:
				break;
			}
		}
		for (int j = 0; j < length; j++) {
			toReturn+=fullString.charAt((int) Math.floor(Math.random() * (fullString.length())));
		}
		return toReturn;
	}
	
	public static int generateRandomNumberBetweenMinAndMax(int min, int max) {
		return (int) (Math.floor(Math.random() * (max - min)) + min);
	}

}
