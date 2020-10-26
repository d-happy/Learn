package com.kh.listviewcustomex;

public class MovieDto {
    private int image; //R.drawable.mov01
    private  String title; //제목
    private  String subTitle; //부제목

    //ALT + Insert

    public MovieDto(int image, String title, String subTitle) {
        this.image = image;
        this.title = title;
        this.subTitle = subTitle;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "image=" + image +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                '}';
    }

}
