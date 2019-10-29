package csedu.englishlearningapp.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Windows8 on 11/5/2017.
 */
@Table(name="words")
public class Words extends Model {
    @Column(name="word")
    String word;
    @Column(name="meaning")
    String meaning;
    @Column(name="type")
    String type; /// type='n' novice ,'m' medium , 'a' advanced

    public Words() {
    }

    public Words(String word, String meaning, String type) {
        this.word = word;
        this.meaning = meaning;
        this.type = type;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
