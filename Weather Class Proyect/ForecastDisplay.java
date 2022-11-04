import java.util.*;

// ForecastDisplay
//The forecast should keep track of the previous set of data,
//and when it gets an update it:

public class ForecastDisplay implements Observer{

  private ArrayList<Double> temp_recordings;
   private ArrayList<Double> humidity_recordings;
   private ArrayList<Double> wind_speed_recordings;
   private WeatherData weather_data;


   public ForecastDisplay(WeatherData weather) {
             SetWeather(weather);
              Reset_Recordings();
       }

       public void SetWeather(WeatherData weather) {
        weather_data = weather;
    }

    public WeatherData GetWeather() {
        return weather_data;
    }

//reset recordings
    public void Reset_Recordings() {
           temp_recordings = new ArrayList<>();
           humidity_recordings = new ArrayList<>();
           wind_speed_recordings = new ArrayList<>();
           weather_data = new WeatherData();
       }

    // Updates recordings based on new readings. Also calls Show(), but you
         // can remove that if you want
        public void Update() {
            temp_recordings.add(weather_data.GetTemperature());
            humidity_recordings.add(weather_data.GetHumidity());
            wind_speed_recordings.add(weather_data.GetWindSpeed());
            Show();
        }


     //show
  //temperature gets better if it’s increasing, but wind speed and
   //humidity get better if they’re decreasing.
//asuming we have 3 entries at least



        public void Show() {
          int first_mark=0;
          int second_mark=0;
          int third_mark=0;


                if (temp_recordings.get(temp_recordings.size() - 2) < temp_recordings.get(temp_recordings.size() - 1)) {
                    first_mark = 1; //weather is improving first mark add one
                }


                if (wind_speed_recordings.get(wind_speed_recordings.size() - 2) > wind_speed_recordings.get(
                        wind_speed_recordings.size() - 1)) {
                    second_mark = 1; //if the wind is decreasing add one to second mark
                }

                //if position 2 is bigger means increasing too
              if (humidity_recordings.get(humidity_recordings.size() - 2) > humidity_recordings.get(
                      humidity_recordings.size() - 1)) {
                  third_mark = 1;//if humidity is decreasing add one to third_mark

              }

                //- If two of the three statistics get better, than the forecast is that the weather will improve.
                if (first_mark + second_mark + third_mark >= 2) {
                    System.out.println("The weather will improve");
                }
              //  if not get worse
                 else {
                    System.out.println("Weather is going to get worse");
                }

        }
    }
