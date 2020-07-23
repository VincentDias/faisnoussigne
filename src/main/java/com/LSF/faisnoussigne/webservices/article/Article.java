package com.LSF.faisnoussigne.webservices.article;

import com.LSF.faisnoussigne.uploadFile.model.DBFile;

import javax.persistence.*;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "files_id", referencedColumnName = "id")
    private DBFile file;


    public Article() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DBFile getFile() {
        return file;
    }

    public void setFile(DBFile file) {
        this.file = file;
    }
}
