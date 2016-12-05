package ru.rus.showsace;

/**
 * Created by Ruslan on 04.12.16.
 */

public class ItemsSoda {
    public String name;
    public int image;
    public int article;

    public ItemsSoda(String name, int image, int article) {
        this.name = name;
        this.image = image;
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {
        this.article = article;
    }
}
