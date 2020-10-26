package com.kh.gridviewex;

public class MovieDto {

    private int drawable;
    private String title;

    public MovieDto(int drawable, String title) {
        this.drawable = drawable;
        this.title = title;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "drawable=" + drawable +
                ", title='" + title + '\'' +
                '}';
    }

}//MovieDto
