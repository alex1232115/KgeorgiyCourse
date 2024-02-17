package technologies.internet.gson.les2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import technologies.internet.gson.les1.UserPost;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class GsonBuilderClass {
    public static void main(String[] args) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        //gsonBuilder.setPrettyPrinting();
        //Класс-строитель для построения объектов других классов с кастомными настройками
        Gson defaultGson = gsonBuilder.create();

        Gson customGson = gsonBuilder.setPrettyPrinting().serializeNulls().create();

        UserPost post = new UserPost();
        post.setPhotoUrl("https://new-socail-network.site/images/3213412.jpg");
//        post.setDescription("Cool photo!");
        post.setLikesQuantity(753);
        String customPostSerialized = customGson.toJson(post);
        String defaultPostSerialized = defaultGson.toJson(post);
        System.out.println("default: " + defaultPostSerialized);
        System.out.println("custom: " + customPostSerialized);

        Function<Integer, String> converter = String::valueOf;
        List<Number> collection = new ArrayList<>();
        collection.add(5);
        collection.add(3);
        collection.add(1);
        List<? super Integer> list = collection;
        list.add(Integer.valueOf(5));
        list.get(0);
        System.out.println(collection);
    }
}
