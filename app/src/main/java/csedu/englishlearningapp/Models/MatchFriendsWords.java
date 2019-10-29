package csedu.englishlearningapp.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Windows8 on 11/4/2017.
 */
@Table(name="MatchFriendsWords")
public class MatchFriendsWords extends Model {
    @Column(name="word1")
    String first;
    @Column(name="word2")
    String second;

    public MatchFriendsWords() {
    }

    public MatchFriendsWords(String word1, String word2) {
        first=word1;
        second=word2;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }
}
