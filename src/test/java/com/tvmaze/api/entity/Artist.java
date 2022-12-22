package com.tvmaze.api.entity;

public class Artist {
    private String name;
    private String birthday;
    private String gender;
    private String birthPlace;

    public Artist(String name, String birthday, String gender, String birthPlace) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.birthPlace = birthPlace;
    }

    public String getName() {
        return name;
    }

     public String getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthPlace() {
        return birthPlace;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artist artist = (Artist) o;

        if (!name.equals(artist.name)) return false;
        if (!birthday.equals(artist.birthday)) return false;
        if (!gender.equals(artist.gender)) return false;
        return birthPlace.equals(artist.birthPlace);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + birthday.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + birthPlace.hashCode();
        return result;
    }
    @Override
    public String toString() {
        return "Artist{" +
                "name:" + name  +
                ", birthday: " + birthday +
                ", gender: " + gender +
                ", born in: " + birthPlace  +
                '}';
    }

}
