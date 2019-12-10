//package assemblersim;
import com.sun.deploy.util.StringUtils;
import org.omg.CosNaming.IstringHelper;

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

        String key = tst[0];
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


    public void Validate(ArrayList<String>tst)
    {
        int counter = 0;
        String Line;
        for (int i = 0; i < tst.size(); i++)
        {
            Line = tst.get(i); //FirstLine add $t0 $s1 $0
            String[] strarr = Line.split(" ");
            String x  = strarr[0];//add
            if(operations.containsKey(x))//Check Instruction Exsitance.
            {
                int nom_of_arguments = operations.get(x);
                int len = strarr.length-1;
                if(nom_of_arguments != len)//Check Number of Arguments.
                {
                    System.out.println ("Error in line" + i + " : " + x + " Takes " +operations.get( x)+" Arguments.");
                }
                else// if(nom_of_arguments == len) // Check Arguments Validation.
                {
                    /*here*/
                }
            }
            else
            {
                System.out.println("Error in line " + i + "Check Instruction name.");
            }
        }
    }




    //Called to check register validation.
    public boolean CheckRegisterValidation(String s) //$s0
    {
        String x = s;
        boolean charValid = false , strvalid = false;
        if((s.equals("$0")) || (s.equals("$at")))
        {
            strvalid = true;
            return true;
        }
        //Zero Register || $ char nom
       if(((s.charAt(0) == '$') && !Character.isLetter(s.charAt(1)) ) )
       {
           s=s.substring(0,1);
           char c = s.charAt(0);

           if( s.charAt(0) == 'v' || s.charAt(0) == 'a' || s.charAt(0) == 't' || s.charAt(0) == 's' || s.charAt(0) == 'k')
           {
               s=s.substring(0,1);

               if(Valid0_1(s , c) || Valid0_3(s,c) || Valid0_7(s,c) || Valid0_9(s,c))
               {
                   return true;
               }
           }
       }
       return false;
    }

    //$v0–$v1 , $k0–$k1
    public boolean Valid0_1(String c , char k)
    {
        int nom = Integer.parseInt(c);
        if(nom >=0 && nom <=1 && (k =='v' || k == 'k'))
        {
            return true;
        }
        return false;
    }

    //$s0–$s7
    public boolean Valid0_7(String c , char k)
    {
        int nom = Integer.parseInt(c);
        if(nom >=0 && nom <=7 && (k =='s'))
        {
            return true;
        }
        return false;
    }

    //$t0–$t7 , $t8–$t9
    public boolean Valid0_9(String c , char k)
    {
        int nom = Integer.parseInt(c);
        if(nom >=0 && nom <=9 && (k =='t'))
        {
            return true;
        }
        return false;
    }

    //$v0–$v1 , $k0–$k1
    public boolean Valid0_3(String c , char k)
    {
        int nom = Integer.parseInt(c);
        if(nom >=0 && nom <=1 && (k =='a'))
        {
            return true;
        }
        return false;
    }

}

