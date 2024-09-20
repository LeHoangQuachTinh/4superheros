/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_4;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class bai_2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        for(int i=1;i<=10;i++){
            System.out.println("Bảng cửu chương:"+i);
            for(int j=1;j<=10;j++){
                System.out.printf("%d x %d = %d\n",i,j,i*j);
            }
            System.out.println("");
        }
            
               
    }
}
