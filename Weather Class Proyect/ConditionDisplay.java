
import java.util.*;

//conditional ConditionDisplay
public class ConditionDisplay implements Observer{
    private double current_temp;
    private double current_humidity;
    private double current_wind_speed;
   private WeatherData weather_data;

//Conditional display constructor
    public ConditionDisplay(WeatherData weather){
      SetWeather(weather);
  	Reset_Recordings();

    }

    //SetWeather
    public void SetWeather(WeatherData weather){
      weather_data=weather;
    }

    //GetWeather
    //return the weather_data
    public WeatherData GetWeather(){
      return weather_data;
    }



    // called when we want to discard what recordings we have and start a new
    //reset temp,humidity and wind speed like stats display
    public void Reset_Recordings() {
      current_temp = 0;
      current_humidity = 0;
      current_wind_speed = 0;
  }



    // Updates the vital statistics to new values.  Eventually will be called
    // directly by the WeatherData subject.  Also calls Show() to output the new
    // values.  If that's not what you want, remove the line with the call

    public void Update( ){
	current_temp = weather_data.GetTemperature();
	current_humidity = weather_data.GetHumidity();
	current_wind_speed = weather_data.GetWindSpeed();
	Show();
    }

    // Outputs the current display. To the screen because I'm boring.
    // Currently atuomatically called by Update whenever anything changes.
    // Can also be called standalone
    public void Show(){
	System.out.println("Here are the current conditions!");
	System.out.println("Current temp: " + current_temp + " degrees.");
	System.out.println("Current humidity: " + current_humidity + " percent.");
	System.out.println("Current wind speed: " + current_wind_speed + " mph.");
	System.out.println();
    }
}
