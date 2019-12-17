//package sample;

import javafx.scene.layout.Pane;

import java.lang.reflect.Parameter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Assembler {

    static VirtualMachine ob = new VirtualMachine();
    //For GUI Table
    static public ArrayList<Instruction>MachineCode = new ArrayList<>();
    static  Instruction tmp = new Instruction();


    static String get_register_number(String parameter) {
        if (parameter.equals("$at")) {
            return "00001";
        } else if (parameter.equals("$v0")) {
            return "00010";
        } else if (parameter.equals("$v1")) {
            return "00011";
        } else if (parameter.equals("$a0")) {
            return "00100";
        } else if (parameter.equals("$a1")) {
            return "00101";
        } else if (parameter.equals("$a2")) {
            return "00110";
        } else if (parameter.equals("$a3")) {
            return "00111";
        } else if (parameter.equals("$t0")) {
            return "01000";
        } else if (parameter.equals("$t1")) {
            return "01001";
        } else if (parameter.equals("$t2")) {
            return "01010";
        } else if (parameter.equals("$t3")) {
            return "01011";
        } else if (parameter.equals("$t4")) {
            return "01100";
        } else if (parameter.equals("$t5")) {
            return "01101";
        } else if (parameter.equals("$t6")) {
            return "01110";
        } else if (parameter.equals("$t7")) {
            return "01111";
        } else if (parameter.equals("$s0")) {
            return "10000";
        } else if (parameter.equals("$s1")) {
            return "10001";
        } else if (parameter.equals("$s2")) {
            return "10010";
        } else if (parameter.equals("$s3")) {
            return "10011";
        } else if (parameter.equals("$s4")) {
            return "10100";
        } else if (parameter.equals("$s5")) {
            return "10101";
        } else if (parameter.equals("$s6")) {
            return "10110";
        } else if (parameter.equals("$s7")) {
            return "10111";
        } else if (parameter.equals("$t8")) {
            return "11000";
        } else if (parameter.equals("$t9")) {
            return "11001";
        } else if (parameter.equals("$k0")) {
            return "11010";
        } else if (parameter.equals("$k1")) {
            return "11011";
        } else if (parameter.equals("$gp")) {
            return "11100";
        } else if (parameter.equals("$sp")) {
            return "11101";
        } else if (parameter.equals("$fp")) {
            return "11110";
        } else if (parameter.equals("$ra")) {
            return "11111";
        } else {
            return "00000";
        }

    }

    public static String Hexa_to_Binary(String hexa)
    {
        hexa = hexa.substring(2);
        hexa =  new BigInteger(hexa, 16).toString(2);
        while (hexa.length() < 32)
        {
            hexa= "0" + hexa;
        }
        return hexa;
    }


    /**********************************************ALU operations************************************************/
    /*
     * 	ALU operations:
     */

    // add $t0 $s1 $0
    // add $t0 $0 $0
    public void add(String[] parameters) {
        String machine = "";
        machine = "000000" + " " + get_register_number(parameters[0]) + " " + get_register_number(parameters[1]) + " "
                + get_register_number(parameters[2]) + " " + "00000" + " " + "100000";

        //For GUI Table
        tmp.Type = "R-Type";
        tmp.MachineCode = machine;
        MachineCode.add(tmp);
        ob.add(machine);
    }

    // add $t0 $s1 5
    // add $t0 $0 3
    public void addi(String[] parameters) {
        int constant = Integer.parseInt(parameters[2]);
        String c = "";
        for (int i = 0; i < 16; i++) {
            if (constant % 2 == 0) {
                c = "0" + c;
            } else {
                c = "1" + c;
            }
            constant /= 2;
        }
        String machine = "";
        machine = "001000" + " " + get_register_number(parameters[1]) + " " + get_register_number(parameters[0]) + " " + c;

        //For GUI Table
        tmp.Type = "I-Type";
        tmp.MachineCode = machine;
        MachineCode.add(tmp);

        ob.addi(machine);
    }


    public void and(String[] parameters) { // not finished yet
        String machine = "";
        machine = "00000" + " " + get_register_number(parameters[0]) + " " + get_register_number(parameters[1]) + " "
                + get_register_number(parameters[2]) + " " + "00000" + " " + "100100";

        //For GUI Table
        tmp.Type = "R-Type";
        tmp.MachineCode = machine;
        MachineCode.add(tmp);
        ob.and(machine);

    }


    // add $t0 $s1 5
    // add $t0 $0 3
    public void andi(String[] parameters) {
        int constant = Integer.parseInt(parameters[2]);
        String c = "";
        for (int i = 0; i < 16; i++) {
            if (constant % 2 == 0) {
                c = "0" + c;
            } else {
                c = "1" + c;
            }
            constant /= 2;
        }
        String machine = "";
        machine = "001100" + " " + get_register_number(parameters[1]) + " " + get_register_number(parameters[0]) + " "
                + c;

        //For GUI Table
        tmp.Type = "I-Type";
        tmp.MachineCode = machine;
        MachineCode.add(tmp);

        ob.andi(machine);

    }


    public void slt(String[] parameters) {

        String machine = "";
        machine = "000000" + " " + get_register_number(parameters[0]) + " " + get_register_number(parameters[1]) + " "
                + get_register_number(parameters[2]) + " " + "00000" + " " + "101010";

        //For GUI Table
        tmp.Type = "R-Type";
        tmp.MachineCode = machine;
        MachineCode.add(tmp);
        ob.slt(machine);
    }


    public void slti(String[] parameters) {

        int constant = Integer.parseInt(parameters[2]);

        String c = "";
        for (int i = 0; i < 16; i++) {
            if (constant % 2 == 0) {
                c = "0" + c;
            } else {
                c = "1" + c;
            }
            constant /= 2;
        }
        String machine = "";
        machine = "001010" + " " + get_register_number(parameters[1]) + " " + get_register_number(parameters[0]) + " "
                + c;

        //For GUI Table
        tmp.Type = "I-Type";
        tmp.MachineCode = machine;
        MachineCode.add(tmp);
        ob.slti(machine);

    }

    //For or
    public void or(String[] parameters) {
        String machineCode = "000000" + " " + get_register_number(parameters[0]) + " " +
                get_register_number(parameters[1]) + " " +
                get_register_number(parameters[2]) + " " +
                "00000" + " " + "100101";

        //For GUI Table
        tmp.Type = "R-Type";
        tmp.MachineCode = machineCode;
        MachineCode.add(tmp);
        ob.or(machineCode);
    }

    //For ori
    public void ori(String[] parameters) {
        String machineCode = "";
        boolean flag = false;
        String code = "";
        if(parameters[2].charAt(0)!='0' && parameters[2].charAt(1) != 'x')
        {
            int constant = Integer.parseInt(parameters[2]);
            code = VirtualMachine.decimal_to_binary(constant);
        }
        else
        {
            flag =true;
            String allBinary = Hexa_to_Binary(parameters[2]); //16 bit
            System.out.println("length : " + allBinary.length());
            for (int i = 16; i < 32; i++)
            {
                code+=""+allBinary.charAt(i);
            }
        }
        //ari $t2 $t0 10
        machineCode = "001101" + " " + get_register_number(parameters[1]) + " " +
                get_register_number(parameters[0]) + " " + code;

        //For GUI Table
        tmp.Type = "I-Type";
        tmp.MachineCode = machineCode;
        MachineCode.add(tmp);


        ob.ori(machineCode , flag);
    }

    //For Shift Logical Left
    public void sll(String[] parameters) { //000000
        int constant = Integer.parseInt(parameters[2]);
        String s = "";
        s = VirtualMachine.decimal_to_binary(constant);
        String machineCode = "000000" + " " + get_register_number(parameters[1]) + " " +
                get_register_number(parameters[0]) + " " + s;

        //For GUI Table
        tmp.Type = "R-Type";
        tmp.MachineCode = machineCode;
        MachineCode.add(tmp);


        ob.sll(machineCode);
    }

    //0x00055 -- First 16 bit -- Most significant bits.
    public void lui(String[] parameters) {
        String allBinary = Hexa_to_Binary(parameters[1]);
        String First_16 = "";

        System.out.println("all binary : " + allBinary);
        for (int i = 0; i < 16; i++) {
            First_16+=""+allBinary.charAt(i);
        }

        String machineCode="001111" + " " +"00000"+" "+ get_register_number(parameters[0]) + " " + First_16;



        //For GUI Table
        tmp.Type = "I-Type";
        tmp.MachineCode = machineCode;
        MachineCode.add(tmp);

        ob.lui(machineCode);
    }

    //For subtract operation
    public void sub(String[] parameters) {
        String machineCode = "";

        machineCode = "000000" + " " + get_register_number(parameters[0]) + " " +
                get_register_number(parameters[1]) + " " +
                get_register_number(parameters[2]) + " " +
                "00000" + " " + "100010";


        //For GUI Table
        tmp.Type = "R-Type";
        tmp.MachineCode = machineCode;
        MachineCode.add(tmp);

        ob.sub(machineCode);
    }

    /**********************************************Loads and stores************************************************/

    /*
     * 	Loads and stores:
     */
    public void lw(String[] parameters) { //100011   //lw $t5 0($t0) 0+0
        String len = "" + parameters[1].charAt(0);
        int offset = Integer.parseInt(len);
        String codeBinary = VirtualMachine.decimal_to_binary(offset);

        //int constant = Integer.parseInt(parameters[2]);

        String temp = "" + parameters[1].charAt(2) + parameters[1].charAt(3) + parameters[1].charAt(4);

        String machineCode = "100011" + " " + get_register_number(temp) + " " +
                get_register_number(parameters[0]) + " " + codeBinary;

        //For GUI Table
        tmp.Type = "I-Type";
        tmp.MachineCode = machineCode;
        MachineCode.add(tmp);

        ob.lw(machineCode);
    }


    public void sw(String[] parameters) {

        String len = "" + parameters[1].charAt(0);

        int offist = Integer.parseInt(len);

        String c = "";
        for (int i = 0; i < 16; i++) {
            if (offist % 2 == 0) {
                c = "0" + c;
            } else {
                c = "1" + c;
            }
            offist /= 2;
        }

        String temp = "" + parameters[1].charAt(2) + parameters[1].charAt(3) + parameters[1].charAt(4);
        String machine = "";
        machine = "101011" + " " + get_register_number(temp) + " " + get_register_number(parameters[0]) + " " + c;

        //For GUI Table
        tmp.Type = "I-Type";
        tmp.MachineCode = machine;
        MachineCode.add(tmp);

        ob.sw(machine);
    }



    /**********************************************Branches/jumps************************************************/
    /*
     *  Branches/jumps:
     */
    //j label
    public void j(String[] parameters) {
        int index = Parser.Labels.get(parameters[0]);
        String c = "";// binary of label instruction index.

        // Convert decimal to binary
        // 16-bit for index
        for (int i = 0; i < 16; i++) {
            if (index % 2 == 0) {
                c = "0" + c;
            } else {
                c = "1" + c;
            }
            index /= 2;
        }

        String machineCode = "";
        machineCode = "000010" + " " + c;

        //For GUI Table
        tmp.Type = "J-Type";
        tmp.MachineCode = machineCode;
        MachineCode.add(tmp);
        ob.j(machineCode);
    }

    // Jump register Instruction. --- go to the address stored in register ---- Rtype Instruction.
    public void jr(String[] parameters)
    {
        String x =get_register_number(parameters[0]);
        String machine ="000000"+" "+ x+" "+"00000" + " " + "00000"+" " +"00000"+" " +"001000";

        //For GUI Table
        tmp.Type = "R-Type";
        tmp.MachineCode = machine;
        MachineCode.add(tmp);
        ob.jr(machine);
    }

    // beq $t0 $0 l
    public void beq(String[] parameters) {
        int index = Parser.Labels.get(parameters[2]);
        String c = "";// binary of label instruction index.

        // Convert decimal to binary
        // 16-bit for index
        for (int i = 0; i < 16; i++) {
            if (index % 2 == 0) {
                c = "0" + c;
            } else {
                c = "1" + c;
            }
            index /= 2;
        }

        String machine = "";

        // 6-bit opcpde ----- 5bit Rigester ------ 5bit Register ------- 16 bit
        machine = "000100" + " " + get_register_number(parameters[0]) + " " + get_register_number(parameters[1]) + " "
                + c;

        //For GUI Table
        tmp.Type = "I-Type";
        tmp.MachineCode = machine;
        MachineCode.add(tmp);

        ob.beq(machine);

    }

    // add $t0 $0 $0
    public void bne(String[] parameters) {
        int index = Parser.Labels.get(parameters[2]);
        String c = "";// binary of label instruction index.

        // Convert decimal to binary
        // 16-bit for index
        for (int i = 0; i < 16; i++) {
            if (index % 2 == 0) {
                c = "0" + c;
            } else {
                c = "1" + c;
            }
            index /= 2;
        }

        String machine = "";

        // 6-bit opcpde ----- 5bit Rigester ------ 5bit Register ------- 16 bit
        machine = "000101" + " " + get_register_number(parameters[0]) + " " + get_register_number(parameters[1]) + " "
                + c;

        //For GUI Table
        tmp.Type = "I-Type";
        tmp.MachineCode = machine;
        MachineCode.add(tmp);

        ob.bne(machine);
    }

}
