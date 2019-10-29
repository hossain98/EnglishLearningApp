package csedu.englishlearningapp.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Windows8 on 11/4/2017.
 */

@Table(name="OddManWords")
public class OddManWords extends Model {
    @Column(name="word1")
    String word1;
    @Column(name="word2")
    String word2;
    @Column(name="word3")
    String word3;
    @Column(name="oddWord")
    String oddWord;

    public OddManWords() {
    }

    public OddManWords(String word1, String word2, String word3, String oddWord) {
        this.word1 = word1;
        this.word2 = word2;
        this.word3 = word3;
        this.oddWord = oddWord;
    }
    public String[] getWords()
    {
        String res[]=new String[4];
        res[0]=word1;
        res[1]=word2;
        res[2]=word3;
        res[3]=oddWord;

        return  res;
    }
}
