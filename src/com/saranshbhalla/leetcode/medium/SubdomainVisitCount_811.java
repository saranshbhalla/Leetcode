package com.saranshbhalla.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount_811 {
    public static void main(String[] args) {

    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> existingDomains = new HashMap<>();
        for(String str : cpdomains){
            int count = Integer.parseInt(str.substring(0, str.indexOf(" ")));
            String domain = str.substring(str.indexOf(" ")+1);
            subdomainVisits(domain, count, existingDomains);
        }
        List<String> results = new ArrayList<>();
        for(String key : existingDomains.keySet())
            results.add(existingDomains.get(key)+" "+key);
        return results;
    }

    public static void subdomainVisits(String subdomains, int count, Map<String, Integer> existingDomains) {
        if(subdomains==null || subdomains.trim().isEmpty())
            return;

        if(existingDomains.containsKey(subdomains))
            existingDomains.put(subdomains, existingDomains.get(subdomains)+count);
        else
            existingDomains.put(subdomains, count);

        int nextDotIndex = subdomains.indexOf('.');
        if(nextDotIndex==-1)
            return;
        String nextSubDomain = subdomains.substring(nextDotIndex+1);
        subdomainVisits(nextSubDomain, count, existingDomains);
    }
}
