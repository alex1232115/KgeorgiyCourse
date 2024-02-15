package technologies.internet.gson.les1;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(new UserPost(
                "userPost",
                10,
                "Some description",
                5 )
        );
        System.out.println(jsonString);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        Gson gson2 = gsonBuilder.create();

        String text = gson.fromJson("\"abc", String.class);
        System.out.println(text);
    }
}
