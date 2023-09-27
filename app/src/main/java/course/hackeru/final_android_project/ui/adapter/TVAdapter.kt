package course.hackeru.final_android_project.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import course.hackeru.final_android_project.data.entity.TV
import course.hackeru.final_android_project.databinding.TvItemBinding


//Logic for loading elements into the ui
class TVAdapter(private val tvs: List<TV>, val tvItemClicked:(TV) -> Unit) :
    Adapter <TVAdapter.TvItem>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TvItem(TvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount() = tvs.size

    override fun onBindViewHolder(holder: TvItem, position: Int) {
        val tv = tvs[position]
        
        with (holder.binding) {
            tvTitle.text = tv.name
            val url = tv.posterUrl
            Picasso.get().load(url).into(tvImage)

            root.setOnClickListener {
                //callBack design pattern in order to navigate
                tvItemClicked(tv)
            }
       }
    }

    class TvItem (val binding: TvItemBinding) : ViewHolder(binding.root)
}