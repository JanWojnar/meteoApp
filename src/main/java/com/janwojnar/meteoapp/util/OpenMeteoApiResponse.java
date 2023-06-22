package com.janwojnar.meteoapp.util;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenMeteoApiResponse {
    private DailyData daily;

    public DailyData getDaily() {
        return daily;
    }

    public void setDaily(DailyData daily) {
        this.daily = daily;
    }

    public static class DailyData {
        private List<String> time;
        private List<String> sunrise;
        private List<String> sunset;
        private List<String> rain_sum;

        public List<String> getTime() {
            return time;
        }

        public void setTime(List<String> time) {
            this.time = time;
        }

        public List<String> getSunrise() {
            return sunrise;
        }

        public void setSunrise(List<String> sunrise) {
            this.sunrise = sunrise;
        }

        public List<String> getSunset() {
            return sunset;
        }

        public void setSunset(List<String> sunset) {
            this.sunset = sunset;
        }

        public List<String> getRain_sum() {
            return rain_sum;
        }

        public void setRain_sum(List<String> rain_sum) {
            this.rain_sum = rain_sum;
        }
    }
}
