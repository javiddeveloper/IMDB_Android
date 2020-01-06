package ir.javid.developer.imdb.ui.infoMovie

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.appbar.AppBarLayout

import ir.javid.developer.imdb.databinding.InfoMovieFragmentBinding
import androidx.lifecycle.Observer
import ir.javid.developer.imdb.ui.widgets.CustomImageView


class InfoMovieFragment : Fragment() {
    private lateinit var mBinding: InfoMovieFragmentBinding
    private lateinit var viewModel: InfoMovieViewModel
    private var search: String = ""

    companion object {
        fun newInstance(item: String): InfoMovieFragment {
            val fragment = InfoMovieFragment()
            val args = Bundle()
            fragment.arguments = args
            fragment.search = item
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(InfoMovieViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        mBinding = InfoMovieFragmentBinding.inflate(inflater, container, false)
        mBinding.action = this
        mBinding.visible = true
        context?.let { viewModel.getMovieInfo(it,search) }
        mBinding.appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (-verticalOffset > appBarLayout.totalScrollRange / 2) {
                mBinding.visible = false
            } else if (-verticalOffset < appBarLayout.totalScrollRange / 2) {
                mBinding.visible = true
            }
        })
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.liveInfoMovie.observe(viewLifecycleOwner, Observer {
            mBinding.item = it
            initPoster(it.poster)
        })
    }

    private fun initPoster(poster: String) {
        mBinding.expandedImage.imageControl(CustomImageView.BLUR, poster)
    }


}
