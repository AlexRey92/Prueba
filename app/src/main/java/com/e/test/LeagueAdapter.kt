package com.e.test
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class LeagueAdapter:ListAdapter<Leagues,LeagueAdapter.ViewHolder>(DiffCallBack) {
    lateinit var onItemClickListener: (Leagues)-> Unit
    inner class ViewHolder(val view:View):RecyclerView.ViewHolder(view){
        private val id: TextView= view.findViewById(R.id.textViewID)
        private val league:TextView=view.findViewById(R.id.textViewLeague)
        private val sport:TextView=view.findViewById(R.id.textViewSport)
        private val alternate:TextView=view.findViewById(R.id.textViewAlternate)
        fun onbind(liga:Leagues){
            id.text=liga.idLeague.toString()
            league.text=liga.streLeague
            sport.text=liga.strSport
            alternate.text=liga.strLeagueAlternate

            view.setOnClickListener{
                onItemClickListener(liga)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val myview: View= LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false)
        return ViewHolder(myview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val bindin=getItem(position)
        holder.onbind(bindin)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Leagues>() {
        override fun areItemsTheSame(oldItem: Leagues, newItem: Leagues): Boolean {
            return oldItem.idLeague == newItem.idLeague
        }

        override fun areContentsTheSame(oldItem: Leagues, newItem: Leagues): Boolean {
            return oldItem == newItem
        }
    }


}