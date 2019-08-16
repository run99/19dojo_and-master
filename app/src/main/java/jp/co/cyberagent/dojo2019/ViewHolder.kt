package jp.co.cyberagent.dojo2019

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
    val nameView : TextView = itemView.findViewById(R.id.name_title)
    val githubView : TextView = itemView.findViewById(R.id.github_title)
    val twitterView : TextView = itemView.findViewById(R.id.twitter_title)
    var trashView: ImageView = itemView.findViewById<ImageView>(R.id.trashButton)

    /*interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }*/
}