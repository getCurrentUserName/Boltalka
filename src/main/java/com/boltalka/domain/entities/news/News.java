package com.boltalka.domain.entities.news;

import com.boltalka.domain.entities.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by LucidMinds on 09.05.16.
 * package com.boltalka.domain.entities.news;
 */
@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "news_table", indexes = {
        @Index(name = News.DATE + "_news_index",  columnList = News.DATE)
})
@DynamicUpdate
@DynamicInsert
public class News {

    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String TEXT = "text";
    public static final String DATE = "date";
    public static final String USER_ID = "userId";

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = ID)
    @Type(type="pg-uuid")
    private UUID id;

    @Column(name = TITLE)
    private String title;

    @Column(name = TEXT, length = 4000)
    private String text;

    @Column(name = DATE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    /** Пользователь */
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false, name = USER_ID)
    private User userId;

    @JsonBackReference
    @OneToMany(mappedBy = NewsComment.NEWS_ID, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<NewsComment> newsComments = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public List<NewsComment> getNewsComments() {
        return newsComments;
    }

    public void setNewsComments(List<NewsComment> newsComments) {
        this.newsComments = newsComments;
    }
}
