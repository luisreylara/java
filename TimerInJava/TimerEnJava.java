package timerenjava;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

// in this script i made a digital timer
public class TimerEnJava {

    public static void main(String[] args) {
        
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss");

        //System.out.println(hourdateFormat.format(date));
        
        TimerEnJava tut = new TimerEnJava();
        tut.runTimer();
        
    }
    
    Timer timer = new Timer();
    
    int i = 5000;
    int vigilante=10;
    
    TimerTask task = new TimerTask() {
        public void run() {

            Date date = new Date();
            DateFormat hourdateFormat = new SimpleDateFormat("HH");
            int totseg = (Integer.parseInt(hourdateFormat.format(date)) * 3600);

            hourdateFormat = new SimpleDateFormat("mm");
            totseg += (Integer.parseInt(hourdateFormat.format(date)) * 60);

            hourdateFormat = new SimpleDateFormat("ss");
            
            totseg += (Integer.parseInt(hourdateFormat.format(date)));

            //System.err.println(totseg);
            String time = getTime(totseg, vigilante);
            //System.out.print(totseg + "  ");
            System.out.println(time);
            i++;

        }
    };

    public void runTimer() {
        timer.schedule(task, 0, 1000);
    }

    static String getTime(int sec, int vigilante) {
        //if we have hours minutes and seconds
        int hours = 0;
        int remainderOfHours = 0;
        int minutes = 0;
        int seconds = 0;
        
        if (sec % vigilante == 0){
            System.out.println("Hola 9A, este es un mensaje de la variable  VIGILANTE");
         
        }
        if (sec % 15 == 0){
            System.out.println("Este es un mensaje cada 15 segundos");
         
        }
        

        if (sec >= 3600) // if we have an hour or more     
        {
            hours = sec / 3600;
            remainderOfHours = sec % 3600;        // could be more or less than a min

            if (remainderOfHours >= 60) //check if remainder is more or equal to a min
            {
                minutes = remainderOfHours / 60;
                seconds = remainderOfHours % 60;
              //  System.out.println(seconds+ "   hola");

            } else {                       // if it's less than a min
                seconds = remainderOfHours;
            }
        } // if we have a min or more
        else if (sec >= 60) {
            hours = 0;               //62
            
            minutes = sec / 60;
            seconds = sec % 60;
        } //if we have just seconds
        else if (sec < 60) {
            hours = 0;
            minutes = 0;
            seconds = sec;
        }
//i get integer hour minuite second. i want to transform them to strings:

        String strHours;
        String strMins;
        String strSecs;

        if (seconds < 10) {
            strSecs = "0" + Integer.toString(seconds);
        } else {
            strSecs = Integer.toString(seconds);
        }

        if (minutes < 10) {
            strMins = "0" + Integer.toString(minutes);
        } else {
            strMins = Integer.toString(minutes);
        }

        if (hours < 10) {
            strHours = "0" + Integer.toString(hours);
        } else {
            strHours = Integer.toString(hours);
        }

        String time = strHours + ":" + strMins + ":" + strSecs;
        return time;
    }

}
