package ir.javid.developer.imdb.ui.listMovie

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.javid.developer.imdb.databinding.ListMovieItemBinding
import android.view.LayoutInflater
import ir.javid.developer.imdb.data.rest.model.Search
import ir.javid.developer.imdb.ui.widgets.CustomImageView
import kotlinx.android.synthetic.main.list_movie_item.view.*


/**
 * Developed by javid
 */
class ListMovieAdapter(var list: List<Search>, private val listener: OnSearchClick) :
    RecyclerView.Adapter<ListMovieAdapter.ViewHolder>() {

    private lateinit var mBinding: ListMovieItemBinding

    companion object {
        var mListener: OnSearchClick? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        mBinding = ListMovieItemBinding.inflate(inflater, parent, false)
        return ViewHolder(mBinding)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        mListener = listener
        holder.bind(list[position])
        holder.itemView.setOnClickListener { mListener?.onClicked(list[position]) }
    }

    class ViewHolder(private val binding: ListMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Search) {
            binding.item = item
            binding.txtTitle.isSelected = true
            binding.executePendingBindings()
        }

    }

    interface OnSearchClick {
        fun onClicked(search: Search)
    }


}