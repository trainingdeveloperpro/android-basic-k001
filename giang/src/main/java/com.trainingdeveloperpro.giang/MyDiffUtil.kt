package com.trainingdeveloperpro.giang

import androidx.recyclerview.widget.DiffUtil


class MyDiffUtil(internal var newList: StudentViewModel?, internal var oldList: StudentViewModel?) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return if (oldList != null) oldList!!.size() else 0
    }

    override fun getNewListSize(): Int {
        return if (newList != null) newList!!.size() else 0
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList!!.getName(newItemPosition) === oldList!!.getName(newItemPosition)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return false
    }
}