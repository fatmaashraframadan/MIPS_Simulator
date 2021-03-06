package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Parser {
    String ErrorMsg = new String();
    public boolean err = false;
    public Assembler assem = new Assembler();
    public String[] parameters = new String[3];
    private HashMap<String, Integer> operations = new HashMap<>();
    static int ProgramCounter = 0;

    //Each Label and its index.
    public static HashMap<String, Integer> Labels = new HashMap<>();


    public Parser() {
        //Arguments 3 and Registers.
        //AllRegisters3.add();
        /**********************************************With 2 Parameters************************************************/
        operations.put("lw", 2);//Register     offset(R)
        operations.put("sw", 2);//Register    offset(R)
        operations.put("lui", 2);//Register     Constant

        /**********************************************With 3 Parameters************************************************/
        operations.put("add", 3);//Register     Register        Register
        operations.put("addi", 3);//Register     Register        Constant

        operations.put("and", 3);//Register     Register        Register
        operations.put("andi", 3);//Register     Register       Constant

        operations.put("beq", 3);//Register     Register        offset
        operations.put("bne", 3);//Register     Register       offset

        operations.put("sub", 3);//Register     Register       Register

        operations.put("or", 3);//Register     Register       Register
        operations.put("ori", 3);//Register     Register      Constant

        operations.put("sll", 3);//Register     Register      Shiftamount
        operations.put("slt", 3);//Register     Register       Register
        operations.put("slti", 3);//Register     Register      Constant
        /**********************************************With 1 Parameters************************************************/
        operations.put("jr", 1);//Address
        operations.put("j", 1);//Address

        /**********************************************With 0 Parameters************************************************/
        operations.put("label", 0);
    }


    //add $t0 $s0 $0
    //add $t0 $s0 $0
    public void parse(String line) {
        String[] tst = line.split(" ");

        String key = tst[0];
        switch (key) {
            /**********************************************With 3 Parameters************************************************/
            case "add":
                String[] arr = {tst[1], tst[2], tst[3]};
                assem.add(arr);
                break;
            case "addi":
                String[] arr2 = {tst[1], tst[2], tst[3]};
                assem.addi(arr2);
                break;
            case "sub":
                String[] arr3 = {tst[1], tst[2], tst[3]};
                assem.sub(arr3);
                break;

            case "bne":
                String[] arr9 = {tst[1], tst[2], tst[3]};
                assem.bne(arr9);
                break;
            case "beq":
                String[] arr10 = {tst[1], tst[2], tst[3]};
                assem.beq(arr10);
                break;

            case "and":
                String[] arr0 = {tst[1], tst[2], tst[3]};
                assem.and(arr0);
                break;
            case "andi":
                String[] arr12 = {tst[1], tst[2], tst[3]};
                assem.andi(arr12);
                break;

            case "or":
                String[] arr11 = {tst[1], tst[2], tst[3]};
                assem.or(arr11);
                break;
            case "ori":
                String[] arr13 = {tst[1], tst[2], tst[3]};
                assem.ori(arr13);
                break;

            case "slti":
                String[] arr6 = {tst[1], tst[2], tst[3]};
                assem.slti(arr6);
                break;
            case "slt":
                String[] arr7 = {tst[1], tst[2], tst[3]};
                assem.slt(arr7);
                break;
            case "sll":
                String[] arr8 = {tst[1], tst[2], tst[3]};
                assem.sll(arr8);
                break;
            /**********************************************With 2 Parameters************************************************/
            case "sw":
                String[] arr4 = {tst[1], tst[2]};
                assem.sw(arr4);
                break;
            case "lui":
                String[] arr5 = {tst[1], tst[2]};
                assem.lui(arr5);
                break;
            case "lw":
                String[] arr15 = {tst[1], tst[2]};
                assem.lw(arr15);
                break;
            /**********************************************With 1 Parameters************************************************/
            case "jr":
                String[] arr14 = {tst[1]};
                assem.jr(arr14);
                break;
            case "j":
                String[] arr17 = {tst[1]};
                assem.j(arr17);
                break;
            /**********************************************With 0 Parameters************************************************/
            case "label":
                // String[] arr16 = {tst[1]};
                //  assem.j(arr16);
                break;
        }
    }


    public void Validate(ArrayList<String> tst) {
        String Line;

        for (int j = 0; j < tst.size(); j++) {
            Line = tst.get(j); //FirstLine add $t0 $s1 $0
            if (Line.contains(":")) {
                Line = Line.substring(0, Line.length() - 1);//label
                Labels.put(Line, j);
            }
        }

        for (; ProgramCounter < tst.size(); ProgramCounter++) {
            Line = tst.get(ProgramCounter); //FirstLine add $t0 $s1 $0
            //ErrorMsg"From Validate Line: " + Line);
            Memory.memorydata[ProgramCounter] = Line;
            String[] strarr = Line.split(" ");
            String x = strarr[0];//add
            //Label case

            if (Line.contains(":")) {
                continue;
            }

            if (operations.containsKey(x))//Check Instruction Exsitance.
            {
                int nom_of_arguments = operations.get(x);
                int len = strarr.length - 1;
                // ErrorMsg"From Validate len " + len + "      From Validate len " + nom_of_arguments);
                if (nom_of_arguments != len)//Check Number of Arguments.
                {
                    ErrorMsg = "\nError in line (" + (ProgramCounter + 1) + ") : " + x + " Takes " + operations.get(x) + " Arguments.\n";
                    err = true;
                } else// if(nom_of_arguments == len) // Check Arguments Validation.
                {
                    if (nom_of_arguments == 3) {
                        check_3_ArgumentsValidation(nom_of_arguments, x, strarr, Line);
                    } else if (nom_of_arguments == 2) {
                        check_2_ArgumentsValidation(nom_of_arguments, x, strarr, Line);
                    } else if (nom_of_arguments == 1) {
                        //strarr[1].equals("j") || strarr[1].equals("jr")) &&
                        if ((x.equals("j") && (Labels.containsKey(strarr[1])))) {
                            parse(Line);
                        } else if (x.equals("jr") && CheckRegisterValidation(strarr[1])) {
                            parse(Line);
                        } else {
                            ErrorMsg = "\nError in line (" + (ProgramCounter + 1) + ")  Check Instruction name.\n";
                            err = true;

                        }
                    }
                }
            }
            //beq bne jr j
            else {
                ErrorMsg = "\nError in line (" + (ProgramCounter + 1) + ")  Check Instruction name.\n";
                err = true;

            }
        }
    }

    //Called to check register validation.
    public boolean CheckRegisterValidation(String s) //$s0
    {
        String x = s;
        boolean charValid = false, strvalid = false;
        if ((s.equals("$0")) || (s.equals("$at"))) {
            strvalid = true;
            return true;
        }

        //Zero Register || $ char nom
        if (((s.charAt(0) == '$'))) //&& !Character.isLetter(s.charAt(1)
        {
            s = s.substring(1);

            //ErrorMsg"From chaeckregistervalidation s after $ " + s);

            char c = s.charAt(0);

            if (s.charAt(0) == 'v' || s.charAt(0) == 'a' || s.charAt(0) == 't' || s.charAt(0) == 's' || s.charAt(0) == 'k') {
                //ErrorMsg"here");
                s = s.substring(1);

                if (Valid0_1(s, c) || Valid0_3(s, c) || Valid0_7(s, c) || Valid0_9(s, c)) {
                    return true;
                }
            }
        }

        return false;
    }

    //$v0–$v1 , $k0–$k1
    public boolean Valid0_1(String c, char k) {
        int nom = Integer.parseInt(c);
        if (nom >= 0 && nom <= 1 && (k == 'v' || k == 'k')) {
            return true;
        }
        return false;
    }

    //$s0–$s7
    public boolean Valid0_7(String c, char k) {
        int nom = Integer.parseInt(c);
        if (nom >= 0 && nom <= 7 && (k == 's')) {
            return true;
        }
        return false;
    }

    //$t0–$t7 , $t8–$t9
    public boolean Valid0_9(String c, char k) {
        int nom = Integer.parseInt(c);
        if (nom >= 0 && nom <= 9 && (k == 't')) {
            return true;
        }
        return false;
    }

    //$v0–$v1 , $k0–$k1
    public boolean Valid0_3(String c, char k) {
        int nom = Integer.parseInt(c);
        if (nom >= 0 && nom <= 1 && (k == 'a')) {
            return true;
        }
        return false;
    }


    public boolean isNumber(String t) {
        try {
            int constant = Integer.parseInt(t);
            return true;
        } catch (NumberFormatException o) {
            return false;
        }
    }


    public boolean isOffset(String t) {
        if (isNumber(t)) {
            int x = Integer.parseInt(t);
            if (x % 4 == 0 || x == 0) {
                return true;
            }
        }
        return false;
    }


    public boolean isOffsetsw_lw(String t) {
        ErrorMsg = "t : " + t + " " + t.length();
        //err = true;

        String x = "";
        x += t.charAt(0);
        //$s0 8($s2)
        if (t.length() == 5 && isNumber(x) && t.charAt(1) == '(' && t.charAt(2) == '$' && t.charAt(4) == ')') {
            String s = "";
            s += t.charAt(2);//$s0
            s += t.charAt(3);
            int nom = Integer.parseInt(x);

            if (CheckRegisterValidation(s) && (nom % 4 == 0)) {
                return true;
            }
        } else if (t.length() == 6 && isNumber(x) && t.charAt(1) == '(' && t.charAt(2) == '$' && t.charAt(5) == ')') //8($s0)
        {
            String s = "";
            s += t.charAt(2);//$s0
            s += t.charAt(3);
            s += t.charAt(4);
            int nom = Integer.parseInt(x);

            if (CheckRegisterValidation(s) && (nom % 4 == 0)) {
                return true;
            }
        }
        return false;
    }


    public void check_3_ArgumentsValidation(int nom_of_arguments, String x, String[] strarr, String Line) {
        int counter = 0;
        //bne $ $ l (Map)

        if (x.equals("bne") || x.equals("beq")) {

            for (int i = 0; i < 2; i++) {
                if (CheckRegisterValidation(strarr[i + 1])) // 1 2
                {
                    counter++;
                }
            }
            String str = strarr[3];
            if (Labels.containsKey(str)) {
                parse(Line);
            }
        }
        if ((x.equals("or") || x.equals("and") || x.equals("add") || x.equals("sub") || x.equals("slt"))) {
            for (int j = 0; j < nom_of_arguments; j++)//0 1 2
            {
                if (CheckRegisterValidation(strarr[j + 1])) // 1 2 3
                {
                    counter++;
                }
            }
            //   ErrorMsg"From Validate Counter :  " + counter);
            if (counter != nom_of_arguments) {
                ErrorMsg = "\nError in line (" + ProgramCounter + ")  Check Instruction arguments.\n";
                err = true;
            } else
                parse(Line);
        }


        //3 Arguments---->Register      Register        Contant
        else if ((x.equals("andi") || x.equals("addi") || x.equals("slti"))) {
            for (int j = 0; j < nom_of_arguments - 1; j++)//0 1 2
            {
                if (CheckRegisterValidation(strarr[j + 1])) // 1 2 3
                {
                    counter++;
                }
            }
            //   ErrorMsg"From Validate Counter :  " + counter);
            if (counter == nom_of_arguments - 1 && isNumber(strarr[3])) {
                parse(Line);
            } else {
                ErrorMsg = "\nError in line (" + ProgramCounter + ")  Check Instruction arguments.\n";
                err = true;
            }

        } else if (x.equals("ori")) {

            for (int i = 0; i < nom_of_arguments - 2; i++) {
                if (CheckRegisterValidation(strarr[i + 1])) // 1 2 3
                {
                    counter++;
                }
            }
            if (counter == nom_of_arguments - 2 && (isHexNumber(strarr[3]) || isNumber(strarr[3])))//0x245F
            {
                parse(Line);
            } else {
                ErrorMsg = "\nError in line (" + ProgramCounter + ")  Check Instruction arguments.\n";
                err = true;

            }
        } else if (x.equals("sll")) {
            if (CheckRegisterValidation(strarr[1]) && CheckRegisterValidation(strarr[2]) && isNumber(strarr[3])) {
                parse(Line);
            } else {
                ErrorMsg = "\nError in line (" + (ProgramCounter + 1) + ")  Check Instruction arguments.\n";
                err = true;
            }
        }
    }

    public void check_2_ArgumentsValidation(int nom_of_arguments, String x, String[] strarr, String Line) {
        int counter = 0;

        if ((x.equals("lui"))) {
            if (CheckRegisterValidation(strarr[1]) && isHexNumber(strarr[2])) {
                parse(Line);
            } else {
                ErrorMsg = "\nError in line (" + (ProgramCounter + 1) + ")  Check Instruction arguments.\n";
                err = true;
            }
        }

        if ((x.equals("sw") || x.equals("lw"))) {
            if (CheckRegisterValidation(strarr[1]) && isOffsetsw_lw(strarr[2])) {
                parse(Line);
            } else {
                ErrorMsg = "\nError in line (" + (ProgramCounter + 1) + ")  Check Instruction arguments.\n";
                err = true;
            }
        }

    }

    public boolean isHexNumber(String x) {
        x = x.substring(2);

        try {
            Long.parseLong(x, 16);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
