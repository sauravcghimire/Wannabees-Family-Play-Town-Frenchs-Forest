
package edu.app.wannabeesfamilyplaytown.model;

import com.google.gson.annotations.Expose;


@SuppressWarnings("unused")
public class Close {

    @Expose
    private Long day;
    @Expose
    private String time;

    public Long getDay() {
        return day;
    }

    public void setDay(Long day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
