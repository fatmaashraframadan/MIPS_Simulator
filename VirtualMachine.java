package sample;

import java.util.HashMap;
import java.util.Map;

public class VirtualMachine {
    //‭7FFFEFFF‬
    final static int memory_address = 4096;
    static Registers register1 = new Registers();

    static Map<String, String> InstructionName = new HashMap<>();
    static Map<String, String> RegisterName = new HashMap<>();

    VirtualMachine() {
        RegisterName.put("00000", "$0");
        RegisterName.put("00001", "$at");
        RegisterName.put("00010", "$v0");
        RegisterName.put("00011", "$v1");
        RegisterName.put("00100", "$a0");
        RegisterName.put("00101", "$a1");
        RegisterName.put("00110", "$a2");
        RegisterName.put("00111", "$a3");
        RegisterName.put("01000", "$t0");
        RegisterName.put("01001", "$t1");
        RegisterName.put("01010", "$t2");
        RegisterName.put("01011", "$t3");
        RegisterName.put("01100", "$t4");
        RegisterName.put("01101", "$t5");
        RegisterName.put("01110", "$t6");
        RegisterName.put("01111", "$t7");
        RegisterName.put("10000", "$s0");
        RegisterName.put("10001", "$s1");
        RegisterName.put("10010", "$s2");
        RegisterName.put("10011", "$s3");
        RegisterName.put("10100", "$s4");
        RegisterName.put("10101", "$s5");
        RegisterName.put("10110", "$s6");
        RegisterName.put("10111", "$s7");
        RegisterName.put("11000", "$t8");
        RegisterName.put("11001", "$t9");
        RegisterName.put("11010", "$k0");
        RegisterName.put("11011", "$k1");
        RegisterName.put("11100", "$gp");
        RegisterName.put("11101", "$sp");
        RegisterName.put("11110", "$fp");
        RegisterName.put("11111", "$ra");
    }

    static int get_register(String parameter) {
        if (parameter.equals("$at")) {
            return Registers.r_$at;
        } else if (parameter.equals("$v0")) {
            return Registers.r_$v0;
        } else if (parameter.equals("$v1")) {
            return Registers.r_$v1;
        } else if (parameter.equals("$a0")) {
            return Registers.r_$a0;
        } else if (parameter.equals("$a1")) {
            return Registers.r_$a1;
        } else if (parameter.equals("$a2")) {
            return Registers.r_$a2;
        } else if (parameter.equals("$a3")) {
            return Registers.r_$a3;
        } else if (parameter.equals("$t0")) {
            return Registers.r_$t0;
        } else if (parameter.equals("$t1")) {
            return Registers.r_$t1;
        } else if (parameter.equals("$t2")) {
            return Registers.r_$t2;
        } else if (parameter.equals("$t3")) {
            return Registers.r_$t3;
        } else if (parameter.equals("$t4")) {
            return Registers.r_$t4;
        } else if (parameter.equals("$t5")) {
            return Registers.r_$t5;
        } else if (parameter.equals("$t6")) {
            return Registers.r_$t6;
        } else if (parameter.equals("$t7")) {
            return Registers.r_$t7;
        } else if (parameter.equals("$s0")) {
            return Registers.r_$s0;
        } else if (parameter.equals("$s1")) {
            return Registers.r_$s1;
        } else if (parameter.equals("$s2")) {
            return Registers.r_$s2;
        } else if (parameter.equals("$s3")) {
            return Registers.r_$s3;
        } else if (parameter.equals("$s4")) {
            return Registers.r_$s4;
        } else if (parameter.equals("$s5")) {
            return Registers.r_$s5;
        } else if (parameter.equals("$s6")) {
            return Registers.r_$s6;
        } else if (parameter.equals("$s7")) {
            return Registers.r_$s7;
        } else if (parameter.equals("$t8")) {
            return Registers.r_$t8;
        } else if (parameter.equals("$t9")) {
            return Registers.r_$t9;
        } else if (parameter.equals("$k0")) {
            return Registers.r_$k0;
        } else if (parameter.equals("$k1")) {
            return Registers.r_$k1;
        } else if (parameter.equals("$gp")) {
            return Registers.r_$gp;
        } else if (parameter.equals("$sp")) {
            return Registers.r_$sp;
        } else if (parameter.equals("$fp")) {
            return Registers.r_$fp;
        } else if (parameter.equals("$ra")) {
            return Registers.r_$ra;
        } else {
            return Registers.r_$0;
        }

    }

