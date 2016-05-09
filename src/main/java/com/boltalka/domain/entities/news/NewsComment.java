package com.boltalka.domain.entities.news;

import com.boltalka.domain.entities.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

/**
 * Created by LucidMinds on 09.05.16.
 * package com.boltalka.domain.entities.newsId;
 */
@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "news_comment_table", indexes = {
        @Index(name = NewsComment.DATE + "_news_comment_index",  columnList = NewsComment.DATE),
        @Index(name = NewsComment.NEWS_ID + "_news_comment_index",  columnList = NewsComment.NEWS_ID)
})
@DynamicUpdate
@DynamicInsert
public class NewsComment {

    public static final String ID = "id";
    public static final String TEXT = "text";
    public static final String DATE = "date";
    public static final String USER_ID = "userId";
    public static final String NEWS_ID = "newsId";

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = ID)
    @Type(type="pg-uuid")
    private UUID id;

    @Column(name = TEXT, length = 1024)
    private String text;

    @Column(name = DATE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    /** Пользователь */
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false, name = USER_ID)
    private User userId;

    /** Пользователь */
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false, name = NEWS_ID)
    private News newsId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public News getNewsId() {
        return newsId;
    }

    public void setNewsId(News newsId) {
        this.newsId = newsId;
    }
}
