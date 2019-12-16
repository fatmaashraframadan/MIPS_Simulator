public class Instruction {

   /** I-Type Example beq $t0, $zero, ENDIF**/

   /** R-Type Example add $s0, $s1, $s2**/

   /** J-Type Example j LOOP**/
   String Type;
   String MachineCode ;
   public Instruction()
   {}
   public Instruction(String t , String MC)
   {
       this.Type = t;
       this.MachineCode = MC;
   }


}
