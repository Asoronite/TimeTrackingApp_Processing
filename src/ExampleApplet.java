
import processing.core.* ;
import processing.sound.*;


public class ExampleApplet extends PApplet {

    public static void main(String args[]) {
        PApplet.main("ExampleApplet");
    }


    PFont f;
    int FirstbuttonX = 100;
    int FirstbuttonY = 100;

    int SecondbuttonX = 450;
    int SecondbuttonY = 100;
    int buttonWidth = 200;
    int buttonHeight = 75;
    boolean timerStarted = false;
    int startingTime = 0;
    int displayedTime = 0;
    boolean WorkingStart = false;
    boolean SocialStart = false;
    boolean WatchingStart = false;
    boolean PlayingStart = false;
    int WorkingTime;
    int SocialTime;
    int WatchingTime;
    int PlayingTime;
    int counter;
    int WorkingCounter;
    int SocialCounter;
    int WatchingCounter;
    int PlayingCounter;
    float workingAngle, socialAngle, watchingAngle, playingAngle;
    boolean reseted = false;
    int totalHours, totalMinutes, totalSeconds;
    int workingHours, workingMinutes, workingSeconds;
    int socialHours, socialMinutes, socialSeconds;
    int watchingHours, watchingMinutes, watchingSeconds;
    int playingHours, playingMinutes, playingSeconds;

    @Override
    public void settings() {
        size(750, 800);


    }

    @Override
    public void setup() {
        f = createFont("YuGo-Bold",15,true);
        startingTime = millis();
        print(PFont.list());
        textSize(25);
    }

