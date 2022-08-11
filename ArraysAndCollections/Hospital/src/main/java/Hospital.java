import java.util.Locale;
import java.util.Random;

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов
        Random random = new Random();
        float[] result = new float[patientsCount];
        for (int i = 0; i < patientsCount; i++){
            result[i] = 32 + (float) random.nextInt(80)/10;
        }
        return result;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */
        int count = temperatureData.length;
        int healthWell = 0;
        float avgTemperature = 0.0F;
        StringBuilder listTemperatures = new StringBuilder();

        for (float temperatureDatum : temperatureData) {
            listTemperatures.append(" ").append(temperatureDatum);
            avgTemperature += temperatureDatum;
            if (temperatureDatum <= 36.9F && temperatureDatum >= 36.2F) {
                healthWell++;
            }
        }

        return "Температуры пациентов:" + listTemperatures +
                "\nСредняя температура: " + String.format(Locale.ENGLISH, "%.2f", avgTemperature/count) +
                "\nКоличество здоровых: " + healthWell;
    }
}
