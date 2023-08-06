package com.example.cityeventsexplorerapp.ui.adapter

import android.view.View
import androidx.core.content.ContextCompat
import com.example.cityeventsexplorerapp.R
import com.example.cityeventsexplorerapp.databinding.ItemChipGroupBinding
import com.example.cityeventsexplorerapp.databinding.ItemDescriptionBinding
import com.example.cityeventsexplorerapp.databinding.ItemInfoBinding
import com.example.cityeventsexplorerapp.databinding.ItemSliderBinding
import com.example.cityeventsexplorerapp.ui.adapter.item.EventDetailStates
import com.example.cityeventsexplorerapp.util.type_alias.RString
import com.google.android.material.chip.Chip
import me.ibrahimyilmaz.kiel.adapterOf
import me.ibrahimyilmaz.kiel.core.RecyclerViewHolder

class EventDetailsAdapter {

    val adapter =
        adapterOf<EventDetailStates> {
            diff(
                areItemsTheSame = { old, new -> old.identifier == new.identifier },
                areContentsTheSame = { old, new -> old == new },
            )

            register(
                layoutResource = R.layout.item_info,
                viewHolder = { v ->
                    InfoViewHolder(v)
                },
                onBindViewHolder = { vh, _, p -> vh.onBind(p) })

            register(
                layoutResource = R.layout.item_slider,
                viewHolder = { v ->
                    SliderViewHolder(v)
                },
                onBindViewHolder = { vh, _, p -> vh.onBind(p) })

            register(
                layoutResource = R.layout.item_chip_group,
                viewHolder = { v ->
                    ChipGroupViewHolder(v)
                },
                onBindViewHolder = { vh, _, p -> vh.onBind(p) })

            register(
                layoutResource = R.layout.item_description,
                viewHolder = { v ->
                    DescriptionViewHolder(v)
                },
                onBindViewHolder = { vh, _, p -> vh.onBind(p) })
        }

    class InfoViewHolder(
        view: View
    ) : RecyclerViewHolder<EventDetailStates.Info>(view) {

        private val binding = ItemInfoBinding.bind(view)

        fun onBind(item: EventDetailStates.Info) = with(binding) {
            tvInfo.text = item.text
            tvInfo.setCompoundDrawablesWithIntrinsicBounds(item.image, 0, 0, 0)
        }
    }

    class SliderViewHolder(
        view: View
    ) : RecyclerViewHolder<EventDetailStates.Slider>(view) {

        private val binding = ItemSliderBinding.bind(view)

        fun onBind(item: EventDetailStates.Slider) = with(binding) {

        }
    }


    class ChipGroupViewHolder(
        view: View
    ) : RecyclerViewHolder<EventDetailStates.ChipGroup>(view) {

        private val binding = ItemChipGroupBinding.bind(view)

        fun onBind(item: EventDetailStates.ChipGroup) = with(binding) {
            item.titles.forEach {
                val chip = Chip(itemView.context)
                chip.text = it
                chip.background = ContextCompat.getDrawable(
                    itemView.context,
                    com.example.coreui.R.drawable.bg_cultured_rounded_10
                )
                binding.chipGroup.addView(chip)
            }
        }
    }

    class DescriptionViewHolder(
        view: View
    ) : RecyclerViewHolder<EventDetailStates.Description>(view) {

        private val binding = ItemDescriptionBinding.bind(view)

        fun onBind(item: EventDetailStates.Description) = with(binding) {
            tvExpandable.text = item.text
            tvMoreOrLess.setOnClickListener {
                if (tvExpandable.isExpanded) {
                    tvExpandable.collapse()
                    tvMoreOrLess.text = itemView.context.getString(RString.read_more)
                } else {
                    tvExpandable.expand()
                    tvMoreOrLess.text = itemView.context.getString(RString.read_less)
                }
            }
        }
    }
}