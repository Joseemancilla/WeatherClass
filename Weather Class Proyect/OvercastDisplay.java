import java.util.*;

//OvercastDisplay

public class OvercastDisplay implements Observer {
    private double cur_cloudiness;
    private WeatherData weather_data;

    // constructor initializes current data to 0
    public OvercastDisplay(WeatherData weather) {
        Reset_Recordings();
        SetWeather(weather);
    }

    public void SetWeather(WeatherData weather) {
        weather_data = weather;
    }

    public WeatherData GetWeather() {
        return weather_data;
    }


    public void Reset_Recordings() {
        cur_cloudiness = 0;
    }

    // Updates the vital statistics to new values. Eventually will be called
    // directly by the WeatherData subject. Also calls Show() to output the new
    // values. If that's not what you want, remove the line with the call

    public void Update() {
        cur_cloudiness = weather_data.GetCloudiness();
        Show();
    }


  //show OvercastDisplay
    public void Show() {
           //cloudy >=88
        if (cur_cloudiness >= 88) {
            System.out.println("Cloudy");
        }
        //mostly clousy 70-87
         else if (cur_cloudiness >= 70 && cur_cloudiness <= 87) {
            System.out.println("Mostly Cloudy");
        }
         //partly sunny 51-69
        else if (cur_cloudiness >= 51 && cur_cloudiness <= 69) {
            System.out.println( "Partly Sunny");
        }
        //mostly sunny 26-50
         else if (cur_cloudiness >= 26 && cur_cloudiness <= 50) {
            System.out.println( "Mostly Sunny");
        }
        //mostly clear 6-25
        else if (cur_cloudiness >= 6 && cur_cloudiness <= 25) {
            System.out.println("Mostly Clear");
        }
        //clear <=5
         else if (cur_cloudiness <= 5) {
            System.out.println("Clear");
        }
    }//closes show




}//closes overcast display
