# MIPS_Simulator

Write a MIPS simulator that consists of assembler and virtual machine. <br>


## Assembler

The assembler is able to take an assembly program written in a subset of MIPS-32 instruction set and translate it into machine language. The assembler should be able to do the following: <br>

  1. Provide a GUI interface and allow the user to load a program: <br>
        1.1. By typing in the instructions directly. <br>
        1.2. Or by copying and pasting. <br>
  2. Support the following instructions: <br>
        2.1. The basic functions without pseudo-instructions and without function calls.  <br>
        2.2. ALU operations: add, addi, sub, and, or, andi, ori, sll, slt, slti, lui <br>
        2.3. Branches/jumps: jr, j, beq, bne and labels. Assembler must decide jump destination.  <br>
  3. The assembler will take as input the text of the assembly program and will output a list of machine language instructions. (See the    assumptions in MIPS Virtual Machine section below) <br>
  4. Note: Your assembler does not work like QTSPIM. So no need to support data declarations, data types, data and text sections, etc. You will get input programs in pure MIPS assembly. <br>
  
  
## MIPS-32 Virtual Machine: <br>

The virtual machine simulates the structure of MIPS-32 processor and can run the machine language program produced by the assembler. Your machine should be able to do the following: <br>
    1. Provide a GUI to allow the user to see the status of the Program Counter, MIPS registers (or at least the important ones), the relevant part of the memory (were used variables are stored) and the currently executing instructions and its type (R, I, J), parts like opcode, registers, etc. <br>
    2. The machine will have buttons to execute the next instruction or the entire program. <br>
    3. Make the following assumptions: <br>
        •	Memory has only two segments: Text (Program) segment and Data segment. <br>
        •	The program is always loaded starting from memory location 0. (Start of text segment) <br>
        •	Data is stored starting from memory location 0x00001000. (Start of Data segment)  <br>
    
    
## Design and Development: <br>

   1. Develop the program in JAVA. Take advantage of JAVA Swing GUI components. <br>
   2. Write file headers with date, author, version, etc. and which Java version /  tools you used. <br>
   3. Use object-oriented design properly. <br>
        3.1. First think of the classes your system should have in this system. <br>
        3.2. Next, think of the responsibility of each class and its attributes and methods to do its job. <br>
        3.3. Next, think of the external API (public methods) that other classes can use in this class. <br>
        3.4. Finally, think of how these classes cooperate to achieve the task of the program. <br>
        3.5. (Advanced - Optional) Consider using the Command Design Pattern. <br>
        
        
## Authors

* **MinaFarid**     - [mina faried](https://github.com/minafaried)
* **Mariam Makram**  - [mariammakram](https://github.com/mariammakram)
* **Fatma Ashraf** - [fatmaashraframadan](https://github.com/fatmaashraframadan)
