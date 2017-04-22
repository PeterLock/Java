{\rtf1\ansi\ansicpg1252\cocoartf1504\cocoasubrtf820
{\fonttbl\f0\fmodern\fcharset0 Courier;}
{\colortbl;\red255\green255\blue255;\red0\green0\blue0;}
{\*\expandedcolortbl;;\cssrgb\c0\c0\c0;}
\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\fs26 \cf0 \expnd0\expndtw0\kerning0
package Chapter3_CaesarCipher;\
\
public class CaesarCipher \{\
	/**Class for doing encryption and decryption using the Caesar Cipher*/\
	protected char [] encoder = new char[26];	//Encryption array\
	protected char[] decoder = new char[26];	//Decryption array\
	/**Constructor that initializes the encryption and decryption arrays*/\
	public CaesarCipher(int rotation)\{\
		for(int k=0; k< 26; k++)\{\
			encoder[k] = (char)('A' + (k + rotation) % 26);\
			decoder[k] = (char)('A' + (k - rotation + 26) % 26);\
		\}\
	\}\
	/**Returns String representing encrypted message*/\
	public String encrypt(String message)\{\
		return transform(message, encoder);		//use encoder array\
	\}\
	/**Returns decrypted message given encrypted secret*/\
	public String decrypt(String secret)\{\
		return transform(secret, decoder);		//use decoder array\
	\}\
	/**Returns transformation of original String using given code/*/\
	private String transform(String original, char[] code)\{\
		char[] msg = original.toCharArray();\
		for(int k = 0; k < msg.length; k++)\{\
			if(Character.isUpperCase(msg[k]))\{	//we have a letter to change\
				int j = msg[k] - 'A';			//will be value from 0 - 25\
				msg[k] = code[j];				//replace the character\
			\}\
		\}\
		return new String(msg);\
	\}\
	/**Simple main method for testing the Caesar cipher*/\
	public static void main(String[] args)\{\
		\
	CaesarCipher cipher = new CaesarCipher(3);\
	System.out.println("Encryption code = " + new String(cipher.encoder));		\
	System.out.println("Decryption code =" + new String(cipher.decoder));\
	String message = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";\
	String coded = cipher.encrypt(message);\
	System.out.println("Secret: " + coded);\
	String answer = cipher.decrypt(coded);\
	System.out.println("Message: " + answer);	//should be plaintext again\
	\
	\}\
	\
	\
	\
\}}