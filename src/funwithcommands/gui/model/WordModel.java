/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithcommands.gui.model;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Stegger
 */
public class WordModel {

    private final ObservableList<String> words;
    private final ArrayList<String> deletedList = new ArrayList();

    public WordModel() {
        words = FXCollections.observableArrayList();
    }

    /**
     * Gets all words in the model.
     *
     * @return
     */
    public ObservableList<String> getWordList() {
        return words;
    }

    /**
     * Adds a new word to the model.
     *
     * @param word
     */
    public void addWord(String word) {
        words.add(word);
    }

    /**
     * Removes the given word from the model.
     *
     * @param word
     */
    public void removeWord(String word) {
        words.remove(word);
    }

    public void clearWords() {
        deletedList.clear();
        deletedList.addAll(words);
        words.clear();
    }

    public void undoClear() {
        words.addAll(deletedList);

    }

}
