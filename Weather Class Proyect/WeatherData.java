
import java.util.*;

public class WeatherData{
    private double my_temp;
    private double my_humidity;
    private double my_wind_speed;
    private double my_cloudiness;

    public WeatherData(){
	my_temp = 0;
	my_humidity = 0;
	my_wind_speed = 0;
    }

    public void SetMeasurements(double new_temp, double new_humidity, double new_wind_speed,double new_cloudiness){
	my_temp = new_temp;
	my_humidity = new_humidity;
	my_wind_speed = new_wind_speed;
  //cloudiness pointer
  my_cloudiness=new_cloudiness;
}




//Make sure you modify the WeatherData class so that notifyObservers gets called from Update-
//that’s how we push the data we generate in SetMeasurements out to the observers.

public double GetTemperature() {
		return my_temp;
	}

	public double GetHumidity() {
		return my_humidity;
	}

	public double GetWindSpeed() {
		return my_wind_speed;
	}

	public double GetCloudiness() {
		return my_cloudiness;
	}




}//close class
