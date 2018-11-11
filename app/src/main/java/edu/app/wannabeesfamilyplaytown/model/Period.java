
package edu.app.wannabeesfamilyplaytown.model;

import com.google.gson.annotations.Expose;


@SuppressWarnings("unused")
public class Period {

    @Expose
    private Close close;
    @Expose
    private Open open;

    public Close getClose() {
        return close;
    }

    public void setClose(Close close) {
        this.close = close;
    }

    public Open getOpen() {
        return open;
    }

    public void setOpen(Open open) {
        this.open = open;
    }

}
