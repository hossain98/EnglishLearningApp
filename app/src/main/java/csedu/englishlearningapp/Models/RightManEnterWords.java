package csedu.englishlearningapp.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by Windows8 on 11/5/2017.
 */
@Table(name="RightManEnterWords")
public class RightManEnterWords extends Model {
    @Column(name="question")
    String question ;
    @Column(name="option1")
    String option1;
    @Column(name="option2")
    String option2;
    @Column(name="option3")
    String option3;
    @Column(name="option4")
    String option4;

    public RightManEnterWords() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public List<RightManEnterWords> getAll()
    {
        return  new Select().from(RightManEnterWords.class).execute();
    }

    public RightManEnterWords(String question, String option1, String option2, String option3, String option4) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
    public String[] getAllOptions()
    {
        String options[]=new String[4];
        options[0]=option1;
        options[1]=option2;
        options[2]=option3;
        options[3]=option4;

        return  options;



    }
}
