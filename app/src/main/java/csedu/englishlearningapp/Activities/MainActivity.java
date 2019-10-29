package csedu.englishlearningapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.activeandroid.ActiveAndroid;

import csedu.englishlearningapp.Models.MatchFriendsWords;
import csedu.englishlearningapp.Models.OddManWords;
import csedu.englishlearningapp.Models.RightManEnterWords;
import csedu.englishlearningapp.Models.Words;
import csedu.englishlearningapp.R;

public class MainActivity extends AppCompatActivity {

    public static void loadDataBase()
    {
        ActiveAndroid.beginTransaction();
        try {
            OddManWords oddManWords=new OddManWords("Love","Affection","kind","hate");
            oddManWords.save();
            oddManWords=new OddManWords("Fun","Joy","Glad","Pain");
            oddManWords.save();
            oddManWords=new OddManWords("Sky","Zenith","Summit","Ground");
            oddManWords.save();
            oddManWords=new OddManWords("Rich","Happy","Great","Bad");
            oddManWords.save();
            oddManWords=new OddManWords("Awesome","Interesting","Formidable","Glaring");
            oddManWords.save();

            MatchFriendsWords matchFriendsWords=new MatchFriendsWords("Good","Better");
            matchFriendsWords.save();
            matchFriendsWords=new MatchFriendsWords("Life","Live");
            matchFriendsWords.save();
            matchFriendsWords=new MatchFriendsWords("Friend","Supporter");
            matchFriendsWords.save();
            matchFriendsWords=new MatchFriendsWords("Sorrow","Grievance");
            matchFriendsWords.save();
            matchFriendsWords=new MatchFriendsWords("Love","Affection");
            matchFriendsWords.save();


            matchFriendsWords=new MatchFriendsWords("Man","Person");
            matchFriendsWords.save();
            matchFriendsWords=new MatchFriendsWords("City","Town");
            matchFriendsWords.save();
            matchFriendsWords=new MatchFriendsWords("Joy","Glad");
            matchFriendsWords.save();
            matchFriendsWords=new MatchFriendsWords("pain","agony");
            matchFriendsWords.save();
            matchFriendsWords=new MatchFriendsWords("enemy","fore");
            matchFriendsWords.save();




            matchFriendsWords=new MatchFriendsWords("Silence","Calm");
            matchFriendsWords.save();
            matchFriendsWords=new MatchFriendsWords("Clean","Neat");
            matchFriendsWords.save();
            matchFriendsWords=new MatchFriendsWords("Summit","Peak");
            matchFriendsWords.save();
            matchFriendsWords=new MatchFriendsWords("Love","Passion");
            matchFriendsWords.save();
            matchFriendsWords=new MatchFriendsWords("Gentle","Smart");
            matchFriendsWords.save();




            matchFriendsWords=new MatchFriendsWords("Attack","Invade");
            matchFriendsWords.save();
            matchFriendsWords=new MatchFriendsWords("Heart","Mind");
            matchFriendsWords.save();
            matchFriendsWords=new MatchFriendsWords("Hit","Beat");
            matchFriendsWords.save();
            matchFriendsWords=new MatchFriendsWords("King","Emperor");
            matchFriendsWords.save();
            matchFriendsWords=new MatchFriendsWords("World","Universe");
            matchFriendsWords.save();




            matchFriendsWords=new MatchFriendsWords("Mercy","Kindness");
            matchFriendsWords.save();
            matchFriendsWords=new MatchFriendsWords("Fundamental","Basic");
            matchFriendsWords.save();
            matchFriendsWords=new MatchFriendsWords("Enjoy","Cheer");
            matchFriendsWords.save();
            matchFriendsWords=new MatchFriendsWords("Read","Study");
            matchFriendsWords.save();
            matchFriendsWords=new MatchFriendsWords("Emergencey","Urgency");
            matchFriendsWords.save();

            RightManEnterWords rightManEnterWords=new RightManEnterWords("The birds________in the sky","sleep","go","eat","fly");
            rightManEnterWords.save();
            rightManEnterWords=new RightManEnterWords("The sun rises in the _______","moon","west","south","east");
            rightManEnterWords.save();
            rightManEnterWords=new RightManEnterWords("______ reads a book","You","I","They","He");
            rightManEnterWords.save();
            rightManEnterWords=new RightManEnterWords("The sun gives us ______","Darkness","Rain","Food","Light");
            rightManEnterWords.save();
            rightManEnterWords=new RightManEnterWords("Banana is a good ______","Place","Room","Man","Fruit");
            rightManEnterWords.save();
            rightManEnterWords=new RightManEnterWords("Bangladesh is a _______","City","Town","Village","Country");
            rightManEnterWords.save();


            Words word= new Words("sky","আকাশ","n");
            word.save();
            word= new Words("Sun","সূর্য" ,"n");
            word.save();
            word= new Words("Moon","চাঁদ" +
                    "","n");
            word.save();
            word= new Words("Good","ভাল" +
                    "","n");
            word.save();
            word= new Words("Bad","খারাপ" +
                    "","n");
            word.save();
            word= new Words("Small", "ছোট" ,"n");
            word.save();
            word= new Words("Big","বড়","n");
            word.save();
            word= new Words("Man","মানুষ" +
                    "","n");
            word.save();
            word= new Words("mercy", "দয়া","n");
            word.save();
            word= new Words("cat","বিড়াল" +
                    "","n");
            word.save();
            word= new Words("fish","মাছ" +
                    "","n");
            word.save();
            word= new Words("tree","গাছ" +
                    "","n");
            word.save();
            word= new Words("cow","গরু" +
                    "","n");
            word.save();
            word= new Words("goat","ছাগল" +
                    "","n");
            word.save();
            word= new Words("banana","কলা" +
                    "","n");
            word.save();
            word= new Words("mango","আম" +
                    "","n");
            word.save();
            word= new Words("river","নদী" +
                    "","n");
            word.save();
            word= new Words("Lord","মালিক" +
                    "","n");
            word.save();
            word= new Words("Servant","চাকর" +
                    "","n");
            word.save();




            word= new Words("Information","সংবাদ","m");
            word.save();
            word= new Words("Law","আইন","m");
            word.save();

            word= new Words("Communication","যোগাযোগ","m");
            word.save();
            word= new Words("Emperor","রাজা","m");
            word.save();
            word= new Words("Queen","রানী" +
                    "","m");
            word.save();
            word= new Words("Great","মহান" +
                    "","m");
            word.save();
            word= new Words("Element","উপাদান" +
                    "","m");
            word.save();
            word= new Words("Silly","বকাটে" +
                    "","m");
            word.save();

            word= new Words("Job","চাকুরী" +
                    "","m");
            word.save();
            word= new Words("Line","রেখা","m");
            word.save();
            word= new Words("Love","ভালবাসা","m");
            word.save();

            word= new Words("Affection","আদর","m");
            word.save();
            word= new Words("Abate","কমান","m");
            word.save();
            word= new Words("Zenith","চুড়া","m");
            word.save();
            word= new Words("Flight","উড়া","m");
            word.save();
            word= new Words("World","বিশ্ব","m");
            word.save();
            word= new Words("Universe","মহা বিশ্ব","m");
            word.save();
            word= new Words("Academy","শিখার জায়গা","m");
            word.save();
            word= new Words("Best","সেরা","m");
            word.save();
            word= new Words("Human","মানব জাতি","m");
            word.save();
            word= new Words("Contemporary","সমসাময়িক","m");
            word.save();

            word= new Words("abase","humiliate","a");
            word.save();
            word= new Words("abash","embarrass","a");
            word.save();
            word= new Words("abstract","theoretical","a");
            word.save();
            word= new Words("abysmal","bottomless","a");
            word.save();
            word= new Words("adept","expert at","a");
            word.save();
            word= new Words("adorn","decorate","a");
            word.save();
            word= new Words("aesthetic","artistic","a");
            word.save();
            word= new Words("affable","warmly frendly","a");
            word.save();
            word= new Words("agitate","stir up","a");
            word.save();
            word= new Words("allay","calm","a");
            word.save();
            word= new Words("alloy","mixture of metals","a");
            word.save();
            word= new Words("aloof","apart","a");
            word.save();
            word= new Words("consort","associated with","a");
            word.save();
            word= new Words("consummate","supremely skilled","a");
            word.save();
            word= new Words("contingent","conditional","a");
            word.save();
            word= new Words("contortions","twistings","a");
            word.save();
            word= new Words("founder","v.fail completely","a");
            word.save();
            word= new Words("founder","n.person who establishes","a");
            word.save();
            word= new Words("frall","weak","a");
            word.save();
            word= new Words("fret","annoyed or vexed","a");
            word.save();
            word= new Words("gruesome","grisly,horrible","a");
            word.save();
            word= new Words("Incorrigible","uncorrectable","a");
            word.save();
            word= new Words("incursion","temporary invasion","a");
            word.save();
            word= new Words("indelible","not able to be erased","a");
            word.save();
            word= new Words("mayhem","injury to body","a");
            word.save();
            word= new Words("meager","scanty,inadequate","a");
            word.save();
            word= new Words("meek","sumissive, patient and long suffering","a");
            word.save();
            word= new Words("medley","mixture","a");
            word.save();
            word= new Words("projectile","missile","a");
            word.save();
            word= new Words("prologue","introduction","a");
            word.save();
            word= new Words("sap","diminish","a");
            word.save();
            word= new Words("satiate","satisfy fully","a");
            word.save();





            ActiveAndroid.setTransactionSuccessful();
        }
        finally {
            ActiveAndroid.endTransaction();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadDataBase();
        setContentView(R.layout.activity_main);
        ImageButton start= (ImageButton) findViewById(R.id.GoButton);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });


    }
}
