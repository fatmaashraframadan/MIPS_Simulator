//package assemblersim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    final static int memory_address=100000;

    public static void main(String[] args)
    {

        registers.r_$s0=memory_address+1; //memory of index 1s
        registers.r_$s1=5;
        // memory.memorydata.add(30);
        //memory.memorydata.add(60);
        Assembler a=new Assembler();
//
//        Assembler.set_register("$s1" , 20 );
//        Assembler.set_register("$s2" , 30 );
//        Assembler.set_register("$s3" , 40 );
//        Assembler.set_register("$t1" , 50 );
//        Assembler.set_register("$t1" , 60 );



        System.out.println("Enter your Code : ");
        Scanner scan = new Scanner(System.in);
        String pass = "" ;
        ArrayList<String>s = new ArrayList<>();
        while (scan.hasNextLine())//Write ctrl + d to stop taking input.
        {
            pass = scan.nextLine();
            s.add(pass);
        }
        parser p = new parser();

        /// System.out.println(s);
        p.Validate(s);


//
//        String[] parameters = new String[3];
//        parameters[0]="$t0";
//        parameters[1]="$s0";
//        parameters[2]="$s1";
//
//        a.add(parameters);
        System.out.println(registers.r_$t0);
        System.out.println(memory.memorydata[2]);
    }

}
