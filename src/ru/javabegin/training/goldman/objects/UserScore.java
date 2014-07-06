package ru.javabegin.training.goldman.objects;

public class UserScore {
    
    private int id;
    private User userName;

    private int score;
    private long playDate;
    private int playCount;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getPlayDate() {
        return playDate;
    }

    public void setPlayDate(long playDate) {
        this.playDate = playDate;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public User getUser() {
        return userName;
    }

    public void setUser(User user) {
        this.userName = user;
    }

    

    

    
}
