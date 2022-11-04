//weather data test
import java.util.*;

class WeatherDataTest {
	public static void main(String[] args) {
		WeatherData Data_Generator = new WeatherData();
		ConditionDisplay Cur_Weather = new ConditionDisplay(Data_Generator);
		StatsDisplay All_Weather = new StatsDisplay(Data_Generator);
		ForecastDisplay F = new ForecastDisplay(Data_Generator);
		OvercastDisplay O = new OvercastDisplay(Data_Generator);
		Random sensor = new Random();



		// randomly get some data
		for (int i = 0; i < 10; i++) {
      //
			Data_Generator.SetMeasurements(sensor.nextInt(100), sensor.nextInt(100),
					sensor.nextInt(100), sensor.nextInt(100));
			Cur_Weather.Update();
			All_Weather.Update();
      //forecast
			F.Update();
      //overcast
			O.Update();
		}

		// The displays should call their Show function when they get updates
		// but let's do it again one last time
		Cur_Weather.Show();
		All_Weather.Show();

		F.Show();
		O.Show();

	}
}
