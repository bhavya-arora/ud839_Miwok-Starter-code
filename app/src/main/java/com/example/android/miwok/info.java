package com.example.android.miwok;

/**
 * Created by Bhavya Arora on 8/2/2017.
 */

public class info {
    private String Name;
    private String Branch;
    private int imageResourceid = -1;
    private int audioResourceId;

    /////////THis is the constructor for those fragments who Have Booth text and pics/////////////
    public info(String Name, String Branch, int imageResourceid, int audioResourceId) {
        this.Name = Name;
        this.Branch = Branch;
        this.imageResourceid = imageResourceid;
        this.audioResourceId = audioResourceId;

    }
    ////////this is the  constructor for who has not pics(ImageResourceid)///////////

    public info(String Name, String Branch, int audioResourceId) {
        this.Name = Name;
        this.Branch = Branch;
        this.audioResourceId = audioResourceId;
    }

    /////////////////////////They Are the getters////////////////////////
    public String getName() {
        return Name;
    }

    public String getBranch() {
        return Branch;
    }

    public int getImageResourceid() {
        return imageResourceid;
    }

    public boolean hasImage() {
        if (imageResourceid == -1) {
            return false;
        } else {
            return true;
        }
    }

    public int getAudioResourceId() {
        return audioResourceId;
    }

    //////////////////This will return the exact info of this class instance//////////////////
    @Override
    public String toString() {
        return "info{" +
                "Name='" + Name + '\'' +
                ", Branch='" + Branch + '\'' +
                ", imageResourceid=" + imageResourceid +
                ", audioResourceId=" + audioResourceId +
                '}';
    }
}
