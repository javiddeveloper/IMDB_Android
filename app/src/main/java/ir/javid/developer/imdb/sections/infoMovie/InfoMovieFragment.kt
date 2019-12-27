package ir.javid.developer.imdb.sections.infoMovie

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.appbar.AppBarLayout

import ir.javid.developer.imdb.databinding.InfoMovieFragmentBinding
import androidx.lifecycle.Observer
import ir.javid.developer.imdb.model.Search
import ir.javid.developer.imdb.widgets.CustomImageView


class InfoMovieFragment : Fragment() {
    private lateinit var mBinding: InfoMovieFragmentBinding
    private lateinit var viewModel: InfoMovieViewModel
    private lateinit var search: Search


    companion object {

        fun newInstance(item: Search): InfoMovieFragment {
            val fragment = InfoMovieFragment()
            val args = Bundle()
            fragment.arguments = args
            fragment.search = item
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = InfoMovieFragmentBinding.inflate(inflater, container, false)
        mBinding.action = this


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
        viewModel = ViewModelProviders.of(this).get(InfoMovieViewModel::class.java)
        viewModel.init(search.imdbID)
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
