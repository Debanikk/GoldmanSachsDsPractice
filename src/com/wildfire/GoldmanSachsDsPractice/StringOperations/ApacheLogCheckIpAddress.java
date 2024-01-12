package com.wildfire.GoldmanSachsDsPractice.StringOperations;

import java.util.HashMap;

public class ApacheLogCheckIpAddress {
    public static void main(String[] args) {

        String lines[] = new String[]{
                "10.0.0.1 - log entry 1 11",
                "10.0.0.1 - log entry 2 213",
                "10.0.0.2 - log entry 133132"};
        String result = findTopIpaddress(lines);

        if (result.equals("10.0.0.1")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }

    public static String findTopIpaddress(String[] lines){
        HashMap<String, Integer> IMap = new HashMap<>();
        int max = 0;
        String resultIp = "";
        for(String s: lines) {
            String ipAddr = s.split("-")[0].trim();
            if(IMap.containsKey(ipAddr)){
                IMap.put(ipAddr, IMap.get(ipAddr) + 1);
            }
            else {
                IMap.put(ipAddr, 1);
            }
        }
        for(String s : IMap.keySet()){
            if(max < IMap.get(s)){
                max = IMap.get(s);
                resultIp = s;
            }
        }
        return resultIp;
    }
}
