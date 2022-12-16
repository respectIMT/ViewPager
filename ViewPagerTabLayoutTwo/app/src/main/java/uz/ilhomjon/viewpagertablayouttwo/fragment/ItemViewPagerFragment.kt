package uz.ilhomjon.viewpagertablayouttwo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.ilhomjon.viewpagertablayouttwo.R
import uz.ilhomjon.viewpagertablayouttwo.databinding.FragmentItemViewPagerBinding
import uz.ilhomjon.viewpagertablayouttwo.models.Data

private const val DATA = "data"

class ItemViewPagerFragment : Fragment() {
    private var data: Data? = null
    private lateinit var binding: FragmentItemViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            data = it.getSerializable(DATA) as Data
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentItemViewPagerBinding.inflate(layoutInflater)

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(data: Data) =
            ItemViewPagerFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(DATA, data)
                }
            }
    }
}