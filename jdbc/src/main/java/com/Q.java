package com;

public class Q {
    public static void main ( String[] args ) {
        long a = System.currentTimeMillis();
        for ( int y = 0 ; y < 10000 ; y++ ) {

            System.out.println ( y );
        }

        System.out.println ( "\r<br> 执行耗时 : " + ( System.currentTimeMillis ( ) - a ) / 1000f + " 秒 " );
    }
}
