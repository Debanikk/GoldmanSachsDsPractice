package com.wildfire.GoldmanSachsDsPractice;

import java.util.HashSet;
import java.util.Iterator;

public class UniqueTuples {
    public static void main(String[] args) {
        String input = "aabbc";
        HashSet<String> result = uniqueTuples( input, 3 );
        if( result.contains( "aab" ) && result.contains("abb") && result.contains("bbc")) {
            System.out.println( "Test passed." );
        } else {
            System.out.println( "Test failed." );
        }
    }

    static HashSet<String> uniqueTuples(String input, int len ) {
        HashSet<String> result = new HashSet<String>();
        for(int i = 0; i < input.length()-len+1; i++) {
            result.add(input.substring(i, i + len));
        }

        Iterator<String> itr = result.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
        return result;
    }
}
