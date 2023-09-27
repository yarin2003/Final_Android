package course.hackeru.final_android_project.ui.tvDetails

import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import course.hackeru.final_android_project.R
import course.hackeru.final_android_project.data.entity.TV
import course.hackeru.final_android_project.databinding.FragmentTvDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvDetailsFragment : Fragment() {

    private lateinit var viewModel: TvDetailsViewModel
    private var _binding: FragmentTvDetailsBinding? = null
    private  val binding: FragmentTvDetailsBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTvDetailsBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(TvDetailsViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tv = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable("tv", TV::class.java)
        } else {
            arguments?.getParcelable("tv") as TV?
        }

        with(binding) {
            tvName.text = tv?.name
            tvOverviewText.text = tv?.overview
            tvGenresText.text = tv?.tvGenres.toString()
            tvLangText.text = tv?.originalLanguage
            tvDateText.text = tv?.firstAirDate
        }

        println(tv)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}