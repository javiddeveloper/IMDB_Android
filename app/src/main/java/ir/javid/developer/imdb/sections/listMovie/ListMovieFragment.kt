package ir.javid.developer.imdb.sections.listMovie

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import ir.javid.developer.imdb.R
import ir.javid.developer.imdb.databinding.ListMovieFragmentBinding
import ir.javid.developer.imdb.model.Search
import ir.javid.developer.imdb.sections.infoMovie.InfoMovieFragment


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


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = ListMovieFragmentBinding.inflate(inflater, container, false)
        mBinding.action = this
        return mBinding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListMovieViewModel::class.java)
        viewModel.mutableLiveData.observe(viewLifecycleOwner, Observer {
            mBinding.rlcImdbList.layoutManager = LinearLayoutManager(context)
            adapter = ListMovieAdapter(it.search)
            mBinding.rlcImdbList.adapter = adapter

            adapter.onClick?.onClicked { search ->
                goToItemMovieInfo(search as Search)
            }

        })

    }

    private fun goToItemMovieInfo(search: Search) {
        childFragmentManager.beginTransaction()
            .replace(R.id.frame_container, InfoMovieFragment.newInstance(search))
            .commit()

    }
}
