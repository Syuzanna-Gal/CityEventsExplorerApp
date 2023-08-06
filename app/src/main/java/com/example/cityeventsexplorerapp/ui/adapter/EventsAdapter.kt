package com.example.cityeventsexplorerapp.ui.adapter

import android.view.View
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.cityeventsexplorerapp.R
import com.example.cityeventsexplorerapp.databinding.ItemEventBinding
import com.example.domain.entity.EventItemUiEntity
import me.ibrahimyilmaz.kiel.core.RecyclerViewHolder
import me.ibrahimyilmaz.kiel.pagingDataAdapterOf

class EventsAdapter(
    private val onEventClick: (id: Long) -> Unit
) {

    val adapter =
        pagingDataAdapterOf<EventItemUiEntity> {
            diff(
                areItemsTheSame = { old, new -> old.id == new.id },
                areContentsTheSame = { old, new -> old == new },
            )

            register(
                layoutResource = R.layout.item_event,
                viewHolder = { v ->
                    EventViewHolder(v, onEventClick)
                },
                onBindViewHolder = { vh, _, p -> vh.onBind(p) })
        }

    class EventViewHolder(
        view: View,
        private val onEventClick: (id: Long) -> Unit
    ) : RecyclerViewHolder<EventItemUiEntity>(view) {

        private val binding = ItemEventBinding.bind(view)

        fun onBind(item: EventItemUiEntity) = with(binding) {
            tvName.text = item.name
            ivPicture.load(item.image){
                transformations(RoundedCornersTransformation(20F))
            }
            itemView.setOnClickListener {
                onEventClick(item.id)
            }
        }
    }
}