    @Override
    public void draw() {
        background(51, 144, 128);
        textFont(f);
        fill(192,192,192);
        strokeWeight(5);
        textSize(20);





//ONLINE
        if (mouseX >= FirstbuttonX && mouseX <= FirstbuttonX + buttonWidth && mouseY >= FirstbuttonY && mouseY <= FirstbuttonY + buttonHeight) {
            stroke(150);
        } else {
            stroke(200);
        }

        rect(FirstbuttonX, FirstbuttonY, buttonWidth, buttonHeight);

        fill(0);
        textAlign(CENTER, CENTER);
        text("I am online", FirstbuttonX + buttonWidth / 2, FirstbuttonY + buttonHeight / 2);





//AFK
        fill(192,192,192);
        if (mouseX >= SecondbuttonX && mouseX <= SecondbuttonX + buttonWidth && mouseY >= SecondbuttonY && mouseY <= SecondbuttonY + buttonHeight) {
            stroke(150);
        } else {
            stroke(200);
        }
        rect(SecondbuttonX, SecondbuttonY, buttonWidth, buttonHeight);

        fill(0);
        textAlign(CENTER, CENTER);
        text("I am afk", SecondbuttonX + buttonWidth / 2, SecondbuttonY + buttonHeight / 2);





//MAIN TIME DISPLAY
        if (timerStarted) {

            displayedTime = millis() - counter;
        }


        totalSeconds = displayedTime / 1000;
        totalHours = totalSeconds / 3600;
        totalMinutes = (totalSeconds % 3600) / 60;
        totalSeconds = totalSeconds % 60;

        String totalTimeText = String.format("In Total: %02d:%02d:%02d", totalHours, totalMinutes, totalSeconds);
        fill(255);

        textAlign(CENTER);
        text(totalTimeText, width / 2, 60);





//WORKING
        fill(102,255,255);

        if (mouseX >= 50 && mouseX <= 50 + 300 && mouseY >= 250 && mouseY <= 250 + buttonHeight) {
            stroke(150);
        } else {
            stroke(200);
        }
        rect(50, 250, 300, buttonHeight);
        fill(0);
        textAlign(CENTER, CENTER);
        text("Working", 50 + 300 / 2, 250 + buttonHeight / 2);

        if (WorkingStart ) {

            WorkingTime = millis() - WorkingCounter;
        }
        fill(102,255,255);

        workingSeconds = WorkingTime / 1000;
        workingHours = workingSeconds / 3600;
        workingMinutes = (workingSeconds % 3600) / 60;
        workingSeconds = workingSeconds % 60;
        text(String.format("%02d:%02d:%02d", workingHours, workingMinutes, workingSeconds), 50 + 300 / 2, 230);









//SOCIAL MEDIA
        fill(245,165,250);

        if (mouseX >= 400 && mouseX <= 400 + 300 && mouseY >= 250 && mouseY <= 250 + buttonHeight) {
            stroke(150);
        } else {
            stroke(200);
        }
        rect(400, 250, 300, buttonHeight);
        fill(0);
        textAlign(CENTER, CENTER);
        text("Social Media", 400 + 300 / 2, 250 + buttonHeight / 2);

        if (SocialStart ) {

            SocialTime = millis() - SocialCounter;
        }
        fill(245,165,250);

        socialSeconds = SocialTime / 1000;
        socialHours = socialSeconds / 3600;
        socialMinutes = (socialSeconds % 3600) / 60;
        socialSeconds = socialSeconds % 60;
        text(String.format("%02d:%02d:%02d", socialHours, socialMinutes, socialSeconds), 400 + 300 / 2, 230);










//WATCHING
        fill(102,255,102);
        if (mouseX >= 50 && mouseX <= 50 + 300 && mouseY >= 375 && mouseY <= 375 + buttonHeight) {
            stroke(150);
        } else {
            stroke(200);
        }
        rect(50, 375, 300, buttonHeight);
        fill(0);
        textAlign(CENTER, CENTER);
        text("Watching", 50 + 300 / 2, 375 + buttonHeight / 2);
        if (WatchingStart ) {

            WatchingTime = millis() - WatchingCounter;
        }
        fill(102,255,102);

        watchingSeconds = WatchingTime / 1000;
        watchingHours = watchingSeconds / 3600;
        watchingMinutes = (watchingSeconds % 3600) / 60;
        watchingSeconds = watchingSeconds % 60;
        text(String.format("%02d:%02d:%02d", watchingHours, watchingMinutes, watchingSeconds), 50 + 300 / 2, 355);











//PLAYING
        fill(255,153,153);
        if (mouseX >= 400 && mouseX <= 400 + 300 && mouseY >= 375 && mouseY <= 375 + buttonHeight) {
            stroke(150);
        } else {
            stroke(200);
        }
        rect(400, 375, 300, buttonHeight);
        fill(0);
        textAlign(CENTER, CENTER);
        text("Playing", 400 + 300 / 2, 375 + buttonHeight / 2);
        fill(255,153,153);

        if (PlayingStart ) {

            PlayingTime = millis() - PlayingCounter;
        }
        fill(255,153,153);

        playingSeconds = PlayingTime / 1000;
        playingHours = playingSeconds / 3600;
        playingMinutes = (playingSeconds % 3600) / 60;
        playingSeconds = playingSeconds % 60;
        text(String.format("%02d:%02d:%02d", playingHours, playingMinutes, playingSeconds), 400 + 300 / 2, 355);

        stroke(200);





//CIRCLE GRAPH
        float totalMillis = WorkingTime + SocialTime + WatchingTime + PlayingTime;

        float workingPercentage = (float) WorkingTime / totalMillis;
        float socialPercentage = (float) SocialTime / totalMillis;
        float watchingPercentage = (float) WatchingTime / totalMillis;
        float playingPercentage = (float) PlayingTime / totalMillis;

        workingAngle = map(workingPercentage, 0, 1, 0, TWO_PI);
        socialAngle = map(socialPercentage, 0, 1, 0, TWO_PI);
        watchingAngle = map(watchingPercentage, 0, 1, 0, TWO_PI);
        playingAngle = map(playingPercentage, 0, 1, 0, TWO_PI);

        float centerX = width / 2;
        float centerY = 630;
        float radius = 150;

    // Working
        fill(102, 255, 255);
        arc(centerX, centerY, radius * 2, radius * 2, 0, workingAngle, PIE);

    // Social Media
        fill(245, 165, 250);
        arc(centerX, centerY, radius * 2, radius * 2, workingAngle, workingAngle + socialAngle, PIE);

    // Watching
        fill(102, 255, 102);
        arc(centerX, centerY, radius * 2, radius * 2, workingAngle + socialAngle, workingAngle + socialAngle + watchingAngle, PIE);

    // Playing
        fill(255, 153, 153);
        arc(centerX, centerY, radius * 2, radius * 2, workingAngle + socialAngle + watchingAngle, workingAngle + socialAngle + watchingAngle + playingAngle, PIE);



//RESET
        if (mouseX >= 650 && mouseX <= 650 + 80 && mouseY >= 750 && mouseY <= 750 + 40) {
            stroke(150);
        } else {
            stroke(200);
        }
        fill(255,36,58);
        rect(650,750,80,40);
        fill(0);
        text("Reset",690,770);

        if (reseted == true){
            timerStarted=false;
            displayedTime=0;

            WorkingStart=false;
            WorkingTime=0;

            SocialStart=false;
            SocialTime=0;

            WatchingStart=false;
            WatchingTime=0;

            PlayingStart=false;
            PlayingTime=0;
        }
    }




