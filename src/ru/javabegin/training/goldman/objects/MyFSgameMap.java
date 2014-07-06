/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.javabegin.training.goldman.objects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author alexkurocha
 */
public class MyFSgameMap extends AbstractGameMap {




    @Override
    public boolean loadMap() {
           String csvFile = "game.map";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
 
	try {
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
		        // use comma as separator
			String[] country = line.split(cvsSplitBy);
			System.out.println("Country [code= " + country[4] 
                                 + " , name=" + country[5] + "]");
 
		}
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
        
        return false;   }

    @Override
    public boolean saveMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean drawMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
