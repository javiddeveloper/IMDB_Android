package ir.javid.developer.imdb.sections.listMovie

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import ir.javid.developer.imdb.databinding.ListMovieFragmentBinding


/**
 * Developed by javid
 */
class ListMovieFragment : Fragment() {
    private lateinit var mBinding: ListMovieFragmentBinding
    private lateinit var viewModel: ListMovieViewModel

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
            mBinding.rlcImdbList.adapter =
                ListMovieAdapter(it.search)

        })

    }

}