    static void set_register(String parameter, int value) {
        if (parameter.equals("$at")) {
            Registers.r_$at = value;
            int idx = register1.searchReg("$at");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$v0")) {
            Registers.r_$v0 = value;
            int idx = register1.searchReg("$v0");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$v1")) {
            Registers.r_$v1 = value;
            int idx = register1.searchReg("$v1");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$a0")) {
            Registers.r_$a0 = value;
            int idx = register1.searchReg("$a0");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$a1")) {
            Registers.r_$a1 = value;
            int idx = register1.searchReg("$a1");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$a2")) {
            Registers.r_$a2 = value;
            int idx = register1.searchReg("$a2");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$a3")) {
            Registers.r_$a3 = value;
            int idx = register1.searchReg("$a3");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$t0")) {
            Registers.r_$t0 = value;
            int idx = register1.searchReg("$t0");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$t1")) {
            Registers.r_$t1 = value;
            int idx = register1.searchReg("$t1");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$t2")) {
            Registers.r_$t2 = value;
            int idx = register1.searchReg("$t2");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$t3")) {
            Registers.r_$t3 = value;
            int idx = register1.searchReg("$t3");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$t4")) {
            Registers.r_$t4 = value;
            int idx = register1.searchReg("$t4");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$t5")) {
            Registers.r_$t5 = value;
            int idx = register1.searchReg("$t5");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$t6")) {
            Registers.r_$t6 = value;
            int idx = register1.searchReg("$t6");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$t7")) {
            Registers.r_$t7 = value;
            int idx = register1.searchReg("$t7");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$s0")) {
            Registers.r_$s0 = value;
            int idx = register1.searchReg("$s0");
            Registers.values.set(idx, value);
            System.out.println(Registers.values.get(idx));
        }
        else if (parameter.equals("$s1")) {
            Registers.r_$s1 = value;
            int idx = register1.searchReg("$s1");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$s2")) {
            Registers.r_$s2 = value;
            int idx = register1.searchReg("$s2");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$s3")) {
            Registers.r_$s3 = value;
            int idx = register1.searchReg("$s3");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$s4")) {
            Registers.r_$s4 = value;
            int idx = register1.searchReg("$at");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$s5")) {
            Registers.r_$s5 = value;
            int idx = register1.searchReg("$s5");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$s6")) {
            Registers.r_$s6 = value;
            int idx = register1.searchReg("$s6");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$s7")) {
            Registers.r_$s7 = value;
            int idx = register1.searchReg("$s7");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$t8")) {
            Registers.r_$t8 = value;
            int idx = register1.searchReg("$t8");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$t9")) {
            Registers.r_$t9 = value;
            int idx = register1.searchReg("$t9");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$k0")) {
            Registers.r_$k0 = value;
            int idx = register1.searchReg("$k0");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$k1")) {
            Registers.r_$k1 = value;
            int idx = register1.searchReg("$k1");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$gp")) {
            Registers.r_$gp = value;
            int idx = register1.searchReg("$gp");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$sp")) {
            Registers.r_$sp = value;
            int idx = register1.searchReg("$sp");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$fp")) {
            Registers.r_$fp = value;
            int idx = register1.searchReg("$fp");
            Registers.values.set(idx, value);
        }
        else if (parameter.equals("$ra")) {
            Registers.r_$ra = value;
            int idx = register1.searchReg("$ra");
            Registers.values.set(idx, value);
        }

    }

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

