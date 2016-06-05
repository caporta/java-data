package com.java_data;

import java.io.Serializable;
import java.util.Date;
public class Tweet implements Comparable<Tweet>, Serializable {
  private static final long serialVersionUID = -410072778031177119L;
  private String mAuthor;
  private String mDescription;
  private Date mCreationDate;

  public Tweet(String auth, String desc, Date date) {
    mAuthor = auth;
    mDescription = desc;
    mCreationDate = date;
  }

  @Override
  public String toString() {
    return String.format("Tweet: \"%s\" by %s on %s",
                         mDescription, mAuthor, mCreationDate);
  }

  @Override
  public int compareTo(Tweet other) {
    if (equals(other)) {
      return 0;
    }
    int dateCmp = mCreationDate.compareTo(other.mCreationDate);
    if (dateCmp == 0) {
      return mDescription.compareTo(other.mDescription);
    }
    return dateCmp;
  }

  public String getAuthor() {
    return mAuthor;
  }

  public String getDescription() {
    return mDescription;
  }

  public Date getCreationDate() {
    return mCreationDate;
  }

  public String[] getWords() {
    return mDescription.toLowerCase().split("[^\\w#@']+");
  }



}
