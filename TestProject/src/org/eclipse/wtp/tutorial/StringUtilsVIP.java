package org.eclipse.wtp.tutorial;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringUtilsVIP {
	
	private final static Charset UTF8_CHARSET = Charset.forName("UTF-8");
	
	public static byte[] getBytesUtf8(String string) {
	   return getBytes(string, UTF8_CHARSET);
	}
	
	private static byte[] getBytes(String string, Charset charset) {
        if (string == null) {
           return null;
          }
        return string.getBytes(charset);
    }
	
    public static String newStringUtf8(byte[] bytes) {
	    return newString(bytes, UTF8_CHARSET);
	}
	 
	private static String newString(byte[] bytes, Charset charset) {
		return bytes == null ? null : new String(bytes, charset);
	}

	/**
	 * Returns the obj if not null, "" otherwise.
	 * @param obj The obj to test
	 * @return obj if not null, "" otherwise.
	 */
	public static String nullSafeGet(String obj) {
		return nullSafeGet(obj, "");
	}

	/**
	 * Returns the obj if not null, nullVal otherwise.
	 * @param obj The obj to test
	 * @param nullVal The value to return if obj is null
	 * @return obj if not null, nullVal otherwise.
	 */
	public static <T> T nullSafeGet(T obj, T nullVal) {
		return obj != null ? obj : nullVal;
	}

	/**
	 * @param orig
	 * @param emptyVal
	 * @return orig if it is not null and not "" (trimmed), emptyVal otherwise
	 */
	public static String nullSafeEmptyCheck(String orig, String emptyVal) {
		return nullSafeTrim(orig).length() == 0 ? emptyVal : orig;
	}

	public static String nullSafeTrim(String obj) {
		return nullSafeGet(obj).trim();
	}
	
	public static boolean isEmpty(String obj){
		return (obj != null && !obj.equals("")) ? false : true ;
	}
	public static boolean isEmpty(Object obj){
		return (obj != null && !obj.equals("")) ? false : true ;
	}

	public static int nullSafeParseInt(String value){
		try{
			return Integer.parseInt(value);
		}catch(Exception e){
		}
		return 0;
	}
	
    /**
     * Trims all the Strings in the List, removing any that are blank.<br />
     * 
     * @param strings The original List of Strings (the list or any of its contents are allowed to be null).
     * @param trimInside The boolean value indicates if whitespaces inside the string also need to trimmed as well [true = trimmed, false = does not trim]
     * @return A new list containing trimmed, non-blank strings.  Will never be null.
     */
   

    public static String[] trimAll(String[] strings) {
    	String[] filtered = new String[strings.length];
    	for (int i = 0; i < strings.length; i++) {
    		filtered[i] = strings[i].trim();
		}
		return filtered;
    }
    /**
     * Converts all the Strings in the array to lower case.<br />
     * 
     * @param orig The original String array (should contain no null values).
     * @return A new array of the same length with the same strings after lower-casing each one.
     */
    public static String[] allToLower(String[] orig) {
        String[] newAry = new String[orig.length];
        for (int i = 0; i < orig.length; i++) {
            newAry[i] = orig[i].toLowerCase();
        }
        return newAry;
    }

    public static long valueAsLong(String value) {
    	try {
			return Long.valueOf(value.trim());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
    }

    public static int valueAsInt(String value) {
    	try {
			return Integer.valueOf(value.trim());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
    }

    public static double valueAsDouble(String value) {
    	try {
			return Double.valueOf(value.trim());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
    }

    public static double valueAsDouble(String value, int decimals) {
    	try {
    		BigDecimal original = new BigDecimal(value); 
    		BigDecimal scaled = original.setScale(decimals, BigDecimal.ROUND_HALF_UP);
			return scaled.doubleValue();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
    }

    public static double valueAsDouble(double value, int decimals) {
    	try {
    		BigDecimal original = new BigDecimal(value); 
    		BigDecimal scaled = original.setScale(decimals, BigDecimal.ROUND_HALF_UP);
			return scaled.doubleValue();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
    }

    public static boolean valueAsBoolean(String value) {
		try {
			if (!StringUtilsVIP.isEmpty(value) && (value.trim().equalsIgnoreCase("true") || value.equalsIgnoreCase("1") || value.equalsIgnoreCase("on") || value.equalsIgnoreCase("yes"))) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}
    
	public static String getAsString(List<String> list, String seperator) {
		StringBuffer returnString = new StringBuffer();
		if (list != null && list.size() > 0) {
			for (String value : list) {
				returnString.append(value);
				returnString.append(seperator);
			}
		}
		
		if (returnString.length() > 0) {
			return returnString.substring(0, returnString.length()-2);
		}
		
		return returnString.toString();
	}

	

	public static String getAsString(Map<String,String> epsImageUrls, String delimiter){
		StringBuilder str = new StringBuilder();
		Set<Map.Entry<String,String>> epsImageUrlSet = epsImageUrls.entrySet();
		
		for(Map.Entry<String, String> epsImageUrl : epsImageUrlSet){
			str.append(epsImageUrl.getValue());
			str.append(delimiter);
		}
		if(str.length() > 0)
			return str.substring(0, str.length()-1);
		return "";
	}
	
	
}
