package com.example;

import java.util.Map;
import java.util.TreeMap;

/**
  * @author Binnur Kurt <binnur.kurt@gmail.com>
  *
  */
public class StudyMap {

	public static void main(String[] args) {
		// LinkedHashMap, HashMap, TreeMap 
		// IdentityMap, EnumMap
		Map<String,Integer> areaCodes = new TreeMap<>();
		areaCodes.put("ankara", 312);
		areaCodes.put("istanbul-anadolu", 216);
		areaCodes.put("istanbul-avrupa", 212);
		areaCodes.put("antalya", 242);
		areaCodes.put("izmir", 232);
		System.out.println(areaCodes.get("antalya"));
		for (String key : areaCodes.keySet())
			System.out.println(key);
		for (int code : areaCodes.values())
			System.out.println(code);
		for (Map.Entry<String, Integer> pair 
				          : areaCodes.entrySet()) {
			System.out.println(pair.getKey() 
					  + " : "
					  + pair.getValue()); 
		}
	}

}









