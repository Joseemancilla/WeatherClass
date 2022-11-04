import java.util.*;

class StatsDisplay implements Observer{

    // capital D for double, since we want the Double class that inherits
    // from Object, not the primitave double type.  Java.

    private ArrayList<Double> temp_recordings;
    private ArrayList<Double> humidity_recordings;
    private ArrayList<Double> wind_speed_recordings;
    private WeatherData weather_data;

    public StatsDisplay(WeatherData weather){
      SetWeather(weather);
	Reset_Recordings();
    }


    public void SetWeather(WeatherData weather){
      weather_data=weather;
    }


   public WeatherData GetWeather(){
     return weather_data;
   }

    // called when we want to discard what recordings we have and start a new list
    //ya esta escrita desde antes
    public void Reset_Recordings(){
	temp_recordings = new ArrayList<Double>();
	humidity_recordings = new ArrayList<Double>();
	wind_speed_recordings = new ArrayList<Double>();
  weather_data=new WeatherData();
    }

    // Updates recordings based on new readings.  Also calls Show(), but you
    // can remove that if you want.
    //cambiar parametros a weather_data
    public void Update(){
	temp_recordings.add(weather_data.GetTemperature());
	humidity_recordings.add(weather_data.GetHumidity());
	wind_speed_recordings.add(weather_data.GetWindSpeed());
	Show();
    }


//Show

    public void Show(){
	System.out.println("Here are some overall statistics: ");
	System.out.print("Temperatures Seen: ");
	System.out.println(temp_recordings.toString());
	// only find max and min if we have at least 1 entry
	if(temp_recordings.size() > 0){
	    System.out.println("Max: " + Collections.max(temp_recordings));
	    System.out.println("Min: " + Collections.min(temp_recordings));
	}

	System.out.println();

	System.out.println("Humidity measurements seen: ");
	System.out.println(humidity_recordings.toString());
	// only find max and min if we have at least 1 entry
	if(humidity_recordings.size() > 0){
	    System.out.println("Max: " + Collections.max(humidity_recordings));
	    System.out.println("Min: " + Collections.min(humidity_recordings));
	}
	System.out.println();

	System.out.println("Wind speeds seen: ");
	System.out.println(wind_speed_recordings.toString());
	// only find max and min if we have at least 1 entry
	if(wind_speed_recordings.size() > 0){
	    System.out.println("Max: " + Collections.max(wind_speed_recordings));
	    System.out.println("Min: " + Collections.min(wind_speed_recordings));
	}

	System.out.println();
    }

}
