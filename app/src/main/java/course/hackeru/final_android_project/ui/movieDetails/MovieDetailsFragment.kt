package course.hackeru.final_android_project.ui.movieDetails

import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import course.hackeru.final_android_project.R
import course.hackeru.final_android_project.data.entity.Movie
import course.hackeru.final_android_project.databinding.FragmentMovieDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {

    private lateinit var viewModel: MovieDetailsViewModel
    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding: FragmentMovieDetailsBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieDetailsBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(MovieDetailsViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movie = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable("movie", Movie::class.java)
        } else {
            arguments?.getParcelable("movie") as Movie?
        }

        with(binding) {
            movieName.text = movie?.title
            movieOverviewText.text = movie?.overview
            movieGenresText.text = movie?.movieGenres.toString()
            movieLangText.text = movie?.originalLanguage
            movieDateText.text = movie?.releaseDate
        }

        println(movie)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}