    //Convert Binary to Decimal.
    static int binary_to_decimal(String binary) {
        StringBuilder temp = new StringBuilder();
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) { // for reverse the binary
            temp.insert(0, "" + binary.charAt(i));
        }
        for (int i = 0; i < temp.length(); i++) {  // for get the integer value of the constant binary
            if (temp.charAt(i) == '1') {
                decimal += Math.pow(2, i);
            }
        }
        return decimal;
    }

    //Convert Decimal to Binary.
    static String decimal_to_binary(int decimal) {
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            if (decimal % 2 == 0) {
                c.insert(0, "0");
            } else {
                c.insert(0, "1");
            }
            decimal /= 2;
        }
        return c.toString();
    }


    //Convert Machine Code of R-type to Actual Instruction.
    static public String[] RType_MachineCodeToText(String machinecode) {
        String[] Parameters = machinecode.split(" ");
        String p1 = RegisterName.get(Parameters[1]);
        String p2 = RegisterName.get(Parameters[2]);
        String p3 = RegisterName.get(Parameters[3]);
        // String ins_Name = InstructionName.get(Parameters[5]);

        String[] tst = {p1, p2, p3};
        return tst;

    }

    //Convert Machine Code of I-type to Actual Instruction.
    static public String[] IType_MachineCodeToText(String machinecode) {
        String[] Parameters = machinecode.split(" ");
        String p1 = RegisterName.get(Parameters[1]);
        String p2 = RegisterName.get(Parameters[2]);
        int constant = 0;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < Parameters[3].length(); i++) { // for reverse the binary
            temp.insert(0, "" + Parameters[3].charAt(i));
        }
        for (int i = 0; i < temp.length(); i++) { // for get the integer value of the constant binary
            if (temp.charAt(i) == '1') {
                constant += Math.pow(2, i);
            }
        }


        String p3 = String.valueOf(constant);

        // String ins_Name = InstructionName.get(Parameters[5]);

        String[] tst = {p2, p1, p3};// the destination is p2 and the values is p1 and p3
        return tst;

    }

    //Convert Machine Code of J-type to Actual Instruction.
    static public int JType_MachineCodeToText(String machineCode) {
        String[] params = machineCode.split(" ");

        return binary_to_decimal(params[1]);
    }

    /**********************************************ALU operations************************************************/
    /*
     * 	ALU operations:
     */

    //10
    public void add(String machincode) {
        String[] parameters = RType_MachineCodeToText(machincode);

        int r1 = get_register(parameters[1]);
        int r2 = get_register(parameters[2]);

//memory add -- val
        // for memory
        // 5000
        if (r1 >= memory_address) {// md const value get the first address in memory=100000

            r1 = binary_to_decimal(Memory.memorydata[r1 - memory_address]); // md const value get the first address in memory=100000
        }
        if (r2 >= memory_address) {
            r2 = binary_to_decimal(Memory.memorydata[r2 - memory_address]);
        }

        set_register(parameters[0], r1 + r2);
    }

    public void addi(String machincode) {

        String[] parameters = IType_MachineCodeToText(machincode);

        int r1 = get_register(parameters[1]);

        if (r1 >= memory_address) {// md const value get the first address in memory=100000

            r1 = binary_to_decimal(Memory.memorydata[r1 - memory_address]); // md const value get the first address in memory=100000
        }

        int constant = Integer.parseInt(parameters[2]);
        set_register(parameters[0], r1 + constant);

    }

    public void and(String machincode) { // not finished yet

        String[] parameters = RType_MachineCodeToText(machincode);

        int r1 = get_register(parameters[1]);

        int r2 = get_register(parameters[2]);

        if (r1 >= memory_address) {// md const value get the first address in memory=100000

            r1 = binary_to_decimal(Memory.memorydata[r1 - memory_address]); // md const value get the first address in memory=100000
        }
        if (r2 >= memory_address) {
            r2 = binary_to_decimal(Memory.memorydata[r2 - memory_address]);
        }

        // System.out.println(r1+" "+r2);

        set_register(parameters[0], r1 & r2);
    }

    // add $t0 $s1 5
    // add $t0 $0 3
    public void andi(String machincode) {
        String[] parameters = IType_MachineCodeToText(machincode);

        int r1 = get_register(parameters[1]);
        if (r1 >= memory_address) {// md const value get the first address in memory=100000

            r1 = binary_to_decimal(Memory.memorydata[r1 - memory_address]); // md const value get the first address in memory=100000
        }

        int constant = Integer.parseInt(parameters[2]);
        set_register(parameters[0], r1 & constant);

    }

    public void slt(String machincode) {
        String[] parameters = RType_MachineCodeToText(machincode);

        int r1 = get_register(parameters[1]);
        int r2 = get_register(parameters[2]);
        if (r1 >= memory_address) {// md const value get the first address in memory=100000

            r1 = binary_to_decimal(Memory.memorydata[r1 - memory_address]); // md const value get the first address in memory=100000
        }
        if (r2 >= memory_address) {
            r2 = binary_to_decimal(Memory.memorydata[r2 - memory_address]);
        }

        // System.out.println(r1+" "+r2);
        if (r1 < r2) {
            set_register(parameters[0], 1);
        } else {
            set_register(parameters[0], 0);
        }
    }

    public void slti(String machincode) {
        String[] parameters = IType_MachineCodeToText(machincode);

        int r1 = get_register(parameters[1]);
        if (r1 >= memory_address) {// md const value get the first address in memory=100000

            r1 = binary_to_decimal(Memory.memorydata[r1 - memory_address]); // md const value get the first address in memory=100000
        }

        int constant = Integer.parseInt(parameters[2]);
        // System.out.println(r1+" "+constant);

        if (r1 < constant) {
            set_register(parameters[0], 1);
        } else {
            set_register(parameters[0], 0);
        }
    }

    //For subtraction
    public void sub(String machineCode) {
        String[] parameters = RType_MachineCodeToText(machineCode);

        int reg1 = get_register(parameters[1]);
        int reg2 = get_register(parameters[2]);


        if (reg1 >= memory_address)
            reg1 = binary_to_decimal(Memory.memorydata[reg1]);
        if (reg2 >= memory_address)
            reg2 = binary_to_decimal(Memory.memorydata[reg2]);
        set_register(parameters[0], reg1 - reg2);

    }

    //For or
    public void or(String machineCode) {
        String[] parameters = RType_MachineCodeToText(machineCode);
        int reg1 = get_register(parameters[1]);
        int reg2 = get_register(parameters[2]);


        if (reg1 >= memory_address)
            reg1 = binary_to_decimal(Memory.memorydata[reg1]);
        if (reg2 >= memory_address)
            reg2 = binary_to_decimal(Memory.memorydata[reg2]);
        set_register(parameters[0], reg1 | reg2);

    }


    //For ori $t0 $t1 5
    public void ori(String machineCode, boolean flag) {

        String[] parameters = IType_MachineCodeToText(machineCode);
        //ori $t0 $t1 10
        if (!flag) {
            int reg1 = get_register(parameters[1]);
            int constNum = Integer.parseInt(parameters[2]);
            set_register(parameters[0], reg1 | constNum);
        } else {
            String d = decimal_to_binary(get_register(parameters[0]));

            String s = d + decimal_to_binary(Integer.parseInt(parameters[2]));

            int x = binary_to_decimal(s);
            set_register(parameters[0], (x + memory_address));//Address Decimal
        }
    }

    //For shift left logical
    public void sll(String machineCode) {
        String[] parameters = IType_MachineCodeToText(machineCode);


        int reg1 = get_register(parameters[1]);
        int constNum = Integer.parseInt(parameters[2]);

        if (reg1 >= memory_address)
            reg1 = binary_to_decimal(Memory.memorydata[reg1]);

        set_register(parameters[0], reg1 << constNum);

    }

    //Load Upper Immediate
    public void lui(String machineCode) {

        String[] parameters = IType_MachineCodeToText(machineCode);
        set_register(parameters[0], Integer.parseInt(parameters[2]));//Address Decimal

    }


    /**********************************************Loads and stores************************************************/
    /*
     * 	Loads and stores:
     */

    //For Load Word
    public void lw(String machineCode) {
        //lw $t5 0($t0)
        String[] parameters = IType_MachineCodeToText(machineCode);

        int reg1 = get_register(parameters[1]);
        //  int reg2 = get_register(parameters[0]);
        int offset = Integer.parseInt(parameters[2]);
        int idx = (reg1) + (offset / 4) - memory_address;

        set_register(parameters[0], binary_to_decimal(Memory.memorydata[idx]));

    }

    // sw $s0, 4($s1)
    // sw $s1, $s0 4 machine code
    public void sw(String machincode) {

        String[] parameters = IType_MachineCodeToText(machincode);

        int r1 = get_register(parameters[1]);


        int r2 = get_register(parameters[0]);
        int offist = Integer.parseInt(parameters[2]);
        int index = (r1 - memory_address) + offist / 4;

        // System.out.println(r1+" "+r2+" "+len);
        Memory.memorydata[index] = decimal_to_binary(r2);

    }


    /**********************************************Branches/jumps************************************************/
    /*
     *  Branches/jumps:
     */

    //Jump instruction
    public void j(String machineCode) {
        String[] parameters = machineCode.split(" ");
        int x = binary_to_decimal(parameters[1]);
        Parser.ProgramCounter = x;
    }

    public void jr(String machincode) {
        String[] Parameters = RType_MachineCodeToText(machincode);

        int r1 = get_register(Parameters[0]);               //jr $t0 -- 5   5000

        if (r1 >= memory_address) {                         // md const value get the first address in memory=100000
            r1 = binary_to_decimal(Memory.memorydata[r1 - memory_address]);  // md const value get the first address in memory=100000
        }

        Parser.ProgramCounter = r1;
    }


    public void bne(String machincode) {// bne $t0 $t1 Label(index)
        String[] parameters = IType_MachineCodeToText(machincode);

        int r1 = get_register(parameters[0]);
        int r2 = get_register(parameters[1]);


        // for memory
        if (r1 >= memory_address) {// md const value get the first address in memory=100000

            r1 = binary_to_decimal(Memory.memorydata[r1 - memory_address]); // md const value get the first address in memory=100000
        }
        if (r2 >= memory_address) {
            r2 = binary_to_decimal(Memory.memorydata[r2 - memory_address]);
        }

        if (r1 != r2) {
            Parser.ProgramCounter = Integer.parseInt(parameters[2]);
        }

    }

    public void beq(String machincode) {
        String[] parameters = IType_MachineCodeToText(machincode);

        int r1 = get_register(parameters[0]);
        int r2 = get_register(parameters[1]);

        // for memory
        if (r1 >= memory_address) {// md const value get the first address in memory=100000

            r1 = binary_to_decimal(Memory.memorydata[r1 - memory_address]); // md const value get the first address in memory=100000
        }
        if (r2 >= memory_address) {
            r2 = binary_to_decimal(Memory.memorydata[r2 - memory_address]);
        }

        if (r1 == r2) {
            Parser.ProgramCounter = Integer.parseInt(parameters[2]);
        }

    }
}
