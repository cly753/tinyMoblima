/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Moblima;

import java.io.*;
import java.util.*;

/**
 *
 * @author Yue
 */
public class Company {
    private int numOfCineplex;
    private ArrayList<Cineplex> cineplexList = new ArrayList<Cineplex>();
    private String name;
    
    public void loadFromFile(String fileParentLocation) {
        String fileLocation = fileParentLocation + "_info_Cineplex.txt";
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(fileLocation));

            int size = Integer.parseInt(properties.getProperty("libSize"));
        } catch (Exception e) {
            System.out.println("Unable to process " + fileLocation);
        }
    }
    
    public ArrayList<Cineplex> get() {
        return cineplexList;
    }
}
