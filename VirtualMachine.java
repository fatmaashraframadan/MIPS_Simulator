package assemblersim;

import java.util.HashMap;
import java.util.Map;

public class VirtualMachine {
	final static int memory_address = 4096;
	static registers r = new registers();

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
			return registers.r_$at;
		} else if (parameter.equals("$v0")) {
			return registers.r_$v0;
		} else if (parameter.equals("$v1")) {
			return registers.r_$v1;
		} else if (parameter.equals("$a0")) {
			return registers.r_$a0;
		} else if (parameter.equals("$a1")) {
			return registers.r_$a1;
		} else if (parameter.equals("$a2")) {
			return registers.r_$a2;
		} else if (parameter.equals("$a3")) {
			return registers.r_$a3;
		} else if (parameter.equals("$t0")) {
			return registers.r_$t0;
		} else if (parameter.equals("$t1")) {
			return registers.r_$t1;
		} else if (parameter.equals("$t2")) {
			return registers.r_$t2;
		} else if (parameter.equals("$t3")) {
			return registers.r_$t3;
		} else if (parameter.equals("$t4")) {
			return registers.r_$t4;
		} else if (parameter.equals("$t5")) {
			return registers.r_$t5;
		} else if (parameter.equals("$t6")) {
			return registers.r_$t6;
		} else if (parameter.equals("$t7")) {
			return registers.r_$t7;
		} else if (parameter.equals("$s0")) {
			return registers.r_$s0;
		} else if (parameter.equals("$s1")) {
			return registers.r_$s1;
		}

		else if (parameter.equals("$s2")) {
			return registers.r_$s2;
		} else if (parameter.equals("$s3")) {
			return registers.r_$s3;
		} else if (parameter.equals("$s4")) {
			return registers.r_$s4;
		} else if (parameter.equals("$s5")) {
			return registers.r_$s5;
		} else if (parameter.equals("$s6")) {
			return registers.r_$s6;
		}

		else if (parameter.equals("$s7")) {
			return registers.r_$s7;
		} else if (parameter.equals("$t8")) {
			return registers.r_$t8;
		} else if (parameter.equals("$t9")) {
			return registers.r_$t9;
		}

		else if (parameter.equals("$k0")) {
			return registers.r_$k0;
		} else if (parameter.equals("$k1")) {
			return registers.r_$k1;
		}

		else if (parameter.equals("$gp")) {
			return registers.r_$gp;
		} else if (parameter.equals("$sp")) {
			return registers.r_$sp;
		} else if (parameter.equals("$fp")) {
			return registers.r_$fp;
		} else if (parameter.equals("$ra")) {
			return registers.r_$ra;
		} else {
			return registers.r_$0;
		}

	}

	static void set_register(String parameter, int value) {
		if (parameter.equals("$at")) {
			registers.r_$at = value;
		} else if (parameter.equals("$v0")) {
			registers.r_$v0 = value;
		} else if (parameter.equals("$v1")) {
			registers.r_$v1 = value;
		} else if (parameter.equals("$a0")) {
			registers.r_$a0 = value;
		} else if (parameter.equals("$a1")) {
			registers.r_$a1 = value;
		} else if (parameter.equals("$a2")) {
			registers.r_$a2 = value;
		} else if (parameter.equals("$a3")) {
			registers.r_$a3 = value;
		} else if (parameter.equals("$t0")) {
			registers.r_$t0 = value;
		} else if (parameter.equals("$t1")) {
			registers.r_$t1 = value;
		} else if (parameter.equals("$t2")) {
			registers.r_$t2 = value;
		} else if (parameter.equals("$t3")) {
			registers.r_$t3 = value;
		} else if (parameter.equals("$t4")) {
			registers.r_$t4 = value;
		} else if (parameter.equals("$t5")) {
			registers.r_$t5 = value;
		} else if (parameter.equals("$t6")) {
			registers.r_$t6 = value;
		} else if (parameter.equals("$t7")) {
			registers.r_$t7 = value;
		} else if (parameter.equals("$s0")) {
			registers.r_$s0 = value;
		} else if (parameter.equals("$s1")) {
			registers.r_$s1 = value;
		} else if (parameter.equals("$s2")) {
			registers.r_$s2 = value;
		} else if (parameter.equals("$s3")) {
			registers.r_$s3 = value;
		} else if (parameter.equals("$s4")) {
			registers.r_$s4 = value;
		} else if (parameter.equals("$s5")) {
			registers.r_$s5 = value;
		} else if (parameter.equals("$s6")) {
			registers.r_$s6 = value;
		} else if (parameter.equals("$s7")) {
			registers.r_$s7 = value;
		} else if (parameter.equals("$t8")) {
			registers.r_$t8 = value;
		} else if (parameter.equals("$t9")) {
			registers.r_$t9 = value;
		}

		else if (parameter.equals("$k0")) {
			registers.r_$k0 = value;
		} else if (parameter.equals("$k1")) {
			registers.r_$k1 = value;
		}

		else if (parameter.equals("$gp")) {
			registers.r_$gp = value;
		} else if (parameter.equals("$sp")) {
			registers.r_$sp = value;
		} else if (parameter.equals("$fp")) {
			registers.r_$fp = value;
		} else if (parameter.equals("$ra")) {
			registers.r_$ra = value;
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

	static int binary_to_decimal(String binary) {
		String temp = "";
		int decimal = 0;
		for (int i = 0; i < binary.length(); i++) { // for reverse the binary
			temp = "" + binary.charAt(i) + temp;
		}
		for (int i = 0; i < temp.length(); i++) { // for get the integer value of the constant binary
			if (temp.charAt(i) == '1') {
				decimal += Math.pow(2, i);
			}
		}
		return decimal;
	}

	static String decimal_to_binary(int decimal) {
		String c = "";
		for (int i = 0; i < 16; i++) {
			if (decimal % 2 == 0) {
				c = "0" + c;
			} else {
				c = "1" + c;
			}
			decimal /= 2;
		}
		return c;
	}

	static public String[] RType_MachineCodeToText(String machinecode) {
		String[] Parameters = machinecode.split(" ");
		String p1 = RegisterName.get(Parameters[1]);
		String p2 = RegisterName.get(Parameters[2]);
		String p3 = RegisterName.get(Parameters[3]);
		System.out.println("p1 : " + p1 + "   p2 : " + p2 + "  p3 :  " + p3);
		// String ins_Name = InstructionName.get(Parameters[5]);

		String[] tst = { p1, p2, p3 };
		return tst;

	}

	static public String[] IType_MachineCodeToText(String machinecode) {
		String[] Parameters = machinecode.split(" ");
		String p1 = RegisterName.get(Parameters[1]);
		String p2 = RegisterName.get(Parameters[2]);
		int constant = 0;
		String temp = "";
		for (int i = 0; i < Parameters[3].length(); i++) { // for reverse the binary
			temp = "" + Parameters[3].charAt(i) + temp;
		}
		for (int i = 0; i < temp.length(); i++) { // for get the integer value of the constant binary
			if (temp.charAt(i) == '1') {
				constant += Math.pow(2, i);
			}
		}
		System.out.println(constant);

		String p3 = String.valueOf(constant);
		System.out.println("p1 : " + p2 + "   p2 : " + p1 + "  p3 :  " + p3);
		// String ins_Name = InstructionName.get(Parameters[5]);

		String[] tst = { p2, p1, p3 };// the destination is p2 and the values is p1 and p3
		return tst;

	}

	public void add(String machincode) {
		String[] parameters = RType_MachineCodeToText(machincode);

		int r1 = get_register(parameters[1]);
		int r2 = get_register(parameters[2]);
		System.out.println(r1 + "  " + r2);

		// for memory
		// 5000
		if (r1 >= memory_address) {// md const value get the first address in memory=100000

			r1 = binary_to_decimal(memory.memorydata[r1]); // md const value get the first address in memory=100000
		}
		if (r2 >= memory_address) {
			r2 = binary_to_decimal(memory.memorydata[r2]);
		}

		set_register(parameters[0], r1 + r2);

		System.out.println("Result : " + get_register(parameters[0]));

	}

	public void bne(String machincode) {// bne $t0 $t1 Label(index)
		String[] parameters = IType_MachineCodeToText(machincode);

		int r1 = get_register(parameters[0]);
		int r2 = get_register(parameters[1]);
		System.out.println(r1 + "  " + r2);

		// for memory
		if (r1 >= memory_address) {// md const value get the first address in memory=100000

			r1 = binary_to_decimal(memory.memorydata[r1]); // md const value get the first address in memory=100000
		}
		if (r2 >= memory_address) {
			r2 = binary_to_decimal(memory.memorydata[r2]);
		}

		if (r1 != r2) {
			parser.ProgramCounter = Integer.parseInt(parameters[2]);
		}

		System.out.println("Program : " + parser.ProgramCounter);
		System.out.println("Result : " + get_register(parameters[0]));

	}

	public void beq(String machincode) {
		String[] parameters = IType_MachineCodeToText(machincode);

		int r1 = get_register(parameters[0]);
		int r2 = get_register(parameters[1]);

		System.out.println(r1 + "  " + r2);

		// for memory
		if (r1 >= memory_address) {// md const value get the first address in memory=100000

			r1 = binary_to_decimal(memory.memorydata[r1]); // md const value get the first address in memory=100000
		}
		if (r2 >= memory_address) {
			r2 = binary_to_decimal(memory.memorydata[r2]);
		}

		if (r1 == r2) {
			parser.ProgramCounter = Integer.parseInt(parameters[2]);
		}

		System.out.println("Program Counter : " + parser.ProgramCounter);
		System.out.println("Result : " + get_register(parameters[0]));
	}

	public void addi(String machincode) {

		String[] parameters = IType_MachineCodeToText(machincode);

		int r1 = get_register(parameters[1]);
		if (r1 >= memory_address) {// md const value get the first address in memory=100000

			r1 = binary_to_decimal(memory.memorydata[r1]); // md const value get the first address in memory=100000
		}

		int constant = Integer.parseInt(parameters[2]);
		set_register(parameters[0], r1 + constant);

	}

	// sw $s0, 4($s1)
	// sw $s1, $s0 4 machine code
	public void sw(String machincode) {

		String[] parameters = IType_MachineCodeToText(machincode);

		int r1 = get_register(parameters[1]);
		if (r1 >= memory_address) {// md const value get the first address in memory=100000

			r1 = binary_to_decimal(memory.memorydata[r1]); // md const value get the first address in memory=100000
		}
		int r2 = get_register(parameters[0]);
		int offist = Integer.parseInt(parameters[2]);
		int index = r1 + offist / 4+memory_address;

		// System.out.println(r1+" "+r2+" "+len);
		memory.memorydata[index] = decimal_to_binary(r2);
	}

	public void and(String machincode) { // not finished yet

		String[] parameters = RType_MachineCodeToText(machincode);

		int r1 = get_register(parameters[1]);

		int r2 = get_register(parameters[2]);

		if (r1 >= memory_address) {// md const value get the first address in memory=100000

			r1 = binary_to_decimal(memory.memorydata[r1]); // md const value get the first address in memory=100000
		}
		if (r2 >= memory_address) {
			r2 = binary_to_decimal(memory.memorydata[r2]);
		}

		// System.out.println(r1+" "+r2);

		set_register(parameters[0], r1 & r2);
		System.out.println("Result : " + get_register(parameters[0]));

	}

	// add $t0 $s1 5
	// add $t0 $0 3
	public void andi(String machincode) {
		String[] parameters = IType_MachineCodeToText(machincode);

		int r1 = get_register(parameters[1]);
		if (r1 >= memory_address) {// md const value get the first address in memory=100000

			r1 = binary_to_decimal(memory.memorydata[r1]); // md const value get the first address in memory=100000
		}

		// System.out.println(r1+" "+Integer.parseInt(parameters[2]));
		int constant = Integer.parseInt(parameters[2]);
		set_register(parameters[0], r1 & constant);

	}

	public void slt(String machincode) {
		String[] parameters = RType_MachineCodeToText(machincode);

		int r1 = get_register(parameters[1]);
		int r2 = get_register(parameters[2]);
		if (r1 >= memory_address) {// md const value get the first address in memory=100000

			r1 = binary_to_decimal(memory.memorydata[r1]); // md const value get the first address in memory=100000
		}
		if (r2 >= memory_address) {
			r2 = binary_to_decimal(memory.memorydata[r2]);
		}

		// System.out.println(r1+" "+r2);
		if (r1 > r2) {
			set_register(parameters[0], 1);
		} else {
			set_register(parameters[0], 0);
		}
	}

	public void slti(String machincode) {
		String[] parameters = IType_MachineCodeToText(machincode);

		int r1 = get_register(parameters[1]);
		if (r1 >= memory_address) {// md const value get the first address in memory=100000

			r1 = binary_to_decimal(memory.memorydata[r1]); // md const value get the first address in memory=100000
		}

		int constant = Integer.parseInt(parameters[2]);
		// System.out.println(r1+" "+constant);

		if (r1 > constant) {
			set_register(parameters[0], 1);
		} else {
			set_register(parameters[0], 0);
		}
	}
}
