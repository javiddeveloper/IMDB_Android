package ir.javid.developer.imdb.ui.infoMovie

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
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
    private lateinit var search: String

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
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = InfoMovieFragmentBinding.inflate(inflater, container, false)
        mBinding.action = this
        viewModel.getMovieInfo(search)
        mBinding.appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (verticalOffset < -300) {
                mBinding.txtTitle.visibility = View.VISIBLE
                mBinding.imgPoster.visibility = View.INVISIBLE
            } else {
                mBinding.imgPoster.visibility = View.VISIBLE
                mBinding.txtTitle.visibility = View.INVISIBLE
            }
        })

        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.mutableLiveData.observe(viewLifecycleOwner, Observer {
            mBinding.item = it
            initPoster(it.poster)
        })
    }

    private fun initPoster(poster: String) {
        mBinding.expandedImage.imageControl(CustomImageView.BLUR, poster)
        mBinding.imgPoster.imageControl(CustomImageView.NORMAL, poster)

    }


}
