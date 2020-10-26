package com.kh.intentvote;

public class PicDto {

    private int drawable;
    private String imagesName;
    private int imagesVote;

    public PicDto(int drawable, String imagesName, int imagesVote) {
        this.drawable = drawable;
        this.imagesName = imagesName;
        this.imagesVote = imagesVote;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getImagesName() {
        return imagesName;
    }

    public void setImagesName(String imagesName) {
        this.imagesName = imagesName;
    }

    public int getImagesVote() {
        return imagesVote;
    }

    public void setImagesVote(int imagesVote) {
        this.imagesVote = imagesVote;
    }

    @Override
    public String toString() {
        return "PicDto{" +
                "drawable=" + drawable +
                ", imagesName='" + imagesName + '\'' +
                ", imagesVote=" + imagesVote +
                '}';
    }

}//PicDto
