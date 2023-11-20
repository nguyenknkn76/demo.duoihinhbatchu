package com.example.duoihinhbatchu.object;

public class Quest {
    public int qId;
    public String qName, qResult, qImg;
    public Quest(){

    }
    public Quest(int qId, String qName, String qResult, String qImg) {
        this.qId = qId;
        this.qName = qName;
        this.qResult = qResult;
        this.qImg = qImg;
    }

    public int getqId() {
        return qId;
    }

    public void setqId(int qId) {
        this.qId = qId;
    }

    public String getqName() {
        return qName;
    }

    public String getqResult() {
        return qResult;
    }

    public void setqResult(String qResult) {
        this.qResult = qResult;
    }

    public String getqImg() {
        return qImg;
    }

    public void setqImg(String qImg) {
        this.qImg = qImg;
    }

    public void setqName(String qName) {
        this.qName = qName;
    }
}
