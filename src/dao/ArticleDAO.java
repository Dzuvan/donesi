package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import beans.Article;
import beans.Drink;
import beans.Meal;
import util.RuntimeTypeAdapterFactory;

public class ArticleDAO {

	private Map<Long, Article> articles = new HashMap<>();
	private static ArticleDAO instance;

	private ArticleDAO() {
	}

	public static ArticleDAO getInstance() {
		if (instance == null) {
			instance = new ArticleDAO();
			instance.createArticles();
		}
		return instance;
	}

	public void createArticles() {
		load();
		if(articles.isEmpty()) {
			Drink drink = new Drink("Tea", 55.2f, "Warm herbal drink", 100.0f);
			Drink drink2 = new Drink("Coffee", 95.2f, "Coffee", 100.0f);
			Meal meal = new Meal("Hamburger", 150.0f, "Juicy beef burgrer", 250.0f);
			Meal meal2 = new Meal("French Fries", 150.0f, "Best potato dish", 150.0f);
			articles.put(drink.getId(), drink);
			articles.put(drink2.getId(), drink2);
			articles.put(meal.getId(), meal);
			articles.put(meal2.getId(), meal2);
		}
	}
	
	private void save() {
		RuntimeTypeAdapterFactory<Article> runtimeAdapterFactory = RuntimeTypeAdapterFactory.of(Article.class, "isA")
				.registerSubtype(Meal.class, "meal")
				.registerSubtype(Drink.class, "drink");
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.registerTypeAdapterFactory(runtimeAdapterFactory).create();
		try (FileWriter file = new FileWriter(new File("articles.json"))) {
			file.write(gson.toJson(articles));
		} catch (IOException e) {
		}
	}
	
	private void load() {
		RuntimeTypeAdapterFactory<Article> runtimeAdapterFactory = RuntimeTypeAdapterFactory.of(Article.class, "isA")
				.registerSubtype(Meal.class, "meal")
				.registerSubtype(Drink.class, "drink");
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.registerTypeAdapterFactory(runtimeAdapterFactory).create();
		try {
			JsonReader reader = new JsonReader(new FileReader("articles.json"));
			articles = gson.fromJson(reader, new TypeToken<Map<Long, Article>>() {}.getType());
		} catch (FileNotFoundException | JsonSyntaxException jpe) {
		}
	}

	public ArrayList<Article> getArticles() {
		return new ArrayList<Article>(articles.values());
	}
	
	public Article create(Article article) {
		articles.put(article.getId(), article);
		save();
		return article;
	}
	
	public Article getArticleById(long id) {
		return articles.get(id);
	}
	
	public boolean deleteArticle(long id) {
		if (getArticleById(id) != null) {
			articles.get(id).setActive(false);
			save();
			return true;
		}
		return false;
	}
	
	public Article updateArticle(Article article) {
		articles.replace(article.getId(), article);
		save();
		return article;
	}
}
