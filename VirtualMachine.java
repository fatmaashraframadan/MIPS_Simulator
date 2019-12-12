import java.util.HashMap;
import java.util.Map;

public class VirtualMachine {
    final static int memory_address=100000;
    static registers r=new registers();

    static Map<String , String> InstructionName = new HashMap<>();
    static Map<String , String>RegisterName = new HashMap<>();


    VirtualMachine()
    {
        RegisterName.put( "01000", "$t0");
        RegisterName.put( "10000", "$s0");
        RegisterName.put("10001" , "$s1");
        RegisterName.put("00000" , "$0");
        //RegisterName.put( , "$t0");
    }

    static int get_register(String parameter) {
        if(parameter.equals("$at")) {
            return registers.r_$at;
        }
        else if(parameter.equals("$v0")) {
            return registers.r_$v0;
        }
        else if(parameter.equals("$v1")) {
            return registers.r_$v1;
        }
        else if(parameter.equals("$a0")) {
            return registers.r_$a0;
        }
        else if(parameter.equals("$a1")) {
            return registers.r_$a1;
        }
        else if(parameter.equals("$a2")) {
            return registers.r_$a2;
        }
        else if(parameter.equals("$a3")) {
            return registers.r_$a3;
        }
        else if(parameter.equals("$t0")) {
            return registers.r_$t0;
        }
        else if(parameter.equals("$t1")) {
            return registers.r_$t1;
        }
        else if(parameter.equals("$t2")) {
            return registers.r_$t2;
        }
        else if(parameter.equals("$t3")) {
            return registers.r_$t3;
        }
        else if(parameter.equals("$t4")) {
            return registers.r_$t4;
        }
        else if(parameter.equals("$t5")) {
            return registers.r_$t5;
        }
        else if(parameter.equals("$t6")) {
            return registers.r_$t6;
        }
        else if(parameter.equals("$t7")) {
            return registers.r_$t7;
        }
        else if(parameter.equals("$s0")) {
            return registers.r_$s0;
        }
        else if(parameter.equals("$s1")) {
            return registers.r_$s1;
        }

        else if(parameter.equals("$s2")) {
            return registers.r_$s2;
        }
        else if(parameter.equals("$s3")) {
            return registers.r_$s3;
        }
        else if(parameter.equals("$s4")) {
            return registers.r_$s4;
        }
        else if(parameter.equals("$s5")) {
            return registers.r_$s5;
        }
        else if(parameter.equals("$s6")) {
            return registers.r_$s6;
        }

        else if(parameter.equals("$s7")) {
            return registers.r_$s7;
        }
        else if(parameter.equals("$t8")) {
            return registers.r_$t8;
        }
        else if(parameter.equals("$t9")) {
            return registers.r_$t9;
        }

        else if(parameter.equals("$k0")) {
            return registers.r_$k0;
        }
        else if(parameter.equals("$k1")) {
            return registers.r_$k1;
        }

        else if(parameter.equals("$gp")) {
            return registers.r_$gp;
        }
        else if(parameter.equals("$sp")) {
            return registers.r_$sp;
        }
        else if(parameter.equals("$fp")) {
            return registers.r_$fp;
        }
        else if(parameter.equals("$ra")) {
            return registers.r_$ra;
        }
        else {
            return registers.r_$0;
        }


    }

    static void set_register(String parameter,int value) {
        if(parameter.equals("$at")) {
            registers.r_$at=value;
        }
        else if(parameter.equals("$v0")) {
            registers.r_$v0=value;
        }
        else if(parameter.equals("$v1")) {
            registers.r_$v1=value;
        }
        else if(parameter.equals("$a0")) {
            registers.r_$a0=value;
        }
        else if(parameter.equals("$a1")) {
            registers.r_$a1=value;
        }
        else if(parameter.equals("$a2")) {
            registers.r_$a2=value;
        }
        else if(parameter.equals("$a3")) {
            registers.r_$a3=value;
        }
        else if(parameter.equals("$t0")) {
            registers.r_$t0=value;
        }
        else if(parameter.equals("$t1")) {
            registers.r_$t1=value;
        }
        else if(parameter.equals("$t2")) {
            registers.r_$t2=value;
        }
        else if(parameter.equals("$t3")) {
            registers.r_$t3=value;
        }
        else if(parameter.equals("$t4")) {
            registers.r_$t4=value;
        }
        else if(parameter.equals("$t5")) {
            registers.r_$t5=value;
        }
        else if(parameter.equals("$t6")) {
            registers.r_$t6=value;
        }
        else if(parameter.equals("$t7")) {
            registers.r_$t7=value;
        }
        else if(parameter.equals("$s0")) {
            registers.r_$s0=value;
        }
        else if(parameter.equals("$s1")) {
            registers.r_$s1=value;
        }
        else if(parameter.equals("$s2")) {
            registers.r_$s2=value;
        }
        else if(parameter.equals("$s3")) {
            registers.r_$s3=value;
        }
        else if(parameter.equals("$s4")) {
            registers.r_$s4=value;
        }
        else if(parameter.equals("$s5")) {
            registers.r_$s5=value;
        }
        else if(parameter.equals("$s6")) {
            registers.r_$s6=value;
        }
        else if(parameter.equals("$s7")) {
            registers.r_$s7=value;
        }
        else if(parameter.equals("$t8")) {
            registers.r_$t8=value;
        }
        else if(parameter.equals("$t9")) {
            registers.r_$t9=value;
        }

        else if(parameter.equals("$k0")) {
            registers.r_$k0=value;
        }
        else if(parameter.equals("$k1")) {
            registers.r_$k1=value;
        }

        else if(parameter.equals("$gp")) {
            registers.r_$gp=value;
        }
        else if(parameter.equals("$sp")) {
            registers.r_$sp=value;
        }
        else if(parameter.equals("$fp")) {
            registers.r_$fp=value;
        }
        else if(parameter.equals("$ra")) {
            registers.r_$ra=value;
        }

    }

