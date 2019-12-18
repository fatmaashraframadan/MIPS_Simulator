package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Registers {

    // Using it to fill GUI Table with Register Names
    public static final List<String> registerNames = Arrays.asList("$0", "$at", "$v0", "$v1", "$a0", "$a1", "$a2",
                                                                    "$a3", "$t0", "$t1", "$t2", "$t3", "$t4", "$t5",
                                                                    "$t6", "$t7", "$s0", "$s1", "$s2", "$s3",
                                                                    "$s4", "$s5", "$s6", "$s7", "$t8", "$t9",
                                                                    "$k0", "$k1", "$gp", "$sp", "$fp", "$ra");
    // Using it to fill GUI Table with Register Values
    public static List<Integer> values = Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);

    final static public int r_$0 = 0;
    static public int r_$at;
    static public int r_$v0;
    static public int r_$v1;
    static public int r_$a0;
    static public int r_$a1;
    static public int r_$a2;
    static public int r_$a3;
    static public int r_$t0;
    static public int r_$t1;
    static public int r_$t2;
    static public int r_$t3;
    static public int r_$t4;
    static public int r_$t5;
    static public int r_$t6;
    static public int r_$t7;
    static public int r_$s0;
    static public int r_$s1;
    static public int r_$s2;
    static public int r_$s3;
    static public int r_$s4;
    static public int r_$s5;
    static public int r_$s6;
    static public int r_$s7;
    static public int r_$t8;
    static public int r_$t9;
    static public int r_$k0;
    static public int r_$k1;
    static public int r_$gp;
    static public int r_$sp;
    static public int r_$fp;
    static public int r_$ra;

    private String name;
    private int address;
    private int value;


    public Registers() {
        name = "";
        address = 0;
        value = 0;
    }

    public Registers(String name, int address, int value) {
        this.name = name;
        this.address = address;
        this.value = value;
    }

    public int searchReg(String nameR){
        int index = registerNames.indexOf(nameR);
        return index;
    }

}
