package spring.gradle.model;

/**
 * Created by arti on 8/26/17.
 */
//@Entity
//@Table(name = "searchString")
public class SearchString {
    public int id;
    public String tagName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public SearchString(int id, String tagName) {
        this.id = id;
        this.tagName = tagName;
    }

}
