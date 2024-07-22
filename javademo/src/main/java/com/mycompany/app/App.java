package com.mycompany.app;

import java.io.IOException;
import java.net.URISyntaxException;

import com.mycompany.app.game.Main;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException, URISyntaxException
    {

        int i = 0;
        System.out.println( "Hello World!" );
        if(i ==0){
            System.out.println("Ciao");
        }
        Main.main(null);
    }
}
