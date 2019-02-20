package entity;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import com.sun.prism.shader.Solid_RadialGradient_REFLECT_AlphaTest_Loader;

import java.sql.Date;

/**
 * Created by LENOVO on 2019-01-15.
 */
public class Book {
    private Integer id;
    private String name;
    private String author;
    private Date time;
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
