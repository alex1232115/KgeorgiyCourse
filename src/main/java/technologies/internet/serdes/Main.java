package technologies.internet.serdes;


import com.google.gson.Gson;

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
    }
}
