package uz.ilhomjon.viewpager8.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import uz.ilhomjon.viewpager8.databinding.FragmentItemViewPagerBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ItemView_pagerFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var binding: FragmentItemViewPagerBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentItemViewPagerBinding.inflate(layoutInflater)

        binding.tvItem.text = param1
        Picasso.get().load(param2).into(binding.imageView)

        return binding.root
    }

    companion object {
        @JvmStatic fun newInstance(param1: String, param2: String) =
                ItemView_pagerFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}