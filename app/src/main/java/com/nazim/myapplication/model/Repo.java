package com.nazim.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Repo implements Parcelable{

    private final String name;
    private final String fullName;
    private final Owner owner;
    private final String url;
    private final String description;
    private final boolean isForked;
    private final String gitUrl;
    private final String homepage;
    private final String language;

    public Repo(String name, String fullName, Owner owner, String url, String description, boolean isForked,
        String gitUrl, String homepage, String language) {
        this.name = name;
        this.fullName = fullName;
        this.owner = owner;
        this.url = url;
        this.description = description;
        this.isForked = isForked;
        this.gitUrl = gitUrl;
        this.homepage = homepage;
        this.language = language;
    }

    protected Repo(Parcel in) {
        name = in.readString();
        fullName = in.readString();
        owner = in.readParcelable(Owner.class.getClassLoader());
        url = in.readString();
        description = in.readString();
        isForked = in.readByte() != 0;
        gitUrl = in.readString();
        homepage = in.readString();
        language = in.readString();
    }

    public static final Creator<Repo> CREATOR = new Creator<Repo>() {
        @Override
        public Repo createFromParcel(Parcel in) {
            return new Repo(in);
        }

        @Override
        public Repo[] newArray(int size) {
            return new Repo[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public boolean isForked() {
        return isForked;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(fullName);
        dest.writeParcelable(owner, 0);
        dest.writeString(url);
        dest.writeString(description);
        dest.writeByte((byte) (isForked ? 0 : 1));
        dest.writeString(gitUrl);
        dest.writeString(homepage);
        dest.writeString(language);
    }
}
