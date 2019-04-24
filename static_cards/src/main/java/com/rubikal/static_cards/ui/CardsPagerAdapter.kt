package com.rubikal.static_cards.ui

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rubikal.static_cards.R
import com.rubikal.static_cards.model.CardsInteraction
import com.rubikal.static_cards.static_cards.model.DiscoverCard
import kotlinx.android.synthetic.main.view_discover_card.view.*
import java.util.*

class CardsPagerAdapter(private val items : ArrayList<DiscoverCard>, private val interactor: CardsInteraction
                        , private val mContext: Context?) : PagerAdapter() {

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val card = items[position]
        val inflater = LayoutInflater.from(mContext)
        val layout = inflater.inflate(R.layout.view_discover_card, collection, false) as ViewGroup
        collection.addView(layout)
        bind(layout,card)
        return layout
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }
    override fun getCount(): Int {
        return items.size
    }
    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    private fun bind(view:ViewGroup, item:DiscoverCard){
        view.tv_title?.text = item.header
        view.tv_subtitle?.text = item.detail
        when(item.num){
            0->{
                view.card_image?.setImageResource(R.drawable.img_card_whymcd)
                view.ivMcLogo?.visibility=View.GONE
            }
            1->{
                view.card_image?.setImageResource(R.drawable.img_card_archways)
                view.ivMcLogo?.visibility=View.GONE
            }
            2->{
                view.card_image?.setImageResource(R.drawable.img_card_mcdcareers)
                view.ivMcLogo?.visibility=View.VISIBLE
            }
        }
        view.setOnClickListener{
            when(item.num){
                0,1->interactor.onStaticCardClicked(item,view.context)
                2->interactor.openCareersActivity()
            }
        }
    }
}