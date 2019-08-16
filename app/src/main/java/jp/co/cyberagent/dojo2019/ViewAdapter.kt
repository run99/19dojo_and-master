package jp.co.cyberagent.dojo2019

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ViewAdapter(private val list: MutableList<Profile>,
                  private val context: Context,
                  private val itemClickListener: ListActivity
) :
    RecyclerView.Adapter<ViewHolder>(){

    private var mRecyclerView : RecyclerView? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("Adapter", "onCreateViewHolder")

        val layoutInflater = LayoutInflater.from(context)
        val mView = layoutInflater.inflate(R.layout.list_item, parent, false)

        return ViewHolder(mView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Adapter", "onBindViewHolder")
        holder.nameView.text = list[position].name
        holder.githubView.text = list[position].github
        holder.twitterView.text = list[position].twitter



        holder.githubView.setOnClickListener{tappedView ->
            mRecyclerView?.let{
                itemClickListener.onGithubClick(tappedView, profile = list[position])
            }
        }

        holder.twitterView.setOnClickListener { tappedView ->
            mRecyclerView?.let {
                itemClickListener.onTwitterClick(tappedView, profile = list[position])
            }
        }

        holder.trashView.setOnClickListener{tappedView ->
            mRecyclerView?.let{
                itemClickListener.onNameClick(tappedView, profile = list[position], position = position)
                list.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, list.size)
            }
        }
    }


    override fun getItemCount(): Int {
        Log.d("Adapter", "getItemCount")
        return list.size
    }


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mRecyclerView = recyclerView
    }


    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        mRecyclerView = null
    }



}