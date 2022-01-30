/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author Daniel Bejarano
 */
public class Util {
    
    private Util(){}
    
    
    public static int nextID(String nomfile)
    {
        int id = 0;
        try (BufferedReader bw = new BufferedReader(new FileReader(nomfile))) {
            String linea;
            while ((linea = bw.readLine()) != null) {
                String [] tokens = linea.split("|");
                id = Integer.parseInt(tokens[0]);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return id+1;        
    }
    
}