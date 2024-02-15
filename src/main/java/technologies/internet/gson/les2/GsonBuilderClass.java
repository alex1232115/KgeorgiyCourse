package technologies.internet.gson.les2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonBuilderClass {
    public static void main(String[] args) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        //Класс-строитель для построения объектов других классов с кастомными настройками
        Gson gson = gsonBuilder.create();
    }
}
