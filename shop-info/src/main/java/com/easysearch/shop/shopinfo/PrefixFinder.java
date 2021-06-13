package com.easysearch.shop.shopinfo;

import java.util.Optional;

public class PrefixFinder {

	public static void main(String[] args) {

		// String arr[]={"String","Strike",""};

		 String arr[]={"ant","antony","antenna","ankle"};

		 //String arr[]={"ant"};

		// String arr[]={};

		 //String arr[]={"abc",null};

		PrefixFinder test = new PrefixFinder();

		Optional<String> finalStr = test.findCommonPrefix(arr);

		if (finalStr.isPresent())
			System.out.println(finalStr.get());

	}

	public Optional<String> findCommonPrefix(String[] arr) {

		Optional<String> commonPrefix = Optional.empty();

		if (arr != null && arr.length > 0) {
			int lowestLen = findLowestLength(arr);
			commonPrefix = getCommonPrefix(lowestLen, arr);
		}
		return commonPrefix;

	}

	private Optional<String> getCommonPrefix(int lowestLen, String[] arr) {

		Optional<String> finalStr = Optional.empty();
		String calculateStr = "";
		

			for (int indexk = 0,indexj=1; indexk <lowestLen&&indexj<arr.length; indexj++) {
				if (arr[0].charAt(indexk) != arr[indexk].charAt(indexk)) {
					break;
				}
				else
				{
					calculateStr = calculateStr + arr[0].charAt(indexk);	
					indexk++;
				}
			}



		if (calculateStr != "") {
			finalStr = Optional.of(calculateStr);
		}

		return finalStr;
	}

	private int findLowestLength(String[] arr) {

		int lowestLen = Integer.MAX_VALUE;

		for (int index = 0; index < arr.length; index++) {
			if (arr[index] == null) {
				lowestLen = 0;
			} else if (arr[index].length() < lowestLen) {
				lowestLen = arr[index].length();
			}
		}

		return lowestLen;

	}

}
