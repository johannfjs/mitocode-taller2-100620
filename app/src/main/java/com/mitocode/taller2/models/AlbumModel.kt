package com.mitocode.taller2.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AlbumModel(
    var id: Int,
    var title: String? = null
) : Parcelable

/*
public void AlbumModel{
    private int id;
    private String title;

    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return this.id;
    }

}
 */