   public void mousePressed() {

        if (mouseX >= FirstbuttonX && mouseX <= FirstbuttonX + buttonWidth && mouseY >= FirstbuttonY && mouseY <= FirstbuttonY + buttonHeight) {
            println("Button 1 clicked!",timerStarted);
            timerStarted = true;
            counter = startingTime;
            counter = millis() - displayedTime;
            reseted=false;

        } else if (mouseX >= SecondbuttonX && mouseX <= SecondbuttonX + buttonWidth && mouseY >= SecondbuttonY && mouseY <= SecondbuttonY + buttonHeight) {
            println("Button 2 clicked!");
            timerStarted = false;
            WorkingStart=false;
            SocialStart=false;
            WatchingStart= false;
            PlayingStart=false;
        }



//WORKING
       if (mouseX >= 50 && mouseX <= 50 + 300 && mouseY >= 250 && mouseY <= 250 + buttonHeight && timerStarted) {
           WorkingStart = true;
           WorkingCounter = startingTime;
           WorkingCounter = millis() - WorkingTime;
           SocialStart = false;
           WatchingStart= false;
           PlayingStart=false;

       } else if (mouseX >= 50 && mouseX <= 50 + 300 && mouseY >= 250 && mouseY <= 250 + buttonHeight) {
           WorkingStart = false;

       }


//SOCIAL MEDIA
       if (mouseX >= 400 && mouseX <= 400 + 300 && mouseY >= 250 && mouseY <= 250 + buttonHeight && timerStarted) {
           SocialStart = true;
           SocialCounter = startingTime;
           SocialCounter = millis() - SocialTime;
           WorkingStart=false;
           WatchingStart= false;
           PlayingStart=false;

       } else if (mouseX >= 400 && mouseX <= 400 + 300 && mouseY >= 250 && mouseY <= 250 + buttonHeight ) {
           SocialStart = false;
       }


//WATCHING
       if (mouseX >= 50 && mouseX <= 50 + 300 && mouseY >= 375 && mouseY <= 375 + buttonHeight && timerStarted) {
           WatchingStart = true;
           WatchingCounter = startingTime;
           WatchingCounter = millis() - WatchingTime;
           WorkingStart=false;
           SocialStart= false;
           PlayingStart=false;

       } else if (mouseX >= 50 && mouseX <= 50 + 300 && mouseY >= 375 && mouseY <= 375 + buttonHeight) {
           WatchingStart = false;
       }





//PLAYING
       if (mouseX >= 400 && mouseX <= 400 + 300 && mouseY >= 375 && mouseY <= 375 + buttonHeight&& timerStarted) {
           PlayingStart = true;
           PlayingCounter = PlayingTime;
           PlayingCounter = millis() - PlayingTime;
           WorkingStart=false;
           SocialStart= false;
           WatchingStart=false;

       } else if (mouseX >= 400 && mouseX <= 400 + 300 && mouseY >= 375 && mouseY <= 375 + buttonHeight) {
           PlayingStart = false;
       }


//Reset
    if (mouseX >= 650 && mouseX <= 650 + 80 && mouseY >= 750 && mouseY <= 750 + 40){
        reseted = true;
    }
    }
    }






