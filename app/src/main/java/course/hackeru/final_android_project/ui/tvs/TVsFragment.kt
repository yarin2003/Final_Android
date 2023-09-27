package course.hackeru.final_android_project.ui.tvs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import course.hackeru.final_android_project.R
import course.hackeru.final_android_project.databinding.FragmentTvsBinding
import course.hackeru.final_android_project.ui.adapter.TVAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TVsFragment : Fragment() {

    private var _binding: FragmentTvsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTvsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tvViewModel =
            ViewModelProvider(this).get(TVsViewModel::class.java)

        tvViewModel.tvs.observe(viewLifecycleOwner){
            with(binding.tvsRecycler){
                layoutManager = LinearLayoutManager(context)
                adapter = TVAdapter(it){
                    findNavController().navigate(
                        R.id.action_TVsFragment_to_tvDetailsFragment,
                        Bundle().apply { putParcelable("tv", it) }
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