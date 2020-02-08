package maze.utils;

import com.google.gson.*;

import java.lang.reflect.Type;



public class PositionDeserializer<T> implements JsonDeserializer<T>
{

    public T deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        JsonElement content = je.getAsJsonObject().get("Position");
        return new Gson().fromJson(content, type);
    }
}