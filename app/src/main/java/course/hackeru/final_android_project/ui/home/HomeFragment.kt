package course.hackeru.final_android_project.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import course.hackeru.final_android_project.R
import course.hackeru.final_android_project.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        //Navigate to MoviesFragment  by clicking on the movies button
        binding.moviesBtn.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_moviesFragment)
        }

        //Navigate to MoviesFragment  by clicking on the movies button
        binding.TVsBtn.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_TVsFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}