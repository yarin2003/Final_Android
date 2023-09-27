package course.hackeru.final_android_project.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import course.hackeru.final_android_project.data.entity.Movie
import course.hackeru.final_android_project.databinding.MovieItemBinding


//Logic for loading elements into the ui
class MovieAdapter(private val movies: List<Movie>, val movieItemClicked:(Movie) -> Unit) :
    Adapter <MovieAdapter.MovieItem>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieItem(MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MovieItem, position: Int) {
        val movie = movies[position]

        with (holder.binding) {
            movieTitle.text = movie.title
            val url = movie.posterUrl
            Picasso.get().load(url).into(movieImage)

            root.setOnClickListener {
                //callBack design pattern in order to navigate
                movieItemClicked(movie)
            }
        }
    }

    class MovieItem (val binding: MovieItemBinding) : ViewHolder(binding.root)
}