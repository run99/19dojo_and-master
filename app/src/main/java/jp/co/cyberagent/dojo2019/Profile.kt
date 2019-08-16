package jp.co.cyberagent.dojo2019

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Profile {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0

    @ColumnInfo
    var name: String? = null
    @ColumnInfo
    var github: String? = null
    @ColumnInfo
    var twitter:String? = null

}