    static String get_register_number(String parameter) {
        if(parameter.equals("$at")) {
            return "00001";
        }
        else if(parameter.equals("$v0")) {
            return "00010";
        }
        else if(parameter.equals("$v1")) {
            return "00011";
        }
        else if(parameter.equals("$a0")) {
            return "00100";
        }
        else if(parameter.equals("$a1")) {
            return "00101";
        }
        else if(parameter.equals("$a2")) {
            return "00110";
        }
        else if(parameter.equals("$a3")) {
            return "00111";
        }
        else if(parameter.equals("$t0")) {
            return "01000";
        }
        else if(parameter.equals("$t1")) {
            return "01001";
        }
        else if(parameter.equals("$t2")) {
            return "01010";
        }
        else if(parameter.equals("$t3")) {
            return "01011";
        }
        else if(parameter.equals("$t4")) {
            return "01100";
        }
        else if(parameter.equals("$t5")) {
            return "01101";
        }
        else if(parameter.equals("$t6")) {
            return "01110";
        }
        else if(parameter.equals("$t7")) {
            return "01111";
        }
        else if(parameter.equals("$s0")) {
            return "10000";
        }
        else if(parameter.equals("$s1")) {
            return "10001";
        }

        else if(parameter.equals("$s2")) {
            return "10010";
        }
        else if(parameter.equals("$s3")) {
            return "10011";
        }
        else if(parameter.equals("$s4")) {
            return "10100";
        }
        else if(parameter.equals("$s5")) {
            return "10101";
        }
        else if(parameter.equals("$s6")) {
            return "10110";
        }

        else if(parameter.equals("$s7")) {
            return "10111";
        }
        else if(parameter.equals("$t8")) {
            return "11000";
        }
        else if(parameter.equals("$t9")) {
            return "11001";
        }

        else if(parameter.equals("$k0")) {
            return "11010";
        }
        else if(parameter.equals("$k1")) {
            return "11011";
        }

        else if(parameter.equals("$gp")) {
            return "11100";
        }
        else if(parameter.equals("$sp")) {
            return "11101";
        }
        else if(parameter.equals("$fp")) {
            return "11110";
        }
        else if(parameter.equals("$ra")) {
            return "11111";
        }
        else {
            return "00000";
        }

    }
    // add $t0 $s1 $0
    // add $t0 $0 $0
     public void add(String machincode)
    {
        String[] parameters = RType_MachineCodeToText(machincode);


        int r1=get_register(parameters[1]);
        int r2=get_register(parameters[2]);
        System.out.println(r1+"  "+r2);

        //for memory
        if(r1>=memory_address)
        {//md const value get the first address in memory=100000
            r1= memory.memorydata[r1-memory_address]; //md const value get the first address in memory=100000
        }
        if(r2>=memory_address)
        {
            r2=memory.memorydata[r1-memory_address];
        }

        set_register(parameters[0], r1+r2);

        System.out.println("Result : " + get_register(parameters[0]));

    }


    static  public String[] RType_MachineCodeToText(String  machinecode)
    {
        String[] Parameters = machinecode.split(" ");
        String p1 = RegisterName.get(Parameters[1]);
        String p2 = RegisterName.get(Parameters[2]);
        String p3 = RegisterName.get(Parameters[3]);
        System.out.println("p1 : " + p1 + "   p2 : " + p2 + "  p3 :  " + p3);
        //String ins_Name = InstructionName.get(Parameters[5]);

        String[] tst = {p1 , p2 , p3};
        return tst;

    }
}