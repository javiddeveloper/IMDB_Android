package ir.javid.developer.imdb.sections.listMovie

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.javid.developer.imdb.databinding.ListMovieItemBinding
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import ir.javid.developer.imdb.model.Search


/**
 * Developed by javid
 */
class ListMovieAdapter(var list: List<Search>) : RecyclerView.Adapter<ListMovieAdapter.ViewHolder>() {

    private lateinit var mBinding: ListMovieItemBinding

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
    }


    class ViewHolder(val binding: ListMovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Search) {
            binding.item = item
            Glide.with(binding.poster.context).load(item.poster)
//            .centerCrop()
//            .placeholder()
                .into(binding.poster)
            binding.executePendingBindings()
        }

    }


//
//
//    inner class ViewHolder(private val binding: ListMovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(item: Search) {
//            binding.executePendingBindings()
//        }
//    }

}