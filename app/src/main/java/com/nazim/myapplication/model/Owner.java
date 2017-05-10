package com.nazim.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Owner implements Parcelable{

    private final String login;
    private final String avatarUrl;
    private final String url;

    public Owner(String login, String avatarUrl, String url) {
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.url = url;
    }

    protected Owner(Parcel in) {
        login = in.readString();
        avatarUrl = in.readString();
        url = in.readString();
    }

    public static final Creator<Owner> CREATOR = new Creator<Owner>() {
        @Override
        public Owner createFromParcel(Parcel in) {
            return new Owner(in);
        }

        @Override
        public Owner[] newArray(int size) {
            return new Owner[size];
        }
    };

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(login);
        dest.writeString(avatarUrl);
        dest.writeString(url);
    }
}
