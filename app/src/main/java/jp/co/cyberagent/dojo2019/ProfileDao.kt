package jp.co.cyberagent.dojo2019

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProfileDao {

    // シンプルなSELECTクエリ


    // メソッドの引数をSQLのパラメーターにマッピングするには :引数名 と書く
    @Query("SELECT * FROM profile WHERE uid IN (:userIds)")
    fun loadAllaByIds(vararg userIds: Int): List<Profile>

    @Insert
    fun insert(profile: Profile)
   // fun insertAll(profiles: List<Profile>)

    @Delete
    fun delete(profile: Profile)


    @Query("SELECT * FROM profile")
    fun getAll(): LiveData<List<Profile>>
}