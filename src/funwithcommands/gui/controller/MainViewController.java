/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithcommands.gui.controller;

import funwithcommands.gui.command.ICommand;
import funwithcommands.gui.model.WordModel;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Stegger
 */
public class MainViewController implements Initializable
{

    @FXML
    private ListView<String> listWords;

    @FXML
    private TextField txtInput;

    @FXML
    private MenuItem menuUndo;

    @FXML
    private MenuItem menuRedo;

    private WordModel model;

    private LinkedList<ICommand> executedCommands;
    private LinkedList<ICommand> undoneCommands;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        model = new WordModel();
        executedCommands = new LinkedList<>();
        undoneCommands = new LinkedList<>();
        listWords.setItems(model.getWordList());
        txtInput.requestFocus();
        updateCommandMenuItemsState();
    }

    @FXML
    private void onButtonClearAll(ActionEvent event)
    {
        //TODO implement Clear all command here!!!
    }

    /**
     * When prompted will add the currently entered text of the textfield to the
     * list.
     *
     * @param actionEvent
     */
    @FXML
    private void onTxtInputAxtion(ActionEvent actionEvent)
    {
        String word = txtInput.getText().trim();
        if (!word.isEmpty())
        {
            ICommand command = new ICommand() //We create a new ICommand object:
            {

                @Override
                public void execute() //When executed will add word to model:
                {
                    model.addWord(word);
                }

                @Override
                public void undo() //When undone will remove same word:
                {
                    model.removeWord(word);
                }
            };
            
            
            
            command.execute(); //We have to execute the ICommand for stuff to happen!
            executedCommands.add(command); //Also we must add it to the list of executed commands if it should be undoable.
            undoneCommands.clear(); //We changed the current "thread of commands" an therefore we should not be able to redo something that we no longer did wan't to do, or didn't wan't to do... Arrgh, you get it, right?
            updateCommandMenuItemsState(); //Som UX stuff, yeah sweet..
        }
        txtInput.clear();           //Quality of life right here
        txtInput.requestFocus();    //Mmmh hm!
    }

    /**
     * Undoes the last executed command (If any).
     *
     * @param event
     */
    @FXML
    private void handleUndo(ActionEvent event)
    {
        if (!executedCommands.isEmpty()) //If nothing to undo, the don't undo anything. Or well, don't DO any UNDOING then...
        {
            ICommand lastCommand = executedCommands.pollLast(); //Get the latest executed command, pull it out of the list..
            lastCommand.undo(); //Undo it...
            undoneCommands.add(lastCommand); //And put it un the undone list...
            updateCommandMenuItemsState(); //Please the user with some updates to the UI
        }
    }

    /**
     * Redoes the last undone command (If any).
     *
     * @param event
     */
    @FXML
    private void handleRedo(ActionEvent event)
    {
        if (!undoneCommands.isEmpty()) //The same thing happen here as above, just a different list...
        {
            ICommand lastCommand = undoneCommands.pollLast(); //So I'm not going to type the same thing twice.
            lastCommand.execute(); //You could consider how, or if, you could merge them in to one method???
            executedCommands.add(lastCommand); //You could pass the list as a parameter, but how would you handle wether or not it should redo or undo?
            updateCommandMenuItemsState(); //Maybe we should just accept two almost identical methods...
        }
    }

    /**
     * Correctly disables the command menu items if there is nothing to
     * redo/undo.
     */
    private void updateCommandMenuItemsState()
    {
        if (executedCommands.isEmpty())
        {
            menuUndo.setDisable(true);
        }
        else
        {
            menuUndo.setDisable(false);
        }

        if (undoneCommands.isEmpty())
        {
            menuRedo.setDisable(true);
        }
        else
        {
            menuRedo.setDisable(false);
        }
    }

}
