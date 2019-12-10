//package assemblersim;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashMap;

public class parser
{
    public String operation;
    public Assembler assem = new Assembler();
    public String[] parameters = new String[3];
    private HashMap<String, Integer> operations = new HashMap<>();

    public parser()
    {
        /**********************************************With 2 Parameters************************************************/
        operations.put("lw", 2);
        operations.put("sw", 2);
        operations.put("lui", 2);

        /**********************************************With 3 Parameters************************************************/
        operations.put("add", 3);
        operations.put("addi", 3);

        operations.put("and", 3);
        operations.put("andi", 3);

        operations.put("beq", 3);
        operations.put("bne ", 3);

        operations.put("sub", 3);

        operations.put("or", 3);
        operations.put("ori", 3);

        operations.put("sll", 3);
        operations.put("slt", 3);
        operations.put("slti", 3);

        /**********************************************With 1 Parameters************************************************/
        operations.put("jr", 1);
        operations.put("j", 1);

        /**********************************************With 0 Parameters************************************************/
        operations.put("label", 0);
    }

    public void parse(String line)
    {
        String[] tst = line.split(" ");

        if(operations.containsKey(tst[0]) )
        {
            String key = tst[0];
            int x = operations.get(key);
            int len = tst.length-1;
            System.out.println("Key : " + key + "  len : " + len);
            if(x==len)
            {
                switch(key)
                {
        /**********************************************With 3 Parameters************************************************/

                    case "add" :
                        String[] arr = {tst[1],tst[2],tst[3]};
                        assem.add(arr);
                        break;
                    case "addi" :
                        String[] arr2 = {tst[1],tst[2],tst[3]};
                        //assem.addi(arr2);
                        break;
                    case "sub" :
                        String[] arr3 = {tst[1],tst[2],tst[3]};
                        //   assem.lw(arr3);
                        break;

                    case "bne" :
                        String[] arr9 = {tst[1],tst[2],tst[3]};
                        //  assem.bne(arr9);
                        break;
                    case "beq" :
                        String[] arr10 = {tst[1],tst[2],tst[3]};
                        //assem.beq(arr10);
                        break;

                    case "and" :
                        String[] arr0 = {tst[1],tst[2] , tst[3]};
                        //assem.and(arr0);
                        break;
                    case "andi" :
                        String[] arr12 = {tst[1],tst[2] , tst[3]};
                        //  assem.andi(arr12);
                        break;

                    case "or" :
                        String[] arr11 = {tst[1],tst[2] , tst[3]};
                        //   assem.or(arr11);
                        break;
                    case "ori" :
                        String[] arr13 = {tst[1],tst[2] , tst[3]};
                        //  assem.ori(arr13);
                        break;

                    case "slti" :
                        String[] arr6 = {tst[1],tst[2],tst[3]};
                        // assem.slti(arr6);
                        break;
                    case "slt" :
                        String[] arr7 = {tst[1],tst[2],tst[3]};
                        //  assem.slt(arr7);
                    case "sll" :
                        String[] arr8 = {tst[1],tst[2],tst[3]};
                        //   assem.sll(arr8);
                        break;


        /**********************************************With 2 Parameters************************************************/
                    case "sw" :
                        String[] arr4 = {tst[1],tst[2]};
                        //  assem.sw(arr4);
                        break;
                    case "lui" :
                        String[] arr5 = {tst[1],tst[2]};
                        //assem.lui(arr5);
                        break;
                    case "lw" :
                        String[] arr15 = {tst[1],tst[2]};
                        //  assem.sw(arr4);
                        break;
        /**********************************************With 1 Parameters************************************************/
                    case "jr" :
                        String[] arr14 = {tst[1]};
                        //  assem.jr(arr14);
                        break;
                    case "j" :
                        String[] arr17 = {tst[1]};
                        //  assem.j(arr15);
                        break;
        /**********************************************With 0 Parameters************************************************/
                    case "label" :
                       // String[] arr16 = {tst[1]};
                        //  assem.j(arr16);
                        break;
                }
            }
            else
            {
                System.out.println("here");
                System.out.println ("Error : " + key + " Takes " +operations.get(key)+" Arguments.");
               // JOptionPane.showConfirmDialog(null,key + " Takes " +operations.get(key)+" Arguments.");
            }
        }
    }


    public void Validate(ArrayList<String>tst)
    {
        String x;
        for (int i = 0; i < tst.size(); i++)
        {
            x = tst.get(i);
            parse(x);
        }
    }
    
   /* public boolean CheckValidation(String[] arr)
    {
        for(int i = 0 ; i < arr.length ; i++)
        {

        }
    }*/

}



