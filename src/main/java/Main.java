import com.dumptruckman.bukkit.configuration.json.JsonConfiguration;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class Main {
    private static Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
    public static void main(String[] args) {
        List<File> files = new ArrayList<>();
        files.add(new File("./quickshop-bukkit/src/main/resources/lang/messages.json"));
        for (File file : Objects.requireNonNull(new File("./crowdin").listFiles(File::isDirectory))) {
            files.addAll(Arrays.asList(Objects.requireNonNull(file.listFiles(f2 -> f2.getName().endsWith(".json")))));
        }
        for (File file : files) {
            convert(file);
        }
    }



    private static void convert(File file) {

    }

    public static void jsonTree(JsonElement e)
    {
        if (e.isJsonNull())
        {
            return;
        }

        if (e.isJsonPrimitive())
        {
            e.getAsJsonPrimiti
            return;
        }

        if (e.isJsonArray())
        {
            JsonArray ja = e.getAsJsonArray();
            if (null != ja)
            {
                for (JsonElement ae : ja)
                {
                    jsonTree(ae);
                }
            }
            return;
        }

        if (e.isJsonObject())
        {
            Set<Entry<String, JsonElement>> es = e.getAsJsonObject().entrySet();
            for (Entry<String, JsonElement> en : es)
            {
                jsonTree(en.getValue());
            }
        }
    }
}
