package ir.javid.developer.imdb.sections.listMovie

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.javid.developer.imdb.databinding.ListMovieItemBinding
import android.view.LayoutInflater
import ir.javid.developer.imdb.model.Search
import ir.javid.developer.imdb.widgets.CustomImageView


/**
 * Developed by javid
 */
class ListMovieAdapter(var list: List<Search>) :
    RecyclerView.Adapter<ListMovieAdapter.ViewHolder>() {

    private lateinit var mBinding: ListMovieItemBinding
    var onClick: OnSearchClick? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        mBinding = ListMovieItemBinding.inflate(inflater, parent, false)
        return ViewHolder(mBinding)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
//        holder.itemView.setOnClickListener { onClick?.onClicked(list[position] as Search) }
        holder.itemView.setOnClickListener { onClick?.onClicked { search -> list[position] } }
    }


    class ViewHolder(private val binding: ListMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Search) {
            binding.item = item
            binding.poster.imageControl(CustomImageView.NORMAL, item.poster)
            binding.executePendingBindings()

        }

    }

    interface OnSearchClick {
        fun onClicked(search: (Any) -> Unit)
    }


}