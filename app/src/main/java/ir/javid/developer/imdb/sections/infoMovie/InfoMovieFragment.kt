package ir.javid.developer.imdb.sections.infoMovie

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.appbar.AppBarLayout

import ir.javid.developer.imdb.R
import ir.javid.developer.imdb.databinding.InfoMovieFragmentBinding
import ir.javid.developer.imdb.databinding.ListMovieFragmentBinding
import ir.javid.developer.imdb.sections.listMovie.ListMovieViewModel
import android.util.Log


class InfoMovieFragment : Fragment() {
    private lateinit var mBinding: InfoMovieFragmentBinding
    private lateinit var viewModel: InfoMovieViewModel

    companion object {
        fun newInstance() = InfoMovieFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = InfoMovieFragmentBinding.inflate(inflater, container, false)
        mBinding.action = this


        mBinding.appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
////            Log.d("_test_position", appBarLayout.totalScrollRange.toString() + "")
//            Log.d("_test_current_position",verticalOffset.toString()+"")
            if (verticalOffset < -300) {
                mBinding.imgPoster.visibility = View.GONE
            } else {
                //Expanded
                mBinding.imgPoster.visibility = View.VISIBLE

            }
        })
        return mBinding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(InfoMovieViewModel::class.java)
    }

}
