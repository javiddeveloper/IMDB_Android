package ir.javid.developer.imdb.ui.listMovie

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.android.schedulers.AndroidSchedulers
import ir.javid.developer.imdb.R
import ir.javid.developer.imdb.databinding.ListMovieFragmentBinding
import ir.javid.developer.imdb.data.rest.model.Search
import ir.javid.developer.imdb.ui.infoMovie.InfoMovieFragment
import java.util.concurrent.TimeUnit


/**
 * Developed by javid
 */
class ListMovieFragment : Fragment() {
    private lateinit var mBinding: ListMovieFragmentBinding
    private lateinit var viewModel: ListMovieViewModel
    private lateinit var adapter: ListMovieAdapter

    companion object {
        fun newInstance() = ListMovieFragment()
    }


    @SuppressLint("CheckResult")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = ListMovieFragmentBinding.inflate(inflater, container, false)
        mBinding.action = this
        mBinding.include.editTextSearch.textChanges()
            .debounce(2000, TimeUnit.MILLISECONDS)
            .filter { it.length > 3 }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                mBinding.txtTitle.text = it.toString()
                viewModel.callList(it.toString())
            }
        return mBinding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListMovieViewModel::class.java)
        viewModel.liveImdb.observe(viewLifecycleOwner, Observer {
            mBinding.rlcImdbList.layoutManager = LinearLayoutManager(context)
            adapter = ListMovieAdapter(it.search, object : ListMovieAdapter.OnSearchClick {
                override fun onClicked(search: Search) {
                    goToItemMovieInfo(search)
                }
            })
            mBinding.rlcImdbList.adapter = adapter
        })


    }

    private fun goToItemMovieInfo(search: Search) {
        fragmentManager?.beginTransaction()
            ?.add(R.id.frame_container, InfoMovieFragment.newInstance(search.imdbID))
            ?.addToBackStack("InfoMovieFragment")?.commit()
    }
}
