package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import beans.Restaurant;

public class Serializator {

	public static <T> void saveHierarchy(RuntimeTypeAdapterFactory<T> factory, String fileName,
			Map<Long, T> items) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.registerTypeAdapterFactory(factory).create();
		try (FileWriter file = new FileWriter(new File(fileName))) {
			file.write(gson.toJson(items));
		} catch (IOException e) {
		}
	}

	public static <T> void loadHierarchy(RuntimeTypeAdapterFactory<T> factory, String fileName, Map<Long, T> items) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.registerTypeAdapterFactory(factory).create();
		try {
			JsonReader reader = new JsonReader(new FileReader(fileName));
			items = gson.fromJson(reader, new TypeToken<Map<Long, T>>() {
			}.getType());
		} catch (FileNotFoundException | JsonSyntaxException jpe) {
		}
	}

	public static <T> void save(String fileName, Map<Long, T> items) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		try (FileWriter file = new FileWriter(new File(fileName))) {
			file.write(gson.toJson(items));
		} catch (IOException e) {
		}
	}

	public static <T> void load(String fileName, Map<Long, T> items) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		try {
			JsonReader reader = new JsonReader(new FileReader(fileName));
			items = gson.fromJson(reader, new TypeToken<Map<Long, Restaurant>>() {
			}.getType());
		} catch (FileNotFoundException | JsonSyntaxException jpe) {
		}
	}
}
