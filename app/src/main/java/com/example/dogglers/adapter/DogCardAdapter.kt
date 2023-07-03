/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataSource
import com.example.dogglers.model.Dog
/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    // TODO: Initialize the data using the List found in data/DataSource

    private val dataset: List<Dog> = DataSource.dogs

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        // TODO: Declare and initialize all of the list item UI component
        val ImageView: ImageView? = view?.findViewById(R.id.item_image)
        val textView1: TextView? = view?.findViewById(R.id.dogName)
        val textView2: TextView? = view?.findViewById(R.id.dogAge)
        val textView3: TextView? = view?.findViewById(R.id.dogHobby)

    }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
            val adapterLayout = when(layout){
                Layout.GRID -> LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)
                else ->  LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
            }
                return DogCardViewHolder(adapterLayout)

        }

        override fun getItemCount(): Int {
            return dataset.size
        }// TODO: return the size of the data set instead of 0

        override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
            val item = dataset[position]
            val resources = context?.resources
            holder.ImageView?.setImageResource(item.imageResourceId)
            holder.textView1?.text = item.name
            if (resources != null) {
                holder.textView2?.text = resources.getString(R.string.dog_age,item.age)
            }
            if (resources != null) {
                holder.textView3?.text = resources.getString(R.string.dog_hobbies,item.hobbies)
            }
        }
}

