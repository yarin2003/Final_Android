package course.hackeru.final_android_project.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import course.hackeru.final_android_project.R
import course.hackeru.final_android_project.databinding.FragmentMoviesBinding
import course.hackeru.final_android_project.ui.adapter.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val movieViewModel =
            ViewModelProvider(this).get(MoviesViewModel::class.java)

        movieViewModel.movies.observe(viewLifecycleOwner){
            println(it)
            with(binding.moviesRecycler){
                layoutManager = LinearLayoutManager(context)
                adapter = MovieAdapter(it){
                    findNavController().navigate(
                        R.id.action_moviesFragment_to_movieDetailsFragment,
                        Bundle().apply { putParcelable("movie", it) }
                    )
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}