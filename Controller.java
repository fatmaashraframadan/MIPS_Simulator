package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Tooltip;


import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    ArrayList<String> instruc = new ArrayList<>();
    public static ArrayList<Registers> registersArray = new ArrayList<>();

    @FXML
    TextArea codeText;
    @FXML
    Button executeButton;
    @FXML
    Button clearButton;
    @FXML
    Button startButton;
    @FXML
    TextArea executionMessage;
    @FXML
    TextField progCounter;
    @FXML
    TableView<Registers> registerTable;
    @FXML
    TableColumn<Registers, String> registerCol = new TableColumn<>("Name");
    @FXML
    TableColumn<Registers, Integer> registerNumber = new TableColumn<>("Address");
    @FXML
    TableColumn<Registers, String> registerValue = new TableColumn<>("Value");
   /* @FXML
    TableColumn<Registers, String> addressCol = new TableColumn<>("Address");
    @FXML
    TableColumn<Registers, String> addressBinary = new TableColumn<>("Binary");
    @FXML
    TableColumn<Registers, String> addressHex = new TableColumn<>("Hex");*/

    ObservableList<Registers> data;


    @Override
    public void initialize(URL location, ResourceBundle resources) {            //Initializes the Stage
        registerCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        registerNumber.setCellValueFactory(new PropertyValueFactory<>("Address"));
        registerValue.setCellValueFactory(new PropertyValueFactory<>("Value"));
        // addressCol.setCellValueFactory(new PropertyValueFactory<>("Address"));
        //addressBinary.setCellValueFactory(new PropertyValueFactory<>("Binary"));
        //addressCol.setCellValueFactory(new PropertyValueFactory<>("Hex"));
        fillTable();
        startButton.setTooltip(new Tooltip("Erases the written code and resets the registers"));
        executeButton.setTooltip(new Tooltip("Executes the written code"));
        clearButton.setTooltip(new Tooltip("Erases previous compilation messages"));
        codeText.setTooltip(new Tooltip("Write your code here"));
        progCounter.setTooltip(new Tooltip("Displays the program counter"));
    }

    public void fillTable() {       //Filling the Registers table with registers values and numbers
        registersArray.clear();
        for (int i = 0; i < 32; i++) {
            registersArray.add(new Registers(Registers.registerNames.get(i), i, Registers.values.get(i)));
        }
        data = FXCollections.observableArrayList();
        data.addAll(registersArray);
        registerTable.setItems(data);
    }

    public void enableButtons() {       //Enables Buttons when textArea is not empty
        if (!codeText.getText().isEmpty()) {
            executeButton.setDisable(false);
            clearButton.setDisable(false);
            startButton.setDisable(false);
        }
    }

    public void execute() {         // Function for executing the Inserted Code
        Instruction instr = new Instruction();
        if (!codeText.getText().isEmpty()) {
            instruc.addAll(Arrays.asList(codeText.getText().split("\\r?\\n")));
            Parser parse1 = new Parser();
            parse1.Validate(instruc);
            if (parse1.err) {
                executionMessage.appendText("\n" + parse1.ErrorMsg);
            } else {
                executionMessage.appendText("\nCompilation done with no errors.\n");
                for (Instruction instruction : Assembler.MachineCode) {
                    executionMessage.appendText("\nInstruction Type: " + instruction.Type);
                    executionMessage.appendText("\nOpcode: " + instruction.MachineCode);
                }
            }
            progCounter.setText("" + Parser.ProgramCounter);
            registerTable.getItems().clear();
            fillTable();
        }
    }

    public void clear() {       //Clears the execution messages window
        if (!executionMessage.getText().isEmpty())
            executionMessage.setText("");
    }

    public void startOver() {           //Clears the window of Code Writer
        if (!codeText.getText().isEmpty()) {
            codeText.setText("");
            for (int i = 0; i < 32; i++) {
                Registers.values.set(i, 0);
            }
            fillTable();
        }
    }

}
