class ForecastDisplay implements Observer, DisplayElement {
    private float currentPressure;
    private float lastPressure;
    private Subject weatherData;

    public ForecastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
        currentPressure = 29.92f;
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }

    public void display() {
        if (currentPressure > lastPressure) {
            System.out.println("Forecast: Improving weather on the way!");
        }
        else if (currentPressure == lastPressure) {
            System.out.println("Forecast: More of the same");
        }
        else {
            System.out.println("Forecast: Watch out for cooler, rainy weather");
        }
    }
}
