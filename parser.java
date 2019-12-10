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
        operations.put("lw", 3);
        operations.put("sw", 3);
        operations.put("add", 3);
        operations.put("addi", 3);
        operations.put("sub", 3);
        operations.put("beq", 3);
        operations.put("bne ", 3);
        operations.put("sll", 3);
        operations.put("slt", 3);
        operations.put("slti", 3);
        operations.put("lui", 3);

        operations.put("and", 2);
        operations.put("or", 2);
        operations.put("andi", 2);
        operations.put("ori", 2);

        operations.put("jr", 1);
        operations.put("j", 1);

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
                    case "add" :
                        String[] arr = {tst[1],tst[2],tst[3]};
                        System.out.println(Arrays.toString(arr));
                        assem.add(arr);
                        System.out.println("Done");
                        break;
                    case "sub" :
                        String[] arr2 = {tst[1],tst[2],tst[3]};
                        assem.sub(arr2);
                    case "lw" :
                        String[] arr3 = {tst[1],tst[2],tst[3]};
                        //   assem.lw(arr3);
                        break;
                    case "sw" :
                        String[] arr4 = {tst[1],tst[2],tst[3]};
                        //  assem.sw(arr4);
                        break;
                    case "lui" :
                        String[] arr5 = {tst[1],tst[2],tst[3]};
                        //assem.lui(arr5);
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
                    case "bne" :
                        String[] arr9 = {tst[1],tst[2],tst[3]};
                        //  assem.bne(arr9);
                        break;
                    case "beq" :
                        String[] arr10 = {tst[1],tst[2],tst[3]};
                        //assem.beq(arr10);
                        break;

                    case "and" :
                        String[] arr0 = {tst[1],tst[2]};
                        //assem.and(arr0);
                    case "or" :
                        String[] arr11 = {tst[1],tst[2]};
                        //   assem.or(arr11);
                        break;
                    case "andi" :
                        String[] arr12 = {tst[1],tst[2]};
                        //  assem.andi(arr12);
                        break;
                    case "ori" :
                        String[] arr13 = {tst[1],tst[2]};
                        //  assem.ori(arr13);
                        break;

                    case "jr" :
                        String[] arr14 = {tst[1]};
                        //  assem.jr(arr14);
                        break;
                    case "j" :
                        String[] arr15 = {tst[1]};
                        //  assem.j(arr15);
                        break;
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

}

