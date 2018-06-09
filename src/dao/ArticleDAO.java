package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import beans.Article;
import beans.Drink;
import beans.Meal;
import util.RuntimeTypeAdapterFactory;
import util.Serializator;

public class ArticleDAO {

	private static final String fileName = "articles.json";
	private Map<Long, Article> articles = new HashMap<>();
	private static ArticleDAO instance;
	private RuntimeTypeAdapterFactory<Article> factory;

	private ArticleDAO() {
		factory = RuntimeTypeAdapterFactory.of(Article.class, "isA")
				.registerSubtype(Meal.class, "meal")
				.registerSubtype(Drink.class, "drink");
	}

	public static ArticleDAO getInstance() {
		if (instance == null) {
			instance = new ArticleDAO();
			instance.createArticles();
		}
		return instance;
	}

	public void createArticles() {
		Serializator.loadHierarchy(factory, fileName, articles);
		if (articles.isEmpty()) {
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

	public ArrayList<Article> getArticles() {
		return new ArrayList<Article>(articles.values());
	}

	public Article create(Article article) {
		articles.put(article.getId(), article);
		Serializator.saveHierarchy(factory, fileName, articles);
		return article;
	}

	public Article getArticleById(long id) {
		return articles.get(id);
	}

	public boolean deleteArticle(long id) {
		if (getArticleById(id) != null) {
			articles.get(id).setActive(false);
			Serializator.saveHierarchy(factory, fileName, articles);
			return true;
		}
		return false;
	}

	public Article updateArticle(Article article) {
		articles.replace(article.getId(), article);
		Serializator.saveHierarchy(factory, fileName, articles);
		return article;
	}
}
