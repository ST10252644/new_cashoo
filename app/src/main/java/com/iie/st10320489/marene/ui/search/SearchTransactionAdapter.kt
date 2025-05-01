package com.iie.st10320489.marene.ui.transaction

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DiffUtil
import com.iie.st10320489.marene.R
import com.iie.st10320489.marene.data.entities.TransactionWithCategory
import com.iie.st10320489.marene.databinding.ItemTransactionBinding

class SearchTransactionAdapter(
    private var searchResults: List<TransactionWithCategory>,
    private val onItemClick: (TransactionWithCategory) -> Unit
) : RecyclerView.Adapter<SearchTransactionAdapter.SearchTransactionViewHolder>() {

    inner class SearchTransactionViewHolder(
        private val binding: ItemTransactionBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TransactionWithCategory) {
            val transaction = item.transaction
            val category = item.category

            binding.apply {
                txtTransactionName.text = transaction.name
                txtTransactionMethod.text = transaction.transactionMethod
                txtTransactionDate.text = transaction.dateTime

                imgCategoryIcon.setImageResource(category.icon)
                imgCategoryIconBackground.background.setTint(
                    ContextCompat.getColor(root.context, category.colour)
                )

                txtTransactionAmount.text = if (transaction.expense) {
                    "-R%.2f".format(transaction.amount)
                } else {
                    "+R%.2f".format(transaction.amount)
                }
                txtTransactionAmount.setTextColor(
                    ContextCompat.getColor(
                        root.context,
                        if (transaction.expense) R.color.outcome else R.color.income
                    )
                )

                root.setOnClickListener { onItemClick(item) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchTransactionViewHolder {
        val binding = ItemTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchTransactionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchTransactionViewHolder, position: Int) {
        holder.bind(searchResults[position])
    }

    override fun getItemCount(): Int = searchResults.size

    fun updateSearchResults(newSearchResults: List<TransactionWithCategory>) {
        val diffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize() = searchResults.size

            override fun getNewListSize() = newSearchResults.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return searchResults[oldItemPosition].transaction.transactionId ==
                        newSearchResults[newItemPosition].transaction.transactionId
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return searchResults[oldItemPosition] == newSearchResults[newItemPosition]
            }
        })
        searchResults = newSearchResults
        diffResult.dispatchUpdatesTo(this)
    }


}
