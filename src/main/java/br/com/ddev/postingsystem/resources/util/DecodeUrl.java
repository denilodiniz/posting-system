package br.com.ddev.postingsystem.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class DecodeUrl {
	
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
}
