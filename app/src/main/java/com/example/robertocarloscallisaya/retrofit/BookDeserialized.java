package com.example.robertocarloscallisaya.retrofit;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by robertocarloscallisaya on 10/10/17.
 */

public class BookDeserialized implements JsonDeserializer<BookResponse> {
    private String isbn;
    public BookDeserialized(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public BookResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        System.out.println(new Gson().toJson(json.getAsJsonObject()));
        JsonObject jsonObject = json.getAsJsonObject().get("ISBN:"+this.isbn).getAsJsonObject();
        BookResponse resp = new BookResponse("123456",jsonObject.get(ConstantsRestApi.BOOK_TITLE).getAsString() , "Autor" ,"2017", 150);
        return resp;
    }
}
