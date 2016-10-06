package com.example.tiniha.karaoke;

/**
 * Created by Me on 10/6/2016.
 */

public class KaraokeModel {
    private int _code;
    private String short_name;
    private String _name;
    private String _name_vn;
    private String lyric;
    private String lyric_vn;

    public KaraokeModel(int _code, String short_name, String _name, String _name_vn, String lyric, String lyric_vn) {
        this._code = _code;
        this.short_name = short_name;
        this._name = _name;
        this._name_vn = _name_vn;
        this.lyric = lyric;
        this.lyric_vn = lyric_vn;
    }

    public int get_code() {
        return _code;
    }

    public void set_code(int _code) {
        this._code = _code;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_name_vn() {
        return _name_vn;
    }

    public void set_name_vn(String _name_vn) {
        this._name_vn = _name_vn;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getLyric_vn() {
        return lyric_vn;
    }

    public void setLyric_vn(String lyric_vn) {
        this.lyric_vn = lyric_vn;
    }
}
