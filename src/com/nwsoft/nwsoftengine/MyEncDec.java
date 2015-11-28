package com.nwsoft.nwsoftengine;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyEncDec {

	/**http://docs.oracle.com/javase/7/docs/technotes/guides/security/StandardNames.html#MessageDigest
	 * MessageDigest Algorithms
		The algorithm names in this section can be specified when generating an instance of MessageDigest.
		
		Algorithm Name			Description
		MD2						The MD2 message digest algorithm as defined in RFC 1319.
		MD5						The MD5 message digest algorithm as defined in RFC 1321.
		SHA-1					Hash algorithms defined in the FIPS PUB 180-2.
		SHA-256					SHA-256 is a 256-bit hash function intended to provide 128 bits of security against 
		SHA-384					collision attacks, while SHA-512 is a 512-bit hash function intended to provide 256  
		SHA-512					bits of security. A 384-bit hash may be obtained by truncating the SHA-512 output.
	 */
	public static void main(String[] args) {
		String strOrigin="secret";
		//String strEncrypt=encSHA256(strOrigin);
		//System.out.println("EncriptedSHA256: "+ strEncrypt);
		String strEncrypt= encMD5(strOrigin);
		System.out.println("EncriptedMD5: " + strEncrypt);
		//if test
		//String testEnc=encSHA256("secret1");
		String testEnc=encMD5("secret2");
		if (strEncrypt.equals(testEnc)) {
			System.out.println("  " + strEncrypt + "\n==" + testEnc);
		} else {
			System.out.println("  " + strEncrypt + "\n!=" + testEnc);
		}
	}

	public static String encSHA256(String str){
		String SHA = ""; 
		try{
			MessageDigest sh = MessageDigest.getInstance("SHA-256"); 
			sh.update(str.getBytes()); 
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer(); 
			for(int i = 0 ; i < byteData.length ; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			SHA = sb.toString();
			
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace(); 
			SHA = null; 
		}
		return SHA;
	}
	public static String encMD5(String str){
		String MD5 = ""; 
		try{
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			md.update(str.getBytes()); 
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer(); 
			for(int i = 0 ; i < byteData.length ; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			MD5 = sb.toString();
			
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace(); 
			MD5 = null; 
		}
		return MD5;
	}
}
