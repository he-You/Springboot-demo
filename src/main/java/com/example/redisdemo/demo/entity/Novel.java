package com.example.redisdemo.demo.entity;

import java.io.Serializable;

/**
 * Created by heyou on 2019/3/13 0013
 */
public class Novel implements Serializable {


    private static final long serialVersionUID = -7336609549889014555L;
    private Long id;

    private String novelName;

    private String novelCategory;

    private String novelImg;

    private String novelSummary;

    private String novelAuthor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNovelName() {
        return novelName;
    }

    public void setNovelName(String novelName) {
        this.novelName = novelName;
    }

    public String getNovelCategory() {
        return novelCategory;
    }

    public void setNovelCategory(String novelCategory) {
        this.novelCategory = novelCategory;
    }

    public String getNovelImg() {
        return novelImg;
    }

    public void setNovelImg(String novelImg) {
        this.novelImg = novelImg;
    }

    public String getNovelSummary() {
        return novelSummary;
    }

    public void setNovelSummary(String novelSummary) {
        this.novelSummary = novelSummary;
    }

    public String getNovelAuthor() {
        return novelAuthor;
    }

    public void setNovelAuthor(String novelAuthor) {
        this.novelAuthor = novelAuthor;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "id=" + id +
                ", novelName='" + novelName + '\'' +
                ", novelCategory='" + novelCategory + '\'' +
                ", novelImg='" + novelImg + '\'' +
                ", novelSummary='" + novelSummary + '\'' +
                ", novelAuthor='" + novelAuthor + '\'' +
                '}';
    }

}
