import java.util.ArrayList;
import java.util.List;

class StatisticsDisplay implements Observer, DisplayElement {
    private List<Float> temperatures;
    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
        temperatures = new ArrayList<>();
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        temperatures.add(temperature);
        display();
    }

    public void display() {
        float sum = 0;
        float max = Float.MIN_VALUE;
        float min = Float.MAX_VALUE;

        for (float temperature : temperatures) {
            sum += temperature;
            max = Math.max(max, temperature);
            min = Math.min(min, temperature);
        }

        float avg = sum / temperatures.size();
        System.out.println("Avg/Max/Min temperature = " + avg + "/" + max + "/" + min);
    }
}