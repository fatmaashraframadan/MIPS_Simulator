//package assemblersim;

import java.util.HashMap;
import java.util.Map;

public class Assembler {

    Map<String, String> register = new HashMap<>();

    static VirtualMachine ob = new VirtualMachine();

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
        }

        else if (parameter.equals("$s2")) {
            return "10010";
        } else if (parameter.equals("$s3")) {
            return "10011";
        } else if (parameter.equals("$s4")) {
            return "10100";
        } else if (parameter.equals("$s5")) {
            return "10101";
        } else if (parameter.equals("$s6")) {
            return "10110";
        }

        else if (parameter.equals("$s7")) {
            return "10111";
        } else if (parameter.equals("$t8")) {
            return "11000";
        } else if (parameter.equals("$t9")) {
            return "11001";
        }

        else if (parameter.equals("$k0")) {
            return "11010";
        } else if (parameter.equals("$k1")) {
            return "11011";
        }

        else if (parameter.equals("$gp")) {
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

    // add $t0 $s1 $0
    // add $t0 $0 $0
    public void add(String[] parameters) {
        String machine = "";
        machine = "000000" + " " + get_register_number(parameters[0]) + " " + get_register_number(parameters[1]) + " "
                + get_register_number(parameters[2]) + " " + "00000" + " " + "100000";
        System.out.println("machine code is : " + machine);
        // return machine;
        ob.add(machine);
    }

    // beq $t0 $0 l
    public void beq(String[] parameters) {
        int index = parser.Labels.get(parameters[2]);
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
        System.out.println(machine);
        ob.beq(machine);

    }


    // Jump Instruction.
    public void j(String[] parameters) {
        int index = parser.Labels.get(parameters[0]);
        String machine = "";

        String c = "";// binary of label instruction index.

        // Convert decimal to binary
        // 16-bit for index
        for (int i = 0; i < 26; i++)
        {
            if (index % 2 == 0) {
                c = "0" + c;
            } else {
                c = "1" + c;
            }
            index /= 2;
        }

        // 6-bit opcpde ----- 5bit Rigester ------ 5bit Register ------- 16 bit
        machine = "000010"+" " + c;
        System.out.println("hereeee    "+machine);
        ob.j(machine);

    }

    // add $t0 $0 $0
    public void bne(String[] parameters) {
        int index = parser.Labels.get(parameters[2]);
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

        System.out.println(machine);
        ob.bne(machine);
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
        machine = "001000" + " " + get_register_number(parameters[1]) + " " + get_register_number(parameters[0]) + " "
                + c;
        System.out.println("machine code is : " + machine);

        ob.addi(machine);
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
        System.out.println("machine code is : " + machine);
        ob.sw(machine);
    }

    public void and(String[] parameters) { // not finished yet
        String machine = "";
        machine = "00000" + " " + get_register_number(parameters[0]) + " " + get_register_number(parameters[1]) + " "
                + get_register_number(parameters[2]) + " " + "00000" + " " + "100100";
        System.out.println("machine code is : " + machine);
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
        System.out.println("machine code is : " + machine);
        ob.andi(machine);

    }

    public void slt(String[] parameters) {

        String machine = "";
        machine = "000000" + " " + get_register_number(parameters[0]) + " " + get_register_number(parameters[1]) + " "
                + get_register_number(parameters[2]) + " " + "00000" + " " + "101010";
        System.out.println("machine code is : " + machine);
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
        System.out.println("machine code is : " + machine);
        ob.slti(machine);

    }

}
